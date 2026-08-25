package com.senai.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.rental.models.Usuario;
import com.senai.rental.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario) {
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
        existente.setSenha(usuario.getSenha());

        return usuarioRepository.save(existente);
    }

    public boolean excluir(Integer id) {

        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }
}