package com.osg.cidadesinteligentes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cidades")
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "Estado é obrigatório")
    private String estado;
    
    @NotNull(message = "População é obrigatória")
    private Integer populacao;
    
    @Column(name = "indice_ESG")
    @NotNull(message = "Índice ESG é obrigatório")
    private Double indiceESG;
    
    private String iniciativasSustentaveis;
    
    // Construtores
    public Cidade() {}
    
    public Cidade(String nome, String estado, Integer populacao, Double indiceESG, String iniciativasSustentaveis) {
        this.nome = nome;
        this.estado = estado;
        this.populacao = populacao;
        this.indiceESG = indiceESG;
        this.iniciativasSustentaveis = iniciativasSustentaveis;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Integer getPopulacao() {
        return populacao;
    }
    
    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }
    
    public Double getIndiceESG() {
        return indiceESG;
    }
    
    public void setIndiceESG(Double indiceESG) {
        this.indiceESG = indiceESG;
    }
    
    public String getIniciativasSustentaveis() {
        return iniciativasSustentaveis;
    }
    
    public void setIniciativasSustentaveis(String iniciativasSustentaveis) {
        this.iniciativasSustentaveis = iniciativasSustentaveis;
    }
}
