package s11;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) 
    {

        SistemaDeNotificaciones sistema = new SistemaDeNotificaciones();


        Scanner scanner = new Scanner(System.in);


        int opcion;
        do 
        {

            System.out.println("1) Crear y suscribir a un nuevo usuario");
            System.out.println("2) Desuscribir a un usuario");
            System.out.println("3) Enviar notificacion");
            System.out.println("4) Mostrar Suscriptores");
            System.out.println("5) Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch(opcion) 
            {
                case 1:
                   
                    System.out.println("Ingrese el nombre del nuevo usuario");
                    String nombreNuevoUsuario = scanner.nextLine();
                    Usuario nuevoUsuario = new Usuario(nombreNuevoUsuario);
                    sistema.suscribir(nuevoUsuario);
                    break;
                case 2:
                	
                    System.out.println("Ingrese el nombre del usuario a desuscribir:");
                    String nombreUsuarioDesuscribir = scanner.nextLine();
                    Usuario usuarioAEliminar = new Usuario(nombreUsuarioDesuscribir);
                    sistema.desuscribir(usuarioAEliminar);
                    break;
                case 3:

                    System.out.println("Ingrese el mensaje de la notificacion:");
                    String mensaje = scanner.nextLine();
                    sistema.enviarNotificacion(mensaje);
                    break;
                case 4:
                	sistema.mostrarSuscriptores();
                case 5:
                    System.out.println("Programa cerrado");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 5);


        scanner.close();
    }
}
