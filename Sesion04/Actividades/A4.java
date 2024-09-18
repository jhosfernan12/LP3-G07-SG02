import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class HistorialVacioException extends Exception {
    public HistorialVacioException(String message) {
        super(message);
    }
}

public class ReporteTransacciones {
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private List<String> transacciones;

    public ReporteTransacciones(String numeroCuenta, String titular, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.transacciones = new ArrayList<>();
    }


    public void agregarTransaccion(String transaccion) {
        transacciones.add(transaccion);
    }

    public void generarReporte(String nombreArchivo) throws HistorialVacioException, IOException {
        if (transacciones.isEmpty()) {
            throw new HistorialVacioException("No se pueden generar reportes para cuentas sin transacciones");
        }

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Reporte de Transacciones\n");
            writer.write("Numero de Cuenta: " + numeroCuenta + "\n");
            writer.write("Titular: " + titular + "\n");
            writer.write("Saldo: " + saldo + "\n");
            writer.write("Transacciones:\n");

            for (String transaccion : transacciones) {
                writer.write(transaccion + "\n");
            }
        } catch (IOException e) {
            throw new IOException("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void leerDatosDesdeArchivo(String nombreArchivo) {
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReporteTransacciones reporte = new ReporteTransacciones("12345", "Juancito", 1500.00);


        try {
            reporte.generarReporte("reporte.txt");
        } catch (HistorialVacioException e) {
            System.err.println("Excepcion: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al generar el reporte: " + e.getMessage());
        }

        reporte.agregarTransaccion("Deposito de S/500");
        try {
            reporte.generarReporte("reporte.txt");
            System.out.println("Reporte generado exitosamente.");
        } catch (HistorialVacioException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }


        reporte.leerDatosDesdeArchivo("reporte.txt");


        reporte.leerDatosDesdeArchivo("archivo_inexistente.txt");
    }
}
