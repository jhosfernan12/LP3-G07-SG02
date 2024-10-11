package main;

import Modelo.Carrito;
import Vista.VistaCarrito;
import controlador.ControladorCarrito;

public class Main {
	public static void main(String[] args) {
		Carrito carrito = new Carrito();
		VistaCarrito vista = new VistaCarrito();
		ControladorCarrito controlador = new ControladorCarrito(carrito, vista);
		controlador.iniciar();
	}
}
