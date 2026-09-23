package com.kraved.artesanal.test;

import com.kraved.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza fria", 0.02, 8000);

		System.out.println("------Estado Inicial-----");
		rubia.imprimir();

		System.out.println("------Llenando maquina -----");
		rubia.llenarMaquina();
		rubia.imprimir();

		System.out.println("------SERVIR 1000 ML -----");
		double valor = rubia.servirCerveza(1000);
		System.out.println("valor a pagar " + valor);

		System.out.println("------SERVIR 2000 ML -----");
		valor = rubia.servirCerveza(2000);
		System.out.println("valor a pagar " + valor);
		rubia.imprimir();
		
		System.out.println("------SERVIR 6000 ML -----");
		valor = rubia.servirCerveza(6000);
		System.out.println("valor a pagar " + valor);
		rubia.imprimir();
	}

}
