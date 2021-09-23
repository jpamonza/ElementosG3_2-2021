package Tienda;

class Descartable extends Producto{
    private Fecha fechaVencimiento;
    
    public Descartable(
        int codigo,
        double precioCompra,
        double precioVenta,
        double descuento,
        Fecha fec){
        super(codigo, precioCompra, precioVenta, descuento);
        fechaVencimiento = fec;
    }
    
    @Override
    public double perdida(){
        return 0;
    }
}