package com.kraved.artesanal.testUnit;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import com.kraved.artesanal.Maquina;

public class TestllenarJUnit {

	@Test
	public void testLllenarMarquina() {

		Maquina rubia = new Maquina("M01", "Pilsener", "cerveza fria", 0.02, 8000);

		rubia.llenarMaquina();

		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
	}

}