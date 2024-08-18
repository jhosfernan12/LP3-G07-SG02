package s1;

import java.util.Scanner;
public class e5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int horas = 0;
		double resultado;
		double cargo = 0;
		
		System.out.println("Ingrese la cantidad de horas: ");
		horas = sc.nextInt();
		sc.close();
		
		for (int i = 0; i < horas+1; i++) {
			cargo = i*0.50;
		}
		
		resultado = cargo + 3;
		
		if (resultado >= 12) {
			System.out.println("El cargo del estacionamiento es 12 S/.");
		}
		else {
			System.out.println("El cargo del estacionamiento es: " + resultado);
		}
		
	}
}
