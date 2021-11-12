package ed.edl;
public class Set<T>{
    private NodoSE<T> ini;
    public Set(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        NodoSE<T> nuevo = new NodoSE(dato);
        if(!vacia()){
            NodoSE<T> act = ini;
            boolean duplicado = false;
            while(!duplicado && act.getSig() != null){
                if(act.getDato().equals(dato)){
                    duplicado = true;
                }else
                    act = act.getSig();
            }
            
            if(act.getSig() == null && !duplicado && !act.getDato().equals(dato))
                act.setSig(nuevo);
        }else
            ini = nuevo;
    }
    public T eliminar(T dato){
        T res = null;
        if(!vacia()){
            NodoSE<T> ant, act, sig;
            ant = null;
            act = ini;
            sig = act.getSig();
            
            while(act != null && !act.getDato().equals(dato)){
                ant = act;
                act = sig;
                if(sig != null)
                    sig = sig.getSig();
            }
            if(act!= null && act.getDato().equals(dato)){
                ant.setSig(sig);
                res = act.getDato();
            }
        }
        return res;
    }
    public String toString(){
        String res = "";
        NodoSE<T> act = ini;
        while(act != null){
            res += act.getDato().toString() + "\t";
            act = act.getSig();
        }
        return res;
    }
}









