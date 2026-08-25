package com.senai.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.rental.models.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}