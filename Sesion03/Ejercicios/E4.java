package Sesion3;

public interface Imprimible 
{
	void Imprimir();
	void Escanear();
}

public class Impresora implements Imprimible
{
	@Override
	public void Imprimir()
	{
		System.out.println("Imprimiendo...");
	}
	@Override
	public void Escanear() 
	{
	    throw new UnsupportedOperationException("La impresora no puede escanear.");
	}
	
}

public class ImpresoraMultifuncional implements Imprimible
{
	@Override
	public void Imprimir()
	{
		System.out.println("Imprimiendo con multifuncionalidad...");
	}
	 @Override
	public void Escanear() 
	{
		 System.out.println("Escaneando...");
	}
}


public class E4
{

	public static void main(String[] args) 
	{
		
		Imprimible impresora = new Impresora();
		Imprimible impresora_multifuncional = new ImpresoraMultifuncional();
			
		impresora.Imprimir();
		try
		{
			impresora.Escanear();
		} 
		catch (UnsupportedOperationException e)
		{
			System.out.println(e.getMessage());
		}
			
		impresora_multifuncional.Imprimir();
		impresora_multifuncional.Escanear();
			
		
	}

}
