using System;

public interface PoliticaCancelacion
{
    bool PuedeCancelar(Reserva reserva);
    decimal ObtenerPenalizacion(Reserva reserva);
}

public class PoliticaCancelacionFlexible : PoliticaCancelacion
{
    public bool PuedeCancelar(Reserva reserva)
    {
        return DateTime.Now < reserva.FechaCheckIn.AddHours(-24);
    }

    public decimal ObtenerPenalizacion(Reserva reserva)
    {
        return 0;
    }
}

public class PoliticaCancelacionModerada : PoliticaCancelacion
{
    public bool PuedeCancelar(Reserva reserva)
    {
        return DateTime.Now < reserva.FechaCheckIn.AddHours(-72);
    }

    public decimal ObtenerPenalizacion(Reserva reserva)
    {
        if (PuedeCancelar(reserva))
        {
            return 0;
        }
        return reserva.CalcularMonto() * 0.5m;
    }
}

public class PoliticaCancelacionEstricta : PoliticaCancelacion
{
    public bool PuedeCancelar(Reserva reserva)
    {
        return false;
    }

    public decimal ObtenerPenalizacion(Reserva reserva)
    {
        return reserva.CalcularMonto();
    }
}

public class Reserva
{
    public DateTime FechaCheckIn { get; set; }
    public DateTime FechaCheckOut { get; set; }
    public bool Cancelada { get; private set; }
    public PoliticaCancelacion Politica { get; set; }
    public decimal Monto { get; set; }

    public Reserva(DateTime checkIn, DateTime checkOut, PoliticaCancelacion politica, decimal monto)
    {
        FechaCheckIn = checkIn;
        FechaCheckOut = checkOut;
        Cancelada = false;
        Politica = politica;
        Monto = monto;
    }

    public void Cancelar()
    {
        if (Politica.PuedeCancelar(this))
        {
            Cancelada = true;
            Console.WriteLine("Reserva cancelada.");
        }
        else
        {
            Console.WriteLine($"No se puede cancelar. Penalizacion aplicada: {Politica.ObtenerPenalizacion(this)}");
        }
    }

    public decimal CalcularMonto()
    {
        return Monto;
    }
}

public class ControladorReserva
{
    public void CrearReserva(DateTime checkIn, DateTime checkOut, decimal monto, string tipoPolitica)
    {
        PoliticaCancelacion politica = SeleccionarPolitica(tipoPolitica);
        Reserva nuevaReserva = new Reserva(checkIn, checkOut, politica, monto);
        Console.WriteLine("Reserva creada con exito.");
    }

    private PoliticaCancelacion SeleccionarPolitica(string tipoPolitica)
    {
        switch (tipoPolitica.ToLower())
        {
            case "flexible":
                return new PoliticaCancelacionFlexible();
            case "moderada":
                return new PoliticaCancelacionModerada();
            case "estricta":
                return new PoliticaCancelacionEstricta();
            default:
                throw new Exception("Politica de cancelacion no valida.");
        }
    }

    public void CancelarReserva(Reserva reserva)
    {
        reserva.Cancelar();
    }
}

public class Programa
{
    public static void Main(string[] args)
    {
        ControladorReserva controlador = new ControladorReserva();
        controlador.CrearReserva(DateTime.Now.AddDays(5), DateTime.Now.AddDays(7), 500, "moderada");

        Reserva reserva = new Reserva(DateTime.Now.AddDays(5), DateTime.Now.AddDays(7), new PoliticaCancelacionModerada(), 500);
        controlador.CancelarReserva(reserva);
    }
}
