package Modelo;
import java.util.ArrayList;

public class Carrito {
	private ArrayList<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void eliminarProducto(String nombre) {
        productos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getTotal();
        }
        return total;
    }

    public void aplicarDescuento(double porcentaje) {
        for (Producto p : productos) {
            double precioConDescuento = p.getPrecio() - (p.getPrecio() * porcentaje / 100);
            p.setCantidad((int) precioConDescuento);
        }
    }

    public double calcularEnvio(double tarifaEnvio) {
        return tarifaEnvio;
    }

    public void vaciarCarrito() {
        productos.clear();
    }
}
