public class Impuestos{
    public double cobrarImpuestos(int[] precios){
        /**
         * Si el acumulado es <500 Bs,
         * impuesto -> 3%
         * Si el acumulado es >= 500 y < 1000
         * impuesto -> 5%
         * Si el acumulado es >= 1000
         * impuesto -> 8%
         */
        Metodos m1 = new Metodos();
        
        int acumulado = m1.sumatoria(precios);
        double precioFinal = 0;
        if(acumulado < 500){
            precioFinal = acumulado + acumulado*3.0/100.0;
        }else if(acumulado >= 500 && acumulado < 1000){
            precioFinal = acumulado + acumulado*5.0/100.0;
        }else if(acumulado >= 1000){
            precioFinal = acumulado + acumulado*8.0/100.0;
        }
        return precioFinal;
    }
}
