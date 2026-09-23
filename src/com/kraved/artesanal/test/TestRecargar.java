package com.kraved.artesanal.test;

import com.kraved.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {

		boolean resultado;

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza fria", 0.02, 8000);

		System.out.println("------Estado Inicial-----");
		rubia.imprimir();

		System.out.println("------ Recarga 1-----");
		resultado = rubia.recargarCerveza(3000);
		System.out.println("¿se recargo completamente? " + resultado);
		rubia.imprimir();

		System.out.println("------ Recarga 2-----");
		resultado = rubia.recargarCerveza(2000);
		System.out.println("¿se recargo completamente? " + resultado);
		rubia.imprimir();
		
		System.out.println("------ Recarga 3-----");
		resultado = rubia.recargarCerveza(2900);
		System.out.println("¿se recargo completamente? " + resultado);
		rubia.imprimir();
	}

}

