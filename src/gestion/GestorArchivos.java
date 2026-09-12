/***package gestion;

import modelo.*;
import excepciones.*;
import java.io.*;
import java.util.ArrayList;

public class GestorArchivos {

    private static final String RUTA_AREAS = "areas.txt";
    private static final String RUTA_CAMAS = "camas.txt";
    private static final String RUTA_PACIENTES = "pacientes.txt";

    public static void guardarDatos(Hospital hospital) {
        try {
            BufferedWriter wAreas = new BufferedWriter(new FileWriter(RUTA_AREAS));
            BufferedWriter wCamas = new BufferedWriter(new FileWriter(RUTA_CAMAS));
            BufferedWriter wPac = new BufferedWriter(new FileWriter(RUTA_PACIENTES));

            ArrayList<Area> areas = hospital.listarAreas();

            // 1. Guardar áreas, camas y pacientes asignados
            for (int i = 0; i < areas.size(); i++) {
                Area a = areas.get(i);
                wAreas.write(a.getCodigo() + "," + a.getNombre() + "," + a.getCapacidadMaxima() + "\n");

                for (int j = 0; j < a.getCamas().size(); j++) {
                    Cama c = a.getCamas().get(j);
                    wCamas.write(a.getCodigo() + "," + c.getIdCama() + "," + c.getCategoriaCama() + "," + c.getDisponibilidad() + "\n");
                    
                    if (c.getPacienteActual() != null) {
                        guardarLineaPaciente(wPac, c.getPacienteActual(), c.getIdCama());
                    }
                }
            }

            // 2. Guardar pacientes sin asignar
            for (int i = 0; i < hospital.getPacientesSinAsignar().size(); i++) {
                guardarLineaPaciente(wPac, hospital.getPacientesSinAsignar().get(i), 0);
            }

            wAreas.close();
            wCamas.close();
            wPac.close();
            System.out.println("Datos guardados correctamente.");

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    private static void guardarLineaPaciente(BufferedWriter w, Paciente p, int idCama) throws IOException {
        String tipo = (p instanceof Adulto) ? "A" : "N";
        String ex1 = (p instanceof Adulto) ? ((Adulto) p).getSistemaPrevision() : ((Nino) p).getNombreApoderado();
        String ex2 = (p instanceof Nino) ? ((Nino) p).getRutApoderado() : "NA";
        SignosVitales s = p.getSignos();

        w.write(tipo + "," + p.getRut() + "," + p.getNombre() + "," + p.getEdad() + "," +
                (s != null ? s.getFrecuenciaCardiaca() : 0) + "," + 
                (s != null ? s.getPresionArterial() : 0.0) + "," +
                (s != null ? s.getSaturacion() : 0) + "," + 
                (s != null ? s.getTemperatura() : 0.0) + "," +
                ex1 + "," + ex2 + "," + idCama + "\n");
    }

    public static void cargarDatos(Hospital hospital) {
        try {
            String linea;
            
            // 1. Cargar áreas
            BufferedReader rAreas = new BufferedReader(new FileReader(RUTA_AREAS));
            while ((linea = rAreas.readLine()) != null) {
                String[] d = linea.split(",");
                hospital.agregarArea(new Area(Integer.parseInt(d[0]), d[1], Integer.parseInt(d[2])));
            }
            rAreas.close();

            // 2. Cargar camas
            BufferedReader rCamas = new BufferedReader(new FileReader(RUTA_CAMAS));
            while ((linea = rCamas.readLine()) != null) {
                String[] d = linea.split(",");
                Cama c = new Cama(Integer.parseInt(d[1]), d[2]);
                c.setDisponibilidad(Integer.parseInt(d[3]));
                hospital.buscarArea(Integer.parseInt(d[0])).agregarCama(c);
            }
            rCamas.close();

            // 3. Cargar pacientes
            BufferedReader rPac = new BufferedReader(new FileReader(RUTA_PACIENTES));
            while ((linea = rPac.readLine()) != null) {
                String[] d = linea.split(",");
                SignosVitales s = new SignosVitales(Integer.parseInt(d[4]), Double.parseDouble(d[5]), Integer.parseInt(d[6]), Double.parseDouble(d[7]));
                Paciente p;

                if (d[0].equals("A")) {
                    p = new Adulto(d[2], d[1], Integer.parseInt(d[3]), s, null, d[8]);
                } else {
                    p = new Nino(d[2], d[1], Integer.parseInt(d[3]), null, d[8], d[9]);
                    p.setSignos(s);
                }

                int idCama = Integer.parseInt(d[10]);
                if (idCama == 0) {
                    hospital.agregarPacienteSinAsignar(p);
                } else {
                    ArrayList<Area> areas = hospital.listarAreas();
                    for (int i = 0; i < areas.size(); i++) {
                        Cama c = areas.get(i).buscarCama(idCama);
                        if (c != null) {
                            c.ocuparCama(p);
                            p.setCamaActual(c);
                            break;
                        }
                    }
                }
            }
            rPac.close();
            System.out.println("Datos cargados correctamente.");

        } catch (Exception e) {
            System.out.println("No se encontraron archivos previos. Iniciando sistema vacío.");
        }
    }
}
***/
