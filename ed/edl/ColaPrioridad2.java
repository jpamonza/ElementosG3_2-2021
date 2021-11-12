package ed.edl;
public class ColaPrioridad2<T, E extends Comparable<E>>{
    private NodoPrioridad<T, E> ini; 
    public ColaPrioridad2(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void encolar(T dato, E comp){
        if(vacia()){
            ini = new NodoPrioridad(dato, comp);
        }else{
            NodoPrioridad<T,E> nuevo = new NodoPrioridad(dato, comp);
            NodoPrioridad<T,E> act = ini;
            NodoPrioridad<T,E> ant = null;
            
            while(act != null && act.getComp().compareTo(comp) <= 0){
                ant = act;
                act = act.getSig();
            }
            
            if(ant != null)
                ant.setSig(nuevo);
            else
                ini = nuevo;
                
            nuevo.setSig(act);
        }
    }
}
