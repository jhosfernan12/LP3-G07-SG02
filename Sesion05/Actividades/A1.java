public class PruebaMetodoGenerico 
{


    public static <E> void imprimirArreglo(E[] arregloEntrada) 
   {
        for (E elemento : arregloEntrada) 
        {
            System.out.printf("%s ", elemento);
        }
        System.out.println();
    } 


    public static void main(String args[]) 
  {
        Integer[] arregloInteger = {1, 2, 3, 4, 5, 6};
        Double[] arregloDouble = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7};
        Character[] arregloCharacter = {'H', 'O', 'L', 'A'};


        System.out.println("El arreglo arregloInteger contiene:");
        imprimirArreglo(arregloInteger); 


        System.out.println("\nEl arreglo arregloDouble contiene:");
        imprimirArreglo(arregloDouble); 


        System.out.println("\nEl arreglo arregloCharacter contiene:");
        imprimirArreglo(arregloCharacter);
    } 
} 



