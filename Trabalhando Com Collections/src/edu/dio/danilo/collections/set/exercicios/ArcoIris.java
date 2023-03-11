package edu.dio.danilo.collections.set.exercicios;

import java.util.*;

/*
    Crie uma conjunto contendo as cores do arco-íris e:
        a) Exiba todas as cores o arco-íris uma abaixo da outra;
        b) A quantidade de cores que o arco-íris tem;
        c) Exiba as cores em ordem alfabética;
        d) Exiba as cores na ordem inversa da que foi informada;
        e) Exiba todas as cores que começam com a letra ”v”;
        f) Remova todas as cores que não começam com a letra “v”;
        g) Limpe o conjunto;
        h) Confira se o conjunto está vazio;
 */
public class ArcoIris {

    public static void main (String[] args) {

        Set<String> arcoiris = new HashSet<>() {
            {
                add( "vermelho" );
                add( "laranja" );
                add( "amarelo" );
                add( "verde" );
                add( "azul" );
                add( "anil" );
                add( "violeta" );
            }
        };

        System.out.println( "O arco-iris tem " + arcoiris.size() + " cores" );
        // Apresentar as cores do arco-iris
        exibir( arcoiris );

        // Para exibir em ordem utilizar o TreeSet
        Set<String> treeArcoIris = new TreeSet<>( arcoiris );
        System.out.println( treeArcoIris );

        // Para cores na ordem inversa informada usar o LikedHashSet que preserva a ordem de inserção
        //  E utilizar o metodo reverse do Collections
        Set<String> linkedArcoIris = new LinkedHashSet<>() {
            {
                add( "vermelho" );
                add( "laranja" );
                add( "amarelo" );
                add( "verde" );
                add( "azul" );
                add( "anil" );
                add( "violeta" );
            }
        };
        List<String> listaArcoIris = new ArrayList<>( linkedArcoIris );
        Collections.reverse( listaArcoIris );
        System.out.println( listaArcoIris );

        // Para exibir as cores que começam com a letra "v"
        for ( String cores : arcoiris ) {
            if ( cores.startsWith( "v" ) )
                System.out.println( cores );
        }

        // Remover as cores que começam com a letra "v"
        removerV( arcoiris );
        System.out.println( "Arco-iris sem cores que começam com a letra \"v\"" );
        exibir( arcoiris );

        // Limpando todo o conjunto
        arcoiris.clear();

        // Verificando
        System.out.println( "O arco-iris desapareceu do ceu? " + arcoiris.isEmpty() );
    }

    public static void exibir (Set<String> set) {
        System.out.println( "As cores sao: " );
        Iterator<String> iterator = set.iterator();
        while ( iterator.hasNext() ) {
            String next = iterator.next();
            System.out.println( "\t" + next );
        }
        System.out.println( "\n" );
    }

    public static void removerV (Set<String> set) {
        Iterator<String> iterator = set.iterator();
        while ( iterator.hasNext() ) {
            String next = iterator.next();
            if ( next.startsWith( "v" ) )
                iterator.remove();
        }
    }
}
