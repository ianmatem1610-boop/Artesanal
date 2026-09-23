package com.kraved.artesanal.testUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.kraved.artesanal.Maquina;
import com.kraved.artesanal.NegocioMejorado;

public class TestNegocioMaquinaJUnit {

    @Test
    public void testGenerarCodigoFormato() {
        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();
        
        assertNotNull(codigo);
        assertTrue(codigo.startsWith("M-"));
    }

    @Test
    public void testRecuperarMaquinaExistenteYNoExistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina m1 = new Maquina("M-10", "Pilsener", "Fria", 0.02);
        negocio.agregarMaquina(m1);

        Maquina recuperada = negocio.recuperarMaquina("M-10");
        assertNotNull(recuperada);
        assertEquals("Pilsener", recuperada.getNombreCerveza());

        Maquina noExistente = negocio.recuperarMaquina("M-99");
        assertNull(noExistente);
    }

    @Test
    public void testValidarDuplicados() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina m1 = new Maquina("M-25", "Club", "Negra", 0.03);
        
        boolean resultadoPrimero = negocio.agregarMaquina(m1);
        assertTrue(resultadoPrimero); // Debe agregar correctamente

        Maquina m2 = new Maquina("M-25", "Pilsener", "Rubia", 0.02);
        boolean resultadoDuplicado = negocio.agregarMaquina(m2);
        assertFalse(resultadoDuplicado); // Debe rechazar por código duplicado
    }
}