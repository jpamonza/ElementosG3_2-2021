package ed.edl;
public class ListaCDE<T> implements Lista<T>{
    private NodoDE<T> ini;
    public ListaCDE(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        if(vacia() == true){
            ini = new NodoDE(dato);
            ini.setSig(ini);
            ini.setAnt(ini);
        }else{
            NodoDE<T> nuevo = new NodoDE(dato);
            NodoDE<T> ultimo = ini.getAnt();
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            nuevo.setSig(ini);
            ini.setAnt(nuevo);
        }
    }
    public void insertar(T dato, int pos){
        if(vacia() == false){
            if(pos % longitud() == 0){
                NodoDE<T> nuevo = new NodoDE(dato);
                NodoDE<T> ultimo = ini.getAnt();
                ultimo.setSig(nuevo);
                nuevo.setAnt(ultimo);
                ini.setAnt(nuevo);
                nuevo.setSig(ini);
                ini = nuevo;
            }else{
                NodoDE<T> nuevo = new NodoDE(dato);
                NodoDE<T> actual = ini;
                if(pos >= 0)
                    while(pos > 0){
                        actual = actual.getSig();
                        pos = pos - 1;
                    }
                else
                    while(pos < 0){
                        actual = actual.getAnt();
                        pos = pos + 1;
                    }
                NodoDE<T> anterior = actual.getAnt();
                anterior.setSig(nuevo);
                nuevo.setAnt(anterior);
                nuevo.setSig(actual);
                actual.setAnt(nuevo);
            }
        }
    }
    public T eliminar(int pos){
        T res = null;
        if(vacia() == false){
            if(longitud() == 1){
                res = ini.getDato();
                ini = null;
            }else if(pos % longitud() == 0){
                NodoDE<T> ultimo = ini.getAnt();
                res = ini.getDato();
                ini = ini.getSig();
                ini.setAnt(ultimo);
                ultimo.setSig(ini);
            }else{
                NodoDE<T> actual = ini;
                if(pos > 0)
                    while(pos > 0){
                        actual = actual.getSig();
                        pos = pos - 1;
                    }
                else
                    while(pos < 0){
                        actual = actual.getAnt();
                        pos = pos + 1;
                    }
                NodoDE<T> anterior = actual.getAnt();
                NodoDE<T> siguiente = actual.getSig();
                anterior.setSig(siguiente);
                siguiente.setAnt(anterior);
                res = actual.getDato();
            }
        }
        return res;
    }
    public T acceder(int pos){
        T res = null;
        if(vacia() == false){
            if(pos < 0){
                NodoDE<T> actual = ini;
                while(pos < 0){
                    actual = actual.getAnt();
                    pos = pos + 1;
                }
                res = actual.getDato();
            }else{
                NodoDE<T> actual = ini;
                while(pos > 0){
                    actual = actual.getSig();
                    pos = pos - 1;
                }
                res = actual.getDato();
            }
        }
        return res;
    }
    public int longitud(){
        int res = 0;
        if(vacia() == false){
            NodoDE<T> actual = ini;
            do{
                res = res + 1;
                actual = actual.getSig();
            }while(actual != ini);
        }
        return res;
    }
}















