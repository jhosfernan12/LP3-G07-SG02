import java.io.*;
import java.util.*;

public class Gestor 
{
    private String archivo;
    private List<Personaje> personajes;

    public Gestor(String archivo) throws IOException 
    {
        this.archivo = archivo;
        this.personajes = new ArrayList<>();
        File file = new File(archivo);
        if (!file.exists()) {
            file.createNewFile();
        } 
        else 
        {
            cargarPersonajesDesdeArchivo(); 
        }
    }


    public void cargarPersonajesDesdeArchivo() throws IOException 
    {
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = reader.readLine()) != null) 
        {
            String[] datos = linea.split(" | ");
            if (datos.length == 6) 
            {
                Personaje p = new Personaje(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), 
                Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
                personajes.add(p);
            }
        }
        reader.close();
    }


    public void guardarPersonajesEnArchivo() throws IOException 
    {
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        for (Personaje p : personajes) 
        {
            writer.write(p.getNombre() + " | " + p.getVida() + " | " + p.getAtaque() + " | " + 
                         p.getDefensa() + " | " + p.getAlcance() + " | " + p.getNivel() + "\n");
        }
        writer.close();
    }


    public void añadirPersonaje(Personaje p) throws IOException 
    {
        if (buscarPersonaje(p.getNombre()) == null) 
        {
            personajes.add(p);
            guardarPersonajesEnArchivo();
            System.out.println("Personaje añadido: " + p);
        } 
        else 
        {
            System.out.println("El personaje ya existe =(");
        }
    }


    public Personaje buscarPersonaje(String nombre) 
    {
        for (Personaje p : personajes) 
        {
            if (p.getNombre().equalsIgnoreCase(nombre)) 
            {
                return p;
            }
        }
        return null;
    }


    public void borrarPersonaje(String nombre) throws IOException 
    {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) {
            personajes.remove(p);
            guardarPersonajesEnArchivo();
            System.out.println("Personaje borrado: " + nombre);
        } else {
            System.out.println("El personaje no existe =(");
        }
    }


    public void filtrarPorAtributo(String atributo) 
    {
        Comparator<Personaje> comparator = null;
        switch (atributo.toLowerCase()) 
        {
            case "vida":
                comparator = Comparator.comparing(Personaje::getVida);
                break;
            case "ataque":
                comparator = Comparator.comparing(Personaje::getAtaque);
                break;
            case "defensa":
                comparator = Comparator.comparing(Personaje::getDefensa);
                break;
            case "alcance":
                comparator = Comparator.comparing(Personaje::getAlcance);
                break;
        }
        if (comparator != null) 
        {
            personajes.sort(comparator.reversed()); 
            for (Personaje p : personajes)
            {
                System.out.println(p);
            }
        } 
        else 
        {
            System.out.println("Atributo desconocido");
        }
    }


    public void mostrarEstadisticas() 
    {
        if (personajes.isEmpty()) 
        {
            System.out.println("No hay personajes registrados aun");
            return;
        }
        int total = personajes.size();
        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);
        
        System.out.println("Total de personajes: " + total);
        System.out.println("Promedio de Vida: " + promedioVida);
        System.out.println("Promedio de Ataque: " + promedioAtaque);
        System.out.println("Promedio de Defensa: " + promedioDefensa);
        System.out.println("Promedio de Alcance: " + promedioAlcance);
    }


    public void cargarPersonajesAleatorios() throws IOException 
    {
        String[] nombres = {"Caballero", "Guerrero", "Arquero", "Dragon", "Mago"};
        Random rand = new Random();
        for (String nombre : nombres) 
        {
            int vida = rand.nextInt(5) + 1;
            int ataque = rand.nextInt(5) + 1;
            int defensa = rand.nextInt(5) + 1;
            int alcance = rand.nextInt(5) + 1;
            int nivel = 1;
            Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance, nivel);
            añadirPersonaje(p);
        }
    }


    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) throws IOException 
    {
        Personaje p = buscarPersonaje(nombre);
        if (p != null) 
        {
            switch (atributo.toLowerCase()) 
            {
                case "vida":
                    p.setVida(nuevoValor);
                    break;
                case "ataque":
                    p.setAtaque(nuevoValor);
                    break;
                case "defensa":
                    p.setDefensa(nuevoValor);
                    break;
                case "alcance":
                    p.setAlcance(nuevoValor);
                    break;
                default:
                    System.out.println("Atributo desconocido");
                    return;
            }
            guardarPersonajesEnArchivo();
            System.out.println("Atributo actualizado: " + p);
        } else {
            System.out.println("El personaje no existe");
        }
    }
}

