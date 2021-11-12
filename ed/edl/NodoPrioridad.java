package ed.edl;
public class NodoPrioridad<T, E extends Comparable<E>>{
    private T dato;
    private E comp;
    private NodoPrioridad sig;
    public NodoPrioridad(T dato, E comp){
        this.dato = dato;
        this.comp = comp;
        sig = null;
    }
    /**
     * METODOS DE ACCESO
     */
    public T getDato(){
        return dato;
    }
    public E getComp(){
        return comp;
    }
    public NodoPrioridad<T, E> getSig(){
        return sig;
    }
    /**
     * METODO DE MODIFICACION
     */
    public void setDato(T nuevoDato){
        dato = nuevoDato;
    }
    public void setSig(NodoPrioridad<T, E> nuevoEnlace){
        sig = nuevoEnlace;
    }
    public void setComp(E nuevoComp){
        comp = nuevoComp;
    }
}
