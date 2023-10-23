package recipemanager.projekt.recipemanager.user.controller.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipemanager.projekt.recipemanager.user.service.AuthenticationService;

import java.io.IOException;

/**
 * Ein Controller, der Endpunkte für die Benutzerauthentifizierung und Registrierung bereitstellt.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/users/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * Verarbeitet eine Registrierungsanfrage und gibt eine Antwort zurück.
     *
     * @param request Die Registrierungsanfrage, die Benutzerdaten enthält.
     * @return Eine ResponseEntity mit einer Registrierungsantwort oder einer akzeptierten Antwort, wenn MFA aktiviert ist.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        var response = service.register(request);

        log.info("Received register request with email: {}",
                request.getEmail());

        if (request.isMfaEnabled()) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.accepted().build();
    }

    /**
     * Verarbeitet eine Authentifizierungsanfrage und gibt eine Authentifizierungsantwort zurück.
     *
     * @param request Die Authentifizierungsanfrage, die Benutzeranmeldeinformationen enthält.
     * @return Eine ResponseEntity mit der Authentifizierungsantwort.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request) {
        log.info("Received authenticate request with email: {}",
                request.getEmail());
        return ResponseEntity.ok(service.authenticate(request));
    }

    /**
     * Verarbeitet eine Anfrage zur Aktualisierung des Tokens und aktualisiert das Token.
     *
     * @param request  Die HTTP-Anfrage, die das Aktualisierungstoken enthält.
     * @param response Die HTTP-Antwort, die das aktualisierte Token zurückgibt.
     * @throws IOException Wenn ein Fehler bei der Aktualisierung des Tokens auftritt.
     */
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }

    /**
     * Verarbeitet eine Anfrage zur Code-Verifizierung und gibt eine Antwort zurück.
     *
     * @param verificationRequest Die Anfrage zur Code-Verifizierung, die den zu überprüfenden Code enthält.
     * @return Eine ResponseEntity mit einer Antwort auf die Code-Verifizierung.
     */
    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(
            @RequestBody VerificationRequest verificationRequest) {
        return ResponseEntity.ok(service.verifyCode(verificationRequest));
    }
}
