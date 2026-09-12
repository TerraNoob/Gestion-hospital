package Ventanas;

import modelo.*;
import excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaGestionPacientes extends JFrame {
    private Hospital hospital;

    private JTextField txtNombre;
    private JTextField txtRut;
    private JSpinner spnEdad;
    private JComboBox<String> cmbTipo;
    private JTextField txtPrevision;
    private JTextField txtApoderadoNombre;
    private JTextField txtApoderadoRut;

    private JTextField txtFC;
    private JTextField txtPA;
    private JTextField txtSat;
    private JTextField txtTemp;

    private JTextArea txtAreaInfo;

    public VentanaGestionPacientes(Hospital hospital) {
        this.hospital = hospital;

        setTitle("Gestión de Pacientes");
        setSize(820, 680);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Administración de Pacientes");
        lblTitulo.setBounds(280, 15, 300, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        // --- COLUMNA 1: DATOS PERSONALES ---
        JLabel lblSecPersonal = new JLabel("Datos Personales:");
        lblSecPersonal.setBounds(30, 50, 180, 25);
        lblSecPersonal.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(lblSecPersonal);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 80, 90, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 80, 150, 25);
        panel.add(txtNombre);

        JLabel lblRut = new JLabel("RUT:");
        lblRut.setBounds(30, 115, 90, 25);
        panel.add(lblRut);

        txtRut = new JTextField();
        txtRut.setBounds(120, 115, 150, 25);
        panel.add(txtRut);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(30, 150, 90, 25);
        panel.add(lblEdad);

        spnEdad = new JSpinner(new SpinnerNumberModel(25, 0, 120, 1));
        spnEdad.setBounds(120, 150, 60, 25);
        panel.add(spnEdad);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(30, 185, 90, 25);
        panel.add(lblTipo);

        cmbTipo = new JComboBox<>(new String[]{"Adulto", "Niño"});
        cmbTipo.setBounds(120, 185, 100, 25);
        panel.add(cmbTipo);

        JLabel lblPrevision = new JLabel("Previsión:");
        lblPrevision.setBounds(30, 220, 90, 25);
        panel.add(lblPrevision);

        txtPrevision = new JTextField("FONASA");
        txtPrevision.setBounds(120, 220, 150, 25);
        panel.add(txtPrevision);

        JLabel lblApod = new JLabel("Apoderado:");
        lblApod.setBounds(30, 255, 90, 25);
        panel.add(lblApod);

        txtApoderadoNombre = new JTextField();
        txtApoderadoNombre.setBounds(120, 255, 150, 25);
        txtApoderadoNombre.setEnabled(false);
        panel.add(txtApoderadoNombre);

        JLabel lblRutApod = new JLabel("RUT Apod.:");
        lblRutApod.setBounds(30, 290, 90, 25);
        panel.add(lblRutApod);

        txtApoderadoRut = new JTextField();
        txtApoderadoRut.setBounds(120, 290, 150, 25);
        txtApoderadoRut.setEnabled(false);
        panel.add(txtApoderadoRut);

        // Evento cambio de tipo de paciente o edad
        cmbTipo.addActionListener(e -> {
            boolean esNino = cmbTipo.getSelectedItem().toString().equals("Niño");
            txtApoderadoNombre.setEnabled(esNino);
            txtApoderadoRut.setEnabled(esNino);
            txtPrevision.setEnabled(!esNino);
        });

        spnEdad.addChangeListener(e -> {
            int edad = (Integer) spnEdad.getValue();
            if (edad < 18) {
                cmbTipo.setSelectedItem("Niño");
            } else {
                cmbTipo.setSelectedItem("Adulto");
            }
        });

        // --- COLUMNA 2: SIGNOS VITALES ---
        JLabel lblSecSignos = new JLabel("Signos Vitales:");
        lblSecSignos.setBounds(300, 50, 180, 25);
        lblSecSignos.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(lblSecSignos);

        JLabel lblFC = new JLabel("Frec. Cardíaca (lpm):");
        lblFC.setBounds(300, 80, 140, 25);
        panel.add(lblFC);

        txtFC = new JTextField("75");
        txtFC.setBounds(445, 80, 80, 25);
        panel.add(txtFC);

        JLabel lblPA = new JLabel("Presión Arterial:");
        lblPA.setBounds(300, 115, 140, 25);
        panel.add(lblPA);

        txtPA = new JTextField("120.0");
        txtPA.setBounds(445, 115, 80, 25);
        panel.add(txtPA);

        JLabel lblSat = new JLabel("Saturación O2 (%):");
        lblSat.setBounds(300, 150, 140, 25);
        panel.add(lblSat);

        txtSat = new JTextField("98");
        txtSat.setBounds(445, 150, 80, 25);
        panel.add(txtSat);

        JLabel lblTemp = new JLabel("Temperatura (°C):");
        lblTemp.setBounds(300, 185, 140, 25);
        panel.add(lblTemp);

        txtTemp = new JTextField("36.5");
        txtTemp.setBounds(445, 185, 80, 25);
        panel.add(txtTemp);

        // --- COLUMNA 3: BOTONES DE ACCIÓN ---
        JButton btnRegistrar = new JButton("Registrar Paciente");
        btnRegistrar.setBounds(580, 75, 180, 30);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(e -> registrarPaciente());
        panel.add(btnRegistrar);

        JButton btnBuscar = new JButton("Buscar por RUT");
        btnBuscar.setBounds(580, 115, 180, 30);
        btnBuscar.setFocusPainted(false);
        btnBuscar.addActionListener(e -> buscarPaciente());
        panel.add(btnBuscar);

        JButton btnModificar = new JButton("Modificar Paciente");
        btnModificar.setBounds(580, 155, 180, 30);
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(e -> modificarPaciente());
        panel.add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar Paciente");
        btnEliminar.setBounds(580, 195, 180, 30);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(e -> eliminarPaciente());
        panel.add(btnEliminar);

        JButton btnListar = new JButton("Listar Pacientes");
        btnListar.setBounds(580, 235, 180, 30);
        btnListar.setFocusPainted(false);
        btnListar.addActionListener(e -> listarPacientes());
        panel.add(btnListar);

        // Área de información con Scroll
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollInfo = new JScrollPane(txtAreaInfo);
        scrollInfo.setBounds(30, 335, 740, 230);
        panel.add(scrollInfo);

        // Botón Limpiar Campos
        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setBounds(250, 585, 140, 30);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panel.add(btnLimpiar);

        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(420, 585, 120, 30);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        add(panel);
        setVisible(true);
    }

    private void registrarPaciente() {
        try {
            String nombre = txtNombre.getText().trim();
            String rut = txtRut.getText().trim();
            int edad = (Integer) spnEdad.getValue();

            if (nombre.isEmpty() || rut.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar al menos Nombre y RUT del paciente.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int fc = Integer.parseInt(txtFC.getText().trim());
            double pa = Double.parseDouble(txtPA.getText().trim());
            int sat = Integer.parseInt(txtSat.getText().trim());
            double temp = Double.parseDouble(txtTemp.getText().trim());

            SignosVitales signos = new SignosVitales(fc, pa, sat, temp);

            Paciente nuevo;
            if (edad < 18) {
                String apoderado = txtApoderadoNombre.getText().trim();
                String rutApod = txtApoderadoRut.getText().trim();
                if (apoderado.isEmpty() || rutApod.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Para pacientes menores de edad debe ingresar los datos del apoderado.", "Datos Incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Nino nino = new Nino(nombre, rut, edad, null, apoderado, rutApod);
                nino.setSignos(signos);
                nuevo = nino;
            } else {
                String prevision = txtPrevision.getText().trim();
                if (prevision.isEmpty()) prevision = "Particular";
                nuevo = new Adulto(nombre, rut, edad, signos, null, prevision);
            }

            if (hospital.agregarPacienteSinAsignar(nuevo)) {
                StringBuilder sb = new StringBuilder();
                sb.append("✓ Paciente registrado con éxito en lista de espera:\n");
                sb.append("   - Nombre: ").append(nombre).append("\n");
                sb.append("   - RUT: ").append(rut).append("\n");
                sb.append("   - Edad: ").append(edad).append("\n");
                sb.append("   - Tipo Atención: ").append(nuevo.obtenerTipoAtencion()).append("\n");
                sb.append("   - Gravedad Calculada: ").append(nuevo.getGravedad()).append("\n");
                txtAreaInfo.setText(sb.toString());
                JOptionPane.showMessageDialog(this, "Paciente registrado con éxito. Gravedad: " + nuevo.getGravedad());
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el paciente.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Verifique los valores de edad y signos vitales (deben ser numéricos).", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPaciente() {
        String rut = txtRut.getText().trim();
        if (rut.isEmpty()) {
            rut = JOptionPane.showInputDialog(this, "Ingrese el RUT del paciente a buscar:");
            if (rut == null || rut.trim().isEmpty()) return;
        }

        try {
            Paciente p = hospital.buscarPaciente(rut.trim());
            txtNombre.setText(p.getNombre());
            txtRut.setText(p.getRut());
            spnEdad.setValue(p.getEdad());

            StringBuilder sb = new StringBuilder();
            sb.append("=== DATOS DEL PACIENTE ENCONTRADO ===\n");
            sb.append("Nombre: ").append(p.getNombre()).append("\n");
            sb.append("RUT: ").append(p.getRut()).append("\n");
            sb.append("Edad: ").append(p.getEdad()).append("\n");
            sb.append("Tipo de Atención: ").append(p.obtenerTipoAtencion()).append("\n");
            sb.append("Gravedad: ").append(p.getGravedad()).append("\n");

            if (p.getCamaActual() != null) {
                sb.append("Estado: Internado en Cama ID ").append(p.getCamaActual().getIdCama()).append("\n");
            } else {
                sb.append("Estado: En lista de espera (Sin cama asignada)\n");
            }

            if (p instanceof Adulto) {
                Adulto a = (Adulto) p;
                sb.append("Previsión: ").append(a.getSistemaPrevision()).append("\n");
                txtPrevision.setText(a.getSistemaPrevision());
                cmbTipo.setSelectedItem("Adulto");
            } else if (p instanceof Nino) {
                Nino n = (Nino) p;
                sb.append("Apoderado: ").append(n.getNombreApoderado()).append(" (RUT: ").append(n.getRutApoderado()).append(")\n");
                txtApoderadoNombre.setText(n.getNombreApoderado());
                txtApoderadoRut.setText(n.getRutApoderado());
                cmbTipo.setSelectedItem("Niño");
            }

            if (p.getSignos() != null) {
                SignosVitales sv = p.getSignos();
                txtFC.setText(String.valueOf(sv.getFrecuenciaCardiaca()));
                txtPA.setText(String.valueOf(sv.getPresionArterial()));
                txtSat.setText(String.valueOf(sv.getSaturacion()));
                txtTemp.setText(String.valueOf(sv.getTemperatura()));

                sb.append("--- Signos Vitales ---\n");
                sb.append("  • Frecuencia Cardíaca: ").append(sv.getFrecuenciaCardiaca()).append(" lpm\n");
                sb.append("  • Presión Arterial: ").append(sv.getPresionArterial()).append(" mmHg\n");
                sb.append("  • Saturación: ").append(sv.getSaturacion()).append(" %\n");
                sb.append("  • Temperatura: ").append(sv.getTemperatura()).append(" °C\n");
            }

            txtAreaInfo.setText(sb.toString());

        } catch (ExcepcionPacienteNoEncontrado ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Paciente No Encontrado", JOptionPane.ERROR_MESSAGE);
            txtAreaInfo.setText(ex.getMessage() + "\n");
        }
    }

    private void modificarPaciente() {
        String rut = txtRut.getText().trim();
        if (rut.isEmpty()) {
            rut = JOptionPane.showInputDialog(this, "Ingrese el RUT del paciente a modificar:");
            if (rut == null || rut.trim().isEmpty()) return;
        }

        try {
            Paciente p = hospital.buscarPaciente(rut.trim());

            String nuevoNombre = JOptionPane.showInputDialog(this, "Nombre del paciente:", p.getNombre());
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                p.setNombre(nuevoNombre.trim());
            }

            String nuevaEdadStr = JOptionPane.showInputDialog(this, "Edad del paciente:", p.getEdad());
            if (nuevaEdadStr != null && !nuevaEdadStr.trim().isEmpty()) {
                p.setEdad(Integer.parseInt(nuevaEdadStr.trim()));
            }

            int confirmSignos = JOptionPane.showConfirmDialog(this, "¿Desea actualizar los signos vitales con los campos del formulario?", "Actualizar Signos", JOptionPane.YES_NO_OPTION);
            if (confirmSignos == JOptionPane.YES_OPTION) {
                int fc = Integer.parseInt(txtFC.getText().trim());
                double pa = Double.parseDouble(txtPA.getText().trim());
                int sat = Integer.parseInt(txtSat.getText().trim());
                double temp = Double.parseDouble(txtTemp.getText().trim());

                SignosVitales nuevos = new SignosVitales(fc, pa, sat, temp);
                p.setSignos(nuevos); // setSignos recalcula la gravedad automáticamente
            }

            txtAreaInfo.setText("✓ Paciente RUT " + p.getRut() + " modificado exitosamente.\nNueva Gravedad: " + p.getGravedad() + "\n");
            JOptionPane.showMessageDialog(this, "Paciente modificado correctamente. Gravedad actualizada: " + p.getGravedad());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Los datos numéricos ingresados no tienen formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionPacienteNoEncontrado ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarPaciente() {
        String rut = txtRut.getText().trim();
        if (rut.isEmpty()) {
            rut = JOptionPane.showInputDialog(this, "Ingrese el RUT del paciente a eliminar:");
            if (rut == null || rut.trim().isEmpty()) return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar al paciente con RUT " + rut + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        // 1. Buscar en lista de espera
        for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {
            Paciente p = hospital.getPacientesSinAsignar().get(i);
            if (rut.equalsIgnoreCase(p.getRut())) {
                hospital.getPacientesSinAsignar().remove(i);
                txtAreaInfo.setText("✓ Paciente " + p.getNombre() + " retirado de la lista de espera.\n");
                JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente.");
                limpiarCampos();
                return;
            }
        }

        // 2. Buscar en camas ocupadas
        for (Area a : hospital.listarAreas()) {
            for (Cama c : a.getCamas()) {
                if (c.getPacienteActual() != null && rut.equalsIgnoreCase(c.getPacienteActual().getRut())) {
                    Paciente p = c.getPacienteActual();
                    c.desocuparCama();
                    txtAreaInfo.setText("✓ Paciente " + p.getNombre() + " eliminado y cama ID " + c.getIdCama() + " en '" + a.getNombre() + "' desocupada.\n");
                    JOptionPane.showMessageDialog(this, "Paciente eliminado y cama liberada.");
                    limpiarCampos();
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "No se encontró ningún paciente con el RUT " + rut, "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarPacientes() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================== LISTADO DE PACIENTES ===================\n\n");

        boolean hayPacientes = false;

        // Lista de espera
        sb.append("--- PACIENTES EN LISTA DE ESPERA ---\n");
        if (hospital.getPacientesSinAsignar().isEmpty()) {
            sb.append("   (No hay pacientes en espera)\n");
        } else {
            for (Paciente p : hospital.getPacientesSinAsignar()) {
                hayPacientes = true;
                sb.append("   • ").append(p.getNombre()).append(" | RUT: ").append(p.getRut())
                  .append(" | Edad: ").append(p.getEdad())
                  .append(" | Atención: ").append(p.obtenerTipoAtencion())
                  .append(" | Gravedad: ").append(p.getGravedad())
                  .append("\n");
            }
        }
        sb.append("\n");

        // Pacientes internados
        sb.append("--- PACIENTES INTERNADOS EN CAMAS ---\n");
        boolean hayInternados = false;
        for (Area a : hospital.listarAreas()) {
            for (Cama c : a.getCamas()) {
                if (c.getPacienteActual() != null) {
                    hayInternados = true;
                    hayPacientes = true;
                    Paciente p = c.getPacienteActual();
                    sb.append("   • ").append(p.getNombre()).append(" | RUT: ").append(p.getRut())
                      .append(" | Cama: ").append(c.getIdCama()).append(" (").append(a.getNombre()).append(")")
                      .append(" | Gravedad: ").append(p.getGravedad())
                      .append(" | Atención: ").append(p.obtenerTipoAtencion())
                      .append("\n");
                }
            }
        }
        if (!hayInternados) {
            sb.append("   (No hay pacientes internados en camas actualmente)\n");
        }

        if (!hayPacientes) {
            txtAreaInfo.setText("No hay pacientes registrados en el sistema.\n");
        } else {
            txtAreaInfo.setText(sb.toString());
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtRut.setText("");
        spnEdad.setValue(25);
        txtPrevision.setText("FONASA");
        txtApoderadoNombre.setText("");
        txtApoderadoRut.setText("");
        txtFC.setText("75");
        txtPA.setText("120.0");
        txtSat.setText("98");
        txtTemp.setText("36.5");
    }
}
