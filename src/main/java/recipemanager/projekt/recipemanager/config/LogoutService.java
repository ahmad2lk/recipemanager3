package recipemanager.projekt.recipemanager.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;
import recipemanager.projekt.recipemanager.user.token.TokenRepo;
/**
 * Dieser Service behandelt den Logout-Vorgang für Benutzer.
 */
@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepo tokenRepo;

    /**
     * Loggt den Benutzer aus, indem das JWT-Token ungültig gemacht wird.
     *
     * @param request        Das HttpServletRequest-Objekt der aktuellen Anfrage.
     * @param response       Das HttpServletResponse-Objekt für die Antwort.
     * @param authentication Die Authentifizierungsinstanz des Benutzers.
     */
    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        jwt = authHeader.substring(7);
        var storedToken = tokenRepo.findByToken(jwt)
                .orElse(null);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepo.save(storedToken);
            SecurityContextHolder.clearContext();
        }
    }
}