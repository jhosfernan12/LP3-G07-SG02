package s11;

import java.util.ArrayList;
import java.util.List;

public class SistemaDeNotificaciones
{
    private List<Usuario> usuarios;
    private List<Notificacion> notificaciones;

    public SistemaDeNotificaciones() {
        usuarios = new ArrayList<>();
        notificaciones = new ArrayList<>();
    }


    public void suscribir(Usuario usuario) 
    {
        if (!usuarios.contains(usuario)) 
        {
            usuarios.add(usuario);
            System.out.println(usuario.getNombre() + " se susscribio al sistema");
        } else {
            System.out.println(usuario.getNombre() + " ya esta suscrito");
        }
    }


    public void desuscribir(Usuario usuario) 
    {

        for (Usuario u : usuarios)
        {
            if (u.getNombre().equals(usuario.getNombre())) 
            {
                usuarios.remove(u);
                System.out.println(usuario.getNombre() + " se ha desuscrito ");
                return;
            }
        }
        System.out.println(usuario.getNombre() + " no esta suscrito");
    }


    public void enviarNotificacion(String mensaje) 
    {
    	
        Notificacion notificacion = new Notificacion(mensaje);
        notificaciones.add(notificacion);
        for (Usuario usuario : usuarios) 
        {
            usuario.recibirNotificacion(notificacion);
        }
    }
    
    public void mostrarSuscriptores()
    {
    	if(!usuarios.isEmpty())
    	{
    		for (Usuario usuario : usuarios)
        	{
        		System.out.println("| " + usuario.getNombre() + " |");
        	}
    	}
    	
    	System.out.println( "No hay nadie suscrito aun para mostrar");
    }
}
