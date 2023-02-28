package edu.dio.danilo.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Exemplos01List {

    public static void main(String[] args) {

//        List<Double> listaDeNotas = new ArrayList<>();
        List<Double> listaDeNotas = new ArrayList<>(
                Arrays.asList(7.0, 8.5, 10.0, 6.3, 5.8, 9.0, 3.9, 3.5, 7.9, 8.9));

        // Dada uma lista com 7 notas de alunos [7, 8.5, 10, 6.3, 5.8, 9, 3.9], faça:
        // Adicionando em uma lista
//        System.out.println("Crie uma lista e adcione 7 notas");
//        for (int i = 0; i < 7; i++) {
//            listaDeNotas.add(scanner.nextDouble());
//        }
        // Apresentando a lista completa de notas
        apresentarLista(listaDeNotas);

        // Apresente a posição da nota 10
        System.out.println("");
        System.out.println("A nota 10 esta na posicao: " + listaDeNotas.indexOf(10.0));

        // Adicionando em uma determinada posição
        System.out.println("Adicione a nota 7 na 3a posicao");
        listaDeNotas.add(3, 7.0);
        apresentarLista(listaDeNotas);

        // Substituindo um nota por outra
        System.out.println("Substitua a nota 10 por 2.5");
        listaDeNotas.set(listaDeNotas.indexOf(10.0), 2.5);
        apresentarLista(listaDeNotas);

        // Verificar se existência de um objeto
        System.out.println("A nota 10 existe na lista? " + listaDeNotas.contains(10.0));

        // Retornar o elemento de uma posição
        System.out.println("5a nota adicionada: " + listaDeNotas.get(4));

        // Exibir a maior e menor nota
        // List não ha implemetação própria, mas Colletcions possui uma implementação
        System.out.println("A maior nota eh: " + Collections.max(listaDeNotas));
        System.out.println("A menor nota eh: " + Collections.min(listaDeNotas));

        // Soma e Média de valores da lista
        // Utilizando o metodo iterator da lista
        System.out.println("A soma das notas eh igual a " + somarLista(listaDeNotas));
        System.out.println("A media das notas eh igual a "
                + somarLista(listaDeNotas) / listaDeNotas.size());

        // Remoções de elementos da lista
        System.out.println("Remover a nota 9.0:");
        listaDeNotas.remove(9.0);
        apresentarLista(listaDeNotas);
        System.out.println("Remover a nota na posicao 0:");
        listaDeNotas.remove(0);
        apresentarLista(listaDeNotas);

        System.out.println("Remover elementos menores que 7");
        System.out.println("Lista atual: ");
        apresentarLista(listaDeNotas);
        removerMenoresQue(listaDeNotas, 7.0);
        System.out.println("Resultado: ");
        apresentarLista(listaDeNotas);

        // Apagando toda a lista
        System.out.println("Apagando toda a lista");
        listaDeNotas.clear();
        System.out.println("A lista esta vazia? " + listaDeNotas.isEmpty());

    }

    private static void apresentarLista(List<Double> lista) {
        System.out.println("A lista eh a seguinte:");
        for (Double nota : lista) {
            System.out.print(nota + " ");
        }
        System.out.println("\n");
    }

    private static Double somarLista(List<Double> lista) {
        Iterator<Double> iterator = lista.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        return soma;
    }

    private static void removerMenoresQue(List<Double> lista, Double limite) {
        Iterator<Double> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Double next = iterator.next();
            if (next < limite)
                iterator.remove();
        }
    }
}
