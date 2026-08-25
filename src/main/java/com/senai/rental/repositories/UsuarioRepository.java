package com.senai.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.rental.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
