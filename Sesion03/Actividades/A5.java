using System;


public interface ICanalNotificacion
{
    void EnviarNotificacion(string mensaje);
}


public class EnviadorCorreo : ICanalNotificacion
{
    public void EnviarNotificacion(string mensaje)
    {
        Console.WriteLine("Enviando correo: " + mensaje);
    }
}


public class EnviadorSMS : ICanalNotificacion
{
    public void EnviarNotificacion(string mensaje)
    {
        Console.WriteLine("Enviando SMS: " + mensaje);
    }
}


public class NotificadorSlack : ICanalNotificacion
{
    public void EnviarNotificacion(string mensaje)
    {
        Console.WriteLine("Enviando mensaje a Slack: " + mensaje);
    }
}


public class NotificadorReserva
{
    private readonly ICanalNotificacion _canalNotificacion;

    public NotificadorReserva(ICanalNotificacion canalNotificacion)
    {
        _canalNotificacion = canalNotificacion;
    }

    public void Notificar(string mensaje)
    {
        _canalNotificacion.EnviarNotificacion(mensaje);
    }
}

public class ControladorReservas
{
    private readonly NotificadorReserva _notificadorReserva;

    public ControladorReservas(NotificadorReserva notificadorReserva)
    {
        _notificadorReserva = notificadorReserva;
    }

    public void CrearReserva(string mensajeReserva)
    {
        Console.WriteLine("Reserva creada.");
        _notificadorReserva.Notificar(mensajeReserva);
    }
}


public class Programa
{
    public static void Main(string[] args)
    {
       
        ICanalNotificacion canalCorreo = new EnviadorCorreo();
        NotificadorReserva notificadorCorreo = new NotificadorReserva(canalCorreo);
        ControladorReservas controladorCorreo = new ControladorReservas(notificadorCorreo);
        controladorCorreo.CrearReserva("Reserva confirmada para el 12 de septiembre.");

       
        ICanalNotificacion canalSMS = new EnviadorSMS();
        NotificadorReserva notificadorSMS = new NotificadorReserva(canalSMS);
        ControladorReservas controladorSMS = new ControladorReservas(notificadorSMS);
        controladorSMS.CrearReserva("Reserva confirmada para el 15 de septiembre.");

      
        ICanalNotificacion canalSlack = new NotificadorSlack();
        NotificadorReserva notificadorSlack = new NotificadorReserva(canalSlack);
        ControladorReservas controladorSlack = new ControladorReservas(notificadorSlack);
        controladorSlack.CrearReserva("Reserva confirmada para el 20 de septiembre.");
    }
}
