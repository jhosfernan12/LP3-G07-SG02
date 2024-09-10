public class Habitacion
{
    public int NumeroHabitacion { get; set; }
    public bool Disponible { get; set; }
    public List<Reserva> Reservas { get; set; }
    public decimal PrecioBase { get; set; }

    public Habitacion(int numeroHabitacion, decimal precioBase)
    {
        NumeroHabitacion = numeroHabitacion;
        PrecioBase = precioBase;
        Disponible = true;
        Reservas = new List<Reserva>();
    }


    public bool EsDisponible(DateTime fechaInicio, DateTime fechaFin)
    {
        foreach (var reserva in Reservas)
        {
            if (reserva.IntersectaCon(fechaInicio, fechaFin))
            {
                return false;
            }
        }
        return true;
    }

    public void MarcarComoReservada(Reserva reserva)
    {
        Reservas.Add(reserva);
        Disponible = false;
    }


    public decimal CalcularPrecio(DateTime fechaInicio, DateTime fechaFin)
    {
        decimal precioTotal = 0;
        int dias = (fechaFin - fechaInicio).Days;
        precioTotal = PrecioBase * dias; 
        return precioTotal;
    }

    
    public void GenerarInformeOcupacion()
    {
        Console.WriteLine($"Habitacion {NumeroHabitacion} ha sido ocupada {Reservas.Count} veces.");
    }
}

public class GestorDisponibilidadHabitacion
{
    private List<Reserva> reservas;
    private decimal precioBase;

    public GestorDisponibilidadHabitacion(List<Reserva> reservas, decimal precioBase)
    {
        this.reservas = reservas;
        this.precioBase = precioBase;
    }


    public bool EsDisponible(DateTime fechaInicio, DateTime fechaFin)
    {
        foreach (var reserva in reservas)
        {
            if (reserva.IntersectaCon(fechaInicio, fechaFin))
            {
                return false;
            }
        }
        return true;
    }


    public void MarcarComoReservada(Reserva reserva)
    {
        reservas.Add(reserva);
    }


    public decimal CalcularPrecio(DateTime fechaInicio, DateTime fechaFin)
    {
        decimal precioTotal = 0;
        int dias = (fechaFin - fechaInicio).Days;
        precioTotal = precioBase * dias; 
        return precioTotal;
    }

    public void GenerarInformeOcupacion()
    {
        Console.WriteLine($"La habitacion ha sido ocupada {reservas.Count} veces.");
    }
}

public class Habitacion
{
    public int NumeroHabitacion { get; set; }
    public GestorDisponibilidadHabitacion gestorDisponibilidad { get; set; }

    public Habitacion(int numeroHabitacion, decimal precioBase)
    {
        NumeroHabitacion = numeroHabitacion;
        gestorDisponibilidad = new GestorDisponibilidadHabitacion(new List<Reserva>(), precioBase);
    }

    // Si la clase Habitacion necesita verificar la disponibilidad, delega la tarea al gestor
    public bool EsDisponible(DateTime fechaInicio, DateTime fechaFin)
    {
        return gestorDisponibilidad.EsDisponible(fechaInicio, fechaFin);
    }

    // Otras interacciones con el gestor
    public decimal CalcularPrecio(DateTime fechaInicio, DateTime fechaFin)
    {
        return gestorDisponibilidad.CalcularPrecio(fechaInicio, fechaFin);
    }

    public void MarcarComoReservada(Reserva reserva)
    {
        gestorDisponibilidad.MarcarComoReservada(reserva);
    }

    public void GenerarInformeOcupacion()
    {
        gestorDisponibilidad.GenerarInformeOcupacion();
    }
}

public class ControladorReserva
{
    public void CrearReserva(Habitacion habitacion, DateTime fechaInicio, DateTime fechaFin, Cliente cliente)
    {
        if (habitacion.EsDisponible(fechaInicio, fechaFin))
        {
            Reserva nuevaReserva = new Reserva(fechaInicio, fechaFin, cliente);
            habitacion.MarcarComoReservada(nuevaReserva);
            Console.WriteLine($"Habitacion {habitacion.NumeroHabitacion} reservada exitosamente.");
        }
        else
        {
            Console.WriteLine($"La habitacion {habitacion.NumeroHabitacion} no esta disponible.");
        }
    }

    public void ConsultarDisponibilidad(Habitacion habitacion, DateTime fechaInicio, DateTime fechaFin)
    {
        if (habitacion.EsDisponible(fechaInicio, fechaFin))
        {
            Console.WriteLine($"La habitacion {habitacion.NumeroHabitacion} esta disponible.");
        }
        else
        {
            Console.WriteLine($"La habitacion {habitacion.NumeroHabitacion} no esta disponible.");
        }
    }
}

