package ed.edl;
public class ListaDE<T> implements Lista<T>{
    private NodoDE<T> ini;
    public ListaDE(){
        ini = null;
    }
    public boolean vacia(){
        return ini == null;
    }
    public void insertar(T dato){
        if(vacia()){
            ini = new NodoDE(dato);
        }else{
            insertar(dato, ini);
        }
    }
    public T eliminar(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            if(pos == 0){
                /**null <- 5 <-> 6 <-> 7 -> null
                   null <- 6 <-> 7 -> null*/
                /**null <- 5 -> null
                   null <- null*/
                res = ini.getDato();
                ini = ini.getSig();
                if(ini != null)
                    ini.setAnt(null);
            }else{
                NodoDE<T> actual = ini;
                while(pos > 0){
                    actual = actual.getSig();
                    pos = pos - 1;
                }
                NodoDE<T> anterior = actual.getAnt();
                NodoDE<T> siguiente = actual.getSig();
                anterior.setSig(siguiente);
                if(siguiente != null)
                    siguiente.setAnt(anterior);
                res = actual.getDato();
            }
        }
        return res;
    }
    private void insertar(T dato, NodoDE<T> actual){
        if(actual.getSig() == null){
            NodoDE<T> nuevo = new NodoDE(dato);
            actual.setSig(nuevo);
            nuevo.setAnt(actual);
        }else
            insertar(dato, actual.getSig());
    }
    public void insertar(T dato, int pos){
        if(pos >= 0 && pos <= longitud()){
            if(pos == 0){
                NodoDE<T> nuevo = new NodoDE(dato);
                nuevo.setSig(ini);
                ini.setAnt(nuevo);
                ini = nuevo;
            }else if(pos == longitud()){
                insertar(dato);
            }else{
                NodoDE<T> nuevo = new NodoDE(dato);
                NodoDE<T> actual = ini;
                while(pos > 0){
                    actual = actual.getSig();
                    pos = pos - 1;
                }
                NodoDE<T> anterior = actual.getAnt();
                anterior.setSig(nuevo);
                nuevo.setSig(actual);
                nuevo.setAnt(anterior);
                actual.setAnt(nuevo);
            }
        }
    }
    public T acceder(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            res = acceder(pos, ini);
        }
        return res;
    }
    private T acceder(int pos, NodoDE<T> actual){
        T res;
        if(pos == 0){
            res = actual.getDato();
        }else
            res = acceder(pos-1, actual.getSig());
        return res;
    }
    public int longitud(){
        return longitud(ini);
    }
    private int longitud(NodoDE<T> actual){
        int res;
        if(actual == null)
            res = 0;
        else
            res = 1 + longitud(actual.getSig());
        return res;
    }
    /**
     * l1 {}        -> longitud() = 0
     * l2 {1,2,3}   -> longitud() = 3
     * ----------
     * l1 {1,2,3}   -> longitud() = 3
     * l2 {1}       -> longitud() = 1
     * ----------
     * l1 {1,2,3}   -> longitud() = 3
     * l2 {1,2,4}   -> longitud() = 3
     */
    /**equals*/
    /*public boolean compararDatos(Lista<T> otra){
        boolean res;
        if(this.longitud() == otra.longitud()){
            res = true;
            for(int i = 0; i < longitud() && res == true; i++){
                if(this.acceder(i).equals(otra.acceder(i)))
                    res = true;
                else
                    res = false;
            }
        }else
            res = false;
        return res;
    }
    //que existan los datos, aunque sea en diferentes posiciones
    public boolean compararDatos2(Lista<T> otra){
        boolean res;
        if(this.longitud() == otra.longitud()){
            //l1 -> this
            //l2 -> otra
            res = true;
            for(int i = 0; i < longitud() && res == true; i++){
                res = res &&
                      otra.contiene(this.acceder(i)) && //l2.contiene(elemento de l1)
                      this.contiene(otra.acceder(i));   //l1.contiene(elemento de l2)
            }
        }else
            res = false;
        return res;
    }
    public boolean contiene(T dato){
        boolean res = false;
        NodoDE<T> actual = ini;
        while(actual != null){
            if(actual.getDato() == dato){
                res = true;
                actual = null;
            }else{
                res = false;
                actual = actual.getSig();
            }
        }
        return res;
    }
    public Lista<T> clonar(){
        ListaDE<T> copia = new ListaDE();
        
        NodoDE<T> actual = ini;
        //visitar todos los nodos
        while(actual != null){
            copia.insertar(actual.getDato());
            actual = actual.getSig();
        }
        
        return copia;
    }*/
}















