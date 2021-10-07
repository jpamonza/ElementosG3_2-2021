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
}
