package Tienda;

class Producto{
    private int codigo;
    private double precioCompra;
    private PrecioVenta precioVenta;
    
    public Producto(
        int codigo,
        double precioCompra,
        double precioVenta,
        double descuento){
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.precioVenta = new PrecioVenta(precioVenta, descuento);
    }    
    
    public double perdida(){
        return 0.0;
    }
}
