package ed.edl;
public class ListaCSE<T> implements Lista<T>{
    private NodoSE<T> ini;
    public ListaCSE(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        if(vacia()){
            ini = new NodoSE(dato);
            ini.setSig(ini);
        }else{
            insertar(dato, ini);
        }
    }
    private void insertar(T dato, NodoSE<T> actual){
        if(actual.getSig() == ini){
            NodoSE<T> nuevo = new NodoSE(dato);
            actual.setSig(nuevo);
            nuevo.setSig(ini);
        }else
            insertar(dato, actual.getSig());
    }
    public int longitud(){
        int res = 0;
        if(vacia() == false){
            NodoSE<T> actual = ini;
            do{
                res = res + 1;
                actual = actual.getSig();
            }while(actual != ini);
        }
        return res;
    }
    public T acceder(int pos){
        T res = null;
        if(vacia() == false && pos >= 0){
            res = acceder(pos, ini);
        }
        return res;
    }
    private T acceder(int pos, NodoSE<T> actual){
        T res;
        if(pos == 0)
            res = actual.getDato();
        else
            res = acceder(pos - 1, actual.getSig());
        return res;
    }
    public void insertar(T dato, int pos){
        if(vacia() == false && pos >= 0){
            if(pos % longitud() == 0){
                NodoSE<T> nuevo = new NodoSE(dato);
                NodoSE<T> ultimo = ini;
                while(ultimo.getSig() != ini){
                    ultimo = ultimo.getSig();
                }
                nuevo.setSig(ini);
                ultimo.setSig(nuevo);
                ini = nuevo;
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
        if(vacia() == false && pos >= 0){
            if(longitud() == 1){
                res = ini.getDato();
                ini = null;
            }else if(pos % longitud() == 0){
                NodoSE<T> ultimo = ini;
                while(ultimo.getSig() != ini){
                    ultimo = ultimo.getSig();
                }
                res = ini.getDato();
                ini = ini.getSig();
                ultimo.setSig(ini);
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
                res = actual.getDato();
                anterior.setSig(siguiente);
            }
        }
        return res;
    }
}












