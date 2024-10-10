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
