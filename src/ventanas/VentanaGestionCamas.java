package ventanas;

import modelo.*;
import excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaGestionCamas extends JFrame {
    private Hospital hospital;

    private JTextField txtCodigoArea;
    private JTextField txtIdCama;
    private JTextField txtCategoria;
    private JTextArea txtAreaInfo;

    public VentanaGestionCamas(Hospital hospital) {
        this.hospital = hospital;

        setTitle("Gestión de Camas");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Administración de Camas");
        lblTitulo.setBounds(240, 15, 250, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        // Código del Área
        JLabel lblCodigoArea = new JLabel("Código Área:");
        lblCodigoArea.setBounds(40, 60, 90, 25);
        panel.add(lblCodigoArea);

        txtCodigoArea = new JTextField();
        txtCodigoArea.setBounds(140, 60, 140, 25);
        panel.add(txtCodigoArea);

        // ID de Cama
        JLabel lblIdCama = new JLabel("ID Cama:");
        lblIdCama.setBounds(40, 95, 90, 25);
        panel.add(lblIdCama);

        txtIdCama = new JTextField();
        txtIdCama.setBounds(140, 95, 140, 25);
        panel.add(txtIdCama);

        // Categoría de Cama
        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(40, 130, 90, 25);
        panel.add(lblCategoria);

        txtCategoria = new JTextField();
        txtCategoria.setBounds(140, 130, 140, 25);
        panel.add(txtCategoria);

        // Botón Agregar Cama
        JButton btnAgregar = new JButton("Agregar Cama");
        btnAgregar.setBounds(310, 60, 160, 28);
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(e -> agregarCama());
        panel.add(btnAgregar);

        // Botón Buscar por ID
        JButton btnBuscarId = new JButton("Buscar por ID");
        btnBuscarId.setBounds(310, 95, 160, 28);
        btnBuscarId.setFocusPainted(false);
        btnBuscarId.addActionListener(e -> buscarCamaPorId());
        panel.add(btnBuscarId);

        // Botón Buscar por RUT Paciente
        JButton btnBuscarRut = new JButton("Buscar por RUT");
        btnBuscarRut.setBounds(310, 130, 160, 28);
        btnBuscarRut.setFocusPainted(false);
        btnBuscarRut.addActionListener(e -> buscarCamaPorRut());
        panel.add(btnBuscarRut);

        // Botón Modificar Cama
        JButton btnModificar = new JButton("Modificar Categoría");
        btnModificar.setBounds(490, 60, 160, 28);
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(e -> modificarCama());
        panel.add(btnModificar);

        // Botón Eliminar Cama
        JButton btnEliminar = new JButton("Eliminar Cama");
        btnEliminar.setBounds(490, 95, 160, 28);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(e -> eliminarCama());
        panel.add(btnEliminar);

        // Botón Listar Camas
        JButton btnListar = new JButton("Listar Camas");
        btnListar.setBounds(490, 130, 160, 28);
        btnListar.setFocusPainted(false);
        btnListar.addActionListener(e -> listarCamas());
        panel.add(btnListar);

        // Área de información con Scroll
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollInfo = new JScrollPane(txtAreaInfo);
        scrollInfo.setBounds(40, 180, 610, 260);
        panel.add(scrollInfo);

        // Botón Limpiar Campos
        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setBounds(200, 460, 140, 30);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panel.add(btnLimpiar);

        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(360, 460, 120, 30);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        add(panel);
        setVisible(true);
    }

    private void agregarCama() {
        try {
            String strCod = txtCodigoArea.getText().trim();
            String strId = txtIdCama.getText().trim();
            String categoria = txtCategoria.getText().trim();

            if (strCod.isEmpty() || strId.isEmpty() || categoria.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar Código de Área, ID de Cama y Categoría.", "Campos Requeridos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codArea = Integer.parseInt(strCod);
            int idCama = Integer.parseInt(strId);

            Area area = hospital.buscarArea(codArea);
            Cama nuevaCama = new Cama(idCama, categoria);

            if (area.agregarCama(nuevaCama)) {
                txtAreaInfo.setText("✓ Cama ID " + idCama + " (" + categoria + ") agregada correctamente al área '" + area.getNombre() + "'.\n");
                JOptionPane.showMessageDialog(this, "Cama agregada exitosamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo agregar la cama. Verifique que no exista otra con el mismo ID o que no se supere la capacidad máxima (" + area.getCapacidadMaxima() + ").", "Error al agregar", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Código de Área e ID de Cama deben ser valores numéricos enteros.", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionAreaNoExistente ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Área No Encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCamaPorId() {
        try {
            String strId = txtIdCama.getText().trim();
            if (strId.isEmpty()) {
                strId = JOptionPane.showInputDialog(this, "Ingrese el ID de la cama a buscar:");
                if (strId == null || strId.trim().isEmpty()) return;
            }

            int idCama = Integer.parseInt(strId.trim());
            ArrayList<Area> areas = hospital.listarAreas();
            Cama encontrada = null;
            Area areaPerteneciente = null;

            for (Area a : areas) {
                encontrada = a.buscarCama(idCama);
                if (encontrada != null) {
                    areaPerteneciente = a;
                    break;
                }
            }

            if (encontrada != null) {
                txtIdCama.setText(String.valueOf(encontrada.getIdCama()));
                txtCategoria.setText(encontrada.getCategoriaCama());
                txtCodigoArea.setText(String.valueOf(areaPerteneciente.getCodigo()));

                StringBuilder sb = new StringBuilder();
                sb.append("=== CAMA ENCONTRADA ===\n");
                sb.append("ID Cama: ").append(encontrada.getIdCama()).append("\n");
                sb.append("Categoría: ").append(encontrada.getCategoriaCama()).append("\n");
                sb.append("Área: ").append(areaPerteneciente.getNombre()).append(" (Código: ").append(areaPerteneciente.getCodigo()).append(")\n");
                sb.append("Disponibilidad: ").append(encontrada.isOcupada() ? "Ocupada" : "Disponible").append("\n");

                if (encontrada.getPacienteActual() != null) {
                    Paciente p = encontrada.getPacienteActual();
                    sb.append("Paciente Internado: ").append(p.getNombre()).append("\n");
                    sb.append("RUT: ").append(p.getRut()).append(" | Edad: ").append(p.getEdad()).append("\n");
                    sb.append("Gravedad: ").append(p.getGravedad()).append("\n");
                } else {
                    sb.append("Paciente: Ninguno (Cama Libre)\n");
                }
                txtAreaInfo.setText(sb.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna cama con el ID " + idCama, "No Encontrada", JOptionPane.INFORMATION_MESSAGE);
                txtAreaInfo.setText("No se encontró ninguna cama con el ID " + idCama + ".\n");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de cama debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarCamaPorRut() {
        String rut = JOptionPane.showInputDialog(this, "Ingrese el RUT del paciente internado:");
        if (rut == null || rut.trim().isEmpty()) return;

        ArrayList<Area> areas = hospital.listarAreas();
        Cama encontrada = null;
        Area areaPerteneciente = null;

        for (Area a : areas) {
            encontrada = a.buscarCama(rut.trim());
            if (encontrada != null) {
                areaPerteneciente = a;
                break;
            }
        }

        if (encontrada != null) {
            txtIdCama.setText(String.valueOf(encontrada.getIdCama()));
            txtCategoria.setText(encontrada.getCategoriaCama());
            txtCodigoArea.setText(String.valueOf(areaPerteneciente.getCodigo()));

            Paciente p = encontrada.getPacienteActual();
            StringBuilder sb = new StringBuilder();
            sb.append("=== CAMA ENCONTRADA POR PACIENTE ===\n");
            sb.append("ID Cama: ").append(encontrada.getIdCama()).append("\n");
            sb.append("Área: ").append(areaPerteneciente.getNombre()).append("\n");
            sb.append("Categoría: ").append(encontrada.getCategoriaCama()).append("\n");
            sb.append("Paciente: ").append(p.getNombre()).append(" (RUT: ").append(p.getRut()).append(")\n");
            sb.append("Gravedad: ").append(p.getGravedad()).append("\n");
            txtAreaInfo.setText(sb.toString());
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ninguna cama con un paciente de RUT: " + rut, "No Encontrada", JOptionPane.INFORMATION_MESSAGE);
            txtAreaInfo.setText("No se encontró ninguna cama con un paciente de RUT " + rut + ".\n");
        }
    }

    private void modificarCama() {
        try {
            String strId = txtIdCama.getText().trim();
            if (strId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese o busque el ID de la cama a modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int idCama = Integer.parseInt(strId);
            Cama cama = null;
            for (Area a : hospital.listarAreas()) {
                cama = a.buscarCama(idCama);
                if (cama != null) break;
            }

            if (cama == null) {
                JOptionPane.showMessageDialog(this, "No existe una cama con el ID " + idCama, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String nuevaCat = JOptionPane.showInputDialog(this, "Nueva categoría para la cama ID " + idCama + ":", cama.getCategoriaCama());
            if (nuevaCat != null && !nuevaCat.trim().isEmpty()) {
                cama.setCategoriaCama(nuevaCat.trim());
                txtCategoria.setText(nuevaCat.trim());
                txtAreaInfo.setText("✓ Categoría de la cama ID " + idCama + " actualizada a '" + nuevaCat.trim() + "'.\n");
                JOptionPane.showMessageDialog(this, "Cama modificada correctamente.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de cama debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarCama() {
        try {
            String strId = txtIdCama.getText().trim();
            if (strId.isEmpty()) {
                strId = JOptionPane.showInputDialog(this, "Ingrese el ID de la cama a eliminar:");
                if (strId == null || strId.trim().isEmpty()) return;
            }

            int idCama = Integer.parseInt(strId.trim());
            for (Area area : hospital.listarAreas()) {
                Cama cama = area.buscarCama(idCama);
                if (cama != null) {
                    if (cama.isOcupada()) {
                        JOptionPane.showMessageDialog(this, "No se puede eliminar una cama ocupada por un paciente.", "Acción Denegada", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la cama ID " + idCama + " del área '" + area.getNombre() + "'?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        area.eliminarCama(idCama);
                        txtAreaInfo.setText("✓ Cama ID " + idCama + " eliminada exitosamente del área " + area.getNombre() + ".\n");
                        JOptionPane.showMessageDialog(this, "Cama eliminada correctamente.");
                        limpiarCampos();
                    }
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "No existe una cama con ese ID.", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El ID de cama debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarCamas() {
        String strCod = txtCodigoArea.getText().trim();
        StringBuilder sb = new StringBuilder();

        if (!strCod.isEmpty()) {
            try {
                int cod = Integer.parseInt(strCod);
                Area area = hospital.buscarArea(cod);
                sb.append("=== CAMAS DEL ÁREA: ").append(area.getNombre()).append(" (Código: ").append(area.getCodigo()).append(") ===\n\n");
                if (area.getCamas().isEmpty()) {
                    sb.append("No hay camas registradas en esta área.\n");
                } else {
                    for (Cama c : area.getCamas()) {
                        sb.append("Cama ID: ").append(c.getIdCama())
                          .append(" | Categoría: ").append(c.getCategoriaCama())
                          .append(" | Estado: ").append(c.isOcupada() ? "Ocupada (" + c.getPacienteActual().getNombre() + ")" : "Disponible")
                          .append("\n");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "El código de área debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (ExcepcionAreaNoExistente ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            sb.append("=================== TODAS LAS CAMAS DEL HOSPITAL ===================\n\n");
            ArrayList<Area> areas = hospital.listarAreas();
            if (areas.isEmpty()) {
                sb.append("No hay áreas ni camas registradas en el hospital.\n");
            } else {
                for (Area a : areas) {
                    sb.append("--- Área: ").append(a.getNombre()).append(" (Código: ").append(a.getCodigo()).append(") ---\n");
                    if (a.getCamas().isEmpty()) {
                        sb.append("   (Sin camas registradas)\n");
                    } else {
                        for (Cama c : a.getCamas()) {
                            sb.append("   • Cama ID: ").append(c.getIdCama())
                              .append(" | Categoría: ").append(c.getCategoriaCama())
                              .append(" | Estado: ").append(c.isOcupada() ? "Ocupada (" + c.getPacienteActual().getNombre() + " - RUT: " + c.getPacienteActual().getRut() + ")" : "Disponible")
                              .append("\n");
                        }
                    }
                    sb.append("\n");
                }
            }
        }

        txtAreaInfo.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtCodigoArea.setText("");
        txtIdCama.setText("");
        txtCategoria.setText("");
    }
}
