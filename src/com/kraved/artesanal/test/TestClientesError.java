package com.kraved.artesanal.test;

import com.kraved.artesanal.NegocioMejorado;

public class TestClientesError {

    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();
        
        // Llamamos a registrarCliente con la variable correcta 'negocio'
        negocio.registrarCliente("Juan Pérez", "1712345678");
    }
}