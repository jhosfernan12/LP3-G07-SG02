import java.util.ArrayList;
import java.util.List;


class Par<F, S> {
    private F primero;
    private S segundo;


    public Par(F primero, S segundo) 
    {
        this.primero = primero;
        this.segundo = segundo;
    }


    @Override
    public String toString() 
    {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
}


class Contenedor<F, S> 
{
    private List<Par<F, S>> pares;


    public Contenedor() {
        this.pares = new ArrayList<>();
    }


    public void agregarPar(F primero, S segundo) 
    {
        Par<F, S> par = new Par<>(primero, segundo);
        pares.add(par);
    }


    public Par<F, S> obtenerPar(int indice) 
    {
        if (indice < 0 || indice >= pares.size()) 
        {
            throw new IndexOutOfBoundsException("Índice fuera de los límites");
        }
        return pares.get(indice);
    }


    public List<Par<F, S>> obtenerTodosLosPares() 
    {
        return new ArrayList<>(pares); 
    }


    public void mostrarPares() 
    {
        for (Par<F, S> par : pares) 
        {
            System.out.println(par);
        }
    }
}


public class Main 
{
    public static void main(String[] args) 
    {
        Contenedor<String, Integer> contenedor = new Contenedor<>();
        
        contenedor.agregarPar("Texto1", 1);
        contenedor.agregarPar("Texto2", 2);
        contenedor.agregarPar("Texto3", 3);
        
        System.out.println("Todos los pares:");
        contenedor.mostrarPares();
        
        Par<String, Integer> par = contenedor.obtenerPar(1);
        System.out.println("Par en índice 1: " + par);
        
 List<Par<String, Integer>> todosLosPares = contenedor.obtenerTodosLosPares();
        System.out.println("Lista completa de pares: " + todosLosPares);
    }
}
