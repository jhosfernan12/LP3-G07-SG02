package s11;

import java.util.ArrayList;
import java.util.List;

public class Usuario 
{
    private String nombre;
    private List<Notificacion> notificaciones;

    public Usuario(String nombre) 
    {
        this.nombre = nombre;
        this.notificaciones = new ArrayList<>();
    }

    public String getNombre() 
    {
        return nombre;
    }


    public void recibirNotificacion(Notificacion notificacion) 
    {
        notificaciones.add(notificacion);
        System.out.println(nombre + " ha recibido la notificacion: " + notificacion.getMensaje());
    }
}
