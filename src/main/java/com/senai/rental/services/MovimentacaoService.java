package com.senai.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.rental.models.Equipamento;
import com.senai.rental.models.Movimentacao;
import com.senai.rental.repositories.EquipamentoRepository;
import com.senai.rental.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final EquipamentoRepository equipamentoRepository;

    public MovimentacaoService(
            MovimentacaoRepository movimentacaoRepository,
            EquipamentoRepository equipamentoRepository) {

        this.movimentacaoRepository = movimentacaoRepository;
        this.equipamentoRepository = equipamentoRepository;
    }

    public Movimentacao salvar(Movimentacao movimentacao) {

        Equipamento equipamento = equipamentoRepository
                .findById(movimentacao.getIdEquipamento())
                .orElse(null);

        if (equipamento == null) {
            return null;
        }

        if (movimentacao.getTipo().equalsIgnoreCase("saida")) {

            if (movimentacao.getQuantidade() > equipamento.getQtdDisponivel()) {
                return null;
            }

            equipamento.setQtdDisponivel(
                    equipamento.getQtdDisponivel()
                            - movimentacao.getQuantidade()
            );

        } else if (movimentacao.getTipo().equalsIgnoreCase("entrada")) {

            equipamento.setQtdDisponivel(
                    equipamento.getQtdDisponivel()
                            + movimentacao.getQuantidade()
            );
        }

        equipamentoRepository.save(equipamento);

        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> listar() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao buscarPorId(Integer id) {
        return movimentacaoRepository.findById(id).orElse(null);
    }
}