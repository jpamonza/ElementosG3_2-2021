package ed.edl;

public class ColaPrioridad <T extends Comparable<T>>{
    private NodoSE<T> frente;

    public ColaPrioridad(){
        frente = null;
    }

    public boolean vacia(){
        return frente == null;
    }

    public void encolar(T dato){
        NodoSE<T> nuevo = new NodoSE(dato);

        if(vacia()){
            frente = nuevo;
        }else{

            NodoSE<T> act = frente;
            NodoSE<T> ant = null;
            while(act != null && act.getDato().compareTo(dato) <= 0){
                ant = act;
                act = act.getSig();
            }

            if(ant != null) // insercion en medio de la cola
                ant.setSig(nuevo);
            else    // insercion es al principio de la cola
                frente = nuevo;
            nuevo.setSig(act);
        }
    }

    public T desencolar(){
        T res;

        if(vacia()){
            res = null;
        }else{
            res = frente.getDato();

            frente = frente.getSig();
        }

        return res;
    }
}


