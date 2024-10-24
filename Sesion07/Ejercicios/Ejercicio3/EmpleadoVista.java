import java.util.Scanner;


public class EmpleadoVista {
    private final EmpleadoControlador controlador;
    private final Scanner scanner;


    public EmpleadoVista(EmpleadoControlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }


    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Gestión de Empleados ---");
            System.out.println("1. Listar todos los empleados");
            System.out.println("2. Agregar un nuevo empleado");
            System.out.println("3. Buscar un empleado por su número");
            System.out.println("4. Eliminar un empleado por su número");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();


            switch (opcion) {
                case 1:
                    controller.listarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }


    private void agregarEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        scanner.nextLine();


        controlador.agregarEmpleado(new Empleado(numero, nombre, sueldo));
    }


    private void buscarEmpleado() {
        System.out.print("Ingrese el número del empleado a buscar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();


        Empleado empleado = controlador.buscarEmpleado(numero);
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }


    private void eliminarEmpleado() {
        System.out.print("Ingrese el número del empleado a eliminar: ");
        int numero = scanner.nextInt();
        scanner.nextLine();


        controlador.eliminarEmpleado(numero);
    }
}


