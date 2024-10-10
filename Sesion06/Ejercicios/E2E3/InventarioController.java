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