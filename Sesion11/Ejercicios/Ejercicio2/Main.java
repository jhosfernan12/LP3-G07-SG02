package s11;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        
        Producto producto = new Producto("Laptop", 1000.0);
        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();
        
        while (true) 
        {
            
            System.out.println("*************************************");
            System.out.println("Producto: " + producto.getNombre() + " | Precio: S/" + producto.getPrecio());
            System.out.print("Ingrese la cantidad: ");
            
            int cantidad = scanner.nextInt();
            while (cantidad <= 0) {
                System.out.print("Cantidad invalida. Ingrese una cantidad valida: ");
                cantidad = scanner.nextInt();
            }

            System.out.println("\nSeleccione una estrategia de descuento:");
            System.out.println("1. Sin descuento");
            System.out.println("2. Descuento fijo (10%)");
            System.out.println("3. Descuento porcentual (30% para 2 productos iguales)");
            System.out.println("4. Descuento porcentual acumulado (50% en el producto mas barato a partir de 3 productos)");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            while (opcion < 1 || opcion > 5) 
            {
                System.out.println("Opcion invalida. Por favor, seleccione una opcion valida (1-5):");
                opcion = scanner.nextInt();
            }

            switch (opcion) 
            {
                case 1:
                    calculadora.setEstrategia(new SinDescuento());
                    break;
                case 2:
                    calculadora.setEstrategia(new DescuentoFijo());
                    break;
                case 3:
                    calculadora.setEstrategia(new DescuentoPorcentual());
                    break;
                case 4:
                    calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
            }


            double precioFinal = calculadora.calcularPrecio(producto, cantidad);
            System.out.printf("Precio final: S/%.2f\n", precioFinal);

           
            System.out.println("\n¿Desea realizar otra compra?");
            System.out.println("1. Si");
            System.out.println("2. No");
            int otraCompra = scanner.nextInt();

            if (otraCompra != 1) {
                System.out.println("Saliendo...");
                break;
            }
        }
    }
}
