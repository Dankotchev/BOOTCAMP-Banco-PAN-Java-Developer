package edu.dio.danilo.collections.map.exercicios;

import java.util.*;

public class População {

    public static void main(String[] args) {

        // Inserindo e preservando a ordem de inserção
        Map<String, Integer> estadosNE = new LinkedHashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };

        // Para alterar um valor, basta passar a chave e o novo valor
        estadosNE.put("RN", 3534165);

        System.out.println(estadosNE);

        // Verificar se PB está contido e adicionar em caso negativo
        if (!estadosNE.containsKey("PB"))
            estadosNE.put("PB", 4039277);

        // População de PE
        System.out.println("A população de PE é igual a: " + estadosNE.get("PE"));

        // Todos estados e população na ordem de inserção
        System.out.println(estadosNE);

        // Para exibir em ordem, necessário utilizar o TreeMap
        Map<String, Integer> treeEstadosNE = new TreeMap<>(estadosNE);
        System.out.println(treeEstadosNE);
        System.out.println("Estados em ordem alfabética");
        for (Map.Entry<String, Integer> entrada : treeEstadosNE.entrySet()) {
            System.out.println("Estado: " + entrada.getKey() + " - População: " + entrada.getValue());
        }

        // Apresentando o estado com maior e menor população
        // Apresentando a soma populacional
        // Apresentando a média populacional
        Collection<Integer> populacoes = treeEstadosNE.values();
        Integer menorPop = Collections.min(populacoes);
        Integer maiorPop = Collections.max(populacoes);
        Integer somaPop = 0;

        for (Map.Entry<String, Integer> entrada : treeEstadosNE.entrySet()) {
            // Caso o menor
            if (entrada.getValue().equals(menorPop))
                System.out.println(
                        "Estado com menor População: " + entrada.getKey() + " - População = " + entrada.getValue());

            // Caso o maior
            if (entrada.getValue().equals(maiorPop))
                System.out.println(
                        "Estado com maior População: " + entrada.getKey() + " - População = " + entrada.getValue());

            // Soma
            somaPop += entrada.getValue();

        }
        System.out.println("Soma Populacional: " + somaPop);

        // Soma por iterator
        somaPop = 0;
        Iterator<Integer> iterator = treeEstadosNE.values().iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            somaPop += next;
        }
        System.out.println("Soma Populacional: " + somaPop);
        System.out.println("Média Populacional: " + somaPop / treeEstadosNE.values().size());

        //
        System.out.println("Removendo estados com população menor que 4.000.000");
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.compareTo(4000000) < 0)
                iterator.remove();
        }

        // Apagando o dicionário
        treeEstadosNE.clear();
        System.out.print("O dicionário de estados está vazio?");
        if (treeEstadosNE.isEmpty())
            System.out.println(" Sim");
        else
            System.out.println(" Não");

    }
    
}
