package ejercicio14uml;

/**
 *
 * @author Pedro Antonio
 */


public class Persona {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    
    protected Cliente[] clientes;
    
    public Persona(String dni, String nombre, String apellidos){
        if(dni != null)
            this.dni = dni;
        
        if(nombre != null)
            this.nombre = nombre;
        
        if(apellidos != null)
            this.apellidos = apellidos;
    }
    
    public void setDni(String dni){
        if(dni != null)
            this.dni = dni;
    }
    
    public String getDni(){
        return dni;
    }
    
    public void setNombre(String nombre){
        if(nombre != null)
            this.nombre = nombre;
    }
    
    public String getNombre(String nombre){
        return nombre;
    }
    
    public void setApellidos(String apellidos){
        if(apellidos != null)
            this.apellidos = apellidos;
    }
    
    public String getApellidos(){
        return apellidos;
    } 
}
