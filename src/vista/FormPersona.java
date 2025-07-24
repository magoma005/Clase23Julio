package vista;

import controlador.PersonaControlador;
import modelo.Persona;
import modelo.Propietario;
import modelo.Veterinario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FormPersona extends JFrame {
    private PersonaControlador controlador;
    private JTextField txtNombre, txtIdentificacion, txtExtra;
    private JTextArea areaListado;
    private JComboBox<String> cmbTipo;


    public FormPersona() {
        setTitle("Gestión de Personas");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        controlador = new PersonaControlador();
        initUI();
        mostrarListado();
    }

    private void initUI() {
        JPanel panelSuperior = new JPanel(new GridLayout(5, 2, 5, 5));

        txtNombre = new JTextField();
        txtIdentificacion = new JTextField();
        txtExtra = new JTextField();

        cmbTipo = new JComboBox<>(new String[]{"Propietario", "Veterinario"});
        cmbTipo.addActionListener(e -> actualizarEtiquetaExtra());

        panelSuperior.add(new JLabel("Nombre:"));
        panelSuperior.add(txtNombre);
        panelSuperior.add(new JLabel("Identificación:"));
        panelSuperior.add(txtIdentificacion);
        panelSuperior.add(new JLabel("Tipo de persona:"));
        panelSuperior.add(cmbTipo);
        panelSuperior.add(new JLabel("Teléfono / Especialidad:"));
        panelSuperior.add(txtExtra);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar por ID");

        btnAgregar.addActionListener(this::agregarPersona);
        btnEliminar.addActionListener(this::eliminarPersona);

        panelSuperior.add(btnAgregar);
        panelSuperior.add(btnEliminar);

        areaListado = new JTextArea();
        areaListado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaListado);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void actualizarEtiquetaExtra() {
        String tipo = (String) cmbTipo.getSelectedItem();
        JLabel lblExtra = (JLabel)((JPanel)getContentPane().getComponent(0)).getComponent(6);
        if (tipo.equals("Propietario")) {
            lblExtra.setText("Teléfono:");
        } else {
            lblExtra.setText("Especialidad:");
        }
    }

    private void agregarPersona(ActionEvent e) {
        String nombre = txtNombre.getText().trim();
        String id = txtIdentificacion.getText().trim();
        String extra = txtExtra.getText().trim();
        String tipo = (String) cmbTipo.getSelectedItem();

        if (!validarPersona(nombre, id)) {
            JOptionPane.showMessageDialog(this, "Nombre no puede estar vacío y el ID debe ser numérico.");
            return;
        }

        // Validación simple
        if (nombre.isEmpty() || id.isEmpty() || extra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
            return;
        }

        Persona persona;
        if (tipo.equals("Propietario")) {
            persona = new Propietario(nombre, id, extra);
        } else {
            persona = new Veterinario(nombre, id, extra);
        }

        controlador.agregar(persona);
        limpiarCampos();
        mostrarListado();

    }

    private void eliminarPersona(ActionEvent e) {
        String id = JOptionPane.showInputDialog(this, "Ingrese ID a eliminar:");
        if (id != null && !id.trim().isEmpty()) {
            controlador.eliminarPorIdentificacion(id.trim());
            mostrarListado();
        }
    }

    private void mostrarListado() {
        StringBuilder sb = new StringBuilder("Listado de personas:\n\n");
        for (Persona p : controlador.listar()) {
            sb.append(p).append("\n");
        }
        areaListado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtIdentificacion.setText("");
        txtExtra.setText("");
    }

    public static boolean validarPersona(String nombre, String documento) {
        return nombre != null && !nombre.isEmpty() && documento != null && documento.matches("\\d+");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormPersona().setVisible(true));
    }
}
