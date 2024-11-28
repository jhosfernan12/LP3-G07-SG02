package s11;

class DescuentoFijo implements Descuento 
{
    public double aplicarDescuento(double precio, int cantidad) 
    {
        return precio * cantidad * 0.9;
    }
}