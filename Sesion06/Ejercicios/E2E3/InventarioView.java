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
