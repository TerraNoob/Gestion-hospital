package modelo;
import java.util.HashMap;
import java.util.ArrayList;

public class Hospital {
	private HashMap<Integer, Area> areas;
	private String nombre;
	private String direccion;
	private ArrayList<Paciente> pacientesSinAsignar;
	
	public Hospital(String n, String d) {
		this.nombre = n;
        this.direccion = d;
        this.areas = new HashMap<>();
        this.pacientesSinAsignar = new ArrayList<>();
	}
	
	public void setAreas(HashMap<Integer, Area> areas) {
	    this.areas = areas;
	}
	public void setNombre(String n) {
		this.nombre = n;
	}
	public void setDireccion(String d) {
		this.direccion = d;
	}
	 public HashMap<Integer, Area> getAreas() {
	    return areas;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public ArrayList<Paciente> getPacientesSinAsignar(){
		return pacientesSinAsignar;
	}
	public boolean agregarArea(Area area) {
	    if (areas.containsKey(area.getCodigo())) {
	        return false;
	    }

	    areas.put(area.getCodigo(), area);
	    return true;
	}
	
	public boolean eliminarArea(int id) {
	    if (areas.containsKey(id)) {
	    	areas.remove(id);
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	public Area buscarArea(int id) {
	    return areas.get(id);
	}
	

	public ArrayList<Area> buscarArea(String nombre){
    	ArrayList<Area> resultado = new ArrayList<>();
    	ArrayList<Area> lista = listarAreas();

    	if (nombre == null){
        	return resultado;
    	}

    	for (int i = 0; i < lista.size(); i++) {
        	Area area = lista.get(i);
        	if (area.getNombre() != null && area.getNombre().toLowerCase().equals(nombre.toLowerCase())){
            	resultado.add(area);
        	}
    	}

    	return resultado;
	}
	

	
	public ArrayList<Area> listarAreas() {
		return new ArrayList<>(areas.values());
	}

	public boolean agregarPacienteSinAsignar(Paciente paciente) {
	    if (paciente == null) {
	        return false;
	    }

	    pacientesSinAsignar.add(paciente);
	    return true;
	}
	
	
	
	 
}
