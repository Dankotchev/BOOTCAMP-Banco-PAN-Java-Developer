package edu.danilo.dio.desafiosdecodigo;

import java.io.IOException;
import java.util.Scanner;

public class ImpostoRenda {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        double renda = sc.nextDouble();
        double imposto = 0;

        if (renda <= 2000)
            System.out.println("Isento");
        else {
            if (renda > 4500) {
                imposto = (1000.0 * 0.08) + (1500.0 * 0.18);
                imposto += (renda - 4500.0) * 0.28;
            } else if (renda > 3000) {
                imposto = (1000.0 * 0.08);
                imposto += (renda - 3000) * 0.18;
            } else if (renda > 2000)
                imposto += (renda - 2000.0) * 0.08;

            System.out.println(String.format("R$ %.2f", imposto));
        }
    }
}
