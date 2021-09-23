package Tienda;

class Tienda{
    private ArrayList<PuntoDeVenta> puntosDeVenta;
    public double perdidaXDia(Fecha fecha){
        double perdida = 0.0;
        for(PuntoDeVenta d: puntosDeVenta){
            if(d.esDe(fecha)){
                perdida = ??? + d.perdida()
            }
        }
        return perdida;
    }
}