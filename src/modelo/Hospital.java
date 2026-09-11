package modelo;
import java.util.HashMap;
import java.util.ArrayList;
import excepciones.*;

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
	
	public boolean eliminarArea(int id) throws ExcepcionAreaNoExistente{
	    if (!areas.containsKey(id)){
	    	throw new ExcepcionAreaNoExistente("No se puede eliminar: el área con código " + id + " no existe");
	    }
		areas.remove(id);
    	return true;
	}
	
	public Area buscarArea(int id) throws ExcepcionAreaNoExistente{
		Area area = areas.get(id);
		if (area == null){
			throw new ExcepcionAreaNoExistente("El área con código " + id + " no existe");
		}
	    return area;
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

	public Paciente buscarPaciente(String rut) throws ExcepcionPacienteNoEncontrado {
		if (rut == null || rut.isEmpty()){
			throw new ExcepcionPacienteNoEncontrado("El RUT ingresado no es válido.");
		}
		// cicnlo para hacer la búsqueda en pacientes a espera de atención
		for (int i = 0; i < pacientesSinAsignar.size(); i++) {
			Paciente p = pacientesSinAsignar.get(i);
			if (p.getRut() != null && p.getRut().toLowerCase().equals(rut.toLowerCase())) {
				return p;
			}
		}

		// búsqueda en cada cama de cada área
		ArrayList<Area> listaAreas = listarAreas();
		for (int i = 0; i < listaAreas.size(); i++){
			Area area = listaAreas.get(i);
			for (int j = 0; j < area.getCamas().size(); j++){
				Cama cama = area.getCamas().get(j);
				if (cama.getPacienteActual() != null){
					Paciente p = cama.getPacienteActual();
					if (p.getRut() != null && p.getRut().toLowerCase().equals(rut.toLowerCase())){
						return p;
					}
				}
			}
		}
		throw new ExcepcionPacienteNoEncontrado("No se encontró ningún paciente con el RUT: " + rut);
	}
}