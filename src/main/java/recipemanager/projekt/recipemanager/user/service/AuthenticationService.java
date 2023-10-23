package recipemanager.projekt.recipemanager.user.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.user.controller.auth.AuthenticationRequest;
import recipemanager.projekt.recipemanager.user.controller.auth.AuthenticationResponse;
import recipemanager.projekt.recipemanager.user.controller.auth.RegisterRequest;
import recipemanager.projekt.recipemanager.user.controller.auth.VerificationRequest;
import recipemanager.projekt.recipemanager.user.model.Role;
import recipemanager.projekt.recipemanager.user.model.User;
import recipemanager.projekt.recipemanager.user.repo.UserRepo;
import recipemanager.projekt.recipemanager.user.tfa.TwoFactorAuthenticationService;

import java.io.IOException;
/**
 * Dieser Service {@link AuthenticationService}behandelt die Benutzerauthentifizierung und -registrierung in der Anwendung.
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepo repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TwoFactorAuthenticationService tfaService;

    /**
     * Registriert einen neuen Benutzer in der Anwendung und gibt eine Authentifizierungsantwort zurück.
     *
     * @param request Das Registrierungsanfrageobjekt mit den Benutzerdaten.
     * @return Die Authentifizierungsantwort mit JWT-Token und anderen Informationen.
     */
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .mfaEnabled(request.isMfaEnabled())
                .build();

        if (request.isMfaEnabled()) {
            user.setSecret(tfaService.generateNewSecret());
        }
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .secretImageUri(tfaService.generateQrCodeImageUri(user.getSecret()))
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .mfaEnabled(user.isMfaEnabled())
                .build();
    }

    /**
     * Authentifiziert einen Benutzer anhand der Anmeldeanfrage und gibt eine Authentifizierungsantwort zurück.
     *
     * @param request Die Anmeldeanfrage mit Benutzerdaten.
     * @return Die Authentifizierungsantwort mit JWT-Token und anderen Informationen.
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        if (user.isMfaEnabled()) {
            return AuthenticationResponse.builder()
                    .accessToken("")
                    .refreshToken("")
                    .mfaEnabled(true)
                    .build();
        }
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .mfaEnabled(false)
                .build();
    }

    /**
     * Aktualisiert das Zugriffstoken für einen Benutzer anhand des Aktualisierungsanfrageobjekts.
     *
     * @param request  Das HTTP-Anfrage objekt.
     * @param response Das HTTP-Antwortobjekt.
     * @throws IOException Wenn ein Fehler beim Lesen/Schreiben von Daten auftritt.
     */
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .mfaEnabled(false)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    /**
     * Überprüft den vom Benutzer eingegebenen Verifizierungscode und gibt eine Authentifizierungsantwort zurück.
     *
     * @param verificationRequest Die Verifizierungsanfrage mit dem eingegebenen Code.
     * @return Die Authentifizierungsantwort mit JWT-Token und MFA-Status.
     */
    public AuthenticationResponse verifyCode(
            VerificationRequest verificationRequest
    ) {
        User user = repository
                .findByEmail(verificationRequest.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No user found with  %S", verificationRequest.getEmail()))
                );
        if (tfaService.isOtpNotValid(user.getSecret(), verificationRequest.getCode())) {
            throw new BadCredentialsException("Code is not correct");
        }
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .mfaEnabled(user.isMfaEnabled())
                .build();
    }
}