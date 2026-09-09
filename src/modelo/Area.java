package modelo;

import java.util.ArrayList;
import java.util.List;

public class Area{

    private String codigo;
    private String nombre;
    private int capacidadMaxima;
    private List<Cama> camas;

    public Area(String codigo, String nombre, int capacidadMaxima){
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.camas = new ArrayList<>();
    }

    public boolean agregarCama(Cama cama){
        if (cama == null) {
            return false;
        }
        if (this.camas.size() >= this.capacidadMaxima){
            return false;
        }
        if (buscarCama(cama.getIdCama()) != null){
            return false;
        }
        return this.camas.add(cama);
    }

    public Cama buscarCama(int idCama){
        for (int i = 0; i < this.camas.size(); i++){
            Cama c = this.camas.get(i);
            if (c.getIdCama() == idCama){
                return c;
            }
        }
        return null;
    }

    public Cama buscarCama(String rutPaciente){
        if (rutPaciente == null || rutPaciente.isEmpty()) {
            return null;
        }
        for (int i = 0; i < this.camas.size(); i++) {
            Cama c = this.camas.get(i);
            if (c.isOcupada() && c.getPacienteActual().getRut().equals(rutPaciente)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarCama(int idCama){
        Cama cama = buscarCama(idCama);
        if (cama != null && !cama.isOcupada()){
            return this.camas.remove(cama);
        }
        return false;
    }

    public List<Cama> getCamasDisponibles(){
        List<Cama> disponibles = new ArrayList<>();

        for (int i = 0; i < this.camas.size(); i++){
            Cama c = this.camas.get(i);
            if (!c.isOcupada()){
                disponibles.add(c);
            }
        }
        return disponibles;
    }

    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Cama> getCamas(){
        return camas;
    }

    public void setCamas(List<Cama> camas){
        this.camas = camas;
    }
}
