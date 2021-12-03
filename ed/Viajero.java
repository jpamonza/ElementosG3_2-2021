package ed;

import ed.ednl.ArbolBin;
import ed.edl.ListaSE;

public class Viajero{
    public ListaSE<String> viajeMasExtenso(ArbolBin<Pueblo> mapa, int x){
        return null;
    }

    private ListaSE<String> preorden(ArbolBin<Pueblo> mapa, int x){
        if(!mapa.vacio()){
            //raiz
            x -= mapa.getRaiz().getTiempo();
            if(x >= 0){
                
                //izq
                if(mapa.getIzq() != null){
                    preorden(mapa.getIzq(), x);     // 5 pueblos
                }
                //der
                if(mapa.getDer() != null){
                    preorden(mapa.getDer(), x);     // 7 pueblos
                }

            }
        }
        return null;
    }
}
