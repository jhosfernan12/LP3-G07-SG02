package modelo;

public class Jugador {
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
