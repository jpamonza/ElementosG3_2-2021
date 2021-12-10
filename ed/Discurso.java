package ed;

import ed.ednl.ArbolBB;

public class Discurso{
    public boolean[] analizar(String[] parrafos, String[] d, String[] s){
        boolean[] res = new boolean[parrafos.length];

        ArbolBB<String> diccionario = new ArbolBB();
        ArbolBB<String> stop = new ArbolBB();

        for(String p : d){
            diccionario.insertar(p);
        }
        for(String p : s){
            stop.insertar(p);
        }

        String parrafo;
        String[] palabras;
        int totalPalabras;
        int noPermitidas;
        for(int i = 0; i < parrafos.length; i++){
            parrafo = parrafos[i];
            palabras = parrafo.split(" ");
            totalPalabras = 0;
            noPermitidas = 0;

            for(String palabra : palabras){
                if(!stop.buscar(palabra)){
                    totalPalabras++;
                    if(!diccionario.buscar(palabra)){
                        noPermitidas++;
                    }
                }
            }
            
            if(noPermitidas * 2 > totalPalabras){
                res[i] = false;
            }else{
                res[i] = true;
            }
        }

        return res;
    }
}
