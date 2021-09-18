public class Metodos{
    public int metodo1(){
        int[] arreglo = {1,2,1,4,5};
        
        int acumulado = sumatoria(arreglo);
        
        for(int i = 0; i < arreglo.length; i++){
            arreglo[i] = arreglo[i] + acumulado;
        }
        
        acumulado = sumatoria(arreglo);
        
        return acumulado;
    }
    public int sumatoria(int[] arreglo){
        int acumulado = 0;
        for(int i = 0; i < arreglo.length; i++){
            acumulado = acumulado + arreglo[i];
        }
        return acumulado;
    }
}











