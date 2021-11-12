package ed.ednl;
import ed.edl.*;
public class ArbolBin<T>{
    private T raiz;
    private ArbolBin<T> izq, der;
    public ArbolBin(){
        raiz = null;
        izq = der = null;
    }
    public boolean vacio(){
        return raiz == null;
    }
    public T eliminar(T dato){
        T res = null;
        Cola<ArbolBin<T>> c = new Cola();
        c.encolar(this);
        ArbolBin<T> act;
        boolean eliminado = false;
        while(!c.vacia() && !eliminado){
            act = c.decolar();
            if(act.raiz == dato){
                act.raiz = null;
                act.izq = null;
                act.der = null;
                eliminado = true;
                res = dato;
            }else{
                if(!act.izq.vacio())
                    c.encolar(act.izq);
                if(!act.der.vacio())
                    c.encolar(act.der);
            }
        }
        return res;
    }
    
    public int altura(){
        return altura(this);
    }
    private int altura(ArbolBin<T> act){
        int res;
        if(act.vacio())
            res = 0;
        else{
            res = 1 + Math.max(altura(act.getIzq()), altura(act.getDer()));
        }
        return res;
    }
    
    public T getRaiz(){
        return raiz;
    }
    
    public ArbolBin<T> getIzq(){
        return izq;
    }
    
    public ArbolBin<T> getDer(){
        return der;
    }
    
    public void insertarAmplitud(T dato){
        Cola<ArbolBin<T>> c = new Cola();
        c.encolar(this);
        ArbolBin<T> act;
        boolean aniadido = false;
        while(!aniadido){
            act = c.decolar();
            if(act.vacio()){
                act.raiz = dato;
                act.izq = new ArbolBin();
                act.der = new ArbolBin();
                aniadido = true;
            }else{
                c.encolar(act.izq);
                c.encolar(act.der);
            }
        }
    }
    public boolean insertar(T dato, Cola<T> ruta){
        boolean res;
        if(vacio()){
            if(ruta.vacia()){
                raiz = dato;
                izq = new ArbolBin();
                der = new ArbolBin();
                res = true;
            }else{
                res = false;
            }
        }else{
            ArbolBin<T> act = this;
            if(act.raiz == ruta.decolar()){
                T aux;
                res = true;
                while(!ruta.vacia() && res){
                    aux = ruta.decolar();
                    if(act.izq.raiz.equals(aux)){
                        act = act.izq;
                    }else if(act.der.raiz.equals(aux)){
                        act = act.der;
                    }else
                        res = false;
                }
                if(res == true){
                    act.insertarAmplitud(dato);
                }
            }else
                res = false;
        }
        return res;
    }
    public boolean semejantes(ArbolBin<T> otro){
        boolean res = false;
        if(!this.vacio() && !otro.vacio()){
            res = this.izq.semejantes(otro.izq) && 
                  this.der.semejantes(otro.der);
        }else
            res = this.vacio() && otro.vacio();
        return res;
    }
    public boolean balanceado(){
        boolean res;
        if(vacio())
            res = true;
        else if(Math.abs(izq.altura() - der.altura()) <= 1 &&
            izq.balanceado() && der.balanceado()){
            res = true;
        }else
            res = false;
        return res;
    }
    /*public int altura(){
        int res;
        if(vacio()){
            res = 0;
        }else
            res = 1 + Math.max(izq.altura(), der.altura());
        return res;
    }
    */
    public boolean samefringe(ArbolBin<T> otro){
        boolean res = true;
        Cola<T> c1 = this.getHojas();
        Cola<T> c2 = otro.getHojas();
        while(res == true && !c1.vacia() && !c2.vacia()){
            if(!c1.decolar().equals(c2.decolar())){
                res = false;
            }
        }
        if((c1.vacia() && !c2.vacia()) || (c2.vacia() && !c1.vacia()))
            res = false;
        return res;
    }
    public Cola<T> getHojas(){
        Cola<T> res = new Cola();
        if(!vacio()){
            getHojas(this, res);
        }
        return res;
    }
    private void getHojas(ArbolBin<T> act, Cola<T> res){
        if(!act.vacio())
            if(act.esHoja()){
                res.encolar(act.raiz);
            }else{
                getHojas(act.izq, res);
                getHojas(act.der, res);
            }
    }
    public boolean esHoja(){
        boolean res = false;
        if(!vacio() && izq.vacio() && der.vacio())
            res = true;
        return res;
    }
    
