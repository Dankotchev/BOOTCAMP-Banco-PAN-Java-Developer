package edu.dio.danilo.collections.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Exemplo02Stream {

    public static void main(String[] args) {

        List<String> numeroAleatorios = Arrays.asList("1", "0", "5", "0", "6", "8", "3", "0", "0", "4", "2", "8", "9");

        System.out.println("Apresentando todos os elementos da lista");
        // Function
        numeroAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println(t);
            }
        });

        // Lambda
        System.out.println("");
        numeroAleatorios.forEach(string -> System.out.println(string));

        // Reference Method
        System.out.println("");
        numeroAleatorios.stream().forEach(System.out::println);

        System.out.println("Peque os primeiros 5 numeros e coloque dentro de um Set.");
        numeroAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
//                .forEach(string -> System.out.println(string));
//        Set<String> set = numeroAleatorios.stream()
//                .limit(5)
//                .collect(Collectors.toSet());

        System.out.println("Transforme a lista de String para inteiro.");
        List<Integer> numerosInteiros = numeroAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Pegue os numeros pares maiores que 2 e coloque em uma lista.");
        numeroAleatorios.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0 && n > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("Mostre a média dos valores da lista.");
        numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

//        System.out.println("Remova os valores impares da lista");
//        numerosInteiros.removeIf(integer -> integer % 2 != 0);
//        System.out.println(numerosInteiros);

        System.out.println("Ignorar os 3 primeiros elementos da lista e imprimir o restante");
        numeroAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("Retirando os numeros repetidos, quantos sobram?");
        long tamanhoSemRepeticao = numeroAleatorios.stream()
                .distinct()
                .count();
        System.out.println("Sobram " + tamanhoSemRepeticao + " elementos distintos");

        System.out.println("Mostre o maior valor da lista:");
        numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("Mostre o menor valor da lista:");
        numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.println("Some apenas os numeros ímpares.");
        int soma = numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(i -> i % 2 != 0)
                .sum();
        System.out.println("A soma é: " + soma);

        System.out.println("Mostre a lista na ordem numérica:");
        numeroAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Agrupe os valores impares multiplos de 3 e de 5");
        Map<Boolean, List<Integer>> multiplosDe3e5 = numerosInteiros.stream()
                .collect(Collectors.groupingBy(i -> (i % 2 != 0 && (i % 3 == 0 || i % 5 == 0))));
        System.out.println(multiplosDe3e5);
    }
}
