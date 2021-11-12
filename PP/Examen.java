package PP;

import java.util.*;

public class Examen{
    public static void main(String[] args){
        String[] muestra = {"011111", "0123456"};
        Elemento[] tabla = {
                new Elemento(1, "Dolor de espalda", false),
                new Elemento(2, "Dolor de cabeza", false),
                new Elemento(3, "Dolor de estomago", false),
            };

        //System.out.println(new Examen().riesgoMortal(muestra, tabla));
        
        int[] cortes = {20, 10, 7, 5, 3, 2, 1};
        ArrayList<ArrayList<Integer>> res = new Examen().fraccionar(cortes, 10);
        for(ArrayList<Integer> subLista : res){
            System.out.println(subLista);
        }
    }

    public double riesgoMortal(String[] muestra, Elemento[] tabla){ // HashMap tabla -> maneja dos valores, una llave y valor
        int cantNegativos = contarEstadosNegativos(tabla, 0);
        return riesgoMortal(muestra, 0, tabla, cantNegativos) * 100.0 / muestra.length ;
    }

    private int riesgoMortal(String[] muestra, int i, Elemento[] tabla, int cantNegativos){
        int res;

        if(i >= muestra.length){
            res = 0;
        }else{
            if(tieneRiesgoMortal(muestra[i], 0, tabla, 0, new boolean[tabla.length], cantNegativos)){
                res = 1 + riesgoMortal(muestra, i+1, tabla, cantNegativos);
            }else{
                res = riesgoMortal(muestra, i+1, tabla, cantNegativos);
            }
        }

        return res;
    }

    private boolean tieneRiesgoMortal(
        String numero,
        int i,
        Elemento[] tabla,
        int negEncontrados,
        boolean[] negativosUsados,
        int cantNegativos
    ){
        boolean res;

        if(negEncontrados == cantNegativos){
            res = true;
        }else if(i >= numero.length()){
            res = false;
        }else{
            if(esNegativo(numero.charAt(i), tabla, 0)){
                if(!sintomaDetectado(numero.charAt(i), tabla, 0, negativosUsados)){
                    negEncontrados++;
                }
            }
            res = tieneRiesgoMortal(numero, i+1, tabla, negEncontrados, negativosUsados, cantNegativos);
        }

        return res;
    }

    private boolean sintomaDetectado(char x, Elemento[] tabla, int i, boolean[] negativosUsados){//x = '1' - '0' -> 49 - 48
        boolean res = false;

        if(i >= tabla.length){
            res = false;
        }else if(tabla[i].getDigito() == (x - '0')){
            res = negativosUsados[i];
            negativosUsados[i] = true;
        }else{
            res = sintomaDetectado(x, tabla, i+1, negativosUsados);
        }

        return res;
    }

    private boolean esNegativo(char x, Elemento[] tabla, int i){//x = '1' - '0' -> 49 - 48
        boolean res = false;

        if(i >= tabla.length){
            res = false;
        }else if(tabla[i].getDigito() == (x - '0')){
            res = !tabla[i].getSaludable();
        }else{
            res = esNegativo(x, tabla, i+1);
        }

        return res;
    }

    private int contarEstadosNegativos(Elemento[] tabla, int i){
        int res;

        if(i >= tabla.length){
            res = 0;
        }else{
            if(!tabla[i].getSaludable()){
                res = 1 + contarEstadosNegativos(tabla, i+1);
            }else{
                res = contarEstadosNegativos(tabla, i+1);
            }
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> fraccionar(int[] cortes, int monto){
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        fraccionar(cortes, 0, monto, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void fraccionar(
        int[] cortes,
        int i,
        int monto,
        int suma,
        ArrayList<ArrayList<Integer>> res,
        ArrayList<Integer> actual
    ){
        if(suma == monto){
            res.add((ArrayList<Integer>)actual.clone());
        }else if(i < cortes.length)
            if(suma < monto){
                if(cortes[i] < monto){
                    // tomar elemento
                    suma = suma + cortes[i];
                    actual.add(cortes[i]);
                    i++;
                    fraccionar(cortes, i, monto, suma, res, actual);
    
                    // no tomar elemento
                    i--;
                    actual.remove((Integer)cortes[i]);
                    suma = suma - cortes[i];
                    fraccionar(cortes, i+1, monto, suma, res, actual);
                }else
                    fraccionar(cortes, i+1, monto, suma, res, actual);
            }
    }
}
