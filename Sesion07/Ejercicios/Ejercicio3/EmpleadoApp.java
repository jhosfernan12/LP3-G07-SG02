
public class EmpleadoApp {
    public static void main(String[] args) {
        EmpleadoControlador controlador = new EmpleadoControlador();
        EmpleadoVista vista = new EmpleadoVista(controlador);
        vista.mostrarMenu();
    }
}
