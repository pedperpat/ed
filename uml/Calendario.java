package ejercicio14uml;

/**
 *
 * @author Pedro Antonio
 */


public class Calendario {
    protected String fechaVac;
    protected String enfermedad;
    
    protected Animal vacunacionesMascota;
    
    public void setFechaVac(String fechaVac){
        if(fechaVac != null)
            this.fechaVac = fechaVac;
    }
    
    public String getFechaVac(){
        return fechaVac;
    }
    
    public void setEnfermedad(String enfermedad){
        if(enfermedad != null)
            this.enfermedad = enfermedad;
    }
    
    public String getEnfermedad(){
        return enfermedad;
    }
}
