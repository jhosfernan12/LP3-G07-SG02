using System;

public interface IServicioLimpieza
{
    void SolicitarLimpieza();
}

public interface IServicioComida
{
    void SolicitarComida(string menu);
}

public interface IServicioLavanderia
{
    void SolicitarLavanderia(int cantidadPrendas);
}


public class Habitacion
{
    public string Numero { get; set; }

    public Habitacion(string numero)
    {
        Numero = numero;
    }

    public void Reservar()
    {
        Console.WriteLine($"Habitacion {Numero} reservada.");
    }
}


public class HabitacionStandard : Habitacion, IServicioLimpieza
{
    public HabitacionStandard(string numero) : base(numero) {}

    public void SolicitarLimpieza()
    {
        Console.WriteLine($"Se ha solicitado limpieza para la habitacion {Numero}.");
    }
}

public class Suite : Habitacion, IServicioLimpieza, IServicioComida, IServicioLavanderia
{
    public Suite(string numero) : base(numero) {}

    public void SolicitarLimpieza()
    {
        Console.WriteLine($"Se ha solicitado limpieza para la suite {Numero}.");
    }

    public void SolicitarComida(string menu)
    {
        Console.WriteLine($"Se ha solicitado el menu '{menu}' para la suite {Numero}.");
    }

    public void SolicitarLavanderia(int cantidadPrendas)
    {
        Console.WriteLine($"Se ha solicitado el servicio de lavanderia para {cantidadPrendas} prendas en la suite {Numero}.");
    }
}


public class ControladorServicios
{
    public void ProcesarServicios(Habitacion habitacion)
    {
        Console.WriteLine($"Procesando servicios para la habitacion {habitacion.Numero}.");

        if (habitacion is IServicioLimpieza limpieza)
        {
            limpieza.SolicitarLimpieza();
        }

        if (habitacion is IServicioComida comida)
        {
            comida.SolicitarComida("Desayuno continental");
        }

        if (habitacion is IServicioLavanderia lavanderia)
        {
            lavanderia.SolicitarLavanderia(5);
        }
    }
}

public class Programa
{
    public static void Main(string[] args)
    {
        ControladorServicios controlador = new ControladorServicios();

        Habitacion habitacionStandard = new HabitacionStandard("101");
        controlador.ProcesarServicios(habitacionStandard);

        Habitacion suite = new Suite("202");
        controlador.ProcesarServicios(suite);
    }
}
