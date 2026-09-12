package Ventanas;

import modelo.*;
import excepciones.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaGestionAreas extends JFrame {
    private Hospital hospital;

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtCapacidad;
    private JTextArea txtAreaInfo;

    public VentanaGestionAreas(Hospital hospital) {
        this.hospital = hospital;

        setTitle("Gestión de Áreas");
        setSize(680, 530);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Título
        JLabel lblTitulo = new JLabel("Administración de Áreas");
        lblTitulo.setBounds(230, 15, 250, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        // Código del Área
        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(40, 60, 80, 25);
        panel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 60, 160, 25);
        panel.add(txtCodigo);

        // Nombre del Área
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 95, 80, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(120, 95, 160, 25);
        panel.add(txtNombre);

        // Capacidad Máxima
        JLabel lblCapacidad = new JLabel("Capacidad:");
        lblCapacidad.setBounds(40, 130, 80, 25);
        panel.add(lblCapacidad);

        txtCapacidad = new JTextField();
        txtCapacidad.setBounds(120, 130, 160, 25);
        panel.add(txtCapacidad);

        // Botón Agregar Área
        JButton btnAgregar = new JButton("Agregar Área");
        btnAgregar.setBounds(310, 60, 150, 28);
        btnAgregar.setFocusPainted(false);
        btnAgregar.addActionListener(e -> agregarArea());
        panel.add(btnAgregar);

        // Botón Buscar por Código
        JButton btnBuscarCod = new JButton("Buscar por Código");
        btnBuscarCod.setBounds(310, 95, 150, 28);
        btnBuscarCod.setFocusPainted(false);
        btnBuscarCod.addActionListener(e -> buscarAreaPorCodigo());
        panel.add(btnBuscarCod);

        // Botón Buscar por Nombre
        JButton btnBuscarNom = new JButton("Buscar por Nombre");
        btnBuscarNom.setBounds(310, 130, 150, 28);
        btnBuscarNom.setFocusPainted(false);
        btnBuscarNom.addActionListener(e -> buscarAreaPorNombre());
        panel.add(btnBuscarNom);

        // Botón Modificar Área
        JButton btnModificar = new JButton("Modificar Área");
        btnModificar.setBounds(480, 60, 150, 28);
        btnModificar.setFocusPainted(false);
        btnModificar.addActionListener(e -> modificarArea());
        panel.add(btnModificar);

        // Botón Eliminar Área
        JButton btnEliminar = new JButton("Eliminar Área");
        btnEliminar.setBounds(480, 95, 150, 28);
        btnEliminar.setFocusPainted(false);
        btnEliminar.addActionListener(e -> eliminarArea());
        panel.add(btnEliminar);

        // Botón Listar Áreas
        JButton btnListar = new JButton("Listar Áreas");
        btnListar.setBounds(480, 130, 150, 28);
        btnListar.setFocusPainted(false);
        btnListar.addActionListener(e -> listarAreas());
        panel.add(btnListar);

        // Área de información con Scroll
        txtAreaInfo = new JTextArea();
        txtAreaInfo.setEditable(false);
        txtAreaInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollInfo = new JScrollPane(txtAreaInfo);
        scrollInfo.setBounds(40, 180, 590, 240);
        panel.add(scrollInfo);

        // Botón Limpiar Campos
        JButton btnLimpiar = new JButton("Limpiar Campos");
        btnLimpiar.setBounds(180, 440, 140, 30);
        btnLimpiar.setFocusPainted(false);
        btnLimpiar.addActionListener(e -> limpiarCampos());
        panel.add(btnLimpiar);

        // Botón Cerrar
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(350, 440, 120, 30);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> dispose());
        panel.add(btnCerrar);

        add(panel);
        setVisible(true);
    }

    private void agregarArea() {
        try {
            String strCod = txtCodigo.getText().trim();
            String nombre = txtNombre.getText().trim();
            String strCap = txtCapacidad.getText().trim();

            if (strCod.isEmpty() || nombre.isEmpty() || strCap.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe completar todos los campos.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int codigo = Integer.parseInt(strCod);
            int capacidad = Integer.parseInt(strCap);

            Area nueva = new Area(codigo, nombre, capacidad);
            if (hospital.agregarArea(nueva)) {
                txtAreaInfo.setText("✓ Área '" + nombre + "' agregada con éxito (Código: " + codigo + ", Capacidad: " + capacidad + ").\n");
                JOptionPane.showMessageDialog(this, "Área agregada correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Ya existe un área con el código " + codigo, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Código y Capacidad deben ser valores numéricos enteros.", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarAreaPorCodigo() {
        try {
            String strCod = txtCodigo.getText().trim();
            if (strCod.isEmpty()) {
                strCod = JOptionPane.showInputDialog(this, "Ingrese el código del área a buscar:");
                if (strCod == null || strCod.trim().isEmpty()) return;
            }

            int codigo = Integer.parseInt(strCod.trim());
            Area area = hospital.buscarArea(codigo);

            txtCodigo.setText(String.valueOf(area.getCodigo()));
            txtNombre.setText(area.getNombre());
            txtCapacidad.setText(String.valueOf(area.getCapacidadMaxima()));

            StringBuilder sb = new StringBuilder();
            sb.append("=== ÁREA ENCONTRADA ===\n");
            sb.append("Código: ").append(area.getCodigo()).append("\n");
            sb.append("Nombre: ").append(area.getNombre()).append("\n");
            sb.append("Capacidad Máxima: ").append(area.getCapacidadMaxima()).append("\n");
            sb.append("Camas Registradas: ").append(area.getCamas().size()).append("\n");
            sb.append("------------------------------------\n");
            for (Cama c : area.getCamas()) {
                sb.append("  • Cama ID: ").append(c.getIdCama())
                  .append(" | Categoría: ").append(c.getCategoriaCama())
                  .append(" | Estado: ").append(c.isOcupada() ? "Ocupada (" + c.getPacienteActual().getNombre() + ")" : "Disponible")
                  .append("\n");
            }
            txtAreaInfo.setText(sb.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionAreaNoExistente ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Área No Encontrada", JOptionPane.ERROR_MESSAGE);
            txtAreaInfo.setText(ex.getMessage() + "\n");
        }
    }

    private void buscarAreaPorNombre() {
        try {
            String nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) {
                nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del área a buscar:");
                if (nombre == null || nombre.trim().isEmpty()) return;
            }

            ArrayList<Area> encontradas = hospital.buscarArea(nombre.trim());
            StringBuilder sb = new StringBuilder();
            sb.append("=== ÁREAS ENCONTRADAS (" + encontradas.size() + ") ===\n\n");
            for (Area a : encontradas) {
                sb.append("Código: ").append(a.getCodigo()).append("\n");
                sb.append("Nombre: ").append(a.getNombre()).append("\n");
                sb.append("Capacidad: ").append(a.getCapacidadMaxima()).append("\n");
                sb.append("Total Camas: ").append(a.getCamas().size()).append("\n");
                sb.append("------------------------------------\n");
            }
            txtAreaInfo.setText(sb.toString());

        } catch (ExcepcionAreaNoExistente ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Área No Encontrada", JOptionPane.ERROR_MESSAGE);
            txtAreaInfo.setText(ex.getMessage() + "\n");
        }
    }

    private void modificarArea() {
        try {
            String strCod = txtCodigo.getText().trim();
            if (strCod.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese o busque el código del área a modificar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int codigo = Integer.parseInt(strCod);
            Area area = hospital.buscarArea(codigo);

            String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo nombre del área:", area.getNombre());
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                area.setNombre(nuevoNombre.trim());
            }

            String nuevaCapStr = JOptionPane.showInputDialog(this, "Nueva capacidad máxima:", area.getCapacidadMaxima());
            if (nuevaCapStr != null && !nuevaCapStr.trim().isEmpty()) {
                int nuevaCap = Integer.parseInt(nuevaCapStr.trim());
                area.setCapacidadMaxima(nuevaCap);
            }

            txtNombre.setText(area.getNombre());
            txtCapacidad.setText(String.valueOf(area.getCapacidadMaxima()));
            txtAreaInfo.setText("✓ Área código " + codigo + " modificada exitosamente.\n");
            JOptionPane.showMessageDialog(this, "Área modificada correctamente.");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La capacidad debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionAreaNoExistente ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarArea() {
        try {
            String strCod = txtCodigo.getText().trim();
            if (strCod.isEmpty()) {
                strCod = JOptionPane.showInputDialog(this, "Ingrese el código del área a eliminar:");
                if (strCod == null || strCod.trim().isEmpty()) return;
            }
            int codigo = Integer.parseInt(strCod.trim());

            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de eliminar el área código " + codigo + "?", 
                "Confirmar Eliminación", 
                JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                hospital.eliminarArea(codigo);
                txtAreaInfo.setText("✓ Área código " + codigo + " eliminada correctamente.\n");
                JOptionPane.showMessageDialog(this, "Área eliminada exitosamente.");
                limpiarCampos();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El código debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionAreaNoExistente ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            txtAreaInfo.setText(ex.getMessage() + "\n");
        }
    }

    private void listarAreas() {
        ArrayList<Area> lista = hospital.listarAreas();
        if (lista.isEmpty()) {
            txtAreaInfo.setText("No hay áreas registradas en el hospital.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=================== LISTADO DE ÁREAS ===================\n\n");
        for (Area a : lista) {
            sb.append("Código: ").append(a.getCodigo())
              .append(" | Nombre: ").append(a.getNombre())
              .append(" | Capacidad: ").append(a.getCapacidadMaxima())
              .append(" | Camas: ").append(a.getCamas().size()).append("\n");
        }
        txtAreaInfo.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCapacidad.setText("");
    }
}
