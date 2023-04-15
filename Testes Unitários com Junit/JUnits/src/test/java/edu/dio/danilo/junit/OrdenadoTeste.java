package edu.dio.danilo.junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrdenadoTeste {

	@Test
	@Order(2)
	void validarFluxoA(){
		Assertions.assertEquals(10, 5+5);

	}

	@Test
	@Order(3)
	void validarFluxoB(){
		Assertions.assertTrue(true);
	}

	@Test
	@Order(1)
	void validarFluxoC(){
Assertions.assertFalse(false);
	}
}
