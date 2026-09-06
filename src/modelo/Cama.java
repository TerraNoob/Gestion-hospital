public class Cama{
    private int idCama;
    private int disponibilidad;
    private String categoriaCama;
    private Paciente pacienteActual;

    public Cama(int idCama, String categoriaCama){
        this.idCama = idCama;
        this.disponibilidad = 1; //0: ocupada, 1: disponible, 2: en limpieza, 3: en mantenimiento. 
        this.categoriaCama = categoriaCama;
    }

    public int getIdCama() { return idCama; }

    public int getDisponibilidad() { return disponibilidad; }

    public String getCategoriaCama() { return categoriaCama; }

    public Paciente getPacienteActual() { return pacienteActual; }

    public void setIdCama(int idCama) { this.idCama = idCama;}

    public void setDisponibilidad(int disponibilidad) { this.disponibilidad = disponibilidad; }

    public void setCategoriaCama(String categoriaCama) { this.categoriaCama = categoriaCama; }

    public void setPacienteActual(Paciente pacienteActual) { this.pacienteActual = pacienteActual; }
    
    public void ocuparCama(Paciente pacienteActual){
        if (disponibilidad == 1){
            this.pacienteActual = pacienteActual;
            this.disponibilidad = 0; 
        }
    }
}