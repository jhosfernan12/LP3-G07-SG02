package Sesion3;

public abstract class Forma 
{
	public void Dibujar()
	{
		System.out.println("Dibujando la forma");
	}
}

public class Circulo extends Forma
{
	@Override 
	public void Dibujar()
	{
		System.out.println("Dibujando un Circulo");
	}

}

public class Triangulo extends Forma
}
	@Override
	public void Dibujar()
	{
		System.out.println("Dibujando un Triangulo");
	}
	
}

public class Cuadrado extends Forma
{
	@Override
	public void Dibujar()
	{
		System.out.println("Dibujando un Cuadrado");
	}
}


public class E2
{
	public static void main(String[] args)
	{
		Forma circulo = new Circulo();
		Forma triangulo = new Triangulo();
		Forma cuadrado = new Cuadrado();
		
		circulo.Dibujar();
		triangulo.Dibujar();
		cuadrado.Dibujar();
		
    }
}
