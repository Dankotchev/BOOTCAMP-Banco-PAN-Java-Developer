package edu.dio.danilo.junit;

public class Transferencia {
	public void transfere(Conta origem, Conta destino, int valor) {
		if (valor <= 0) throw new IllegalArgumentException("Valor deve ser maior que 0");
	}
}
