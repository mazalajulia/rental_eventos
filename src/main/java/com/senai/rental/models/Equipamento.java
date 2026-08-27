package com.senai.rental.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 


@Entity 
@Table(name="Equipamento") 

public class Equipamento{ 
   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_equipamento")
private Integer idEquipamento;

    @Column(name="nome") 
    private String nome; 

    @Column(name="marca") 
    private String marca; 

    @Column(name="modelo") 
    private String modelo; 

    @Column(name="categoria") 
    private String categoria; 

    @Column(name="potencia") 
    private String potencia; 

    @Column(name="material") 
    private String material; 

    @Column(name="peso") 
    private Double peso; 

    @Column(name="dimensoes") 
    private String dimensoes; 

    @Column(name="cor") 
    private String cor; 

    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;

    @Column(name = "quantidade_minima")
    private Integer quantidadeMinima;

    public Equipamento() {
    }

    public Equipamento(Integer idEquipamento, String nome, String marca, String modelo, String categoria,
            String potencia, String material, Double peso, String dimensoes, String cor, Integer quantidadeDisponivel,
            Integer quantidadeMinima) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.cor = cor;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeMinima = quantidadeMinima;
    }

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    
}
