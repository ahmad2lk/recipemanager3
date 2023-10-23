package recipemanager.projekt.recipemanager.user.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Eine Serviceklasse zur Erstellung und Verwaltung
 * von JSON Web Tokens (JWT) für die Authentifizierung und Autorisierung von Benutzern.
 */
@Qualifier("jwtServiceImpl")
@Service
public class JwtService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;
    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshExpiration;

    /**
     * Extrahiert den Benutzernamen aus einem JWT.
     *
     * @param token Das JWT, aus dem der Benutzername extrahiert werden soll.
     * @return Der Benutzername, der aus dem JWT extrahiert wurde.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extrahiert eine Anspruchsfunktion (Claim) aus einem JWT.
     *
     * @param token          Das JWT, aus dem der Anspruch extrahiert werden soll.
     * @param claimsResolver Die Funktion zur Extraktion des Anspruchs.
     * @return Der extrahierte Anspruch.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Generiert ein JWT für einen Benutzer.
     *
     * @param userDetails Die Benutzerdetails, für die das JWT generiert wird.
     * @return Das generierte JWT.
     */
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Generiert ein JWT mit zusätzlichen Ansprüchen (Claims) für einen Benutzer.
     *
     * @param extraClaims Zusätzliche Ansprüche, die im JWT enthalten sein sollen.
     * @param userDetails Die Benutzerdetails, für die das JWT generiert wird.
     * @return Das generierte JWT.
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    /**
     * Generiert ein JWT für die Aktualisierung von Zugriffstoken (Refresh Token) eines Benutzers.
     *
     * @param userDetails Die Benutzerdetails, für die das Refreshtoken generiert wird.
     * @return Das generierte Refreshtoken.
     */
    public String generateRefreshToken(
            UserDetails userDetails
    ) {
        return buildToken(new HashMap<>(), userDetails, refreshExpiration);
    }

    /**
     * Erstellt ein JWT anhand der angegebenen  (Claims), Benutzerdetails und Ablaufzeit.
     *
     * @param extraClaims Zusätzliche Anforderung, die im JWT enthalten sein sollen.
     * @param userDetails Die Benutzerdetails, für die das JWT erstellt wird.
     * @param expiration  Die Ablaufzeit des JWT in Millisekunden ab dem aktuellen Zeitpunkt.
     * @return Das erstellte JWT.
     */
    private String buildToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails,
            long expiration
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Überprüft, ob ein JWT gültig ist und einem bestimmten Benutzer zugeordnet ist.
     *
     * @param token       Das zu überprüfende JWT.
     * @param userDetails Die Benutzerdetails, für die die Überprüfung durchgeführt wird.
     * @return true, wenn das JWT gültig und dem Benutzer zugeordnet ist, andernfalls false.
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Überprüft, ob ein JWT abgelaufen ist.
     *
     * @param token Das zu überprüfende JWT.
     * @return true, wenn das JWT abgelaufen ist, andernfalls false.
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extrahiert das Ablaufdatum (Expiration) aus einem JWT.
     *
     * @param token Das JWT, aus dem das Ablaufdatum extrahiert werden soll.
     * @return Das extrahierte Ablaufdatum als Date-Objekt.
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extrahiert alle Ansprüche (Claims) aus einem JWT.
     *
     * @param token Das JWT, aus dem die Ansprüche extrahiert werden sollen.
     * @return Die extrahierten Ansprüche als Claims-Objekt.
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Gibt den geheimen Schlüssel (Signing Key) für die JWT-Unterschrift zurück.
     *
     * @return Der geheime Schlüssel als Key-Objekt.
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}