package modelo;

public class Niño extends Paciente {
	
	private String nombreApoderado;
	private String rutApoderado;
	
	public Niño(String nombre, String rut, int edad, Cama camaActual, String na, String ra) {
		super(nombre, rut, edad, camaActual);
		this.nombreApoderado = na;
		this.rutApoderado = ra;
	}
	public String getNombreApoderado() {
        return nombreApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public String getRutApoderado() {
        return rutApoderado;
    }

    public void setRutApoderado(String rutApoderado) {
        this.rutApoderado = rutApoderado;
    }
    //Placeholder
    @Override
    public String obtenerTipoAtencion() {
        return "Atención pediátrica";
    }
}
