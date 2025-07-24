package app;
import javax.swing.*;

import modelo.*;
import java.util.ArrayList;
import java.util.List;
import vista.FormPersona;

public class Main {
    public static void main(String[] args) {
        // Establecer look and feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 UnsupportedLookAndFeelException e) {
            System.err.println("No se pudo establecer el Look and Feel: " + e.getMessage());
        }

        // Crear personas de prueba antes de abrir la GUI
        List<Persona> personas = new ArrayList<>();
        personas.add(new Propietario("Laura", "123", "3001234567"));
        personas.add(new Veterinario("Pedro", "456", "Cirugía"));

        for (Persona p : personas) {
            System.out.println(p.getClass().getSimpleName() + ": " + p.getNombre());
        }

        // Ejecutar la interfaz principal en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            new FormPersona().setVisible(true);
        });
    }
}
