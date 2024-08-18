package s1;
import java.util.Random;


public class e3 {
	public static void main(String[] args) {
       final int num_lanzamientos = 20000;
       final int num_caras = 6;


       int[] frecuencia = new int[num_caras];


       Random random = new Random();


       for (int i = 0; i < num_lanzamientos; i++) {
           int resultado = random.nextInt(num_caras);
           frecuencia[resultado]++;
       }


       System.out.println("Frecuencia de cada cara del dado después de " + num_lanzamientos + " lanzamientos:");
       for (int i = 0; i < num_caras; i++) {
           System.out.println("Cara " + (i + 1) + ": " + frecuencia[i]);
       }
   }
}
