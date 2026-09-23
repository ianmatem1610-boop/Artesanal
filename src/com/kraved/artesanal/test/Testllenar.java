package com.kraved.artesanal.test;

import com.kraved.artesanal.Maquina;

public class Testllenar {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza fria", 0.02, 8000);
		rubia.imprimir();
		rubia.llenarMaquina();
		rubia.imprimir();
		 	
		Maquina negra = new Maquina("M02", "club", "cerveza buena", 0.03);
		negra.imprimir();
		negra.llenarMaquina();
		negra.imprimir();
	}	
}
