package modelo;
public class Item 
{
	private String nombre;
	private int cantidad;
	private boolean tipo;
	private String descripcion;
	
	public Item(String _nombre, int _cantidad, boolean _tipo, String _descripcion)
	{
		this.nombre = _nombre;
		this.cantidad = _cantidad;
		this.tipo = _tipo;
		this.descripcion = _descripcion;
	
	}
	
	public void usarItem(int cantidadUsar) 
	{
        if (cantidadUsar > 0 && cantidadUsar <= cantidad) 
        {
            cantidad -= cantidadUsar;
            System.out.println("Has usado " + cantidadUsar + " de " + nombre + ". Te quedan " + cantidad + "");
        } 
        else 
        {
            System.out.println("No puedes usar esa cantidad =(");
        }
    }
	
	public String getNombre() 
	{
        return nombre;
    }

    public int getCantidad() 
    {
        return cantidad;
    }

    public boolean isTipo() 
    {
        return tipo;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }
	
	
	
}
