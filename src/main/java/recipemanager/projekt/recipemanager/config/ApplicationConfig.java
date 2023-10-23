package recipemanager.projekt.recipemanager.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import recipemanager.projekt.recipemanager.user.repo.UserRepo;

import java.util.Arrays;
import java.util.Collections;




/**
 * Diese Konfigurationsklasse definiert verschiedene Konfigurationen für die Anwendung
 * u.a. passwordEncoder,corsFilter, authenticationProvider,userDetailsService, authenticationManager.
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepo repository;

    /**
     * Konfiguriert einen CORS-Filter, um Cross-Origin-Anfragen zu ermöglichen.
     *
     * @return Der CORS-Filter mit den konfigurierten Einstellungen.
     */
    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedHeaders(Arrays.asList(
                HttpHeaders.ORIGIN,
                HttpHeaders.CONTENT_TYPE,
                HttpHeaders.ACCEPT,
                HttpHeaders.AUTHORIZATION
        ));
        config.setAllowedMethods(Arrays.asList(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.DELETE.name(),
                HttpMethod.PUT.name(),
                HttpMethod.PATCH.name()
        ));
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    /**
     * Konfiguriert einen PasswordEncoder für die Anwendung.
     *
     * @return Der PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Konfiguriert einen AuthenticationProvider für die Anwendung.
     *
     * @return Der AuthenticationProvider.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Konfiguriert einen UserDetailsService für die Anwendung.
     *
     * @return Der UserDetailsService, der Benutzerinformationen aus dem Repository abruft.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Benutzer nicht gefunden"));
    }

    /**
     * Konfiguriert einen AuthenticationManager für die Anwendung.
     *
     * @param config Die AuthenticationConfiguration für die Anwendung.
     * @return Der AuthenticationManager.
     * @throws Exception Wenn ein Fehler bei der Konfiguration auftritt.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}
