package modelo;

public class SignosVitales{
    private int frecuenciaCardiaca;
    private double presionArterial;
    private int saturacion;
    private double temperatura;

    public SignosVitales(int frecuenciaCardiaca, double presionArterial, int saturacion, double temperatura){
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionArterial = presionArterial;
        this.saturacion = saturacion;
        this.temperatura = temperatura;
    }

    public float calcularGravedad(){

        float gravedad = 0.0f;

        // Considera saturación bajo lo normal
        if (this.saturacion < 95){
            gravedad += 1.5f;
        }

        // Considera frecuencia cardíaca sobre y bajo lo normal
        if (this.frecuenciaCardiaca >= 100 || this.frecuenciaCardiaca < 50){
            gravedad += 1.5f;
        }

        // Considera temperatura bajo y sobre lo normal
        if (this.temperatura >= 37.5 || this.temperatura < 35.5){
            gravedad += 1.5f;
        }

        // Considera presión arterial fuera de rango
        if (this.presionArterial >= 140.0 || this.presionArterial < 90.0){
            gravedad += 1.5f;
        }

        return gravedad;
    }

    public int getFrecuenciaCardiaca(){ return frecuenciaCardiaca; }

    public double getPresionArterial(){ return presionArterial; }

    public int getSaturacion(){ return saturacion; }

    public double getTemperatura(){ return temperatura; }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca){
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public void setPresionArterial(double presionArterial){
        this.presionArterial = presionArterial;
    }

    public void setSaturacion(int saturacion){
        this.saturacion = saturacion;
    }

    public void setTemperatura(double temperatura){
        this.temperatura = temperatura;
    }
}
