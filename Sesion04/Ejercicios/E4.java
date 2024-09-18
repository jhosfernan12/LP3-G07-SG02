import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes 
{
    private ArrayList<String> estudiantes;
    public RegistroEstudiantes() 
  {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(String nombre) 
  {
        if (nombre == null || nombre.trim().isEmpty())
        {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo :(");
        }
        estudiantes.add(nombre);
    }


    public String buscarEstudiante(String nombre) 
  {
        if (nombre == null || nombre.trim().isEmpty()) 
        {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo ");
        }

        for (String estudiante : estudiantes) 
        {
            if (estudiante.equalsIgnoreCase(nombre))
            {
                return estudiante;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado en el registro");
    }

    public static void main(String[] args) 
  {
        RegistroEstudiantes registro = new RegistroEstudiantes();


        try {
            registro.agregarEstudiante("Fernando");
            registro.agregarEstudiante("Leonardo");
            registro.agregarEstudiante(""); 

        } catch (IllegalArgumentException e) 
          {
            System.out.println("Error al agregar estudiante: " + e.getMessage());
        }

        try {
            String estudianteEncontrado = registro.buscarEstudiante("Leonardo");
            System.out.println("Estudiante encontrado: " + estudianteEncontrado);

            registro.buscarEstudiante("Pedro"); // Esto lanzara NoSuchElementException

        } 
        catch (IllegalArgumentException e) 
        {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        } 
        catch (NoSuchElementException e) 
        {
            System.out.println("Error al buscar estudiante: " + e.getMessage());
        }
    }
}
