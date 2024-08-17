import java.util.Scanner;
public class NumerosPerfectosConFunciones 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = scanner.nextInt();
        imprimirNumerosPerfectos(n);
    }
    // Funcion para verificar si un numero es perfecto
    public static boolean esPerfecto(int num) 
    {
    int sumaDivisores = 0;
        for (int i = 1; i <= num / 2; i++) 
        {
            if (num % i == 0) 
            {
            sumaDivisores += i;
            }
        }
        return sumaDivisores == num;
    }
    // Funcion para encontrar y mostrar todos los numeros perfectosmenores a un numero dado n
    public static void imprimirNumerosPerfectos(int n) 
    {
        for (int num = 1; num < n; num++) 
        {
            if (esPerfecto(num)) 
            {
                System.out.println(num + " es un numero perfecto.");
            }
        }
    }
}