package s9;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;


public class MarcoPanel extends JFrame
{
	private final JPanel panelBotones; // panel que contiene los botones
	private final JButton[] botones;
	 // constructor sin argumentos
	 public MarcoPanel()
	 {
		 super("DIAZ - PACHECO");
		 botones = new JButton[5];
		 panelBotones = new JPanel();
		 panelBotones.setLayout(new GridLayout(1, botones.length));

		 for (int cuenta = 0; cuenta < botones.length; cuenta++)
		 {
			 botones[cuenta] = new JButton("Boton " + (cuenta + 1));
			 panelBotones.add(botones[cuenta]); 
		 }
		 add(panelBotones, BorderLayout.SOUTH);
	 }
	 
}
