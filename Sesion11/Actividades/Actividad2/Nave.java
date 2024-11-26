package s11;
import java.util.ArrayList;
import java.util.List;

class Nave implements Observable 
{
    private EstrategiaMovimiento estrategia;
    private String estado;
    private List<Observer> observadores = new ArrayList<>();

    public Nave(EstrategiaMovimiento estrategia)
    {
        this.estrategia = estrategia;
        this.estado = "Preparada para viajar";
    }

    public void mover() 
    {
        estrategia.mover();
        estado = "En movimiento";
        notificarObservadores();
    }

    public void cambiarEstrategia(EstrategiaMovimiento nuevaEstrategia) 
    {
        this.estrategia = nuevaEstrategia;
        estado = "Estrategia cambiada";
        notificarObservadores();
    }

    @Override
    public void agregarObservador(Observer o) 
    {
        observadores.add(o);
    }

    @Override
    public void notificarObservadores() {
        for (Observer observador : observadores) 
        {
            observador.update(estado);
        }
    }
}