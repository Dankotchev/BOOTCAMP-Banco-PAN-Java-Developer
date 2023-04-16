
package com.dio.danilo.bootcamp.model;

public abstract class Conteudo {
    private String titulo;
    private String descricao;
    protected static final Double XP_PADRAO = 15.0;
    
    public abstract Double calcularXP();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
