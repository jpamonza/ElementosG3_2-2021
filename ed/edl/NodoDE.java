package ed.edl;
public class NodoDE<T>{
    private T dato;
    private NodoDE<T> sig;
    private NodoDE<T> ant;
    public NodoDE(T dato){
        this.dato = dato;
        sig = null;
        ant = null;
    }
    public T getDato(){
        return dato;
    }
    public NodoDE<T> getAnt(){
        return ant;
    }
    public NodoDE<T> getSig(){
        return sig;
    }
    public void setDato(T nuevoDato){
        dato = nuevoDato;
    }
    public void setSig(NodoDE<T> nuevoSig){
        sig = nuevoSig;
    }
    public void setAnt(NodoDE<T> nuevoAnt){
        ant = nuevoAnt;
    }
}
