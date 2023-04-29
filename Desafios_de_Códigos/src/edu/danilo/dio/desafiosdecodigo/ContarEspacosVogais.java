package edu.danilo.dio.desafiosdecodigo;

import java.util.Scanner;

public class ContarEspacosVogais {

    public static void main(String[] args) {
        // Entrada da frase
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine().toLowerCase();

        
        String[] entradaDividida = entrada.split(" ");
        char[] arrayVogais = {'a', 'e', 'i', 'o', 'u'};

        // Resolve a quantidade de espaços em branco
        int espacosEmBranco = entradaDividida.length - 1;
        
        int quantVogais = 0;

        // Para cada palavra da frase
        for (String palavra : entradaDividida) {
            
            // Tranforma cada palavra em um conjunto de letras
            char[] arrayDeChar = palavra.toCharArray();
            
            // Para cada letra da palavra
            for (char letraPalavra : arrayDeChar) {
                
                // Compara com cada vogal do alfabeto
                for (char vogal : arrayVogais) {
                    
                    // Caso seja uma vogal
                    if (vogal == letraPalavra) {
                        
                        // Incrementa o contador de vogais.
                        quantVogais++;
                    }
                }
            }
        }
        System.out.println("Espacos em branco: " + espacosEmBranco + " Vogais: " + quantVogais);
    }
}
