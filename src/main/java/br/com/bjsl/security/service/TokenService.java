package br.com.bjsl.security.service;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class TokenService {

    @Value("${produto.jwt.secret}")
    private String secret;

    public Boolean isTokenValid(String token) {
        return Optional.ofNullable(Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token))
                .isPresent();
    }

    public String obterIdUsuario(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
