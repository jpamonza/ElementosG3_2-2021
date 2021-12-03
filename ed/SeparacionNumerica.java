package ed;

import ed.edl.Cola;

public class SeparacionNumerica{
    public int[] separacion(int n){
        Cola<Integer> cola = new Cola();
        
        while(n >= 2){
            cola.encolar(n%2);
            n = n / 2;
        }
        cola.encolar(n);
        
        String a = "";
        String b = "";
        
        int x;
        boolean turnoA = true;
        while(!cola.vacia()){
            x = cola.decolar();
            
            if(x == 0){
                a = "0" + a;
                b = "0" + b;
            }else{
                if(turnoA){
                    a = "1" + a;
                    b = "0" + b;
                    //turnoA = false;
                }else{
                    a = "0" + a;
                    b = "1" + b;
                    //turnoA = true;
                }
                turnoA = !turnoA;
            }
        }
        
        int[] res = {Integer.parseInt(a, 2), Integer.parseInt(b, 2)};
        return res;
    }
}
