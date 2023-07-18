package com.portal.estudante.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.portal.estudante.entity.Person;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    public String generateToken(Person person) {
        return JWT.create()
                .withIssuer("")
                .withSubject(person.getCPF())
                .withClaim("id", person.id)
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(15)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256("Atumalaka"));
    }
}
