package com.kraved.artesanal.test;

import com.kraved.artesanal.Maquina;

public class TestAtributo {

	public static void main(String[] args) {

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza rubia", 0.02, 10000);
		rubia.imprimir();

		rubia.setNombreCerveza("golde ali");
		rubia.setDescripcion("Cerveza con aroma a choclate");
		rubia.imprimir();

	}

}
