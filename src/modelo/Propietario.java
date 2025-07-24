package modelo;

import java.util.ArrayList;

public class Propietario extends Persona {
    private String telefono;

    public Propietario(String nombre, String identificacion, String telefono) {
        super(nombre, identificacion);
        this.telefono = telefono;
    }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String getTipo() {
        return "Propietario";
    }
}
