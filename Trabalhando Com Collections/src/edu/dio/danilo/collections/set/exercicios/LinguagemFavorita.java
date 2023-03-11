package edu.dio.danilo.collections.set.exercicios;

import java.util.*;

public class LinguagemFavorita {

    public static void main (String[] args) {
        Set<Linguagem> linguagensFavoritas = new LinkedHashSet<>() {
            {
                add( new Linguagem( "Java", 1991, "Netbeans" ) );
                add( new Linguagem( "C", 1972, "Code::Blocks" ) );
                add( new Linguagem( "C", 1972, "VS Code" ) );
                add( new Linguagem( "Python", 1991, "Pycharm" ) );
            }
        };

        // Apresentar por ordem de inserção
        System.out.println( "Apresentando por ordem de insercao" );
        for ( Linguagem linguagensFavorita : linguagensFavoritas ) {
            System.out.println( linguagensFavorita );
        }

        // Ordem natura, nomes
        System.out.println( "Apresentando por ordem alfabetica" );
        Set<Linguagem> ordemAlfabetica = new TreeSet<>( linguagensFavoritas );
        for ( Linguagem linguagem : ordemAlfabetica ) {
            System.out.println( "\t" + linguagem.getNome() );
        }

        // Por ordem de IDE
        System.out.println( "Por IDEs" );
        Set<Linguagem> ordemIDE = new TreeSet<>( new ComparatorIDE() );
        ordemIDE.addAll( linguagensFavoritas );
        for ( Linguagem linguagem : ordemIDE ) {
            System.out.println( linguagem );
        }

        // Por ano de criação e nome
        System.out.println( "Por ano de criacao e nome" );
        Set<Linguagem> ordemAnoNome = new TreeSet<>( new ComparatorAnoCriacaoNome() );
        ordemAnoNome.addAll( linguagensFavoritas );
        for ( Linguagem linguagem : ordemAnoNome ) {
            System.out.println( linguagem );
        }

        // Por todos os parametros
        System.out.println( "Por todos os atributos" );
        Set<Linguagem> ordemTotal = new TreeSet<>( new ComparatorTodos() );
        ordemTotal.addAll( linguagensFavoritas );
        for ( Linguagem linguagem : ordemTotal ) {
            System.out.println( linguagem );
        }

    }

}

class Linguagem implements Comparable<Linguagem> {

    private String nome;
    private int anoCriacao;
    private String ide;

    //
    public Linguagem (String nome, int anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public int getAnoCriacao () {
        return anoCriacao;
    }

    public void setAnoCriacao (int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getIde () {
        return ide;
    }

    public void setIde (String ide) {
        this.ide = ide;
    }

    @Override
    public String toString () {
        return "Linguagem{" + "nome=" + nome + ", anoCriacao=" + anoCriacao + ", ide=" + ide + '}';
    }

    @Override
    public int hashCode () {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode( this.nome );
        hash = 11 * hash + this.anoCriacao;
        hash = 11 * hash + Objects.hashCode( this.ide );
        return hash;
    }

    @Override
    public boolean equals (Object obj) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        final Linguagem other = ( Linguagem ) obj;
        if ( this.anoCriacao != other.anoCriacao )
            return false;
        if ( !Objects.equals( this.nome, other.nome ) )
            return false;
        return Objects.equals( this.ide, other.ide );
    }

    // Comparação por nome da linguagem
    @Override
    public int compareTo (Linguagem other) {
        return this.getNome().compareToIgnoreCase( other.getNome() );
    }
}

class ComparatorIDE implements Comparator<Linguagem> {

    @Override
    public int compare (Linguagem l1, Linguagem l2) {
        return l1.getIde().compareToIgnoreCase( l2.getIde() );
    }

}

class ComparatorAnoCriacaoNome implements Comparator<Linguagem> {

    @Override
    public int compare (Linguagem l1, Linguagem l2) {
        int ano = Integer.compare( l1.getAnoCriacao(), l2.getAnoCriacao() );
        if ( ano != 0 )
            return ano;
        return l1.getNome().compareToIgnoreCase( l2.getNome() );
    }
}

class ComparatorTodos implements Comparator<Linguagem> {

    @Override
    public int compare (Linguagem l1, Linguagem l2) {
        int ano = Integer.compare( l1.getAnoCriacao(), l2.getAnoCriacao() );
        if ( ano != 0 )
            return ano;
        int nome = l1.getNome().compareToIgnoreCase( l2.getNome() );
        if ( nome != 0 )
            return nome;
        return l1.getIde().compareToIgnoreCase( l2.getIde() );
    }
}
