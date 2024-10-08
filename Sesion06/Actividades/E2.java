package Controlador;
import java.util.List;
import modelo.PedidoModelo;
import vista.PedidoVista;
import modelo.Pedido;

public class PedidoControlador 
{
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) 
    {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void agregarPedido(String nombrePlato, String tipoPlato) 
    {
        if (!nombrePlato.isEmpty() && !tipoPlato.isEmpty()) 
        {
            modelo.agregarPedido(new Pedido(nombrePlato, tipoPlato));
            vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
        } 
        else 
        {
            vista.mostrarMensaje("El nombre o tipo del plato no pueden estar vacíos.");
        }
    }

    public void eliminarPedido(String nombrePlato) 
    {
        if (modelo.eliminarPedido(nombrePlato)) 
        {
            vista.mostrarMensaje("Pedido eliminado: " + nombrePlato);
        } 
        else 
        {
            vista.mostrarMensaje("No se encontró el pedido: " + nombrePlato);
        }
    }

    public void actualizarPedido(String nombrePlato, String nuevoNombre) 
    {
        if (modelo.actualizarPedido(nombrePlato, nuevoNombre)) 
        {
            vista.mostrarMensaje("Pedido actualizado: " + nuevoNombre);
        } 
        else 
        {
            vista.mostrarMensaje("No se encontró el pedido: " + nombrePlato);
        }
    }

    public void buscarPedido(String criterio) 
    {
        List<Pedido> resultados = modelo.buscarPedido(criterio);
        if (resultados.isEmpty()) 
        {
            vista.mostrarMensaje("No se encontraron pedidos con el criterio: " + criterio);
        }
        else 
        {
            vista.mostrarPedidos(resultados);
        }
    }

    public void contarPedidos() 
    {
        int total = modelo.contarPedidos();
        vista.mostrarMensaje("Total de pedidos: " + total);
    }

    public void mostrarPedidos() 
    {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
    }

    public void iniciar() 
    {
        String opcion;
        do 
        {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) 
            {
                case "1":
                    String nombrePlato = vista.solicitarNombrePlato();
                    String tipoPlato = vista.solicitarTipoPlato();
                    agregarPedido(nombrePlato, tipoPlato);
                    break;
                case "2":
                    mostrarPedidos();
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombrePlato();
                    eliminarPedido(nombreEliminar);
                    break;
                case "4":
                    String nombreActualizar = vista.solicitarNombrePlato();
                    String nuevoNombre = vista.solicitarNombrePlato(); 
                    actualizarPedido(nombreActualizar, nuevoNombre);
                    break;
                case "5":
                    String criterio = vista.solicitarNombrePlato(); 
                    buscarPedido(criterio);
                    break;
                case "6":
                    contarPedidos();
                    break;
                case "7":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!opcion.equals("7"));
        vista.cerrarScanner();
    }
}

package modelo;
import java.util.ArrayList;
import java.util.List;

public class PedidoModelo 
{
    private List<Pedido> pedidos;

    public PedidoModelo() 
    {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) 
    {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() 
    {
        return pedidos;
    }

    public boolean eliminarPedido(String nombrePlato) 
    {
    	
        return pedidos.removeIf(pedido -> pedido.getNombrePlato().equalsIgnoreCase(nombrePlato));
    }

    public boolean actualizarPedido(String nombrePlato, String nuevoNombre) 
    {
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombrePlato)) 
            {
                pedidos.set(pedidos.indexOf(pedido), new Pedido(nuevoNombre, pedido.getTipoPlato()));
                return true;
            }
        }
        return false; 
    }

    public List<Pedido> buscarPedido(String criterio) 
    {
        List<Pedido> resultados = new ArrayList<>();
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getNombrePlato().equalsIgnoreCase(criterio) || pedido.getTipoPlato().equalsIgnoreCase(criterio)) 
            {
                resultados.add(pedido);
            }
        }
        return resultados;
    }

    public int contarPedidos() 
    {
        return pedidos.size();
    }
}
package vista;
import java.util.List;
import java.util.Scanner;
import modelo.Pedido;

public class PedidoVista 
{
    private Scanner scanner;

    public PedidoVista() 
    {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() 
    {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() 
    { 
        System.out.print("Introduce el tipo del plato: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) 
    {
        if (pedidos.isEmpty()) 
        {
            System.out.println("No hay pedidos en la lista.");
        } 
        else 
        {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) 
            {
                System.out.println("- " + pedido);
            }
        }
    }

    public void mostrarMenu() 
    {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
    }

    public String solicitarOpcion() 
    {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) 
    {
        System.out.println(mensaje);
    }

    public void cerrarScanner() 
    {
        scanner.close();
    }
}


package modelo;

public class Pedido 
{
    private String nombrePlato;
    private String tipoPlato; 

    public Pedido(String nombrePlato, String tipoPlato) 
    {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato;
    }

    public String getNombrePlato() 
    {
        return nombrePlato;
    }

    public String getTipoPlato() 
    { 
        return tipoPlato;
    }

    @Override
    public String toString() 
    {
        return "Pedido: " + nombrePlato + " (Tipo: " + tipoPlato + ")";
    }
}

package Controlador;

import modelo.PedidoModelo;
import vista.PedidoVista;

public class main 
{
    public static void main(String[] args) 
    {
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
