package Tienda;

public abstract class Producto{
    protected int codigo;
    protected double precioCompra;
    protected PrecioVenta precioVenta;
    
    public Producto(
        int codigo,
        double precioCompra,
        double precioVenta,
        double descuento){
        this.codigo = codigo;
        this.precioCompra = precioCompra;
        this.precioVenta = new PrecioVenta(precioVenta, descuento);
    }    
    
    public abstract double perdida();
}
