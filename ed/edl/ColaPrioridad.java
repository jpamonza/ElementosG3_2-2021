package ed.edl;
public class ColaPrioridad<T extends Comparable<T>>{
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
            if(frente.getDato().compareTo(dato) > 0){
                nuevo.setSig(frente);
                frente = nuevo;
            }else{
                NodoSE<T> anterior = null;
                NodoSE<T> actual = frente;
                while(actual != null && actual.getDato().compareTo(dato) <= 0){
                    anterior = actual;
                    actual = actual.getSig();
                }
                anterior.setSig(nuevo);
                nuevo.setSig(actual);
            }
        }
    }
    public T verFrente(){
        T res = null;
        if(!vacia())
            res = frente.getDato();
        return res;
    }
    public T decolar(){
        T res = null;
        if(!vacia()){
            res = frente.getDato();
            frente = frente.getSig();
        }
        return res;
    }
}
