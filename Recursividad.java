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
    
    public int verduras(char[][] tablero, int cX, int cY){
        return verduras(tablero, cX, cY, true);
    }

    private int verduras(char[][] tablero, int cX, int cY, boolean inicio){
        int res;

        if(cX >= 0 && cX < tablero.length){
            if(cY >= 0 && cY < tablero[cX].length){
                if(tablero[cX][cY] == 'V' || inicio){
                    //if(tablero[cX][cY] != '*'){
                    boolean eraVerdura = false;
                    if(tablero[cX][cY] == 'V'){
                        tablero[cX][cY] = 'N';
                        eraVerdura = true;
                    }
                    //tablero[cX][cY] = '*';

                    inicio = false;

                    int r1 = verduras(tablero, cX+2, cY+1, inicio);
                    int r2 = verduras(tablero, cX+2, cY-1, inicio);
                    int r3 = verduras(tablero, cX-2, cY+1, inicio);
                    int r4 = verduras(tablero, cX-2, cY-1, inicio);
                    int r5 = verduras(tablero, cX+1, cY+2, inicio);
                    int r6 = verduras(tablero, cX-1, cY+2, inicio);
                    int r7 = verduras(tablero, cX+1, cY-2, inicio);
                    int r8 = verduras(tablero, cX-1, cY-2, inicio);

                    res = Math.max(r1, r2);
                    res = Math.max(res, r3);
                    res = Math.max(res, r4);
                    res = Math.max(res, r5);
                    res = Math.max(res, r6);
                    res = Math.max(res, r7);
                    res = Math.max(res, r8);

                    if(eraVerdura){
                        res += 1;
                        tablero[cX][cY] = 'V';
                    }
                }else{
                    res = 0;
                }
            }else{
                res = 0;
            }
        }else{
            res = 0;
        }

        return res;
    }
}









