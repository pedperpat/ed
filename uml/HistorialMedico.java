package ejercicio14uml;

/**
 *
 * @author Pedro Antonio
 */


public class HistorialMedico {
    protected String nombreEnfermedad;
    protected String fechaEnfermedad;
    
    protected Animal mascota;
    
    public void setNombreEnfermedad(String nombreEnfermedad){
        if(nombreEnfermedad != null)
            this.nombreEnfermedad = nombreEnfermedad;
    }
    
    public String getNombreEnfermedad(){
        return nombreEnfermedad;
    }
    
    public void setFechaEnfermedad(String fechaEnfermedad){
        if(fechaEnfermedad != null)
            this.fechaEnfermedad = fechaEnfermedad;
    }
    
    public String getFechaEnfermedad(){
        return fechaEnfermedad;
    }
}
