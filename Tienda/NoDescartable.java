package Tienda;

class NoDescartable extends Producto{
    private String descripcion;
    public NoDescartable(
        int codigo,
        double precioCompra,
        double precioVenta,
        double descuento,
        String descripcion){
        super(codigo, precioCompra, precioVenta, descuento);
        this.descripcion = descripcion;
    }
}