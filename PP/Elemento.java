package PP;


public class Elemento{
    private int digito;
    private String descripcion;
    private boolean saludable;
    
    public Elemento(int digito, String descripcion, boolean saludable){
        this.digito = digito;
        this.descripcion = descripcion;
        this.saludable = saludable;
    }
    
    public int getDigito(){
        return digito;
    }
    
    public boolean getSaludable(){
        return saludable;
    }
}
