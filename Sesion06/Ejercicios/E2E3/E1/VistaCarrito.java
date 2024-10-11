package Vista;
import java.util.Scanner;

public class VistaCarrito {
	private Scanner scanner;

    public VistaCarrito() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== MENÚ DE CARRITO DE COMPRAS ===");
        System.out.println("1. Agregar producto al carrito");
        System.out.println("2. Ver productos del carrito");
        System.out.println("3. Eliminar producto del carrito");
        System.out.println("4. Aplicar descuento");
        System.out.println("5. Calcular envío");
        System.out.println("6. Realizar compra");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public String obtenerInput() {
        return scanner.nextLine();
    }

    public String pedirNombreProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        return scanner.nextLine();
    }

    public double pedirPrecioProducto() {
        System.out.print("Ingrese el precio del producto: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public double pedirDescuento() {
        System.out.print("Ingrese el porcentaje de descuento: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public double pedirTarifaEnvio() {
        System.out.print("Ingrese la tarifa de envío: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
