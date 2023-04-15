
package edu.dio.danilo.junit;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    
    public int getIdade(){
        return (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }
    
    public boolean ehMaiorDeIdade(){
        return this.getIdade() >= 18;
    }

    //
    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
