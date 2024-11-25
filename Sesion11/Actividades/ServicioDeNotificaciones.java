package s11;

import java.util.ArrayList;
import java.util.List;


interface Observador
{
    void actualizar(String mensaje);
}


class ServicioDeNotificaciones 
{
    private List<Observador> observadores = new ArrayList<>();

    public void agregarObservador(Observador observador)
    {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) 
    {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensaje) 
    {
        for (Observador observador : observadores) 
        {
            observador.actualizar(mensaje);
        }
    }
}


class Usuario implements Observador 
{
    private String nombre;

    public Usuario(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String mensaje) 
    {
        System.out.println(nombre + " recibio la notificacion: " + mensaje);
    }
}
