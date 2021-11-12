package ed.edl;
public class Cola<T>{
    private NodoSE<T> frente;
    private NodoSE<T> fin;
    public Cola(){
        frente=fin=null;
    }
    public boolean vacia(){
        return frente==null;
    }
    public void encolar(T dato){
        NodoSE<T> p = new NodoSE<T>(dato);
        if(vacia()){
            frente=fin=p;
        }else{
            fin.setSig(p);
            fin=p;
        }
    }
    public T  decolar(){
        T dato;
        if(vacia()){
            dato=null;
        }else{
            dato=frente.getDato();
            frente=frente.getSig();
            if(frente==null){
                fin=null;
            }
        }
        return dato;
    }
    public T ver(){//peek
        T dato=null;
        if(!vacia()){
            dato=frente.getDato();
        }
        return dato;
    }
}