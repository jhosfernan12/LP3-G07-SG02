import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


interface PoliticaCancelacion 
{
    boolean puedeCancelar(Reserva reserva, LocalDateTime fechaCancelacion);
}

class PoliticaCancelacionFlexible implements PoliticaCancelacion 
{
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDateTime fechaCancelacion) 
    {
        LocalDateTime checkIn = reserva.getCheckIn();
        return ChronoUnit.HOURS.between(fechaCancelacion, checkIn) >= 24;
    }
}

class PoliticaCancelacionModerada implements PoliticaCancelacion 
{
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDateTime fechaCancelacion) 
    {
        LocalDateTime checkIn = reserva.getCheckIn();
        return ChronoUnit.HOURS.between(fechaCancelacion, checkIn) >= 72;
    }
}

class PoliticaCancelacionEstricta implements PoliticaCancelacion 
{
    @Override
    public boolean puedeCancelar(Reserva reserva, LocalDateTime fechaCancelacion) 
    {
        return false;
    }
}


class Reserva 
{
    private Habitacion habitacion;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Cliente cliente;
    private PoliticaCancelacion politicaCancelacion;

    public Reserva(Habitacion habitacion, LocalDateTime checkIn, LocalDateTime checkOut, Cliente cliente, PoliticaCancelacion politicaCancelacion) {
        this.habitacion = habitacion;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cliente = cliente;
        this.politicaCancelacion = politicaCancelacion;
    }

    public LocalDateTime getCheckIn() 
    {
        return checkIn;
    }

    public boolean cancelar(LocalDateTime fechaCancelacion) 
    {
        if (politicaCancelacion.puedeCancelar(this, fechaCancelacion)) 
        {

            return true;
        } 
        else 
        {

            return false;
        }
    }
}


class Controlador 
{
    public Reserva crearReserva(Habitacion habitacion, LocalDateTime checkIn, LocalDateTime checkOut, Cliente cliente, PoliticaCancelacion politicaCancelacion) 
    {
        return new Reserva(habitacion, checkIn, checkOut, cliente, politicaCancelacion);
    }

    public boolean cancelarReserva(Reserva reserva, LocalDateTime fechaCancelacion) 
    {
        return reserva.cancelar(fechaCancelacion);
    }
}

class Habitacion 
{
    private int numero;
    private double precio;

    public Habitacion(int numero, double precio) 
    {
        this.numero = numero;
        this.precio = precio;
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
