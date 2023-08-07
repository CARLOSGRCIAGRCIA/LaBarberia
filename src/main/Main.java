package main;

import barberia.Barberia;
import barberos.Barbero;
import barberia.IAtencionCliente;

public class Main {
    public static void main(String[] args) {
        Barbero julio = new Barbero("Julio");
        Barbero tulio = new Barbero("Tulio");
        Barbero[] barberos = {julio, tulio};

        String[] clientes = {"c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8"};

        IAtencionCliente barberia = new Barberia(barberos);

        for (String cliente : clientes) {
            barberia.encolar(cliente);
        }

        barberia.atender();
        barberia.atender();

        barberia.servir();
        barberia.servir();

        ((Barberia) barberia).mostrarEstado();
    }
}