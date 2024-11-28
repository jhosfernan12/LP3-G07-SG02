package s11;

class DescuentoPorcentualAcumulado implements Descuento 
{
    public double aplicarDescuento(double precio, int cantidad) 
    {
        if (cantidad >= 3) 
        {
            return (precio * (cantidad - 1)) + (precio * 0.5);
        }
        else 
        {
        	System.out.print("Hay menos de 3 productos, no aplica descuento acumulado: ");
        	return precio * cantidad;
        }

    }
}