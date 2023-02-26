package edu.danilo.dio.desafiosdecodigo;

import java.util.Scanner;

public class Dragao {

    public static void main(String[] args) {
        int casos, poderDeLuta;

        Scanner leitor = new Scanner(System.in);
        casos = leitor.nextInt();

        for (int i = 0; i < casos; i++) {
            poderDeLuta = leitor.nextInt();

            //TODO: Implemente a condição adequada para a impressão dos textos conforme o solicitado no desafio:
            if (poderDeLuta > 8000) {
                System.out.println("Mais de 8000!");
            } else {
                System.out.println("Inseto!");
            }
        }

    }
}
