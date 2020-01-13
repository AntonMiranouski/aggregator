package by.it.app.service.security;

import org.springframework.security.core.Authentication;

public interface TokenService {

    String generate(Authentication authentication);

    String extractUsername(String token);

    boolean validate(String authToken);
}
