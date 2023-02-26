package edu.danilo.dio.desafiosdecodigo;

import java.io.IOException;
import java.util.Scanner;

public class Animal {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String AN1, AN2, AN3, resultado = null;
        AN1 = scanner.nextLine();
        AN2 = scanner.nextLine();
        AN3 = scanner.nextLine();

        //TODO: Implemente as condição necessária para que seja verificado que tipo de animal é:
        //Dica: Você pode utilizar o método equals para realizar comparações.
        if (AN1.equals("vertebrado")) {
            if (AN2.equals("ave")) {
                if (AN3.equals("carnivoro")) {
                    resultado = "aguia";
                } else {
                    resultado = "pomba";
                }
            } else {
                if (AN3.equals("onivoro")) {
                    resultado = "homem";
                } else {
                    resultado = "vaca";
                }
            }
        } else {
            if (AN2.equals("inseto")) {
                if (AN3.equals("hematofago")) {
                    resultado = "pulga";
                } else {
                    resultado = "lagarta";
                }
            } else {
                if (AN3.equals("hematofago")) {
                    resultado = "sanguessuga";
                } else {
                    resultado = "minhoca";
                }
            }
        }

        System.out.println(resultado);
    }
}
