package com.dev.senior.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dev.senior.model.Usuario;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service 
public class JwtService {

    private final SecretKey secretKey;
    private final long expiration;

    public JwtService(
    @Value("${jwt.secret}") String secret,
    @Value ("${jwt.expiration}") long expiration
    ){
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expiration = expiration;
    }

    public String generarToken(Usuario usuario) {
    Date ahora = new Date();
    Date fechaExpiracion = new Date(ahora.getTime() + expiration);

    return Jwts.builder()
            .subject(usuario.getEmail())
            .issuedAt(ahora)
            .expiration(fechaExpiracion)
            .signWith(secretKey)
            .compact();
}

}
