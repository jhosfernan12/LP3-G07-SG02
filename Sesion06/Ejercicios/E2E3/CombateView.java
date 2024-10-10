package vista;

import modelo.Jugador;
import modelo.Enemigo;

import java.util.List;

public class CombateView 
{
    public void mostrarEstadoCombate(Jugador jugador, List<Enemigo> enemigos) 
    {
        System.out.println("Estado del combate:");
        System.out.println(jugador.getNombre() + " Salud: " + jugador.getSalud());
        for (Enemigo enemigo : enemigos) {
            System.out.println(enemigo.getNombre() + " Salud: " + enemigo.getSalud());
        }
    }

    public void mostrarMensaje(String mensaje) 
    {
        System.out.println(mensaje);
    }
}
