package s11;

interface Comando 
{
 void ejecutar();
}


class ControlRemoto
{
	 private Comando comandoEncender;
	 private Comando comandoApagar;
	 private Comando comandoSubirVolumen;
	 private Comando comandoBajarVolumen;
	 private Comando comandoCambiarCanal;
	

		 public void establecerComandoEncender(Comando comando) 
		 {
		     this.comandoEncender = comando;
		 }
		
		 public void establecerComandoApagar(Comando comando) 
		 {
		     this.comandoApagar = comando;
		 }
		
		 public void establecerComandoSubirVolumen(Comando comando) 
		 {
		     this.comandoSubirVolumen = comando;
		 }
		
		 public void establecerComandoBajarVolumen(Comando comando) 
		 {
		     this.comandoBajarVolumen = comando;
		 }
		
		 public void establecerComandoCambiarCanal(Comando comando) 
		 {
		     this.comandoCambiarCanal = comando;
		 }
		
		
		 public void pulsarEncender() 
		 {
		     comandoEncender.ejecutar();
		 }
		
		 public void pulsarApagar() 
		 {
		     comandoApagar.ejecutar();
		 }
		
		 public void pulsarSubirVolumen() 
		 {
		     comandoSubirVolumen.ejecutar();
		 }
		
		 public void pulsarBajarVolumen() 
		 {
		     comandoBajarVolumen.ejecutar();
		 }
		
		 public void pulsarCambiarCanal() 
		 {
		     comandoCambiarCanal.ejecutar();
		 }
	}
	
	
	class Televisor 
	{
		 public void encender() 
		 {
		     System.out.println("El televisor esta encendido");
		 }
		
		 public void apagar() {
		     System.out.println("El televisor esta apagado");
		 }
		
		 public void subirVolumen() 
		 {
		     System.out.println("Subiendo el volumn.");
		 }
		
		 public void bajarVolumen() 
		 {
		     System.out.println("Bajando el volumen");
		 }
		
		 public void cambiarCanal() 
		 {
		     System.out.println("Cambiando de canal");
		 }
	}
	
	
	class EncenderComando implements Comando 
	{
		private Televisor televisor;
	
		 public EncenderComando(Televisor televisor) 
		 {
		     this.televisor = televisor;
		 }
	
		 @Override
		 public void ejecutar() 
		 {
		     televisor.encender();
		 }
	}
	

	class ApagarComando implements Comando 
	{
		 private Televisor televisor;
		
		 public ApagarComando(Televisor televisor) 
		 {
		     this.televisor = televisor;
		 }
		
		 @Override
		 public void ejecutar()
		 {
		     televisor.apagar();
	 }
}


class SubirVolumenComando implements Comando
{
	 private Televisor televisor;
	
	 public SubirVolumenComando(Televisor televisor)
	 {
	     this.televisor = televisor;
	 }
	
	 @Override
	 public void ejecutar() 
	 {
	     televisor.subirVolumen();
	 }
}


class BajarVolumenComando implements Comando 
{
	 private Televisor televisor;
	
	 public BajarVolumenComando(Televisor televisor)
	 {
	     this.televisor = televisor;
	 }
	
	 @Override
	 public void ejecutar() {
	     televisor.bajarVolumen();
	 }
}


class CambiarCanalComando implements Comando 
{
	 private Televisor televisor;
	
	 public CambiarCanalComando(Televisor televisor)
	 {
	     this.televisor = televisor;
	     
	 }
	
	 @Override
	 public void ejecutar() {
	     televisor.cambiarCanal();
	 }
}

