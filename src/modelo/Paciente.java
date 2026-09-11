package modelo;

public class Paciente {
    private String nombre;
    private String rut;
    private int edad;
    private float gravedad;
    private SignosVitales signos;
    private Cama camaActual;

    public Paciente(String nombre, String rut, int edad, SignosVitales signos, Cama camaActual){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.gravedad = signos.calcularGravedad();
        this.signos = signos;
        this.camaActual = camaActual;
    }
    // sobrecarga de constructor dónde por default el usuario ingrese con gravedad al máximo, por ejemplo en casos de infarto, accidentes, etc
    public Paciente(String nombre, String rut, int edad, Cama camaActual){
        this.nombre = nombre;
        this.rut = rut;
        this.edad = edad;
        this.signos = null;
        this.camaActual = camaActual;
        this.gravedad = 7.0f;
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
    public Cama getCamaActual() {
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

    public void setGravedad(float gravedad){
        this.gravedad = gravedad;
    }

    public void setSignos(SignosVitales signos){
        this.signos = signos;
        this.gravedad = signos.calcularGravedad();
    }
    public void setCamaActual(Cama camaActual){
        this.camaActual = camaActual;
    }
    public String obtenerTipoAtencion() {
        return "Atención general";
    }

}


