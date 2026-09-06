package modelo;

public class paciente {
	private String nombre;
	private String rut;
	private int edad;
	private float gravedad;
	private SignosVitales signos;
	private Cama camaActual;
	
	public Paciente(String nombre, String rut, int edad, SignosVitales signos, Cama camaActual) {
		this.nombre = nombre;
		this.rut = rut;
		this.edad = edad;
	this.gravedad = obtenerGravedad(signos);
	this.signos = signos;
	this.camaActual = camaActual;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public String getRut() {
		return this.rut;
	}
	public int getEdad() {
		return this.edad;
	}
	public float getGravedad() {
		return this.gravedad;
	}
	public SignosVitales getSignos() {
		return signos;
	}
	public Cama getCama() {
		return this.camaActual;
	}
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	public void setRut(String r) {
		this.rut = r;
	}
	public void setEdad(int e) {
		this.edad = e;
	}
	public void setSignosVitales(SignosVitales signos) {
		this.signos = signos;
		this.gravedad = obtenerGravedad(signos);
	}
	public void setCama(Cama camaActual) {
		this.camaActual = camaActual;
	}
	
}
