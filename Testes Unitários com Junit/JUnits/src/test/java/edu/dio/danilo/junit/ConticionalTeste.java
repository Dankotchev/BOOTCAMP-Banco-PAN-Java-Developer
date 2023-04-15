package edu.dio.danilo.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ConticionalTeste {

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "danilo")
    void validarAlgoUsuarioDanilo (){
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "USER", matches = "danko")
    void validarAlgoUsuarioDanko (){
        Assertions.assertEquals(10, 5+5);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void validarNoWindons(){
        Assertions.assertEquals(20, 10+10);
    }
}
