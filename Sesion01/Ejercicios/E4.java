package Sesion1;
import java.util.Scanner;

public class E4 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		//Ingresamos los valores utilizando el scanner
		System.out.println("Ingrese un primer numero con parte decimal: ");
		double a = scanner.nextDouble();
		System.out.println("Ingrese un segundo numero con parte decimal: ");
		double b = scanner.nextDouble();
		System.out.println("Ingrese un tercer numero con parte decimal: ");
		double c = scanner.nextDouble();
		double resultado = OrdenarDecimales(a,b,c); //Llamamos a la funcion OrdenarDecimales
		System.out.println("El numero menor es: " + resultado);//Imprimimos la funcion

	}
	
	public static double OrdenarDecimales(double num1, double num2, double num3)
	{
		double menor = num1; //Suponemos el el numero1 es el menor;
		if (num2 < menor) 
		{
            menor = num2;  // Si el segundo numero es menor, lo actualizamos
        }
        if (num3 < menor) 
        {
            menor = num3;  // Si el tercer numero es menor, lo actualizamos
        }

        return menor;  // Devolvemos el menor numero
	}
}
