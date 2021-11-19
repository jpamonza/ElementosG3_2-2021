public class Persona implements Comparable<Persona>{
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
    
    @Override
    public int compareTo(Persona otra){
        int res;
        
        /*if(this.edad > otra.edad){
            res = -1;
        }else if(this.edad < otra.edad){
            res = 1;
        }else{
            res = 0;
        }*/
        
        res = this.nombre.compareTo(otra.nombre);   
        // compareTo de string se basa en orden alfabetico
        // a -> z
        
        return res;
    }
}












