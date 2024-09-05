package Sesion2;
import java.util.ArrayList;

public class E1 
{

    public abstract class Persona 
    {
        protected String nombre;

        public Persona(String nombre) 
        {
            this.nombre = nombre;
        }

        public abstract String getDetalles();
    }

    public class Estudiante extends Persona 
    {
        private int id;

        public Estudiante(String nombre, int id) 
        {
            super(nombre);
            this.id = id;
        }

        @Override
        public String getDetalles() 
        {
            return "Estudiante: " + nombre + " - ID: " + id;
        }

        public int getId() 
        {
            return id;
        }

        public String getNombre() 
        {
            return nombre;
        }
    }

    public class Profesor extends Persona 
    {
        private String departamento;

        public Profesor(String nombre, String departamento) 
        {
            super(nombre);
            this.departamento = departamento;
        }

        @Override
        public String getDetalles() 
        {
            return "Profesor: " + nombre + " - Departamento: " + departamento;
        }

        public String getDepartamento() 
        {
            return departamento;
        }

        public String getNombre() 
        {
            return nombre;
        }
    }

    public class Curso 
    {
        private String nombre;
        private Profesor profesor;
        private int capacidadMaxima;
        private int estudiantesMatriculados;

        public Curso(String nombre, Profesor profesor, int capacidadMaxima) 
        {
        	
            this.nombre = nombre;
            this.profesor = profesor;
            this.capacidadMaxima = capacidadMaxima;
            this.estudiantesMatriculados = 0;
        }

        public String getNombre() 
        {
            return nombre;
        }

        public Profesor getProfesor() 
        {
            return profesor;
        }

        public boolean inscribirEstudiante(Estudiante estudiante) 
        {
            if (estudiantesMatriculados < capacidadMaxima) 
            {
                estudiantesMatriculados++;
                System.out.println("Estudiante " + estudiante.getNombre() + " inscrito en el curso " + nombre);
                return true;
            } else {
                System.out.println("El curso " + nombre + " esta lleno.");
                return false;
            }
        }

        public int getEstudiantesMatriculados() 
        {
            return estudiantesMatriculados;
        }
    }

    public class SistemaGestion 
    {
        private ArrayList<Curso> cursos = new ArrayList<>();

        public void agregarCurso(Curso curso) 
        {
            cursos.add(curso);
        }

        public void mostrarCursosDisponibles() 
        {
            for (Curso curso : cursos) 
            {
                System.out.println("Curso: " + curso.getNombre() + " - Profesor: " + curso.getProfesor().getNombre());
            }
        }
    }

    public static void main(String[] args) 
    {
        E1 e1 = new E1();

       
        Profesor profesor1 = e1.new Profesor("Dr. Zuñiga", "Matematicas");
        Profesor profesor2 = e1.new Profesor("Dr. Calderon", "Programacion");

        
        Curso curso1 = e1.new Curso("Calculo Integral", profesor1, 30);
        Curso curso2 = e1.new Curso("Programacion Java", profesor2, 25);

       
        Estudiante estudiante1 = e1.new Estudiante("Fernando Pacheco", 101);
        Estudiante estudiante2 = e1.new Estudiante("Leonardo Diaz", 102);

        
        SistemaGestion sistema = e1.new SistemaGestion();

       
        sistema.agregarCurso(curso1);
        sistema.agregarCurso(curso2);

      
        curso1.inscribirEstudiante(estudiante1);
        curso1.inscribirEstudiante(estudiante2);

       
        sistema.mostrarCursosDisponibles();
    }
}
