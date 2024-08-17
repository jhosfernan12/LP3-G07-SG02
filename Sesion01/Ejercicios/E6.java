package Sesion1;
import java.util.Scanner;

public class E6 
{

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		//Ingresemos las horas minutos y segundos
		System.out.print("Ingrese el numero de horas: ");
		int horas = scanner.nextInt();
		System.out.print("Ingrese el numero de minutos: ");
		int minutos = scanner.nextInt();
		System.out.print("Ingrese el número de segundos: ");
        int segundos = scanner.nextInt();
        
        int totalSegundos = ConvertirSegundos(horas, minutos, segundos);
        
        System.out.println("El equivalente en segundos es: " + totalSegundos);
	}
	
	public static int ConvertirSegundos(int horas, int minutos, int segundos)
	{
		int segundosHoras = horas * 3600; // 1 hora equivale a 3600 segundos
		int segundosMinutos = minutos * 60; // 1 minuto equivale a 60 segundos
		return segundosHoras + segundosMinutos + segundos; //Segundos no es necesario convertir
	}
	

}
