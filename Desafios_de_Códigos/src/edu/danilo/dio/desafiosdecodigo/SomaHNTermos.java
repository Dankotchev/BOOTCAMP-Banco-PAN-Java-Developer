package edu.danilo.dio.desafiosdecodigo;

import java.util.Scanner;

public class SomaHNTermos {

    public static void main(String[] Args) {

        double h = 0;
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();

        for (int i = 1; i <= n; i++) {
            //TODO: Calcule o valor de H de forma que resulte na soma dos termos:
            h += 1d / i;
        }
        //TODO: Imprima a soma dos termos, considerando um resultado com duas casas decimais:
        System.out.println(String.format("%.0f", h));
    }
}
