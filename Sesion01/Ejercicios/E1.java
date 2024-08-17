package s1;

public class e1 {
	public static int sumarElementos(int[] arreglo) {
       int suma = 0;
       for (int num : arreglo) {
           suma += num;
       }
       return suma;
   }


   public static void main(String[] args) {
       int[] arreglo = {1, 2, 3, 4, 5};
       int resultado = sumarElementos(arreglo);
       System.out.println("La suma de los elementos es: " + resultado);
   }
}
