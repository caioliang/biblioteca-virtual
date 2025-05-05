package br.com.fiap.biblioteca_virtual_api.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.fiap.biblioteca_virtual_api.controller.Credentials;
import br.com.fiap.biblioteca_virtual_api.model.Token;
import br.com.fiap.biblioteca_virtual_api.model.User;

@Service
public class TokenService {
    private Instant experiesAt = LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.ofHours(-3));
    private Algorithm algorithm = Algorithm.HMAC256("secret-muito-muito-muito-secreto-do-secreto");
    
    public Token createToken(User user){
        var jwt = JWT.create()
            .withSubject(user.getId().toString())
            .withClaim("email", user.getEmail())
            .withClaim("role", user.getRole().toString())
            .withExpiresAt(experiesAt)
            .sign(algorithm);
        
            return new Token(jwt, "Beaer", user.getEmail());
            
        }
}
