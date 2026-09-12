package ventanas;

import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaFuncionesEspeciales extends JFrame {
    private Hospital hospital;

    private JTextField txtRutAsignar;
    private JTextField txtIdCamaAsignar;
    private JTextArea txtAreaInfo;

    public VentanaFuncionesEspeciales(Hospital hospital) {
        this.hospital = hospital;

        setTitle("Funciones Especiales y Gestión Clínica");
        setSize(780, 580);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Funciones Especiales y Clínicas");
        lblTitulo.setBounds(240, 15, 320, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        // Sección Asignación
        JLabel lblAsignacion = new JLabel("Asignación de Cama a Paciente:");
        lblAsignacion.setBounds(40, 55, 250, 25);
        lblAsignacion.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(lblAsignacion);

        JLabel lblRut = new JLabel("RUT Paciente en Espera:");
        lblRut.setBounds(40, 85, 160, 25);
        panel.add(lblRut);

        txtRutAsignar = new JTextField();
        txtRutAsignar.setBounds(200, 85, 140, 25);
        panel.add(txtRutAsignar);

        JLabel lblIdCama = new JLabel("ID Cama Disponible:");
        lblIdCama.setBounds(370, 85, 140, 25);
        panel.add(lblIdCama);

        txtIdCamaAsignar = new JTextField();
        txtIdCamaAsignar.setBounds(510, 85, 80, 25);
        panel.add(txtIdCamaAsignar);

        JButton btnAsignar = new JButton("Asignar Cama");
        btnAsignar.setBounds(605, 85, 130, 26);
        btnAsignar.setFocusPainted(false);
        btnAsignar.addActionListener(e -> asignarCama());
        panel.add(btnAsignar);

        // Barra de botones de consultas y automatizaciones
        JButton btnCamasDisp = new JButton("Camas Disponibles");
        btnCamasDisp.setBounds(40, 130, 160, 30);
        btnCamasDisp.setFocusPainted(false);
        btnCamasDisp.addActionListener(e -> listarCamasDisponibles());
        panel.add(btnCamasDisp);

        JButton btnPacientesEspera = new JButton("Pacientes en Espera");
        btnPacientesEspera.setBounds(210, 130, 160, 30);
        btnPacientesEspera.setFocusPainted(false);
        btnPacientesEspera.addActionListener(e -> listarPacientesEnEspera());
        panel.add(btnPacientesEspera);

        JButton btnReubicar = new JButton("Reubicar por Gravedad");
        btnReubicar.setBounds(380, 130, 175, 30);
        btnReubicar.setFocusPainted(false);
        btnReubicar.setToolTipText("Reubica automáticamente pacientes críticos a camas de mayor complejidad");
        btnReubicar.addActionListener(e -> reubicarPorGravedad());
        panel.add(btnReubicar);

        JButton btnAltas = new JButton("Automatizar Altas");
        btnAltas.setBounds(565, 130, 170, 30);
        btnAltas.setFocusPainted(false);
        btnAltas.setToolTipText("Evalúa gravedad y libera camas de pacientes con alta médica");
        btnAltas.addActionListener(e -> automatizarAltas());
        panel.add(btnAltas);

        // Área de información con Scroll
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollInfo = new JScrollPane(txtAreaInfo);
        scrollInfo.setBounds(40, 180, 695, 310);
        panel.add(scrollInfo);

        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(330, 500, 120, 30);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        add(panel);
        setVisible(true);
    }

    private void asignarCama() {
        String rut = txtRutAsignar.getText().trim();
        String strIdCama = txtIdCamaAsignar.getText().trim();

        if (rut.isEmpty() || strIdCama.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el RUT del paciente y el ID de la cama.", "Campos Requeridos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idCama = Integer.parseInt(strIdCama);

            // 1. Buscar paciente en lista de espera
            Paciente paciente = null;
            for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {
                Paciente p = hospital.getPacientesSinAsignar().get(i);
                if (rut.equalsIgnoreCase(p.getRut())) {
                    paciente = p;
                    break;
                }
            }

            if (paciente == null) {
                JOptionPane.showMessageDialog(this, "No existe un paciente sin asignar con el RUT: " + rut, "Paciente No Encontrado", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 2. Buscar cama en las áreas
            Cama camaDestino = null;
            Area areaDestino = null;

            for (Area area : hospital.listarAreas()) {
                Cama c = area.buscarCama(idCama);
                if (c != null) {
                    camaDestino = c;
                    areaDestino = area;
                    break;
                }
            }

            if (camaDestino == null) {
                JOptionPane.showMessageDialog(this, "No existe una cama con el ID: " + idCama, "Cama No Encontrada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (camaDestino.getDisponibilidad() != 1) {
                JOptionPane.showMessageDialog(this, "La cama ID " + idCama + " no está disponible (estado ocupada o en mantención).", "Cama No Disponible", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // 3. Realizar asignación
            camaDestino.ocuparCama(paciente);
            paciente.setCamaActual(camaDestino);
            hospital.getPacientesSinAsignar().remove(paciente);

            StringBuilder sb = new StringBuilder();
            sb.append("✓ ASIGNACIÓN EXITOSA:\n");
            sb.append("   - Paciente: ").append(paciente.getNombre()).append(" (RUT: ").append(paciente.getRut()).append(")\n");
            sb.append("   - Gravedad: ").append(paciente.getGravedad()).append("\n");
            sb.append("   - Cama Asignada: ID ").append(camaDestino.getIdCama()).append(" (").append(camaDestino.getCategoriaCama()).append(")\n");
            sb.append("   - Área: ").append(areaDestino.getNombre()).append(" (Código: ").append(areaDestino.getCodigo()).append(")\n");
            txtAreaInfo.setText(sb.toString());

            JOptionPane.showMessageDialog(this, "Paciente asignado correctamente a la cama ID " + idCama);
            txtRutAsignar.setText("");
            txtIdCamaAsignar.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de cama debe ser un número entero.", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarCamasDisponibles() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================== CAMAS DISPONIBLES ===================\n\n");

        boolean hayDisponibles = false;
        for (Area area : hospital.listarAreas()) {
            for (Cama c : area.getCamas()) {
                if (c.getDisponibilidad() == 1) {
                    hayDisponibles = true;
                    sb.append("Cama ID: ").append(c.getIdCama())
                      .append(" | Categoría: ").append(c.getCategoriaCama())
                      .append(" | Área: ").append(area.getNombre())
                      .append(" (Código: ").append(area.getCodigo()).append(")\n");
                }
            }
        }

        if (!hayDisponibles) {
            sb.append("No hay camas disponibles en este momento.\n");
        }

        txtAreaInfo.setText(sb.toString());
    }

    private void listarPacientesEnEspera() {
        StringBuilder sb = new StringBuilder();
        sb.append("============= PACIENTES EN LISTA DE ESPERA =============\n\n");

        if (hospital.getPacientesSinAsignar().isEmpty()) {
            sb.append("No hay pacientes en lista de espera.\n");
        } else {
            for (Paciente p : hospital.getPacientesSinAsignar()) {
                sb.append("• Nombre: ").append(p.getNombre())
                  .append(" | RUT: ").append(p.getRut())
                  .append(" | Edad: ").append(p.getEdad())
                  .append(" | Atención: ").append(p.obtenerTipoAtencion())
                  .append(" | Gravedad: ").append(p.getGravedad())
                  .append("\n");
            }
        }

        txtAreaInfo.setText(sb.toString());
    }

    private void reubicarPorGravedad() {
        StringBuilder sb = new StringBuilder();
        sb.append("============== REUBICACIÓN SEGÚN GRAVEDAD ==============\n\n");

        ArrayList<Area> areas = hospital.listarAreas();
        int reubicados = 0;

        // Caso: Paciente en área no crítica con gravedad severa (>= 4.0) que requiere traslado a Urgencias o UCI
        for (Area areaOrigen : areas) {
            if (areaOrigen.getNombre().toLowerCase().contains("uci")) {
                continue; // Ya se encuentra en UCI
            }

            for (Cama camaOrigen : areaOrigen.getCamas()) {
                if (camaOrigen.isOcupada() && camaOrigen.getPacienteActual() != null) {
                    Paciente p = camaOrigen.getPacienteActual();

                    if (p.getGravedad() >= 4.0f) {
                        // Buscar cama disponible en UCI o área de mayor complejidad
                        Cama camaDestino = null;
                        Area areaDestino = null;

                        for (Area a : areas) {
                            if (a.getNombre().toLowerCase().contains("uci") || a.getNombre().toLowerCase().contains("urgencia")) {
                                for (Cama cd : a.getCamas()) {
                                    if (cd.getDisponibilidad() == 1) {
                                        camaDestino = cd;
                                        areaDestino = a;
                                        break;
                                    }
                                }
                            }
                            if (camaDestino != null) break;
                        }

                        if (camaDestino != null && areaDestino != null) {
                            camaOrigen.desocuparCama();
                            camaDestino.ocuparCama(p);
                            p.setCamaActual(camaDestino);

                            sb.append("✓ TRASLADO CRÍTICO: ").append(p.getNombre())
                              .append(" (RUT: ").append(p.getRut()).append(", Gravedad: ").append(p.getGravedad()).append(")\n")
                              .append("   Trasladado de Cama ID ").append(camaOrigen.getIdCama()).append(" (").append(areaOrigen.getNombre()).append(")\n")
                              .append("   A Cama ID ").append(camaDestino.getIdCama()).append(" (").append(areaDestino.getNombre()).append(")\n\n");

                            reubicados++;
                        }
                    }
                }
            }
        }

        if (reubicados == 0) {
            sb.append("No se registraron pacientes que requieran reubicación inmediata por gravedad o no hay camas de alta complejidad disponibles.\n");
            JOptionPane.showMessageDialog(this, "No se requirió reubicación de pacientes.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Se completaron " + reubicados + " reubicación(es) por gravedad exitosamente.");
        }

        txtAreaInfo.setText(sb.toString());
    }

    private void automatizarAltas() {
        StringBuilder sb = new StringBuilder();
        sb.append("=========== AUTOMATIZACIÓN DE ESTATUS 'ALTA' ===========\n\n");

        int altas = 0;
        for (Area area : hospital.listarAreas()) {
            for (Cama c : area.getCamas()) {
                if (c.isOcupada() && c.getPacienteActual() != null) {
                    Paciente p = c.getPacienteActual();

                    // Criterio clínico: gravedad menor o igual a 1.0 representa signos estables
                    if (p.getGravedad() <= 1.0f) {
                        sb.append("✓ ALTA MÉDICA OTORGADA: ").append(p.getNombre())
                          .append(" (RUT: ").append(p.getRut()).append(")\n")
                          .append("   - Gravedad estabilizada: ").append(p.getGravedad()).append("\n")
                          .append("   - Cama liberada: ID ").append(c.getIdCama())
                          .append(" en ").append(area.getNombre()).append("\n\n");

                        c.desocuparCama();
                        p.setCamaActual(null);
                        altas++;
                    }
                }
            }
        }

        if (altas == 0) {
            sb.append("No hay pacientes internados con condición de alta médica (gravedad <= 1.0).\n");
            JOptionPane.showMessageDialog(this, "No se encontraron pacientes para dar de alta en este momento.", "Sin altas", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Se procesaron " + altas + " alta(s) médica(s) y camas liberadas exitosamente.");
        }

        txtAreaInfo.setText(sb.toString());
    }
}
