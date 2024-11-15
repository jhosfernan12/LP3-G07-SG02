package s9;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MarcoRastreadorRaton extends JFrame
{
	  private final JPanel panelRaton; // Panel en el que ocurrirán los eventos de ratón
	    private final JLabel barraEstado; // Muestra información de los eventos

	    // Constructor de MarcoRastreadorRaton establece la GUI y registra los manejadores de eventos de ratón
	    public MarcoRastreadorRaton() 
	    {
	        super("DIAZ - PACHECO");

	        panelRaton = new JPanel(); // Crea un nuevo panel
	        panelRaton.setBackground(Color.WHITE); // Establece el color de fondo del panel
	        add(panelRaton, BorderLayout.CENTER); // Agrega el panel al JFrame en el centro

	        barraEstado = new JLabel("Raton fuera de JPanel"); // Etiqueta para mostrar la información
	        add(barraEstado, BorderLayout.SOUTH); // Agrega la etiqueta al JFrame en la parte inferior

	        // Crea y registra un componente de escucha para los eventos de ratón y su movimiento
	        ManejadorRaton manejador = new ManejadorRaton();
	        panelRaton.addMouseListener(manejador); // Escucha los eventos de ratón
	        panelRaton.addMouseMotionListener(manejador); // Escucha los eventos de movimiento del ratón
	    }

	    // Clase interna que maneja los eventos del ratón
	    private class ManejadorRaton implements MouseListener, MouseMotionListener {
	        
	        // Los manejadores de eventos de MouseListener

	        // Maneja el evento cuando se hace clic con el ratón
	        @Override
	        public void mouseClicked(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Se hizo clic en [%d, %d]", evento.getX(), evento.getY()));
	        }

	        // Maneja el evento cuando se oprime el botón del ratón
	        @Override
	        public void mousePressed(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Se oprimió en [%d, %d]", evento.getX(), evento.getY()));
	        }

	        // Maneja el evento cuando se suelta el botón del ratón
	        @Override
	        public void mouseReleased(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Se soltó en [%d, %d]", evento.getX(), evento.getY()));
	        }

	        // Maneja el evento cuando el ratón entra al área
	        @Override
	        public void mouseEntered(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Ratón entró en [%d, %d]", evento.getX(), evento.getY()));
	            panelRaton.setBackground(Color.GREEN); // Cambia el color de fondo a verde
	        }

	        // Maneja el evento cuando el ratón sale del área
	        @Override
	        public void mouseExited(MouseEvent evento) 
	        {
	            barraEstado.setText("Ratón fuera de JPanel");
	            panelRaton.setBackground(Color.WHITE); // Restaura el color de fondo a blanco
	        }

	        // Los manejadores de eventos de MouseMotionListener

	        // Maneja el evento cuando el usuario arrastra el ratón con el botón oprimido
	        @Override
	        public void mouseDragged(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Se arrastró en [%d, %d]", evento.getX(), evento.getY()));
	        }

	        // Maneja el evento cuando el usuario mueve el ratón
	        @Override
	        public void mouseMoved(MouseEvent evento) 
	        {
	            barraEstado.setText(String.format("Se movió en [%d, %d]", evento.getX(), evento.getY()));
	        }
	    } // Fin de la clase interna ManejadorRaton
}
