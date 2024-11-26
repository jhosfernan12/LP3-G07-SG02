package s11;


class ControlCentro implements Observer 
{
	 @Override
	 public void update(String estado) 
	 {
	     System.out.println("Control Centro ha sido notificado. Estado de la nave: " + estado);
	 }
}
