package edu.dio.danilo.collections.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/*
    Dados as seguintes informações sobre series, crie um conjunto  e ordene exibindo
(formato - nome - genero - tempo de episódio);

        Série 1 == formato: sitcom  nome: That 70's Show,    genero: Comédia,    tempoEpisódio: 25;
        Série 2 == formato: serie   nome: The Last of Us,    genero: Drama,      tempoEpisódio: 60;
        Série 3 == formato: sitcom  nome: Vicious,           genero: Comédia,    tempoEpisódio: 30;
        Série 4 == formato: serie   nome: Community,         genero: Comédia,    tempoEpisódio: 23;
        Série 5 == formato: serie   nome: Vikings,           genero: Drama,      tempoEpisódio: 45;
 */
public class Exemplos02OrdenadoSet {

    public static void main(String[] args) {

        System.out.println("---\tApresentar em Ordem Aleatória");
        Set<Serie> conjSeries = new HashSet<>() {
            {
                add(new Serie("SITCOM", "That 70's Show", "Comedia", 25));
                add(new Serie("SERIE", "The Last of Us", "Drama", 60));
                add(new Serie("SITCOM", "Vicious", "Comedia", 30));
                add(new Serie("SERIE", "Community", "Comedia", 23));
                add(new Serie("SERIE", "Vikings", "Drama", 25));
            }
        };
        apresentarConjunto(conjSeries);

        // Necessário para comparar utilizar o TreeSet
        Set<Serie> treeSetSeries = new TreeSet<>(conjSeries);
        System.out.println("---\tApresentar na Ordem Natural (Tempo de Episódio)");
        apresentarConjunto(treeSetSeries);

        System.out.println("---\tApresentar na Ordem Formato | Genero | Tempo de Episodio | Nome");
        Set<Serie> treeConjuntoSerie = new TreeSet<>(new ComparatorTotal());
        treeConjuntoSerie.addAll(conjSeries);
        apresentarConjunto(treeConjuntoSerie);

    }

    private static void apresentarConjunto(Set<Serie> conjunto) {
        System.out.println("O conjunto eh o seguinte:");
        for (Serie s : conjunto) {
            System.out.println(s);
        }
        System.out.println("\n");
    }
}

class Serie implements Comparable<Serie> {

    private String formato;
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String formato, String nome, String genero, Integer tempoEpisodio) {
        this.formato = formato;
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "formato: " + formato + ",\t\tnome: " + nome + ",\t\tgenero: " + genero + ",\t\ttempoEpisodio: " + tempoEpisodio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.formato);
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.genero);
        hash = 41 * hash + Objects.hashCode(this.tempoEpisodio);
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
        final Serie other = (Serie) obj;
        if (!Objects.equals(this.formato, other.formato))
            return false;
        if (!Objects.equals(this.nome, other.nome))
            return false;
        if (!Objects.equals(this.genero, other.genero))
            return false;
        return Objects.equals(this.tempoEpisodio, other.tempoEpisodio);
    }

    @Override
    public int compareTo(Serie other) {
        // Comparando por tempo de Episódio, caso sejam iguais necessário outra comparação
        int tempo = Integer.compare(this.getTempoEpisodio(), other.getTempoEpisodio());
        if (tempo != 0)
            return tempo;
        return this.getGenero().compareToIgnoreCase(other.getGenero());

    }
}

class ComparatorTotal implements Comparator<Serie> {

    @Override
    public int compare(Serie o1, Serie o2) {

        int formato = o1.getFormato().compareToIgnoreCase(o2.getFormato());
        if (formato != 0)
            return formato;

        int nome = o1.getGenero().compareToIgnoreCase(o2.getGenero());
        if (nome != 0)
            return nome;

        int tempo = Integer.compare(o1.getTempoEpisodio(), o2.getTempoEpisodio());
        if (tempo != 0)
            return tempo;

        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }

}
