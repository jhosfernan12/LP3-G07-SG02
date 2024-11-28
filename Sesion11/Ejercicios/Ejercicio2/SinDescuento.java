package s11;

class SinDescuento implements Descuento 
{
    public double aplicarDescuento(double precio, int cantidad) 
    {
        return precio * cantidad;
    }
}