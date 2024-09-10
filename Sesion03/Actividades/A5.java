interface CanalNotificacion 
{
    void enviarNotificacion(String mensaje);
}

class EnviadorCorreo implements CanalNotificacion 
{
    @Override
    public void enviarNotificacion(String mensaje) 
    {
        System.out.println("Enviando correo: " + mensaje);
    }
}

class EnviadorSMS implements CanalNotificacion 
{
    @Override
    public void enviarNotificacion(String mensaje) 
    {
        System.out.println("Enviando SMS: " + mensaje);
    }
}

class NotificadorSlack implements CanalNotificacion 
{
    @Override
    public void enviarNotificacion(String mensaje) 
    {
        System.out.println("Enviando notificación a Slack: " + mensaje);
    }
}

class NotificadorReserva 
{
    private CanalNotificacion canalNotificacion;

    public NotificadorReserva(CanalNotificacion canalNotificacion) 
    {
        this.canalNotificacion = canalNotificacion;
    }

    public void notificarReserva(String mensaje) 
    {
        canalNotificacion.enviarNotificacion(mensaje);
    }
}

class Controlador 
{
    public void procesarReserva() 
    {
        CanalNotificacion canal = new EnviadorCorreo(); 
        NotificadorReserva notificador = new NotificadorReserva(canal);
        notificador.notificarReserva("Reserva confirmada.");
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        Controlador controlador = new Controlador();
        controlador.procesarReserva();
    }
}
