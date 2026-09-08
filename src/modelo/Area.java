package modelo;
import java.util.ArrayList;

public class Area {
	private ArrayList<Paciente> pacientes = new ArrayList<>();
	private ArrayList<Cama> camas = new ArrayList<>();
	private int id; //Para el HashMap 
	private int capacidad;
	
	public Area(int i,int c) {
		this.id = i;
		this.capacidad = c;
	}
	
	public int getId() {
		return this.id;
	}
	public int getCapacidad() {
		return this.capacidad;
	}
	public ArrayList<Cama> getCamas() {
	    return camas;
	}

	public ArrayList<Paciente> getPacientes() {
	    return pacientes;
	}
	public void setCapacidad(int c) {
		this.capacidad = c;
	}
	public boolean agregarPaciente(Paciente nuevo) {
		if(pacientes.size()<capacidad) {
			pacientes.add(nuevo);
			return true;
		}else {
			return false;
		}
	}
	public boolean agregarCama(Cama nueva) {
		if(camas.size() < capacidad) {
			camas.add(nueva);
			return true;
		}else {
			return false;
		}
		
	}
}
