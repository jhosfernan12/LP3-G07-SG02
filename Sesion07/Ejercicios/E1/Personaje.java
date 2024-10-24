
public class Personaje 
{
	 private String nombre;
	    private int vida;
	    private int ataque;
	    private int defensa;
	    private int alcance;

	    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) 
	    {
	        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) 
		{
	            throw new IllegalArgumentException("La vida, ataque, defensa y alcance deben ser mayores que 0");
	        }
	        this.nombre = nombre;
	        this.vida = vida;
	        this.ataque = ataque;
	        this.defensa = defensa;
	        this.alcance = alcance;
	    }

	    public String getNombre() 
	    {
	        return nombre;
	    }

	    @Override
	    public String toString() 
	    {
	        return nombre + " | " + vida + " | " + ataque + " | " + defensa + " | " + alcance;
	    }

	    public static Personaje fromString(String linea) 
	    {
	    	
	        String[] partes = linea.split(" | ");
	        return new Personaje(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
	                Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
	    }
}
