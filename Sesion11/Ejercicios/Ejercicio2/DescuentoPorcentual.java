package s11;

class DescuentoPorcentual implements Descuento 
{
    public double aplicarDescuento(double precio, int cantidad) 
    {
        if (cantidad >= 2)
        {
            return precio * cantidad * 0.7;
        }
        else 
        {
        	System.out.print("Hay menos de 2 productos,  no aplica descuento: ");
        	return precio * cantidad;
        }
    }
}