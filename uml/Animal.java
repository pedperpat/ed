package ejercicio14uml;

/**
 *
 * @author Pedro Antonio
 */


public class Animal {
    protected String cod;
    protected String alias;
    protected String especie;
    protected String raza;
    protected String color;
    protected String fechaNac;
    protected double pesoMedio;
    protected double pesoActual;
    protected Cliente[] cliente;
    protected HistorialMedico historialMacota;
    
    public void setCodigo(String cod) {
        if (cod != null) {
            this.cod = cod;
        }
    }
    
    public String getCodigo() {
        return cod;
    }
    
    public void setAlias(String alias) {
        if (alias != null)
            this.alias = alias;  
    }
    
    public String getAlias() {
        return alias;
    }
    
    public void setEspecie(String especie) {
        if (especie != null)
            this.especie = especie;
    }
    
    public String getEspecie() {
        return especie;
    }
    
    public void setRaza(String raza) {
        if (raza != null)
            this.raza = raza;
    }
      
    public String getRaza() {
        return raza;
    }
    
    public void setColor(String color) {
        if (color != null)
            this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setFechaNacimiento(String fechaNac) {
        if (fechaNac != null) {
            this.fechaNac = fechaNac;
        }
    }
    
    public String getFechaNacimiento() {
        return fechaNac;
    }
    
    public double getPesoMedio() {
        return pesoMedio;
    }
    
    public void setPesoActual(double pesoActual) {
        if (pesoActual > 0) {
            this.pesoActual = pesoActual;
        }
    }
    
    public double getPesoActual() {
        return pesoActual;
    }
}
