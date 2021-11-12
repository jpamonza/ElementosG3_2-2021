package ed.edl;
public class ListaSER<T> implements Lista<T>{
    private T dato;
    private ListaSER<T> sig;
    public ListaSER(){
        dato = null;
        sig = null;
    }
    public boolean vacia(){
        return dato == null;
    }
    public void insertar(T dato){
        if(vacia()){
            this.dato = dato;
            sig = new ListaSER();
        }else{
            sig.insertar(dato);
        }
    }
    public int longitud(){
        int res;
        if(vacia())
            res = 0;
        else
            res = 1 + sig.longitud();
        return res;
    }
    public T acceder(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            if(pos == 0)
                res = this.dato;
            else
                res = sig.acceder(pos - 1);
        }
        return res;
    }
    public void insertar(T dato, int pos){
        if(pos >= 0 && pos <= longitud()){
            if(pos == 0){
                ListaSER<T> copia = new ListaSER();
                copia.insertar(this.dato);
                copia.sig = sig;
                this.dato = dato;
                this.sig = copia;
            }else
                sig.insertar(dato, pos-1);
        }
    }
    public T eliminar(int pos){
        T res = null;
        if(pos >= 0 && pos < longitud()){
            if(pos == 0){
                res = this.dato;
                this.dato = sig.dato;
                this.sig = sig.sig;
            }else
                res = sig.eliminar(pos-1);
        }
        return res;
    }
}












