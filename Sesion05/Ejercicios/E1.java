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

    // Métodos set
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

    public static void main(String[] args) 
    {
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        System.out.println(par1); // Imprimira: (Primero: 1, Segundo: Uno)

        Par<String, Double> par2 = new Par<>("Dos", 2.0);
        System.out.println(par2); // Imprimira: (Primero: Dos, Segundo: 2.0)

        par1.setPrimero(2);
        par1.setSegundo("Dos");
        System.out.println(par1); // Imprimira: (Primero: 2, Segundo: Dos)
    }
}
