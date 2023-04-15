package edu.dio.danilo.collections.map.exercicios;

import java.util.Map;
import java.util.TreeMap;

public class LancamentoDado {

    public static void main(String[] args) {

//        Map<String, int> conjuntoDados = new TreeMap<>();
        Map<String, Integer> conjuntoDados = new TreeMap<>() {
            {
                put("1", 0);
                put("2", 0);
                put("3", 0);
                put("4", 0);
                put("5", 0);
                put("6", 0);
            }
        };

        for (int i = 0; i < 100; i++) {
            int valor = (int) (Math.random() * 6 + 1);
            switch (valor) {
                case 1:
                    Integer quantidade1 = conjuntoDados.get("1");
                    conjuntoDados.put("1", quantidade1 += 1);
                    break;

                case 2:
                    Integer quantidade2 = conjuntoDados.get("2");
                    conjuntoDados.put("2", quantidade2 += 1);
                    break;

                case 3:
                    Integer quantidade3 = conjuntoDados.get("3");
                    conjuntoDados.put("3", quantidade3 += 1);
                    break;

                case 4:
                    Integer quantidade4 = conjuntoDados.get("4");
                    conjuntoDados.put("4", quantidade4 += 1);
                    break;

                case 5:
                    Integer quantidade5 = conjuntoDados.get("5");
                    conjuntoDados.put("5", quantidade5 += 1);
                    break;

                case 6:
                    Integer quantidade6 = conjuntoDados.get("6");
                    conjuntoDados.put("6", quantidade6 += 1);
                    break;

            }
        }

        for (Map.Entry<String, Integer> entrada : conjuntoDados.entrySet()) {
            System.out.println("Face do Dado: " + entrada.getKey() + " - Quantidade: " + entrada.getValue());
        }
    }

}
