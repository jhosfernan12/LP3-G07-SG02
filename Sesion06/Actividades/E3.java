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
        } else {
            vista.mostrarMensaje("El nombre o tipo del plato no puede estar vacío.");
        }
    }

    public void mostrarPedidos() 
    {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
        vista.mostrarContadorPendientes(modelo.contarPedidosPendientes()); 
    }

    public void marcarPedidoComoCompleto() 
    {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
        System.out.print("Introduce el nombre del plato que deseas marcar como completo: ");
        String nombre = vista.solicitarNombrePlato();
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre) && pedido.getEstado().equals("pendiente")) 
            {
                modelo.marcarPedidoComoCompleto(pedido);
                vista.mostrarMensaje("Pedido marcado como completo: " + nombre);
                return;
            }
        }
        vista.mostrarMensaje("No se encontro un pedido pendiente con ese nombre.");
    }

    public void eliminarPedido() 
    {
        List<Pedido> pedidos = modelo.getPedidos();
        vista.mostrarPedidos(pedidos);
        System.out.print("Introduce el nombre del plato que deseas eliminar: ");
        String nombre = vista.solicitarNombrePlato();
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getNombrePlato().equalsIgnoreCase(nombre) && pedido.getEstado().equals("pendiente")) 
            {
                modelo.eliminarPedido(pedido);
                vista.mostrarMensaje("Pedido eliminado: " + nombre);
                return;
            }
        }
        vista.mostrarMensaje("No se encontró un pedido pendiente con ese nombre.");
    }

    public void mostrarPedidosPendientes() 
    {
        List<Pedido> pedidosPendientes = modelo.getPedidosPorEstado("pendiente");
        vista.mostrarPedidos(pedidosPendientes);
    }

    public void mostrarHistorial() 
    {
        List<Pedido> historial = modelo.getHistorial();
        if (historial.isEmpty()) 
        {
            vista.mostrarMensaje("No hay historial de pedidos.");
        } 
        else 
        {
            vista.mostrarPedidos(historial);
        }
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
                    marcarPedidoComoCompleto();
                    break;
                case "4":
                    eliminarPedido();
                    break;
                case "5":
                    mostrarPedidosPendientes();
                    break;
                case "6":
                    mostrarHistorial();
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

public class Pedido 
{
    private String nombrePlato;
    private String tipoPlato; 
    private String estado; 

    public Pedido(String nombrePlato, String tipoPlato) 
    {
        this.nombrePlato = nombrePlato;
        this.tipoPlato = tipoPlato; 
        this.estado = "pendiente"; 
    }

    public String getNombrePlato() 
    {
        return nombrePlato;
    }

    public String getTipoPlato() 
    {
        return tipoPlato; 
    }

    public String getEstado() 
    {
        return estado; 
    }

    public void marcarComoCompleto() 
    {
        this.estado = "completo"; 
    }

    public void eliminar() 
    {
        this.estado = "eliminado"; 
    }

    @Override
    public String toString() 
    {
        return "Pedido: " + nombrePlato + " (Tipo: " + tipoPlato + ", Estado: " + estado + ")";
    }
}

package modelo;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo 
{
    private List<Pedido> pedidos;
    private List<Pedido> historial; 

    public PedidoModelo() 
    {
        pedidos = new ArrayList<>();
        historial = new ArrayList<>(); 
    }

    public void agregarPedido(Pedido pedido) 
    {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() 
    {
        return pedidos;
    }

    public void eliminarPedido(Pedido pedido) 
    {
        pedido.eliminar(); 
        historial.add(pedido); 
    }

    public void marcarPedidoComoCompleto(Pedido pedido) 
    {
        pedido.marcarComoCompleto(); 
    }

    public List<Pedido> getPedidosPorEstado(String estado) 
    {
        List<Pedido> pedidosFiltrados = new ArrayList<>();
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getEstado().equals(estado)) 
            {
                pedidosFiltrados.add(pedido);
            }
        }
        return pedidosFiltrados;
    }

    public int contarPedidosPendientes() 
    {
        int contador = 0;
        for (Pedido pedido : pedidos) 
        {
            if (pedido.getEstado().equals("pendiente")) 
            {
                contador++;
            }
        }
        return contador;
    }

    public List<Pedido> getHistorial() 
    {
        return historial; 
    }
}

package vista;

import java.util.List;
import modelo.Pedido;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() { // Solicitar tipo de plato
        System.out.print("Introduce el tipo de plato: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos en la lista.");
        } else {
            System.out.println("Lista de Pedidos:");
            for (Pedido pedido : pedidos) {
                System.out.println("- " + pedido);
            }
        }
    }

    public void mostrarContadorPendientes(int contador) {
        System.out.println("Total de pedidos pendientes: " + contador);
    }

    public void mostrarMenu() {
        System.out.println("\nOpciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Pedidos");
        System.out.println("3. Marcar Pedido como Completo");
        System.out.println("4. Eliminar Pedido");
        System.out.println("5. Mostrar Pedidos Pendientes");
        System.out.println("6. Mostrar Historial de Pedidos");
        System.out.println("7. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opcion: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
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

