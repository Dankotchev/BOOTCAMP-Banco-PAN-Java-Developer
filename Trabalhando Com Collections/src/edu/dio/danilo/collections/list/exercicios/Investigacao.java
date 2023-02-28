package edu.dio.danilo.collections.list.exercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa
 * sobre um crime. As perguntas são: 1. "Telefonou para a vítima?" 2. "Esteve no
 * local do crime?" 3. "Mora perto da vítima?" 4. "Devia para a vítima?" 5. "Já
 * trabalhou com a vítima?"
 * <p>
 * Se a pessoa responder positivamente a 2 questões ela deve ser classificada
 * como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassina". Caso
 * contrário ela será classificada com "Inocente".
 */
public class Investigacao {

    public static void main(String[] args) {

        List<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inicio do interrogatorio...");
        System.out.println("Responda as seguintes perguntas com S ou N");

        System.out.print("Telefonou para a vitima?\t");
        respostas.add(scanner.nextLine().toUpperCase());

        System.out.print("Esteve no local do crime?\t");
        respostas.add(scanner.nextLine().toUpperCase());

        System.out.print("Mora perto da vitima?\t");
        respostas.add(scanner.nextLine().toUpperCase());

        System.out.print("Devia para a vitima?\t");
        respostas.add(scanner.nextLine().toUpperCase());

        System.out.print("Ja trabalhou com a vitima?\t");
        respostas.add(scanner.nextLine().toUpperCase());

        System.out.println("Estamos analisando o caso...");
        System.out.print("Com as informacoes obtidas, podemos afimar que voce eh ");

        int contador = 0;
        Iterator<String> iterator = respostas.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("S"))
                contador++;
        }

        switch (contador) {
            case 0:
            case 1:
                System.out.println("Inocente.");
                break;

            case 2:
                System.out.println("Suspeita.");
                break;

            case 3:
            case 4:
                System.out.println("Cumplice.");
                break;

            case 5:
                System.out.println("Assassina.");
                break;
        }
    }
}
