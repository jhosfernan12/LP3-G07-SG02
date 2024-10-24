
import java.io.*;
import java.util.ArrayList;


public class EmpleadoControlador {
    private final String archivo = "empleados.dat";
    private ArrayList<Empleado> empleados;


    public EmpleadoControlador() {
        empleados = leerEmpleados();
    }


    public ArrayList<Empleado> leerEmpleados() {
   	try (ObjectInputStream	ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<Empleado>) ois.readObject();
        } 
		catch (FileNotFoundException e) {
    		return new ArrayList<>();
        } 
		catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        guardarEmpleados();
        System.out.println("Empleado agregado correctamente.");
    }


	 public Empleado buscarEmpleado(int numero) {
	 return empleados.stream().filter(emp -> emp.getNumero() == numero).findFirst().orElse(null);
    }


    public void eliminarEmpleado(int numero) {
        Empleado empleado = buscarEmpleado(numero);
        if (empleado != null) {
            empleados.remove(empleado);
            guardarEmpleados();
            System.out.println("Empleado eliminado correctamente.");
        } 
		 else {
            System.out.println("Empleado no encontrado.");
        }
    }


    private void guardarEmpleados() {
	 try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados);
        } 
		 catch (IOException e) {
            System.out.println("Error al guardar empleados: " + e.getMessage());
        }
    }


    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } 
		 else {
            empleados.forEach(System.out::println);
        }
    }
}


