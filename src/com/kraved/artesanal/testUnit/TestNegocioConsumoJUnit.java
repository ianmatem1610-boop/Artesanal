package com.kraved.artesanal.testUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.kraved.artesanal.Cliente;
import com.kraved.artesanal.Maquina;
import com.kraved.artesanal.NegocioMejorado;

public class TestNegocioConsumoJUnit {

    @Test
    public void testConsumirCervezaEIntegracion() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        // Agregar máquina con capacidad 8000 ml y llenarla
        Maquina maquina = new Maquina("M-01", "Pilsener", "Rubia", 0.02, 8000);
        negocio.agregarMaquina(maquina);
        negocio.cargarMaquinas(); // La máquina queda con 7800 ml (regla de -200 ml)

        // Registrar cliente (Obtiene el código "C-1")
        negocio.registrarCliente("Carlos Andrade", "1722334455");

        // Consumir 1000 ml
        double valorConsumo = negocio.consumirCerveza("C-1", "M-01", 1000);

        // Validaciones: 1000 ml * 0.02 = 20.0
        assertEquals(20.0, valorConsumo, 0.001);

        // Validar cliente actualizado
        Cliente cliente = negocio.buscarClientePorCodigo("C-1");
        assertEquals(20.0, cliente.getTotalConsumido(), 0.001);

        // Validar máquina afectada (7800 - 1000 = 6800 ml)
        Maquina maquinaAfectada = negocio.recuperarMaquina("M-01");
        assertEquals(6800.0, maquinaAfectada.getCantidadActual(), 0.001);
    }

    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        Maquina m1 = new Maquina("M-01", "Pilsener", "Rubia", 0.02, 8000);
        negocio.agregarMaquina(m1);
        negocio.cargarMaquinas();

        negocio.registrarCliente("Cliente Uno", "1111111111"); // C-1
        negocio.registrarCliente("Cliente Dos", "2222222222"); // C-2

        negocio.consumirCerveza("C-1", "M-01", 1000); // 20.0
        negocio.consumirCerveza("C-2", "M-01", 2000); // 40.0

        double totalVendido = negocio.consultarValorVendido();
        assertEquals(60.0, totalVendido, 0.001);
    }
}