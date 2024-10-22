package com.nzhussup.javadatamanagementservice.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JWTIssuer {

    private final JWTProperties jwtProperties;

    public String issue(long userid, String email, List<String> roles) {
        return JWT.create()
                .withSubject(String.valueOf(userid))
                .withExpiresAt(Instant.now().plus(Duration.ofDays(1)))
                .withClaim("e", email)
                .withClaim("a", roles)
                .sign(Algorithm.HMAC256(jwtProperties.getSecretKey()));
    }
}
