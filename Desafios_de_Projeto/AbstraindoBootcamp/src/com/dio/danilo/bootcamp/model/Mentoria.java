package com.dio.danilo.bootcamp.model;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate dataMonitoria;

    @Override
    public Double calcularXP() {
        return XP_PADRAO + 15.0;
    }

    //
    public LocalDate getDataMonitoria() {
        return dataMonitoria;
    }

    public void setDataMonitoria(LocalDate dataMonitoria) {
        this.dataMonitoria = dataMonitoria;
    }

    @Override
    public String toString() {
        return "Mentoria{ titulo = " + super.getTitulo() + ", descricao = " + super.getDescricao() + ", dataMonitoria = " + dataMonitoria + '}';
    }
}
