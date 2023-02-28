package edu.dio.danilo.collections.set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Exemplos01Set {

    public static void main(String[] args) {

        Set<Double> listaDeNotas = new HashSet<>(
                Arrays.asList(7.0, 8.5, 10.0, 9.0, 5.8, 9.0, 3.9, 3.5, 7.9, 8.5));

        // Verificar se existência de um objeto
        System.out.println("A nota 10 existe na lista? " + listaDeNotas.contains(10.0));
        
        
        // Apresentar o Set, não preserva a ordem de inserção
        System.out.println("O set possui essas notas:");
        apresentarConjunto(listaDeNotas);

                
        // Apresentar na Ordem de Inserção
        //  Para isso é necessário utilizar a LinkedHashSet
        Set<Double> listaDeNotasLinkada = new LinkedHashSet<>(
                Arrays.asList(7.0, 8.5, 10.0, 9.0, 5.8, 9.0, 3.9, 3.5, 7.9, 8.5));       
        System.out.println("LinkedHashSet para presevar ordem de insercao:");
        apresentarConjunto(listaDeNotasLinkada);

        
        // Apresentar na ordem Natural dos elementos, ordem crescente
        // É necessário possuir a implementação Comparable e utilizar TreeSet
        Set<Double> listaDeNotasTree = new TreeSet<>(
                Arrays.asList(7.0, 8.5, 10.0, 9.0, 5.8, 9.0, 3.9, 3.5, 7.9, 8.5));

        System.out.println("TreeSet para conseguir comparar elementos:");
        apresentarConjunto(listaDeNotasTree);

        
        // Exibir a maior e menor nota
        // Set não ha implemetação própria, mas Colletcions possui uma implementação
        System.out.println("A maior nota eh: " + Collections.max(listaDeNotas));
        System.out.println("A menor nota eh: " + Collections.min(listaDeNotas));

        
        // Soma e Média de valores do set
        // Utilizando o metodo iterator o set
        System.out.println("A soma das notas eh igual a " + somarSet(listaDeNotas));
        System.out.println("A media das notas eh igual a "
                + somarSet(listaDeNotas) / listaDeNotas.size());

        
        // Remoções de elementos do set
        System.out.println("");
        System.out.println("Remover a nota 9.0:");
        listaDeNotas.remove(9.0);
        apresentarConjunto(listaDeNotas);

        
        System.out.println("Remover elementos menores que 7");
        System.out.println("Lista atual: ");
        apresentarConjunto(listaDeNotas);
        removerMenoresQue(listaDeNotas, 7.0);
        System.out.println("Resultado: ");
        apresentarConjunto(listaDeNotas);

        
        // Apagando toda a lista
        System.out.println("Apagando toda a lista");
        listaDeNotas.clear();
        System.out.println("A lista esta vazia? " + listaDeNotas.isEmpty());

    }

    private static void apresentarConjunto(Set<Double> conjunto) {
        System.out.println("O conjunto eh o seguinte:");
        for (Double nota : conjunto) {
            System.out.print(nota + " ");
        }
        System.out.println("\n");
    }

    private static Double somarSet(Set<Double> lista) {
        Iterator<Double> iterator = lista.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        return soma;
    }

    private static void removerMenoresQue(Set<Double> lista, Double limite) {
        Iterator<Double> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Double next = iterator.next();
            if (next < limite)
                iterator.remove();
        }
    }
}
