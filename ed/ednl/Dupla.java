package ed.ednl;
public class Dupla<T>{
    private T dato;
    private int nivel;
    public Dupla(T dato, int nivel){
        this.dato = dato;
        this.nivel = nivel;
    }
    @Override
    public String toString(){
        return "{" + dato.toString() + ", " + nivel + "}";
    }
}
