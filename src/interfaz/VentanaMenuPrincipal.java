package Ventanas;

import modelo.*;
import javax.swing.*;
import java.awt.*;

public class VentanaMenuPrincipal extends JFrame {
    private Hospital hospital;

    public VentanaMenuPrincipal(Hospital hospital) {
        this.hospital = hospital;

        setTitle("SIA - Gestión Hospitalaria");
        setSize(550, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Título del Sistema
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN HOSPITALARIA");
        lblTitulo.setBounds(80, 20, 400, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(lblTitulo);

        // Subtítulo con datos del Hospital
        JLabel lblHospital = new JLabel("Hospital: " + hospital.getNombre() + " (" + hospital.getDireccion() + ")");
        lblHospital.setBounds(100, 55, 350, 25);
        lblHospital.setFont(new Font("Arial", Font.ITALIC, 14));
        panel.add(lblHospital);

        // Botón Gestión de Áreas
        JButton btnAreas = new JButton("1. Gestión de Áreas");
        btnAreas.setBounds(150, 100, 230, 35);
        btnAreas.setFocusPainted(false);
        btnAreas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAreas.addActionListener(e -> {
            new VentanaGestionAreas(hospital);
        });
        panel.add(btnAreas);

        // Botón Gestión de Camas
        JButton btnCamas = new JButton("2. Gestión de Camas");
        btnCamas.setBounds(150, 150, 230, 35);
        btnCamas.setFocusPainted(false);
        btnCamas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnCamas.addActionListener(e -> {
            new VentanaGestionCamas(hospital);
        });
        panel.add(btnCamas);

        // Botón Gestión de Pacientes
        JButton btnPacientes = new JButton("3. Gestión de Pacientes");
        btnPacientes.setBounds(150, 200, 230, 35);
        btnPacientes.setFocusPainted(false);
        btnPacientes.setFont(new Font("Arial", Font.PLAIN, 14));
        btnPacientes.addActionListener(e -> {
            new VentanaGestionPacientes(hospital);
        });
        panel.add(btnPacientes);

        // Botón Funciones Especiales / Clínicas
        JButton btnEspeciales = new JButton("4. Funciones Especiales");
        btnEspeciales.setBounds(150, 250, 230, 35);
        btnEspeciales.setFocusPainted(false);
        btnEspeciales.setFont(new Font("Arial", Font.PLAIN, 14));
        btnEspeciales.addActionListener(e -> {
            new VentanaFuncionesEspeciales(hospital);
        });
        panel.add(btnEspeciales);

        // Botón Cerrar / Volver
        JButton btnCerrar = new JButton("Cerrar Ventana");
        btnCerrar.setBounds(200, 315, 130, 30);
        btnCerrar.setFocusPainted(false);
        btnCerrar.addActionListener(e -> {
            dispose();
        });
        panel.add(btnCerrar);

        add(panel);
        setVisible(true);
    }
}
