package s11;


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
