package s8;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class VideojuegoManager {
    private List<Videojuego> videojuegos;


    public VideojuegoManager() {
        videojuegos = new ArrayList<>();
        videojuegos.add(new Videojuego(1, "Juego A", "PC", 2021));
        videojuegos.add(new Videojuego(2, "Juego B", "PS5", 2020));
        videojuegos.add(new Videojuego(3, "Juego C", "Xbox", 2019));
    }


    public void consultarVideojuegos(String campoMostrar, String condicionCampo, String condicionValor,
                                     String ordenCampo, boolean descendente, int limite) {
        List<Videojuego> resultado = new ArrayList<>(videojuegos);


        if (!condicionCampo.isEmpty() && !condicionValor.isEmpty()) {
            resultado = resultado.stream().filter(v -> {
                switch (condicionCampo.toLowerCase()) {
                    case "titulo": return v.titulo.equalsIgnoreCase(condicionValor);
                    case "plataforma": return v.plataforma.equalsIgnoreCase(condicionValor);
                    case "aniosalida": return v.anioSalida == Integer.parseInt(condicionValor);
                    default: return true;
                }
            }).collect(Collectors.toList());
        }


        if (!ordenCampo.isEmpty()) {
            Comparator<Videojuego> comparator = switch (ordenCampo.toLowerCase()) {
                case "titulo" -> Comparator.comparing(v -> v.titulo);
                case "plataforma" -> Comparator.comparing(v -> v.plataforma);
                case "aniosalida" -> Comparator.comparingInt(v -> v.anioSalida);
                default -> Comparator.comparingInt(v -> v.id);
            };
            resultado.sort(descendente ? comparator.reversed() : comparator);
        }


        if (limite > 0 && limite < resultado.size()) {
            resultado = resultado.subList(0, limite);
        }


        resultado.forEach(v -> {
            switch (campoMostrar.toLowerCase()) {
                case "titulo" -> System.out.println("Título: " + v.titulo);
                case "plataforma" -> System.out.println("Plataforma: " + v.plataforma);
                case "aniosalida" -> System.out.println("Año de salida: " + v.anioSalida);
                default -> System.out.println(v);
            }
        });
    }


    public static void main(String[] args) {
        VideojuegoManager manager = new VideojuegoManager();
        Scanner scanner = new Scanner(System.in);


        System.out.print("Campo a mostrar (titulo/plataforma/aniosalida o 'todos'): ");
        String campoMostrar = scanner.nextLine();


        System.out.print("Condición en el campo (titulo/plataforma/aniosalida o vacío): ");
        String condicionCampo = scanner.nextLine();


        System.out.print("Valor de la condición (o vacío): ");
        String condicionValor = scanner.nextLine();


        System.out.print("Campo para ordenar (titulo/plataforma/aniosalida o vacío): ");
        String ordenCampo = scanner.nextLine();


        System.out.print("¿Orden descendente? (true/false): ");
        boolean descendente = scanner.nextBoolean();


        System.out.print("Límite de registros a mostrar: ");
        int limite = scanner.nextInt();


        manager.consultarVideojuegos(campoMostrar, condicionCampo, condicionValor, ordenCampo, descendente, limite);
    }
}
