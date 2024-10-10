//CONTROLADOR
package controlador;


import modelo.Jugador;
import modelo.Enemigo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CombateController 
{
    private Jugador jugador;
    private List<Enemigo> enemigos;
    public CombateController(Jugador jugador) 
    {
        this.jugador = jugador;
        this.enemigos = new ArrayList<>();
    }
    public void agregarEnemigo(Enemigo enemigo) 
    {
        enemigos.add(enemigo);
    }
    public void iniciarCombate() 
    {
        while (jugador.getSalud() > 0 && !enemigos.isEmpty()) 
        {
            for (Enemigo enemigo : new ArrayList<>(enemigos)) 
            {
                jugador.atacar(enemigo);
                if (enemigo.getSalud() <= 0) 
                {
                    enemigos.remove(enemigo);
                } 
                else 
                {
                    enemigo.atacar(jugador);
                }
            }
        }
        if (jugador.getSalud() <= 0) 
        {
            System.out.println("El jugador ha sido derrotado");
        } else {
            System.out.println("Todos los enemigos han sido derrotados");
        }
    }
}
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


//MODELO
package modelo;
public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;


    public Enemigo(String nombre, int salud, int nivel, String tipo) 
    {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public void atacar(Jugador jugador) 
    {
        int danio = nivel * 5; 
        System.out.println(nombre + " ataca a " + jugador.getNombre() + " y causa " + danio + " puntos de daño.");
        jugador.recibirDanio(danio);
    }

    public void recibirDanio(int danio) 
    {
        salud -= danio;
        System.out.println(nombre + " recibe " + danio + " puntos de daño.");
        if (salud <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    public String getNombre() {
        return nombre;
    }

	public int getSalud() 
	{
		return salud;
	}
}
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
package modelo;
public class Jugador 
{
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item objetoEquipped;


    public Jugador(String nombre, int salud, int nivel) 
    {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.inventario = new InventarioModel();
    }


    public void equiparObjeto(Item item) 
    {
        this.objetoEquipped = item;
        System.out.println(nombre + " ha equipado " + item.getNombre());
    }


    public void atacar(Enemigo enemigo) 
    {
        if (objetoEquipped != null) 
        {
            System.out.println(nombre + " ataca a " + enemigo.getNombre() + " usando " + objetoEquipped.getNombre());
            enemigo.recibirDanio(objetoEquipped.getCantidad());
        } else {
            System.out.println(nombre + " no tiene ningún objeto equipado.");
        }
    }


    public void recibirDanio(int danio) 
    {
        salud -= danio;
        System.out.println(nombre + " recibe " + danio + " puntos de daño.");
        if (salud <= 0) 
        {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }


    public int getSalud() 
    {
        return salud;
    }


    public String getNombre() 
    {
        return nombre;
    }
}
//VISTA
package vista;


import modelo.Jugador;
import modelo.Enemigo;


import java.util.List;


public class CombateView 
{
    public void mostrarEstadoCombate(Jugador jugador, List<Enemigo> enemigos) 
    {
        System.out.println("Estado del combate:");
        System.out.println(jugador.getNombre() + " Salud: " + jugador.getSalud());
        for (Enemigo enemigo : enemigos) {
            System.out.println(enemigo.getNombre() + " Salud: " + enemigo.getSalud());
        }
    }


    public void mostrarMensaje(String mensaje) 
    {
        System.out.println(mensaje);
    }
}
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

//MAIN
import modelo.Item;
import modelo.Jugador;
import modelo.Enemigo;
import controlador.CombateController;


public class main 
{
    public static void main(String[] args) 
    {
        Jugador jugador = new Jugador("Steve", 100, 1);

        Item espada = new Item("Espada de Diamante", 10, true, "Una espada afilada");
        Item pocion = new Item("Pocion de Curacion", 5, false, "Restaura salud.");

        jugador.equiparObjeto(espada);

        Enemigo enemigo1 = new Enemigo("Crepper", 30, 1, "Crepper");
        Enemigo enemigo2 = new Enemigo("Enderman", 50, 2, "Enderman");


        CombateController combateController = new CombateController(jugador);
        combateController.agregarEnemigo(enemigo1);
        combateController.agregarEnemigo(enemigo2);

        combateController.iniciarCombate();
    }
}






