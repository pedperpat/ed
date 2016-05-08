package ejercicio14uml;

/**
 *
 * @author Pedro Antonio
 */


public class Cliente {
    protected String codCli;
    protected String apellido;
    protected String cuenta;
    protected String direccion;
    protected String telefono;
    
    protected Persona[] datos;
    protected Animal[] mascota;
    
    public Cliente() {
        // TODO
    }
    
    public String getCodigo() {
        return codCli;
    }
    
    public boolean setCodigo(String codCli) {
        if (codCli != null) {
            this.codCli = codCli;
            return true;
        }
        return false;
    }
    
    public void setApellido(String apellido) {
        if (apellido != null)
            this.apellido = apellido;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    
    public String getCuenta() {
        return cuenta;
    }
    
    public void setDireccion(String direccion) {
        if (direccion != null) 
            this.direccion = direccion;
    }
    
        public String getDireccion() {
        return direccion;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
        public String getTelefono() {
        return telefono;
    }
}
