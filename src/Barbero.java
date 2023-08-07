class Barbero {
    private String nombre;

    public Barbero(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void atenderCliente(String cliente) {
        System.out.println(cliente + ", en atención por " + nombre);
    }

    public void servirCliente(String cliente) {
        System.out.println(cliente + ", servido por " + nombre);
    }
}
