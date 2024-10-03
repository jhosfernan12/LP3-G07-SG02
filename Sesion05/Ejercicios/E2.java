public class Par<F, S> 
{
    private F primero;
    private S segundo;

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


    public boolean esIgual(Par<?, ?> otro) 
    {
        if (otro == null) return false;
        return (this.primero.equals(otro.getPrimero()) && this.segundo.equals(otro.getSegundo()));
    }

    @Override
    public String toString() 
    {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    public static void main(String[] args) 
    {
        Par<Integer, String> par1 = new Par<>(1, "Uno");
        Par<Integer, String> par2 = new Par<>(1, "Uno");
        Par<String, Double> par3 = new Par<>("Dos", 2.0);
        
        System.out.println(par1); 
        System.out.println(par2); 
        System.out.println(par3); 

        System.out.println(par1.esIgual(par2)); 
        System.out.println(par1.esIgual(par3)); 
        
        par1.setPrimero(2);
        par1.setSegundo("Dos");
        System.out.println(par1); 
    }
}
