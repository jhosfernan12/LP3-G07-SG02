import java.io.*;

public class Gestor 
{
	 private String archivo;

	 public Gestor(String archivo) throws IOException 
	 {
	        this.archivo = archivo;
	        File file = new File(archivo);
	        if (!file.exists()) 
	        {
	            file.createNewFile();
	            System.out.println("Archivo 'personajes.txt' creado.");
	        }
	    }

	    public void añadirPersonaje(Personaje personaje) throws IOException 
	    {
	        if (buscarPersonaje(personaje.getNombre()) != null) 
	        {
	            System.out.println("El personaje '" + personaje.getNombre() + "' ya existe.");
	            return;
	        }

	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) 
	        {
	            bw.write(personaje.toString());
	            bw.newLine();
	        }

	        System.out.println("Personaje añadido: " + personaje.getNombre());
	    }

	    public void mostrarPersonajes() throws IOException 
	    {
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) 
	        {
	            String linea;
	            while ((linea = br.readLine()) != null) 
	            {
	                System.out.println(linea);
	            }
	        }
	    }

	    public void modificarPersonaje(String nombre, Personaje nuevoPersonaje) throws IOException 
	    {
	        File inputFile = new File(archivo);
	        File tempFile = new File("temp.txt");

	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) 
	        {
	            String linea;
	            boolean modificado = false;
	            while ((linea = br.readLine()) != null) 
	            {
	                Personaje personajeExistente = Personaje.fromString(linea);
	                if (personajeExistente.getNombre().equals(nombre)) 
	                {
	                    bw.write(nuevoPersonaje.toString());
	                    modificado = true;
	                } else 
	                {
	                    bw.write(linea);
	                }
	                bw.newLine();
	            }

	            if (modificado) 
	            {
	                System.out.println("Personaje '" + nombre + "' modificado.");
	            } else {
	                System.out.println("El personaje '" + nombre + "' no existe.");
	            }
	        }

	        inputFile.delete();
	        tempFile.renameTo(inputFile);
	    }

	    public void borrarPersonaje(String nombre) throws IOException 
	    {
	        File inputFile = new File(archivo);
	        File tempFile = new File("temp.txt");

	        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) 
	        {
	            String linea;
	            boolean borrado = false;
	            while ((linea = br.readLine()) != null) 
	            {
	                Personaje personaje = Personaje.fromString(linea);
	                if (personaje.getNombre().equals(nombre)) 
	                {
	                    borrado = true;
	                    continue;
	                }
	                bw.write(linea);
	                bw.newLine();
	            }

	            if (borrado) 
	            {
	                System.out.println("Personaje '" + nombre + "' borrado.");
	            } 
	            else 
	            {
	                System.out.println("El personaje '" + nombre + "' no existe.");
	            }
	        }

	        inputFile.delete();
	        tempFile.renameTo(inputFile);
	    }

	    public Personaje buscarPersonaje(String nombre) throws IOException
	    {
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) 
	        {
	            String linea;
	            while ((linea = br.readLine()) != null) 
	            {
	                Personaje personaje = Personaje.fromString(linea);
	                if (personaje.getNombre().equals(nombre)) 
	                {
	                    return personaje;
	                }
	            }
	        }
	        return null;
	    }
}
