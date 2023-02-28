package edu.dio.danilo.collections.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Faça um programa que receba e armazene a temperatura média dos 6 primeiro
 * meses do ano e armazene-as em uma lista.
 * <p>
 * Após isto, calcule a média semestral das temperaturas e mostre todas as
 * temperaturas acima desta média, em que mês elas ocorreram (mostrar o mês por
 * extenso: 1 - Janeiro, 2 - Fevereiro e etc).
 */
public class TemperaturaMedia {

    public static void main(String[] args) {

        List<Double> temperaturas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String[] meses = {"Janeiro", "Fevereiro", "Marco",
            "Abril", "Maio", "Junho"};

        System.out.println("Informe as temperaturas medias de cada mes.");
        for (int i = 1; i <= 6; i++) {
            System.out.print("Temperatura media do mes 0" + i + ": ");
            temperaturas.add(scanner.nextDouble());
        }

        Double tempMedia, soma = 0.0;
        soma = somarLista(temperaturas);
        tempMedia = soma / 6.0;
        System.out.println("A temperatura media foi de " + tempMedia + "C.");

        System.out.println("Meses acima da media:");
        Iterator<Double> iterator = temperaturas.iterator();
        while (iterator.hasNext()) {
            Double next = iterator.next();
            if (next > tempMedia)
                System.out.println(
                        meses[temperaturas.indexOf(next)]
                        + " - "
                        + next);
        }
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
}
