package s11;

public class MainStrategy
{
    public static void main(String[] args) 
    {
        Producto producto = new Producto(800.0);
        

        producto.establecerEstrategiaDePromocion(new DescuentoFijoEstrategia(85.0));
        System.out.println("Precio descuento fijo: " + producto.obtenerPrecioConPromocion());
        
       
        producto.establecerEstrategiaDePromocion(new DescuentoPorcentajeEstrategia(20));
        System.out.println("Precio  descuento por porcentaje: " + producto.obtenerPrecioConPromocion());
    }
}
