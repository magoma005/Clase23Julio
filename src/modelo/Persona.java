package modelo;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected String nombre;
    protected String identificacion;

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    // Método abstracto para personalizar en subclases
    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " - " + nombre + " (" + identificacion + ")";
    }
}
