package com.kraved.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

    private ArrayList<Maquina> maquinas;
    private ArrayList<Cliente> clientes = new ArrayList<>(); // Inicializado para evitar NullPointerException en la solución
    private int ultimoCodigo = 0;

    public NegocioMejorado() {
        this.maquinas = new ArrayList<>();
    }

    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    // 3. Generar código tipo M-25, M-78 usando Math.random() del 1 al 100
    public String generarCodigo() {
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        return "M-" + numeroAleatorio;
    }

    // 4 y 7. Agregar máquina evitando duplicados de código
    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigoGenerado = generarCodigo();

        // Si el código aleatorio generado ya existe en la lista, rechazamos la adición como duplicado
        if (recuperarMaquina(codigoGenerado) != null) {
            return false;
        }

        Maquina nuevaMaquina = new Maquina(codigoGenerado, nombreCerveza, descripcion, precioPorMl);
        maquinas.add(nuevaMaquina);
        return true;
    }

    // SOBRECARGA: Permite agregar una máquina con código explícito (útil para pruebas unitarias)
    public boolean agregarMaquina(Maquina maquina) {
        if (recuperarMaquina(maquina.getCodigo()) != null) {
            return false; // duplicado
        }
        maquinas.add(maquina);
        return true; // agregado correctamente
    }

    // 5. Cargar (llenar) todas las máquinas registradas
    public void cargarMaquinas() {
        for (int i = 0; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            m.llenarMaquina();
        }
    }

    // 6. Recuperar máquina por su código
    public Maquina recuperarMaquina(String codigo) {
        for (int i = 0; i < maquinas.size(); i++) {
            Maquina m = maquinas.get(i);
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }

    // 9. Registrar cliente con código secuencial
    public void registrarCliente(String nombre, String cedula) {
        ultimoCodigo++;
        String codigoCliente = "C-" + ultimoCodigo;
        Cliente nuevoCliente = new Cliente(codigoCliente, nombre, cedula);
        clientes.add(nuevoCliente);
    }

    // 13. Buscar cliente por número de cédula
    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    // 14. Buscar cliente por código de cliente
    public Cliente buscarClientePorCodigo(String codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            if (c.getCodigo().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    // 16. Sumar consumo al total consumido del cliente (acumular)
    public void registrarConsumo(Cliente cliente, double valorConsumido) {
        if (cliente != null) {
            double nuevoTotal = cliente.getTotalConsumido() + valorConsumido;
            cliente.setTotalConsumido(nuevoTotal);
        }
    }

    // 15 y 17. Servir cerveza de la máquina recuperada y registrar el consumo del cliente
    public double consumirCerveza(String codigoCliente, String codigoMaquina, double cantidad) {
        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);

        if (maquina != null && cliente != null) {
            double valorCobrado = maquina.servirCerveza(cantidad);
            registrarConsumo(cliente, valorCobrado);
            return valorCobrado;
        }
        return 0;
    }

    // 19. Consultar el total vendido acumulado en todos los clientes
    public double consultarValorVendido() {
        double totalVendido = 0;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            totalVendido += c.getTotalConsumido();
        }
        return totalVendido;
    }
}