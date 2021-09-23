package Tienda;

public class PrecioVenta{
    // descuento sera un valor entre 0 y 100
    private double precioVenta, descuento;
    
    public PrecioVenta(double precioVenta, double descuento){
        this.precioVenta = precioVenta;
        this.descuento = descuento;
    }
    
    public void setPrecioVenta(int nuevoPrecio){
        precioVenta = nuevoPrecio;
    }
    
    public void setDescuento(int nuevoDescuento){
        descuento = nuevoDescuento;
    }
    
    /**
     * Calculo del precio de venta aplicando el descuento
     */
    public double getPrecioVentaReal(){
        double res = 0;
        
        double precioAdescontar = precioVenta * descuento / 100;
        res = precioVenta - precioAdescontar;
        
        return res;
    }
}








