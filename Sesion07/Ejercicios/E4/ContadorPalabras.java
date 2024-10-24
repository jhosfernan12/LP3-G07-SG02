import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;


public class ContadorPalabras {


    public static void main(String[] args) {
        try {
            // Abrimos el  archivo con jfilechoser
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                
                procesarArchivo(archivo);
            } else {
                System.out.println("No se seleccionó ningún archivo.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al procesar el archivo: " + e.getMessage());
        }
    }


    public static void procesarArchivo(File archivo) {
        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> conteoPalabras = new HashMap<>();


        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;


                totalCaracteres += contarCaracteres(linea);


                String[] palabras = linea.split("\\s+"); //se dividen los espacios en blanco
                totalPalabras += palabras.length;


                for (String palabra : palabras) {
                    palabra = limpiarPalabra(palabra);
                    if (!palabra.isEmpty()) {
                 		conteoPalabras.put(palabra, conteoPalabras.getOrDefault(palabra, 0) + 1);
                    }
                }
            }


            System.out.println("Total de líneas: " + totalLineas);
            System.out.println("Total de palabras: " + totalPalabras);
           System.out.println("Total de caracteres (sin contar saltos de línea): " + totalCaracteres);
            System.out.printf("Promedio de palabras por línea: %.2f%n", (double) totalPalabras / totalLineas);


            System.out.println("Palabras más frecuentes:");
            conteoPalabras.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(10)  //palabras mas frecuentes
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }


    public static int contarCaracteres(String linea) {
        int contador = 0;
        for (char c : linea.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                contador++;
            }
        }
        return contador;
    }


    public static String limpiarPalabra(String palabra) {
        return palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}




