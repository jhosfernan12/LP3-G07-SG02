package s10;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Producto 
{
	private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) 
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public double getPrecio() 
    {
        return precio;
    }

    public int getCantidadStock() 
    {
        return cantidadStock;
    }

    public String getCategoria() 
    {
        return categoria;
    }

    public void actualizarProducto(String nombre, double precio, int cantidadStock, String categoria) 
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    public String obtenerInformacion() 
    {
        return String.format("Nombre: %s\nPrecio: S/%.2f\nStock: %d\nCategoria: %s",
                nombre, precio, cantidadStock, categoria);
    }
}


