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
