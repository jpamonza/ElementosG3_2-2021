package ed;

public class Pueblo{
    private String nombre;
    private int tiempo;
    
    public Pueblo(String n, int t){
        this.nombre = n;
        this.tiempo = t;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getTiempo(){
        return tiempo;
    }
}
