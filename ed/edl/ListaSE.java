package ed.edl;
public class ListaSE<T> implements Lista<T>{
    private NodoSE<T> ini;
    public ListaSE(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        if(vacia()){
            NodoSE<T> nuevo = new NodoSE(dato);
            ini = nuevo;
        }else{
            insertar(dato, ini);
        }
    }
    private void insertar(T dato, NodoSE<T> actual){
        if(actual.getSig() == null){
            actual.setSig(new NodoSE<T>(dato));
        }else
            insertar(dato, actual.getSig());
    }
    public void insertar(T dato, int pos){
        if(pos >= 0 && pos <= longitud()){
            if(pos == 0){
                NodoSE<T> nuevo = new NodoSE(dato);
                NodoSE<T> aux = ini;
                nuevo.setSig(aux);
                ini = nuevo;
            }else if(pos == longitud()){
                NodoSE<T> nuevo = new NodoSE(dato);
                NodoSE<T> actual = ini;
                while(actual.getSig() != null){
                    actual = actual.getSig();
                }
                actual.setSig(nuevo);
            }else{
                NodoSE<T> nuevo = new NodoSE(dato);
                NodoSE<T> anterior = null;
                NodoSE<T> actual = ini;
                while(pos > 0){
                    anterior = actual;
                    actual = actual.getSig();
                    pos = pos - 1;
                }
                anterior.setSig(nuevo);
                nuevo.setSig(actual);
            }
        }
    }
    public T eliminar(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            if(pos == 0){
                res = ini.getDato();
                ini = ini.getSig();
            }else{
                NodoSE<T> anterior = null;
                NodoSE<T> actual = ini;
                NodoSE<T> siguiente = actual.getSig();
                while(pos > 0){
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.getSig();
                    pos = pos - 1;
                }
                anterior.setSig(siguiente);
                res = actual.getDato();
            }
        }
        return res;
    }
    public T acceder(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            res = acceder(pos, ini);
        }
        return res;
    }
    private T acceder(int pos, NodoSE<T> actual){
        T res;
        if(pos == 0)
            res = actual.getDato();
        else
            res = acceder(pos-1, actual.getSig());
        return res;
    }
    public int longitud(){
        return longitud(ini);
    }
    private int longitud(NodoSE<T> actual){
        int res;
        if(actual == null)
            res = 0;
        else
            res = 1 + longitud(actual.getSig());
        return res;
    }
    public void invertir(){
        Pila<T> pila = new Pila();
        while(this.vacia() == false){
            T dato = this.eliminar(0);
            pila.push(dato);
        }
        while(pila.vacia() == false){
            this.insertar(pila.pop());
        }
    }
    public ListaSE<T> clone(){
        ListaSE<T> copia = new ListaSE();
        for(int i = 0; i < longitud(); i++){
            copia.insertar(acceder(i));
        }
        return copia;
    }
    public String toString(){
        String res = "";
        for(int i = 0; i < longitud(); i++){
            res += acceder(i).toString() + "\t";
        }
        return res;
    }
}



















