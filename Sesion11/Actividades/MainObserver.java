package s11;

public class MainObserver
{
    public static void main(String[] args) 
    {
        ServicioDeNotificaciones servicioDeNotificaciones = new ServicioDeNotificaciones();
        

        Usuario usuario1 = new Usuario("Diaz");
        Usuario usuario2 = new Usuario("Pacheco");
        

        servicioDeNotificaciones.agregarObservador(usuario1);
        servicioDeNotificaciones.agregarObservador(usuario2);
        

        servicioDeNotificaciones.notificarObservadores("Nueva actualizacion!");
    }
}
