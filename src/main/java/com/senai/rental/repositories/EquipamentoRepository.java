package com.senai.rental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.rental.models.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {

}
