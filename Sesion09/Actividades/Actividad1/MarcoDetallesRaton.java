package s9;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MarcoDetallesRaton  extends JFrame
{
	 	private String detalles; // String que se muestra en barraEstado
	    private final JLabel barraEstado; // JLabel que aparece en la parte inferior de la ventana

	    // Constructor establece String de la barra de título y registra el componente de escucha del ratón
	    public MarcoDetallesRaton() 
	    {
	        super("Clics y botones del ratón");
	        
	        barraEstado = new JLabel("Haga clic en el ratón"); // Mensaje inicial
	        add(barraEstado, BorderLayout.SOUTH); // Agrega la barra de estado en la parte inferior de la ventana

	        // Registra el manejador de eventos de ratón
	        addMouseListener(new ManejadorClicRaton()); 
	    }

	    // Clase interna para manejar los eventos del ratón
	    private class ManejadorClicRaton extends MouseAdapter 
	    {
	        // Maneja el evento de clic del ratón y determina cuál botón se oprimió
	        @Override
	        public void mouseClicked(MouseEvent evento) 
	        {
	            int xPos = evento.getX(); // Obtiene la posición x del ratón
	            int yPos = evento.getY(); // Obtiene la posición y del ratón

	            // Establece el mensaje que indica cuántas veces se hizo clic
	            detalles = String.format("Se hizo clic %d vez(veces)", evento.getClickCount());

	            // Verifica qué botón del ratón fue presionado
	            if (evento.isMetaDown()) 
	            { // Botón derecho del ratón
	                detalles += " con el botón derecho del ratón";
	            } else if (evento.isAltDown()) 
	            { // Botón central del ratón
	                detalles += " con el botón central del ratón";
	            } else { // Botón izquierdo del ratón (por defecto)
	                detalles += " con el botón izquierdo del ratón";
	            }

	            // Muestra el mensaje en la barra de estado
	            barraEstado.setText(detalles);
	        }
	    } // Fin de la clase interna ManejadorClicRaton
}
