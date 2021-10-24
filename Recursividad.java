import java.util.*;

public class Recursividad{
    /*
     {
    {'.','C','.','.','.','.','.','.','.','.','.','.'},
    {'c','C','.','C','.','.','.','.','.','.','.','.'},
    {'.','C','.','C','.','.','.','.','.','C','.','.'},
    {'.','C','.','C','.','.','.','.','.','C','.','.'},
    {'.','C','C','C','C','C','C','C','C','C','.','.'},
    {'.','C','.','.','.','.','.','.','.','.','.','.'},
    {'.','C','.','.','.','.','.','.','.','.','.','.'},
    }
     */
    public int carbonos(char[][] tab){
        return carbonos(tab, 0, 0);
    }
    
    private int carbonos(char[][] tab, int i, int j){
        int res;
        //buscar carbonos
        if(i < tab.length){
            if(j < tab[i].length){
                if(tab[i][j] == 'C'){
                    //movimientos
                    res = movimientos(tab, i, j);
                    res = Math.max(res, carbonos(tab, i, j+1));
                }else{
                    res = carbonos(tab, i, j+1);
                }
            }else{
                res = carbonos(tab, i+1, 0);
            }
        }else{
            res = 0;
        }
        return res;
    }
    
    private int movimientos(char[][] tab, int i, int j){
        int res;
        
        if(i >= 0 && i < tab.length){
            if(j >= 0 && j < tab[i].length){
                if(tab[i][j] == 'C'){
                    tab[i][j] = '.';
                    
                    int r1 = movimientos(tab, i-1, j);
                    int r2 = movimientos(tab, i+1, j);
                    int r3 = movimientos(tab, i, j-1);
                    int r4 = movimientos(tab, i, j+1);
                    
                    res = Math.max(r1, r2);
                    res = Math.max(res, r3);
                    res = Math.max(res, r4);
                    
                    res = res + 1;
                    
                    tab[i][j] = 'C';
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
    
    public int[] convertir(String s){
        int[] arreglo = new int[ s.length() ];
        
        llenarArreglo(arreglo, 0, s);
        
        return arreglo;
    }
    
    private void llenarArreglo(int[] arreglo, int i, String s){
        if(i < arreglo.length){
            arreglo[i] = s.charAt(i) - '0';
            llenarArreglo(arreglo, i+1, s);
        }
    }
    
    public String convertir(int[] arreglo){
        return convertir(arreglo, 0);
    }
    
    private String convertir(int[] arreglo, int i){
        String res;
        
        if(i == arreglo.length){
            res = "";
        }else{
            res = arreglo[i] + convertir(arreglo, i+1);
        }
        
        return res;
    }
    
    /**
     * Ejercicio 1 - PP 1-2021
     */
    public ArrayList<Integer> secuenciaMasLarga(int[] sec){
        return secuenciaMasLarga(sec, 0, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    private ArrayList<Integer> secuenciaMasLarga(
        int[] sec,
        int i,
        ArrayList<Integer> act,
        ArrayList<Integer> mejor
    ){
        ArrayList<Integer> res;
        if(sec.length == 0){
            res = mejor;
        }else if(i == sec.length-1){
            act.add(sec[i]);
            if(act.size() > mejor.size()){
                mejor = (ArrayList<Integer>)act.clone();
            }
            res = mejor;
        }else{
            if(Math.abs(sec[i] - sec[i+1]) == 1){
                //consecutivos
                act.add(sec[i]);
                res = secuenciaMasLarga(sec, i+1, act, mejor);
            }else{
                act.add(sec[i]);
                if(act.size() > mejor.size()){
                    mejor = (ArrayList<Integer>)act.clone();
                }
                act.clear();
                res = secuenciaMasLarga(sec, i+1, act, mejor);
            }
        }
        return res;
    }
    
    /**
     * Numero primo
     */
    public boolean esPrimo(int n){
        /*boolean res = true;

        for(int i = 2; i*i <= n && res; i++){
            if(n % i == 0){
                res = false;
            }
        }

        return res;*/
        return esPrimo(2, n);
    }

    private boolean esPrimo(int i, int n){
        boolean res;

        if(i*i <= n){
            if(n % i == 0){
                res = false;
            }else
                res = esPrimo(i+1, n);
        }else{
            res = true;
        }

        return res;
    }

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





