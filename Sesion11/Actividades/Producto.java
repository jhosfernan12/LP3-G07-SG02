package s11;


interface EstrategiaDePromocion 
{
 	double aplicarPromocion(double precio);
}


class DescuentoFijoEstrategia implements EstrategiaDePromocion 
{
	 private double descuento;
	
	 public DescuentoFijoEstrategia(double descuento) 
	 {
	     this.descuento = descuento;
	 }
	
	 @Override
	 public double aplicarPromocion(double precio) 
	 {
	     return precio - descuento;
	 }
}


class DescuentoPorcentajeEstrategia implements EstrategiaDePromocion 
{
	 private double porcentaje;
	
	 public DescuentoPorcentajeEstrategia(double porcentaje) 
	 {
	     this.porcentaje = porcentaje;
	 }
	
	 @Override
	 public double aplicarPromocion(double precio) 
	 {
	     return precio - (precio * (porcentaje / 100));
	 }
}


class Producto 
{
	 private double precio;
	 private EstrategiaDePromocion estrategiaDePromocion;
	
	 public Producto(double precio) 
	 {
	     this.precio = precio;
	 }
	
	 public void establecerEstrategiaDePromocion(EstrategiaDePromocion estrategiaDePromocion)
	 {
	     this.estrategiaDePromocion = estrategiaDePromocion;
	 }
	
	 public double obtenerPrecio()
	 {
	     return precio;
	 }
	
	 public double obtenerPrecioConPromocion() 
	 {
	     return estrategiaDePromocion.aplicarPromocion(precio);
	 }
}
