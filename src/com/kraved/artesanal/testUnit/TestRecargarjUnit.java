package com.kraved.artesanal.testUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.kraved.artesanal.Maquina;

public class TestRecargarjUnit {

	@Test
	public void testRecargaExitosa() {

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza fria", 0.02, 8000);

		boolean resultado = rubia.recargarCerveza(3000);

		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadActual(), 0.0001);
	}

	@Test
	public void testRecargaFallidaPorDesborde() {

		Maquina negra = new Maquina("M02", "club", "cerveza fria", 0.03, 8000);
		
		negra.recargarCerveza(7000);
		
		boolean resultado = negra.recargarCerveza(1000);

		assertFalse(resultado);
		assertEquals(7000, negra.getCantidadActual(), 0.0001);
	}
}
