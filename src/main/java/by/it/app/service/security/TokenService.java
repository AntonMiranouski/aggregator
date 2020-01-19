package by.it.app.service.security;

import org.springframework.security.core.Authentication;

/**
 * The interface Token service.
 */
public interface TokenService {

    /**
     * Generate authentication.
     *
     * @param authentication the authentication
     * @return the string
     */
    String generate(Authentication authentication);

    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    String extractUsername(String token);

    /**
     * Validate token.
     *
     * @param authToken the authentication token
     * @return the boolean
     */
    boolean validate(String authToken);
}
