package barberia;

import barberos.Barbero;

import java.util.LinkedList;
import java.util.Queue;

public class Barberia implements IAtencionCliente {
    private Barbero[] barberos;
    private Queue<String> clientesEspera;
    private Queue<String> clientesAtencion;
    private Queue<String> clientesServidos;

    public Barberia(Barbero[] barberos) {
        this.barberos = barberos;
        this.clientesEspera = new LinkedList<>();
        this.clientesAtencion = new LinkedList<>();
        this.clientesServidos = new LinkedList<>();
    }

    public void encolar(String cliente) {
        if (clientesEspera.size() < barberos.length * 5) {
            clientesEspera.add(cliente);
            System.out.println(cliente + ", en espera");
        } else {
            System.out.println("Estamos ocupados. Vuelve más tarde.");
        }
    }

    public void atender() {
        for (Barbero barbero : barberos) {
            if (!clientesEspera.isEmpty()) {
                String clienteAtendido = clientesEspera.poll();
                clientesAtencion.add(clienteAtendido);
                barbero.atenderCliente(clienteAtendido);
            } else {
                System.out.println(barbero.getNombre() + " está disponible para atender.");
            }
        }
    }

    public void servir() {
        for (Barbero barbero : barberos) {
            if (!clientesAtencion.isEmpty()) {
                String clienteServido = clientesAtencion.poll();
                clientesServidos.add(clienteServido);
                barbero.servirCliente(clienteServido);
            } else {
                System.out.println(barbero.getNombre() + " no tiene clientes en atención.");
            }
        }
    }

    public void mostrarEstado() {
        System.out.println("\nEstado de la barbería:");
        System.out.println("Clientes en espera: " + clientesEspera);
        System.out.println("Clientes en atención: " + clientesAtencion);
        System.out.println("Clientes servidos: " + clientesServidos);
    }
}
