package edu.dio.danilo.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionsTeste {

	@Test
	void validarCenarioDeExeptions() {
		Conta origem = new Conta("123456", 0);
		Conta destino = new Conta("654321", 0);

		Transferencia tranferencia = new Transferencia();

		Assertions.assertThrows(IllegalArgumentException.class, () -> tranferencia.transfere(origem, destino, -100));
	}

	@Test
	void validarCenarioDeNaoExeptions() {
		Conta origem = new Conta("123456", 0);
		Conta destino = new Conta("654321", 0);

		Transferencia tranferencia = new Transferencia();

		Assertions.assertDoesNotThrow(() -> tranferencia.transfere(origem, destino, 30));
	}
}
