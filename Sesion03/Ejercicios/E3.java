package s3_1;

public abstract class Vehiculo
{
  protected int velocidad;
   public Vehiculo() 
   {
         this.velocidad = 0;
   }
   public abstract void acelerar();
   public int getVelocidad() 
   {
       return velocidad;
   }
}


public class Carro extends Vehiculo
{
    @Override
    public void acelerar() 
    {
        System.out.println("Acelerando el coche usando el motor.");
        velocidad += 10; 
    }
}



public class Bicicleta extends Vehiculo 
{
	@Override
	public void acelerar() 
    {
	    System.out.println("Acelerando la bicicleta pedaleando.");
	}
}



public class Main 
{
	public static void main(String[] args) 
  {
       Vehiculo carro = new Carro();
       Vehiculo bicicleta = new Bicicleta();

       carro.acelerar();
       System.out.println("Velocidad del coche: " + carro.getVelocidad());

       bicicleta.acelerar();
       System.out.println("Velocidad de la bicicleta: " + bicicleta.getVelocidad());
   }
}

