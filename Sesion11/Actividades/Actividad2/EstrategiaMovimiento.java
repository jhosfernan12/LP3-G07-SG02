package s11;

//EstrategiaMovimiento.java
interface EstrategiaMovimiento
{
	void mover();
}

class MovimientoConstante implements EstrategiaMovimiento 
{
	 @Override
	 public void mover() 
	 {
	     System.out.println("La nave se mueve a velocidad constante");
	 }
}

class MovimientoAcelerado implements EstrategiaMovimiento 
{
	 @Override
	 public void mover() 
	 {
	     System.out.println("La nave acelera poco a poco");
	 }
}
