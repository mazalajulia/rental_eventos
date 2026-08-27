package com.senai.rental.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental.models.Movimentacao;
import com.senai.rental.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
@CrossOrigin(origins = "*")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(
            MovimentacaoService movimentacaoService) {

        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public List<Movimentacao> listar() {
        return movimentacaoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> buscarPorId(
            @PathVariable Integer id) {

        Movimentacao movimentacao =
                movimentacaoService.buscarPorId(id);

        if (movimentacao == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movimentacao);
    }

    @PostMapping
    public ResponseEntity<Movimentacao> salvar(
            @RequestBody Movimentacao movimentacao) {

        Movimentacao novaMovimentacao =
                movimentacaoService.salvar(movimentacao);

        if (novaMovimentacao == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(novaMovimentacao);
    }
}