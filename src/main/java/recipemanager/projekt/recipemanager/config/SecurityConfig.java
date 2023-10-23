package recipemanager.projekt.recipemanager.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
/**
 * Diese Klasse konfiguriert die Sicherheitseinstellungen für die Anwendung.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final LogoutHandler logoutHandler;
    private final AuthenticationProvider authenticationProvider;

    /**
     * Konfiguriert die Sicherheitsfilterkette für HTTP-Anfragen.
     *
     * @param http Die HttpSecurity-Instanz zum Konfigurieren der Sicherheit.
     * @return Die konfigurierte SecurityFilterChain.
     * @throws Exception Wenn ein Fehler bei der Konfiguration auftritt.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors() // Konfiguriere Cross-Origin Resource Sharing (CORS)
                .and()
                .csrf() // Deaktiviere CSRF-Schutz
                .disable()
                .authorizeHttpRequests() // Konfiguriere die Autorisierung der HTTP-Anfragen

                .requestMatchers("/api/v1/users/auth/**") // Ermögliche den Zugriff auf bestimmte Endpunkte ohne Authentifizierung
                .permitAll()

                .anyRequest() // Für alle anderen Anfragen
                .authenticated() // Authentifizierung ist erforderlich
                .and()
                .sessionManagement() // Konfiguriere die Session-Verwaltung
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Verwende zustandslose Sitzungen
                .and()
                .authenticationProvider(authenticationProvider) // Konfiguriere den AuthenticationProvider
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Füge den JwtAuthenticationFilter hinzu
                .logout() // Konfiguriere den Logout
                .logoutUrl("/api/v1/auth/logout") // Logout-Endpunkt
                .addLogoutHandler(logoutHandler) // Füge den Logout-Handler hinzu
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()); // Konfiguriere den Logout-Erfolg

        return http.build();
    }
}