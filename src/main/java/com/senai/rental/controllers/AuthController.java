package com.senai.rental.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental.models.Usuario;
import com.senai.rental.security.JwtService;
import com.senai.rental.services.UsuarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public AuthController(
            UsuarioService usuarioService,
            JwtService jwtService) {

        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        Usuario usuarioLogado =
                usuarioService.login(
                        usuario.getEmail(),
                        usuario.getSenha()
                );

        if (usuarioLogado == null) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Email ou senha inválidos");
        }

        String token = jwtService.gerarToken(usuarioLogado);

        return ResponseEntity.ok(
                Map.of(
                    "token", token,
                    "tipo", "Bearer"
                )
        );
    }
}