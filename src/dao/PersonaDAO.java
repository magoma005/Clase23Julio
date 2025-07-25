package dao;

import modelo.Persona;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private final String archivo = "data/personas.dat";


    //Se agregó la verificación y creación de la carpeta 'data' antes de guardar el archivo personas.dat.
    //Esto soluciona el error "El sistema no puede encontrar la ruta especificada" cuando la carpeta no existe.
    public void guardarPersonas(List<Persona> personas) {
        try {
            //Verificar y crear la carpeta
            File carpeta = new File("data");
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Guardar el archivo ahora que la carpeta existe
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
            oos.writeObject(personas);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error guardando personas: " + e.getMessage());
        }
    }

    /*  public void guardarPersonas(List<Persona> personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(personas);
        } catch (IOException e) {
            System.err.println("Error guardando personas: " + e.getMessage());
        }
    }*/

    public List<Persona> cargarPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            personas = (List<Persona>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
        return personas;
    }
}
