package by.it.app.service.security.impl;

import by.it.app.security.model.AuthenticationUserDetails;
import by.it.app.service.security.TokenService;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenServiceImpl.class);

    private static final String JWT_SECRET = "top_secret";

    private static final Integer JWT_EXPIRATION_MILLIS = 300000;

    @Override
    public String generate(Authentication authentication) {
        return generate(((AuthenticationUserDetails) authentication.getPrincipal()).getUsername());
    }

    @Override
    public String refresh(String token) {
        return generate(extractUsername(token));
    }

    @Override
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    @Override
    public boolean validate(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e){
            LOGGER.error("Invalid JWT signature", e);
            throw e;
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT token", e);
            throw e;
        } catch (ExpiredJwtException e) {
            LOGGER.error("Expired JWT token", e);
            throw e;
        } catch (UnsupportedJwtException e) {
            LOGGER.error("Unsupported JWT token", e);
            throw e;
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT claims string is empty", e);
            throw e;
        }
    }

    private String generate(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION_MILLIS))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }
}
