package br.com.bjsl.security.service;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

public class TokenService {

    public static Boolean isTokenValid(String token, String secret) {
        return Optional.ofNullable(Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token))
                .isPresent();
    }

    public static String obterIdUsuario(String token, String secret) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
