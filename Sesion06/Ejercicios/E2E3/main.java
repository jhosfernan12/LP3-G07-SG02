import modelo.Item;
import modelo.Jugador;
import modelo.Enemigo;
import controlador.CombateController;

public class main 
{
    public static void main(String[] args) 
    {
        Jugador jugador = new Jugador("Steve", 100, 1);


        Item espada = new Item("Espada de Diamante", 10, true, "Una espada afilada");
        Item pocion = new Item("Pocion de Curacion", 5, false, "Restaura salud.");


        jugador.equiparObjeto(espada);


        Enemigo enemigo1 = new Enemigo("Crepper", 30, 1, "Crepper");
        Enemigo enemigo2 = new Enemigo("Enderman", 50, 2, "Enderman");


        CombateController combateController = new CombateController(jugador);
        combateController.agregarEnemigo(enemigo1);
        combateController.agregarEnemigo(enemigo2);


        combateController.iniciarCombate();
    }
}