    /**
     * Saber si es espejo
     */
    public boolean simetrico(){
        boolean res;
        if(vacio())
            res = true;
        else{
            res = simetrico(izq, der);
        }
        return res;
    }
    private boolean simetrico(ArbolBin<T> actIzq, ArbolBin<T> actDer){
        boolean res;
        if(actIzq.vacio() && actDer.vacio())
            res = true;
        else if(actIzq.raiz.equals(actDer.raiz)){
            res = simetrico(actIzq.izq, actDer.der) && simetrico(actIzq.der, actDer.izq);
        }else
            res = false;
        return res;
    }
    
    public ListaSE<Dupla<T>> amplitudNiveles(){
        ListaSE<Dupla<T>> res = new ListaSE();
        if(!this.vacio()){
            Cola<ArbolBin<T>> sec = new Cola();
            Cola<Integer> niv = new Cola();
            
            sec.encolar(this);
            niv.encolar(0);
            ArbolBin<T> act;
            int n;
            
            while(!sec.vacia()){
                /**DECOLAR EL PRIMER ELEMENTO JUNTO CON SU NIVEL*/
                act = sec.decolar();
                n = niv.decolar();
                /**GUARDANDO ESA INFORMACION*/
                res.insertar(new Dupla(act.raiz, n));
                /**ENCOLAR SUS HIJOS*/
                if(!act.izq.vacio()){
                    sec.encolar(act.izq);
                    niv.encolar(n+1);
                }
                if(!act.der.vacio()){
                    sec.encolar(act.der);
                    niv.encolar(n+1);
                }
            }
        }
        System.out.println(res);
        
        return res;
    }
    
    public void podar(int altura){
        podar(altura, this, 1);
    }
    private void podar(int altura, ArbolBin<T> act, int nivAct){
        if(nivAct == altura){
            /**ROMPER TODAS LAS RAMAS MAYORES A LA ALTURA ESTABLECIDA*/
            act.izq = new ArbolBin();//null
            act.der = new ArbolBin();//null
        }else{
            if(!act.izq.vacio())
                podar(altura, act.izq, nivAct + 1);
            if(!act.der.vacio())
                podar(altura, act.der, nivAct + 1);
        }
    }
    
    public ListaSE<T> frontera(){
        ListaSE<T> res = new ListaSE();
        /**Preorden hasta la 1ra hoja*/
        preordenModificado(res, this);
        
        encontrarHojas(res);
        
        Pila<T> p = preordenInvertidoModificado();
        while(!p.vacia()){
            T d = p.pop();
            res.insertar(d);
        }
        return res;
    }
    private Pila<T> preordenInvertidoModificado(){
        Pila<T> res = new Pila();
        /**RAIZ*/
        //no me conviene tomarlo
        if(!der.vacio())
            preordenInvertidoModificado(res, der);
        else if(!this.izq.vacio()){
            preordenInvertidoModificado(res, izq);
        }
        return res;
    }
    private boolean preordenInvertidoModificado(Pila<T> res, ArbolBin<T> act){
        boolean finalizo = false;
        if(!act.esHoja() && !act.vacio()){
            /**RAIZ*/
            res.push(act.raiz);
            /**DER*/
            if(!act.der.vacio())
                finalizo = preordenInvertidoModificado(res, act.der);
            /**IZQ*/
            if(!act.izq.vacio() && !finalizo)
                finalizo = preordenInvertidoModificado(res, act.izq);
        }else
            finalizo = true;
        return finalizo;
    }
    private void encontrarHojas(ListaSE<T> res){
        //como inorden
        encontrarHojas(res, this);
    }
    private void encontrarHojas(ListaSE<T> res, ArbolBin<T> act){
        /**IZQ*/
        if(!act.izq.vacio())
            encontrarHojas(res, act.izq);
        /**RAIZ*/
        if(act.esHoja())
            res.insertar(act.raiz);
        /**DER*/
        if(!act.der.vacio())
            encontrarHojas(res, act.der);
    }
    private boolean preordenModificado(ListaSE<T> res, ArbolBin<T> act){
        boolean finalizo = false;
        if(!act.esHoja() && !act.vacio()){
            /**RAIZ*/
            res.insertar(act.raiz);
            /**IZQ*/
            if(!act.izq.vacio())
                finalizo = preordenModificado(res, act.izq);
            /**DER*/
            if(!act.der.vacio() && !finalizo)
                preordenModificado(res, act.der);
        }else
            finalizo = true;
        return finalizo;
    }
}















