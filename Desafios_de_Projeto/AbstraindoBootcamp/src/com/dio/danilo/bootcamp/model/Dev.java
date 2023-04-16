package com.dio.danilo.bootcamp.model;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> listaConteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> listaConteudosConcluidos = new LinkedHashSet<>();

    public void inscreverNoBootcamp(Bootcamp bootcamp) {
        this.listaConteudosInscritos.addAll(bootcamp.getListaConteudo());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.listaConteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.listaConteudosConcluidos.add(conteudo.get());
            this.listaConteudosInscritos.remove(conteudo.get());
        } else
            System.err.println("Você não está matriculado em nenhum conteúdo.");
    }

    public Double calcularTotalXP() {
        return this.listaConteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    //
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getListaConteudosInscritos() {
        return listaConteudosInscritos;
    }

    public void setListaConteudosInscritos(Set<Conteudo> listaConteudosInscritos) {
        this.listaConteudosInscritos = listaConteudosInscritos;
    }

    public Set<Conteudo> getListaConteudosConcluidos() {
        return listaConteudosConcluidos;
    }

    public void setListaConteudosConcluidos(Set<Conteudo> listaConteudosConcluidos) {
        this.listaConteudosConcluidos = listaConteudosConcluidos;
    }

    public Dev(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.listaConteudosInscritos);
        hash = 29 * hash + Objects.hashCode(this.listaConteudosConcluidos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Dev other = (Dev) obj;
        if (!Objects.equals(this.nome, other.nome))
            return false;
        if (!Objects.equals(this.listaConteudosInscritos, other.listaConteudosInscritos))
            return false;
        return Objects.equals(this.listaConteudosConcluidos, other.listaConteudosConcluidos);
    }
    
    

}
