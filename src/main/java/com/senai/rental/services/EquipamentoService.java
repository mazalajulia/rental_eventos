package com.senai.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.rental.models.Equipamento;
import com.senai.rental.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public EquipamentoService(EquipamentoRepository equipamentoRepository) {
        this.equipamentoRepository = equipamentoRepository;
    }

    public Equipamento salvar(Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    public List<Equipamento> listar() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Integer id) {
        return equipamentoRepository.findById(id).orElse(null);
    }

    public Equipamento atualizar(Integer id, Equipamento equipamento) {

        Equipamento existente = equipamentoRepository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setNome(equipamento.getNome());
        existente.setMarca(equipamento.getMarca());
        existente.setModelo(equipamento.getModelo());
        existente.setCategoria(equipamento.getCategoria());
        existente.setPotencia(equipamento.getPotencia());
        existente.setMaterial(equipamento.getMaterial());
        existente.setPeso(equipamento.getPeso());
        existente.setDimensoes(equipamento.getDimensoes());
        existente.setCor(equipamento.getCor());
        existente.setQtdDisponivel(equipamento.getQtdDisponivel());
        existente.setQtdMinima(equipamento.getQtdMinima());

        return equipamentoRepository.save(existente);
    }

    public boolean excluir(Integer id) {

        if (!equipamentoRepository.existsById(id)) {
            return false;
        }

        equipamentoRepository.deleteById(id);
        return true;
    }
}