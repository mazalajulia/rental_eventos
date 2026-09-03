package com.senai.rental.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.rental.models.Usuario;
import com.senai.rental.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario salvar(Usuario usuario) {

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario atualizar(Integer id, Usuario usuario) {

        Usuario existente = usuarioRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());

        if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
            existente.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }

        return usuarioRepository.save(existente);
    }

    public boolean excluir(Integer id) {

        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }

    public Usuario login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);

        if (usuario == null) {
            return null;
        }

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            return null;
        }

        return usuario;
    }
}