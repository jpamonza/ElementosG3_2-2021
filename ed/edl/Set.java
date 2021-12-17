package ed.edl;

public class Set<T extends Comparable<T>>{
    private NodoSE<T> ini;
    
    public Set(){
        ini = null;
    }
    
    public boolean vacio(){
        return ini == null;
    }
    
    public void insertar(T dato){
        if(vacio()){
            ini = new NodoSE(dato);
        }else{
            boolean existe = false;
            NodoSE<T> act = ini;
            while(
                !(existe = act.getDato().compareTo(dato) == 0) &&
                act.getSig() != null
            ){
                act = act.getSig();
            }
            
            if(!existe){
                act.setSig(new NodoSE(dato));
            }
        }
    }
    
    public T eliminar(T dato){
        T res = null;
        
        if(!vacio()){
            NodoSE<T> ant = null;
            NodoSE<T> act = ini;
            while(act != null && res != null){
                if(act.getDato().compareTo(dato) == 0){
                    res = dato;
                    
                    if(ant != null)
                        ant.setSig(act.getSig());
                    else
                        this.ini = act.getSig();
                }
                
                ant = act;
                act = act.getSig();
            }
        }
        
        return res;
    }
}








