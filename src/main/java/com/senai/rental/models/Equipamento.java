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

    @Column(name="id") 
    private Integer id; 

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

    @Column(name="qtd_disponivel") 
    private Integer qtdDisponivel; 

    @Column(name="qtd_minima") 
    private Integer qtdMinima;

    public Equipamento() {
    }

    public Equipamento(Integer id, String nome, String marca, String modelo, String categoria, String potencia,
            String material, Double peso, String dimensoes, String cor, Integer qtdDisponivel, Integer qtdMinima) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.cor = cor;
        this.qtdDisponivel = qtdDisponivel;
        this.qtdMinima = qtdMinima;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(Integer qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public Integer getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(Integer qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    
}
