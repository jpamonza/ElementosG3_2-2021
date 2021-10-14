import java.util.Arrays;

public class Recursividad{
    /**
     * Ejercicio 14
     */
    public boolean todosPares(int n){
        boolean res;

        if(n == 0){
            res = true;
        }else{
            int dig = n % 10;
            if(dig % 2 == 0){
                n = n / 10;
                res = todosPares(n);
            }else{
                res = false;
            }
        }

        return res;
    }
    
    public boolean busquedaBinaria(int[] arreglo, int x){
        /**
         * Algoritmo burbuja
         * Merge Sort (Ordenamiento por mezcla)
         * 
         * Arreglos -> Paso de referencia
         * Tipos primitivos -> Copia de valor
         */
        Arrays.sort(arreglo);
        return busquedaBinaria(arreglo, x, 0, arreglo.length-1);
    }
    
    private boolean busquedaBinaria(int[] arreglo, int x, int l, int r){
        boolean res;
        
        /*int l, r, m;
        l = 0;
        r = arreglo.length - 1;*/
        int m = (r + l) / 2;
        
        if(arreglo[m] == x){
            res = true;
        }else if(l == r){
            res = false;
        }else{
            if(x > arreglo[m]){
                res = busquedaBinaria(arreglo, x, m+1, r);
            }else{
                res = busquedaBinaria(arreglo, x, l, m);
            }
        }
        
        return res;
    }
}






