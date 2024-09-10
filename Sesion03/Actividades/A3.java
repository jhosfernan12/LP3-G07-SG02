using System;

public class Habitacion
{
    public string Numero { get; set; }
    public decimal PrecioPorNoche { get; set; }

    public Habitacion(string numero, decimal precioPorNoche)
    {
        Numero = numero;
        PrecioPorNoche = precioPorNoche;
    }

    public virtual decimal CalcularPrecioTotal(int noches)
    {
        return PrecioPorNoche * noches;
    }

    public virtual void Reservar()
    {
        Console.WriteLine("Habitacion reservada.");
    }
}

public class Suite : Habitacion
{
    public decimal CostoServiciosAdicionales { get; set; }

    public Suite(string numero, decimal precioPorNoche, decimal costoServicios)
        : base(numero, precioPorNoche)
    {
        CostoServiciosAdicionales = costoServicios;
    }

    public override decimal CalcularPrecioTotal(int noches)
    {
        return base.CalcularPrecioTotal(noches) + CostoServiciosAdicionales;
    }
}

public class HabitacionEconomica : Habitacion
{
    public decimal DescuentoPorNoche { get; set; }

    public HabitacionEconomica(string numero, decimal precioPorNoche, decimal descuento)
        : base(numero, precioPorNoche)
    {
        if (descuento < 0)
        {
            throw new ArgumentException("El descuento no puede ser negativo.");
        }

        DescuentoPorNoche = descuento;
    }

    public override decimal CalcularPrecioTotal(int noches)
    {
        decimal precioTotal = base.CalcularPrecioTotal(noches) - (DescuentoPorNoche * noches);
        if (precioTotal < 0)
        {
            return 0; // Aseguramos que el precio no sea negativo.
        }
        return precioTotal;
    }
}

public class ControladorReservas
{
    public void ProcesarReserva(Habitacion habitacion, int noches)
    {
        decimal precioTotal = habitacion.CalcularPrecioTotal(noches);
        Console.WriteLine($"Reserva procesada para la habitacion {habitacion.Numero} por {noches} noches. Precio total: {precioTotal}");
        habitacion.Reservar();
    }
}

public class Programa
{
    public static void Main(string[] args)
    {
        ControladorReservas controlador = new ControladorReservas();

        Habitacion suite = new Suite("101", 200, 50);
        controlador.ProcesarReserva(suite, 3);

        Habitacion habitacionEconomica = new HabitacionEconomica("102", 100, 20);
        controlador.ProcesarReserva(habitacionEconomica, 3);
    }
}
