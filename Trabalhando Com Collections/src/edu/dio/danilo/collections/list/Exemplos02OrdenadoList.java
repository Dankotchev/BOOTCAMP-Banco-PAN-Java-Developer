package edu.dio.danilo.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    Dados as seguintes informações sobre gatos, crie uma lista e ordene exibindo
(nome - idade - cor);

        Gato 1 == nome: Nebula, Idade: 9, cor: preto;
        Gato 2 == nome: Simba, Idade: 5, cor: amarela;
        Gato 3 == nome: Nebula, Idade: 8, cor: branca;
        Gato 4 == nome: Avatar, Idade: 10, cor: tigrado;
        Gato 4 == nome: Nala, Idade: 5, cor: amarela;
 */
public class Exemplos02OrdenadoList {

    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>() {
            {
                add(new Gato("Nebula", 9, "preto"));
                add(new Gato("Simba", 5, "amarela"));
                add(new Gato("Nebula", 8, "branca"));
                add(new Gato("Avatar", 10, "cinza"));
                add(new Gato("Nala", 5, "tigrada"));
            }
        };

        System.out.println("---\tApresentar na Ordem de Insercao");
        apresentar(meusGatos);

        System.out.println("---\tApresentar na Ordem Aleatoria");
        Collections.shuffle(meusGatos);
        apresentar(meusGatos);

        System.out.println("---\tApresentar na Ordem Alfabetica");
        // Classe Gato deve ter implementado o Comparable
        Collections.sort(meusGatos);
        apresentar(meusGatos);

        // Para as comparações a seguir é necessário a 
        //  implementação da interface Comparator
        System.out.println("---\tApresentar por Idade");
        meusGatos.sort(new ComparatorIdade());
        apresentar(meusGatos);

        System.out.println("---\tApresentar na Ordem de Cores");
        meusGatos.sort(new ComparatorCor());
        apresentar(meusGatos);

        System.out.println("---\tApresentar na Ordem Nome | Cor | Idade");
        meusGatos.sort(new ComparatorNomeCorIdade());
        apresentar(meusGatos);
    }

    // Metodo para apresentar de forma agradável
    private static void apresentar(List<Gato> lista) {
        for (Gato gato : lista) {
            System.out.println(gato);
        }
        System.out.println("");
    }
}

// Classe Gato
class Gato implements Comparable<Gato> {

    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "nome: " + nome + ",\tidade: " + idade + ",\tcor: " + cor;
    }

    @Override
    public int compareTo(Gato other) {
        // Por nome tratar-se de uma String, a mesma já possui métodos para comparação
        //  o compareTo
        return this.getNome().compareToIgnoreCase(other.getNome());
    }
}

// Implementações do Comparator para comparar os objetos da Classe Gato
class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        // Comparando inicialmente os nomes
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        // Caso nomes diferente, comparação realizada e retorna por nomes
        if (nome != 0)
            return nome;

        // Comparando por Cor, caso nomes iguais
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0)
            return cor;

        // Caso cores iguais, comparar finalmente as idades
        return Integer.compare(g1.getIdade(), g2.getIdade());

    }
}
