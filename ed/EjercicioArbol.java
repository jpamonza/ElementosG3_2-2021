package ed;

import ed.ednl.ArbolBin;
import ed.edl.Cola;

public class EjercicioArbol{    
    public void buscar(ArbolBin<Integer> numerolandia, int x){
        numerolandia.inorden();
        
        Cola<ArbolBin<Integer>> cola = new Cola();
        
        cola.encolar(numerolandia);
        ArbolBin<Integer> act;
        
        while(!cola.vacia()){
            act = cola.decolar();
            
            if(act.getRaiz() == x){
                System.out.println("El numero existe");
            }
            
            if(act.getIzq() != null){
                cola.encolar(act.getIzq());
            }
            if(act.getDer() != null){
                cola.encolar(act.getDer());
            }
        }
    }
}
