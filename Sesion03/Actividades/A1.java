import java.util.List;
import java.util.Map;

class Habitacion 
{
    private int numero;
    private double precio;
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Habitacion(int numero, double precio) 
    {
        this.numero = numero;
        this.precio = precio;
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public boolean verificarDisponibilidad(String fechaInicio, String fechaFin) 
    {
        return gestorDisponibilidad.verificarDisponibilidad(this, fechaInicio, fechaFin);
    }

    public void marcarComoReservada(boolean reservada) 
    {
        gestorDisponibilidad.marcarDisponibilidad(this, reservada);
    }

    public double calcularPrecio(String temporada) 
    {
        return gestorDisponibilidad.calcularPrecio(this, temporada);
    }

    public void generarInformeOcupacion() 
    {
        gestorDisponibilidad.generarInformeOcupacion(this);
    }

    public void setGestorDisponibilidad(GestorDisponibilidadHabitacion gestor) 
    {
        this.gestorDisponibilidad = gestor;
    }
}

class GestorDisponibilidadHabitacion 
{
    private List<Reserva> reservas;
    private Map<String, Double> promociones;

    public boolean verificarDisponibilidad(Habitacion habitacion, String fechaInicio, String fechaFin) 
    {
        return true; /
    }

    public void marcarDisponibilidad(Habitacion habitacion, boolean reservada) 
    {
 
    }

    public double calcularPrecio(Habitacion habitacion, String temporada) 
    {
        return habitacion.precio; // Placeholder
    }

    public void generarInformeOcupacion(Habitacion habitacion) 
    {

    }
}

class Reserva 
{
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;
    private Cliente cliente;

    public Reserva(Habitacion habitacion, String fechaInicio, String fechaFin, Cliente cliente) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
    }

}

class Cliente 
{
    private String nombre;
    private String documento;

    public Cliente(String nombre, String documento) 
    {
        this.nombre = nombre;
        this.documento = documento;
    }


}

class Controlador
{
    private GestorDisponibilidadHabitacion gestorDisponibilidad;

    public Controlador() 
    {
        this.gestorDisponibilidad = new GestorDisponibilidadHabitacion();
    }

    public void crearReserva(Habitacion habitacion, String fechaInicio, String fechaFin, Cliente cliente) {
        if (gestorDisponibilidad.verificarDisponibilidad(habitacion, fechaInicio, fechaFin)) {
            habitacion.marcarComoReservada(true);
            new Reserva(habitacion, fechaInicio, fechaFin, cliente);
        } 
        else 
        {
            System.out.println("Habitación no disponible.");
        }
    }

    public void consultarDisponibilidad(Habitacion habitacion, String fechaInicio, String fechaFin) 
    {
        boolean disponible = gestorDisponibilidad.verificarDisponibilidad(habitacion, fechaInicio, fechaFin);
        System.out.println(disponible ? "Habitación disponible." : "Habitación no disponible.");
    }
}
