package ed.edl;

public class Pila<T>{
    private NodoSE<T> cima;
    public Pila(){
        cima = null;
    }
    public Pila(T dato){
        cima = new NodoSE(dato);
    }
    public void invertir(){
        /*Pila<T> aux = new Pila();
        while(vacia() == false){
            T dato = pop();
            aux.push(dato);
        }
        this.cima = aux.cima;*/
        if(vacia() == false && cima.getSig() != null){
            /**      1er      2do   elemento*/
            invertir(null, cima);
        }
    }
    private void invertir(NodoSE<T> ant, NodoSE<T> act){
        if(act == null){
            cima = ant;
        }else{
            invertir(act, act.getSig());
            act.setSig(ant);
        }
    }
    public Pila<T> clone(){
        Pila copia = new Pila();
        if(!vacia()){
            NodoSE<T> copiaNodo = new NodoSE(cima.getDato());
            copia.cima = copiaNodo;
            NodoSE<T> actual = cima.getSig();
            while(actual != null){
                copiaNodo.setSig(new NodoSE(actual.getDato()));
                actual = actual.getSig();
                copiaNodo = copiaNodo.getSig();
            }
        }
        return copia;
    }
    public boolean vacia(){
        return cima == null;
    }
    public void push(T dato){
        NodoSE<T> aux = new NodoSE<T>(dato);
        aux.setSig(cima);
        cima = aux;
    }
    public T pop(){
        T res = null;
        if(!vacia()){
            res = cima.getDato();
            cima = cima.getSig();
        }
        return res;
    }
    public T peek(){/**tope - getCima - getTope*/
        T res = null;
        if(!vacia()){
            res = cima.getDato();
        }
        return res;
    }
}