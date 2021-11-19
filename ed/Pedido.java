package ed;

public class Pedido implements Comparable<Pedido>{
    private String zona;
    private int pesoTotal;
    
    public int compareTo(Pedido otro){
        int res;
        
        res = this.zona.compareTo(otro.zona);
        
        if(res == 0){
            if(this.pesoTotal < otro.pesoTotal){
                res = -1;
            }else if(this.pesoTotal > otro.pesoTotal){
                res = 1;
            }else{
                res = 0;
            }
        }
        
        return res;
    }
}
