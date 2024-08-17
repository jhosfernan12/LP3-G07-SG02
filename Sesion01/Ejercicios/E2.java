package Sesion1;
import java.util.Scanner;

public class E2 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int[] numeros = new int[10];
		
		System.out.println("Ingrese un numero: ");
        numeros[0] = scanner.nextInt();  // Ingresamos el primer numero fuera del ciclo
        
		for(int i = 1; i < numeros.length; i++)
		{
			System.out.println("Ingrese un numero: ");
			int numero = scanner.nextInt();
			
			if (numero > numeros[i-1]) // i-1 para comprar con la iteracion anterior 
			{
				numeros[i] = numero;
			}
			else
			{
				 System.out.println("El numero ingresado no es mayor que el anterior");
	                i--;  // Decrementamos i para repetir la iteración sin avanzar en el arreglo
			}
		}
		
		 System.out.println("Numeros guardados en el arreglo:");
	        for (int num : numeros) 
	        {
	            System.out.println(num); // Mostramos el contenido del arreglo
	        }
	}

}
