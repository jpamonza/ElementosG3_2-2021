package Tienda;

class Diario{
    private Fecha diaVenta;
    private ArrayList<Venta> ventas;
    public void registrar(Venta v){
        ???
    }

    public boolean esDe(Fecha fecha){
        return diaVenta.igual(fecha);
    }

    public double perdida(){
        double perdida = 0.0;
        for(Venta v: ???){
            perdida = perdida + v.perdida();
        }
        return perdida;
    }
}