package s7;
import java.io.IOException;
import java.util.Scanner;

public class main 
{
	public static void main(String[] args) throws IOException 
	{
        Scanner scanner = new Scanner(System.in);
        Gestor gestor = new Gestor("personajes.txt");

        while (true) 
        {
            System.out.println("\n----- Menu -----");
            System.out.println("1 Añadir personaje");
            System.out.println("2 Mostrar personajes");
            System.out.println("3 Modificar personaje");
            System.out.println("4 Borrar personaje");
            System.out.println("5 Salir");
            System.out.print("Elige una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) 
            {
                case 1:
                    System.out.print("Nombre del personaje: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Vida: ");
                    int vida = scanner.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = scanner.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = scanner.nextInt();
                    Personaje nuevoPersonaje = new Personaje(nombre, vida, ataque, defensa, alcance);
                    gestor.añadirPersonaje(nuevoPersonaje);
                    break;
                case 2:
                    gestor.mostrarPersonajes();
                    break;
                case 3:
                    System.out.print("Nombre del personaje a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("NUEVA vida: ");
                    int nuevaVida = scanner.nextInt();
                    System.out.print("NUEVO ataque: ");
                    int nuevoAtaque = scanner.nextInt();
                    System.out.print("NUEVA defensa: ");
                    int nuevaDefensa = scanner.nextInt();
                    System.out.print("NUEVO alcance: ");
                    int nuevoAlcance = scanner.nextInt();
                    Personaje personajeModificado = new Personaje(nombreModificar, nuevaVida, nuevoAtaque, nuevaDefensa, nuevoAlcance);
                    gestor.modificarPersonaje(nombreModificar, personajeModificado);
                    break;
                case 4:
                    System.out.print("Nombre del personaje que se desea borrar: ");
                    String nombreBorrar = scanner.nextLine();
                    gestor.borrarPersonaje(nombreBorrar);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalido");
            }
        }
    }
}
