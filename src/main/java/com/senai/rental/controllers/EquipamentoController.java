package com.senai.rental.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental.models.Equipamento;
import com.senai.rental.services.EquipamentoService;

@RestController
@RequestMapping("/equipamentos")
@CrossOrigin(origins = "*")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    public EquipamentoController(EquipamentoService equipamentoService) {
        this.equipamentoService = equipamentoService;
    }

    @GetMapping
    public List<Equipamento> listar() {
        return equipamentoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> buscarPorId(@PathVariable Integer id) {

        Equipamento equipamento = equipamentoService.buscarPorId(id);

        if (equipamento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(equipamento);
    }

    @PostMapping
    public ResponseEntity<Equipamento> salvar(
            @RequestBody Equipamento equipamento) {

        return ResponseEntity.ok(
                equipamentoService.salvar(equipamento)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> atualizar(
            @PathVariable Integer id,
            @RequestBody Equipamento equipamento) {

        Equipamento atualizado =
                equipamentoService.atualizar(id, equipamento);

        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {

        boolean excluido = equipamentoService.excluir(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}