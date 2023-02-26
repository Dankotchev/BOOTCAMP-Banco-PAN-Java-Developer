package edu.danilo.dio.desafiosdecodigo;

import java.io.IOException;
import java.util.Scanner;

public class Triangulo {

    public static void main(String[] args) throws IOException {

        Scanner leitor = new Scanner(System.in);
        double A = leitor.nextDouble();
        double B = leitor.nextDouble();
        double C = leitor.nextDouble();

        //TODO: Implemente a condição necessária para o cálculo do triângulo:
        //Dica: Você pode utilizar o String.format() na formatação do texto.
        
        // Verificar se é um triangulo
        if ((A < B + C) && (B < A + C) && (C < A + B)) {
            double perimetro = A + B + C;
            System.out.println(String.format("Perimetro = %.1f", perimetro));
        } else {
            double area = ((A + B) * C) / 2;
            System.out.println(String.format("Area = %.1f", area));
        }
    }
}
