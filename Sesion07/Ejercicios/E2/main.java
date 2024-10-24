import java.io.IOException;
import java.util.Scanner;

public class main 
{
    public static void main(String[] args) throws IOException 
    {
        Gestor gestor = new Gestor("personajes.txt");
        gestor.cargarPersonajesAleatorios(); 

        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("1 Añadir personaje");
            System.out.println("2 Borrar personaje");
            System.out.println("3 Filtrar personajes por atributo");
            System.out.println("4 Actualizar atributo de personaje");
            System.out.println("5 Mostrar estadísticas generales");
            System.out.println("6 Salir");
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
                    int nivel = 1;
                    gestor.añadirPersonaje(new Personaje(nombre, vida, ataque, defensa, alcance, nivel));
                    break;
                case 2:
                    System.out.print("Nombre del personaje a borrar: ");
                    String nombreBorrar = scanner.nextLine();
                    gestor.borrarPersonaje(nombreBorrar);
                    break;
                case 3:
                    System.out.print("Filtrar por (vida|ataque|defensa|alcance): ");
                    String atributo = scanner.nextLine();
                    gestor.filtrarPorAtributo(atributo);
                    break;
                case 4:
                    System.out.print("Nombre del personaje: ");
                    String nombreActualizar = scanner.nextLine();
                    System.out.print("Atributo a actualizar (vida|ataque|defensa|alcance): ");
                    String atributoActualizar = scanner.nextLine();
                    System.out.print("Nuevo valor: ");
                    int nuevoValor = scanner.nextInt();
                    gestor.actualizarAtributo(nombreActualizar, atributoActualizar, nuevoValor);
                    break;
                case 5:
                    gestor.mostrarEstadisticas();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion invalida");
            }
        }
    }
}
