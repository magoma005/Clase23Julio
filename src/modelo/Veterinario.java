package modelo;

public class Veterinario extends Persona {
    private String especialidad;

    public Veterinario(String nombre, String identificacion, String especialidad) {
        super(nombre, identificacion);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String getTipo() {
        return "Veterinario";
    }
}
