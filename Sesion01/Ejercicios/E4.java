package Sesion1;
import java.util.Scanner;

public class E4 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese un numero decimal: ");
		//Ingresamos los valores utilizando el scanner
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		double resultado = OrdenarDecimales(a,b,c); //Llamamos a la funcion OrdenarDecimales
		System.out.println("El numero menor es: " + resultado);//Imprimimos la funcion

	}
	
	public static double OrdenarDecimales(double num1, double num2, double num3)
	{
		double menor = num1; //Suponemos el el numero 1 es elmenor;
		if (num2 < menor) 
		{
            menor = num2;  // Si el segundo número es menor, lo actualizamos
        }
        if (num3 < menor) 
        {
            menor = num3;  // Si el tercer número es menor, lo actualizamos
        }

        return menor;  // Devolvemos el menor número
	}
}
