package s11;

public class MainCommand 
{
	 public static void main(String[] args) 
	 {
	
	     Televisor televisor = new Televisor();
	     
	
	     Comando encender = new EncenderComando(televisor);
	     Comando apagar = new ApagarComando(televisor);
	     Comando subirVolumen = new SubirVolumenComando(televisor);
	     Comando bajarVolumen = new BajarVolumenComando(televisor);
	     Comando cambiarCanal = new CambiarCanalComando(televisor);
	     
	
	     ControlRemoto controlRemoto = new ControlRemoto();
	     
	    
	     controlRemoto.establecerComandoEncender(encender);
	     controlRemoto.establecerComandoApagar(apagar);
	     controlRemoto.establecerComandoSubirVolumen(subirVolumen);
	     controlRemoto.establecerComandoBajarVolumen(bajarVolumen);
	     controlRemoto.establecerComandoCambiarCanal(cambiarCanal);
	     
	
	     controlRemoto.pulsarEncender();
	     controlRemoto.pulsarSubirVolumen();
	     controlRemoto.pulsarCambiarCanal();
	     controlRemoto.pulsarBajarVolumen();
	     controlRemoto.pulsarSubirVolumen();
	     controlRemoto.pulsarCambiarCanal();
	     controlRemoto.pulsarApagar();
	 }
}
