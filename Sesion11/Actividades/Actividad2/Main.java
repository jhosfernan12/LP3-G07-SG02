package s11;

//Main.java
public class Main 
{
	 public static void main(String[] args) 
	 {
	
	     EstrategiaMovimiento constante = new MovimientoConstante();
	     EstrategiaMovimiento acelerada = new MovimientoAcelerado();
	
	
	     Nave nave = new Nave(constante);
	
	
	     ControlCentro controlCentro = new ControlCentro();
	     nave.agregarObservador(controlCentro);
	
	
	     Comando comandoMover = new ComandoMover(nave);
	     Comando comandoCambiarEstrategia = new ComandoCambiarEstrategia(nave, acelerada);
	
	
	     System.out.println("Iniciando mision:");
	     comandoMover.ejecutar(); 
	     comandoCambiarEstrategia.ejecutar(); 
	     comandoMover.ejecutar(); 

	 }
}
