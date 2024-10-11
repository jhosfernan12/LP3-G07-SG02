package controlador;

import Modelo.Carrito;
import Modelo.Producto;
import Vista.VistaCarrito;

public class ControladorCarrito {
	private Carrito carrito;
    private VistaCarrito vista;

    public ControladorCarrito(Carrito carrito, VistaCarrito vista) {
        this.carrito = carrito;
        this.vista = vista;
    }

    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            vista.mostrarMenu();
            String opcion = vista.obtenerInput();

            switch (opcion) {
                case "1":
                    agregarProducto();
                    break;
                case "2":
                    verCarrito();
                    break;
                case "3":
                    eliminarProducto();
                    break;
                case "4":
                    aplicarDescuento();
                    break;
                case "5":
                    calcularEnvio();
                    break;
                case "6":
                    realizarCompra();
                    break;
                case "7":
                    continuar = false;
                    vista.mostrarMensaje("Saliendo del sistema...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        }
    }

    private void agregarProducto() {
        String nombre = vista.pedirNombreProducto();
        double precio = vista.pedirPrecioProducto();
        carrito.agregarProducto(new Producto(nombre, precio));
        vista.mostrarMensaje("Producto agregado al carrito.");
    }

    private void verCarrito() {
        if (carrito.getProductos().isEmpty()) {
            vista.mostrarMensaje("El carrito está vacío.");
        } else {
            vista.mostrarMensaje("Productos en el carrito:");
            for (Producto p : carrito.getProductos()) {
                vista.mostrarMensaje(p.getNombre() + " - $" + p.getPrecio() + " x " + p.getCantidad());
            }
            vista.mostrarMensaje("Total: $" + carrito.calcularTotal());
        }
    }

    private void eliminarProducto() {
        String nombre = vista.pedirNombreProducto();
        carrito.eliminarProducto(nombre);
        vista.mostrarMensaje("Producto eliminado del carrito.");
    }

    private void aplicarDescuento() {
        double descuento = vista.pedirDescuento();
        carrito.aplicarDescuento(descuento);
        vista.mostrarMensaje("Descuento aplicado.");
    }

    private void calcularEnvio() {
        double tarifaEnvio = vista.pedirTarifaEnvio();
        double envio = carrito.calcularEnvio(tarifaEnvio);
        vista.mostrarMensaje("Costo de envío: $" + envio);
    }

    private void realizarCompra() {
        double total = carrito.calcularTotal();
        carrito.vaciarCarrito();
        vista.mostrarMensaje("Compra realizada por un total de $" + total);
    }
}
