// CONTROLADOR
package controlador;
import modelo.Item;
import modelo.InventarioModel;
import java.util.List;

public class InventarioController 
{
    private InventarioModel inventarioModel;


    public InventarioController() 
    {
        this.inventarioModel = new InventarioModel();
    }

    public void agregarItem(Item item) 
    {
        inventarioModel.agregarItem(item);
        System.out.println("Item añadido: " + item.getNombre());
    }

    public void eliminarItem(Item item) 
    {
        inventarioModel.eliminarItem(item);
        System.out.println("Item eliminado: " + item.getNombre());
    }

    public void verInventario() 
    {
        List<Item> items = inventarioModel.obtenerItems();
        System.out.println("Inventario:");
        for (Item item : items) 
        {
            System.out.println("- " + item.getNombre() + " (Cantidad: " + item.getCantidad() + ")");
        }
    }

    public void mostrarDetalles(String nombre) 
    {
        Item item = inventarioModel.buscarItem(nombre);
        if (item != null) 
        {
            System.out.println("Detalles de " + item.getNombre() + ":");
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + (item.isTipo() ? "Tipo A" : "Tipo B"));
            System.out.println("Descripcion: " + item.getDescripcion());
        } 
        else 
        {
            System.out.println("No se encontro ningun: " + nombre);
        }
    }


    public void buscarItem(String nombre) 
    {
        List<Item> encontrados = inventarioModel.buscarItems(nombre);
        if (encontrados.isEmpty()) 
        {
            System.out.println("No se encontro ningun: " + nombre);
        } else {
            System.out.println("Items encontrados:");
            for (Item item : encontrados) 
            {
                System.out.println("- " + item.getNombre());
            }
        }
    }
}

// MODELO
package modelo;
import java.util.ArrayList;
import java.util.List;

public class InventarioModel 
{
	private List<Item> items;
	
	 public InventarioModel() 
	 {
	        this.items = new ArrayList<>();
	  }
  
	    public void agregarItem(Item item) 
	    {
	        items.add(item);
	    }

	    public void eliminarItem(Item item) 
	    {
	        items.remove(item);
	    }

	    public List<Item> obtenerItems() 
	    {
	        return items;
	    }

	    public List<Item> buscarItems(String nombre) 
	    {
	        List<Item> encontrados = new ArrayList<>();
	        for (Item item : items) 
	        {
	            if (item.getNombre().equalsIgnoreCase(nombre))  //equalsIgnoreCase para completar 2 cadenas
	            {
	                encontrados.add(item);
	            }
	        }
	        return encontrados;
	    }


	    public Item buscarItem(String nombre) 
	    {
	        for (Item item : items) 
	        {
	            if (item.getNombre().equalsIgnoreCase(nombre)) 
	            {
	                return item; 
	            }
	        }
	        return null; 
	    }
}



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

// VISTA
package vista;
import modelo.Item;
import java.util.List;

public class InventarioView 
{

    public void mostrarInventario(List<Item> items) 
    {
        System.out.println("Inventario:");
        if (items.isEmpty()) 
        {
            System.out.println("El inventario esta vacío");
        } 
        else 
        {
            for (Item item : items) 
            {
                System.out.println("- " + item.getNombre() + " (Cantidad: " + item.getCantidad() + ")");
            }
        }
    }

    public void mostrarMensaje(String mensaje) 
    {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) 
    {
        if (item != null) 
        {
            System.out.println("Detalles de " + item.getNombre() + ":");
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Tipo: " + (item.isTipo() ? "Tipo A" : "Tipo B"));
            System.out.println("Descripción: " + item.getDescripcion());
        } 
        else 
        {
            System.out.println("No se encontro ningun item con ese nombre");
        }
    }
}







