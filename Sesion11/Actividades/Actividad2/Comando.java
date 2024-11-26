package s11;

//Comando.java
interface Comando 
{
	void ejecutar();
}

class ComandoMover implements Comando 
{
	 private Nave nave;
	
	 public ComandoMover(Nave nave) 
	 {
	     this.nave = nave;
	 }
	
	 @Override
	 public void ejecutar()
	 {
	     nave.mover();
	 }
}

class ComandoCambiarEstrategia implements Comando 
{
	 private Nave nave;
	 private EstrategiaMovimiento nuevaEstrategia;
	
	 public ComandoCambiarEstrategia(Nave nave, EstrategiaMovimiento nuevaEstrategia)
	 {
	     this.nave = nave;
	     this.nuevaEstrategia = nuevaEstrategia;
	 }
	
	 @Override
	 public void ejecutar() 
	 {
	     nave.cambiarEstrategia(nuevaEstrategia);
	 }
}

