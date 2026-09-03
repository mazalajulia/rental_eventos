package com.senai.rental.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.senai.rental.models.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final SecretKey chave = Keys.hmacShaKeyFor(
            "rental-eventos-chave-secreta-2026-seguranca".getBytes()
    );

    private final long tempoExpiracao = 1000 * 60 * 60; // 1 hora

    public String gerarToken(Usuario usuario) {

        return Jwts.builder()
                .subject(usuario.getEmail())
                .claim("nome", usuario.getNome())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + tempoExpiracao))
                .signWith(chave)
                .compact();
    }

    public String extrairEmail(String token) {

        return extrairClaims(token).getSubject();
    }

    public boolean validarToken(String token) {

        try {
            extrairClaims(token);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private Claims extrairClaims(String token) {

        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
