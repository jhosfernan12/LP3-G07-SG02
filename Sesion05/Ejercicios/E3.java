public class Par<F, S> 
{
    private F primero;
    private S segundo;

    // Constructor
    public Par(F primero, S segundo) 
    {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() 
    {
        return primero;
    }

    public S getSegundo() 
    {
        return segundo;
    }

    public void setPrimero(F primero) 
    {
        this.primero = primero;
    }

    public void setSegundo(S segundo) 
    {
        this.segundo = segundo;
    }

    @Override
    public String toString() 
    {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}


class Persona 
{
    private String nombre;

    public Persona(String nombre) 
    {
        this.nombre = nombre;
    }

    @Override
    public String toString() 
    {
        return nombre;
    }
}


public class Main 
{
  
    public static <F, S> void imprimirPar(Par<F, S> par) 
    {
        System.out.println(par);
    }

    public static void main(String[] args) 
    {
        Par<String, Integer> par1 = new Par<>("Uno", 1);
        imprimirPar(par1); // Imprime: (Primero: Uno, Segundo: 1)

  
        Par<Double, Boolean> par2 = new Par<>(3.14, true);
        imprimirPar(par2); // Imprime: (Primero: 3.14, Segundo: true)


        Par<Persona, Integer> par3 = new Par<>(new Persona("Juan"), 25);
        imprimirPar(par3); // Imprime: (Primero: Juan, Segundo: 25)
    }
}
