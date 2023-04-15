package edu.dio.danilo.junit;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTeste {

    @Test
    void verificarCalcularIdadeCorretamente() {
        Pessoa danilo = new Pessoa("Danilo", LocalDate.of(1996, 7, 27));
        Assertions.assertEquals(26, danilo.getIdade());
    }

    @Test
    void verificarRetonoMaiorDeIdade(){
        Pessoa danilo = new Pessoa("Danilo", LocalDate.of(1996, 7, 27));
        Assertions.assertTrue(danilo.ehMaiorDeIdade());
        
        Pessoa joao = new Pessoa("João", LocalDate.now());
        Assertions.assertFalse(joao.ehMaiorDeIdade());
    }
}
