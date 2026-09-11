package modelo;

public class Adulto extends Paciente {
	
	private String sistemaPrevision;
	
	public Adulto(String nombre, String rut, int edad, SignosVitales signos, Cama camaActual, String sistemaPrevision) {
		super(nombre, rut, edad, signos, camaActual);
		this.sistemaPrevision = sistemaPrevision;
	}
	
	public String getSistemaPrevision() {
		return this.sistemaPrevision;
	}
	
	public void setSistemaPrevision(String sistemaPrevision) {
		this.sistemaPrevision = sistemaPrevision;
	}
	
	//Placeholder
	@Override
	public String obtenerTipoAtencion() {
	    return "Atención de adultos";
	}
}
