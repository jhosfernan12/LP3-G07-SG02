package s4;

public class E2
{
	public static double Sumar(double a,double b)
	{
		return a + b;
	}
	
	public static double Restar(double a,double b)
	{
		return a - b;
	}
	
	public static double Multiplicar(double a,double b)
	{
		return a * b;
	}
	
	public static double Dividir(int numerador, int divisor) throws DivisionPorCeroException 
	{
        if (divisor == 0) 
        {
            throw new DivisionPorCeroException("Error: Division por cero");
        }
        return (double) numerador / divisor;
    }
	
	 public static void main(String[] args) 
	 {
	        int numerador = 10;
	        int divisor = 0;
	        try 
	        {
	            double resultado = Dividir(numerador, divisor);
	            System.out.println("El resultado de la división es: " + resultado);
	        } 
	        catch (DivisionPorCeroException e) 
	        {
	        	
	            System.out.println("Excepcion personalizada capturada: " + e.getMessage());
	        } 
	        catch (ArithmeticException e) 
	        {
	            System.out.println("Excepcion de aritmética capturada: " + e.getMessage());
	        } 
	        catch (IllegalArgumentException e) 
	        {
	            System.out.println("Excepcion de argumento ilegal capturada: " + e.getMessage());
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Excepcion general capturada: " + e.getMessage());
	        }
	    }
}


public class DivisionPorCeroException extends Exception
{
	public DivisionPorCeroException(String mensaje) 
	{
        super(mensaje);
    }
}


