package edu.dio.danilo.collections.stream;

import java.util.*;

public class Exemplo01Stram {

    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {
            {
                put(1, new Contato("Simba", 5555));
                put(4, new Contato("Cami", 1111));
                put(3, new Contato("Jon", 2222));
            }
        };
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> linkedAgenda = new LinkedHashMap<>() {
            {
                put(1, new Contato("Simba", 5555));
                put(4, new Contato("Cami", 1111));
                put(3, new Contato("Jon", 2222));
            }
        };
        System.out.println(linkedAgenda);
        for (Map.Entry<Integer, Contato> entry : linkedAgenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> idAgenda = new TreeMap<>(linkedAgenda);
        System.out.println(idAgenda);
        for (Map.Entry<Integer, Contato> entry : idAgenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        //precisamos organizar os valores. Logo:

//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
//                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
//            }
//        });
//
//          ----
//
//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
//                new Function<Map.Entry<Integer, Contato>, Integer>() {
//            @Override
//            public Integer apply(Map.Entry<Integer, Contato> contato) {
//                return contato.getValue().getNumero();
//            }
//        }));
        //
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                contato -> contato.getValue().getNumero()));
        
        set.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entrada : set) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue().getNumero()
                    + ": " + entrada.getValue().getNome());
        }

        System.out.println("--\tOrdem nome contato\t--");
        //precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(
                contato -> contato.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        //imprimindo usando forEach
        set1.forEach(entrada -> System.out.println(entrada.getKey() + " - " + entrada.getValue().getNome()));
    }
}
