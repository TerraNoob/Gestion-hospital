public class SignosVitales {
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
