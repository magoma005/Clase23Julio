package controlador;

import dao.PersonaDAO;
import modelo.Persona;
import modelo.Propietario;
import modelo.Veterinario;

import java.util.ArrayList;
import java.util.List;

public class PersonaControlador {
    private final PersonaDAO dao;
    private List<Persona> personas;


    public PersonaControlador() {
        this.dao = new PersonaDAO();
        this.personas = dao.cargarPersonas();
    }

    public List<Persona> listar() {
        /*List<Persona> personas = new ArrayList<>();
        personas.add(new Propietario("Laura", "123", "3164908363"));
        personas.add(new Veterinario("Pedro", "456", "Cirugía"));

        for (Persona p : personas) {
            System.out.println(p.getTipo() + ": " + p.getNombre());
        }*/

        return personas;
    }

    public void agregar(Persona persona) {
        personas.add(persona);
        dao.guardarPersonas(personas);
    }

    public void eliminarPorIdentificacion(String id) {
        personas.removeIf(p -> p.getIdentificacion().equals(id));
        dao.guardarPersonas(personas);
    }


}