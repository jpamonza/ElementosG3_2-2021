public class Persona{
    private String nombre;
    private int edad;
    private int ci;
    
    public Persona(String nombre, int edad, int ci){
        this.nombre = nombre;
        this.edad = edad;
        this.ci = ci;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public Persona clone(){
        Persona clon = new Persona(nombre, 0, 0);
        return clon;
    }
}
