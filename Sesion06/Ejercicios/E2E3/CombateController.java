package controlador;

import modelo.Jugador;
import modelo.Enemigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombateController 
{
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public CombateController(Jugador jugador) 
    {
        this.jugador = jugador;
        this.enemigos = new ArrayList<>();
    }

    public void agregarEnemigo(Enemigo enemigo) 
    {
        enemigos.add(enemigo);
    }

    public void iniciarCombate() 
    {
        while (jugador.getSalud() > 0 && !enemigos.isEmpty()) 
        {
            for (Enemigo enemigo : new ArrayList<>(enemigos)) 
            {
                jugador.atacar(enemigo);
                if (enemigo.getSalud() <= 0) 
                {
                    enemigos.remove(enemigo);
                } 
                else 
                {
                    enemigo.atacar(jugador);
                }
            }
        }
        if (jugador.getSalud() <= 0) 
        {
            System.out.println("El jugador ha sido derrotado");
        } else {
            System.out.println("Todos los enemigos han sido derrotados");
        }
    }
}
