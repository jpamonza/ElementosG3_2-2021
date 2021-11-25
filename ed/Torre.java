package ed;

import ed.edl.Pila;

public class Torre{
    private Pila<String> pila;
    
    public Torre(){
        pila = new Pila();
    }
    
    public void agregar(String s){
        if(pila.vacia()){
            pila.push(s);
        }else{
            String primero = pila.pop();
            if(pila.vacia()){
                pila.push(primero);
                pila.push(s);
            }else{
                String segundo = pila.pop();
                if(segundo.equals(primero)){
                    pila.push(segundo);
                    pila.push(s);
                    pila.push(primero);
                }else{
                    pila.push(segundo);
                    pila.push(primero);
                    pila.push(s);
                }
            }
        }
    }
    
    public String toString(){
        String res = "";
        
        while(!pila.vacia()){
            res += pila.pop() + " ";
        }
        
        return res;
    }
}
