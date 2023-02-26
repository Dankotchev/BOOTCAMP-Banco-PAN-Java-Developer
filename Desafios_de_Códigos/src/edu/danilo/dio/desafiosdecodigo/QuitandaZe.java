package edu.danilo.dio.desafiosdecodigo;

import java.util.Scanner;

public class QuitandaZe {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int morangos = input.nextInt();
        int macas = input.nextInt();

        double precoMorango = 2.50, precoMacas = 1.80;
        int pesoTotal = morangos + macas;
        double total;

        //TODO: Implemente as condições necessárias para retornar o preço a ser
        // pago pelo cliente, conforme a tabela de preços do seu Zé:
        if (morangos > 5) 
            precoMorango = 2.20;
        if (macas > 5) 
            precoMacas = 1.50;
        

        total = (morangos * precoMorango) + (macas * precoMacas);

        if ((pesoTotal > 8) || (total > 25.0)) 
            total *= 0.90;
        
        System.out.println(total);
    }
}
