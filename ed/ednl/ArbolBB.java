package ed.ednl;
public class ArbolBB<T extends Comparable<T>>{
    private T raiz;
    private ArbolBB<T> izq, der;
    public ArbolBB(){
        raiz = null;
        izq = der = null;
    }
    public boolean vacio(){
        return raiz == null;
    }
    public void insertar(T dato){
        if(vacio()){
            raiz = dato;
            izq = new ArbolBB();
            der = new ArbolBB();
        }else{
            
        }
    }
    public T buscar(T dato){
        T res = null;
        if(!vacio()){
            if(raiz.equals(dato))
                res = dato;
            else{
                if(dato.compareTo(raiz) > 0){
                    res = der.buscar(dato);
                }else
                    res = izq.buscar(dato);
            }
        }
        return res;
    }
    public boolean eliminar(T dato){
        boolean res;
        if(vacio()){
            res = false;
        }else if(raiz == dato){
            /*if(esHoja()){*/
                res = true;
                raiz = null;
                izq = null;
                der = null;
            /*}else
                res = false;*/
        }else{
            if(dato.compareTo(raiz) > 0){
                res = der.eliminar(dato);
            }else
                res = izq.eliminar(dato);
        }
        return res;
    }
}
