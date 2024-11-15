package s9;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MarcoDemoTeclas extends JFrame implements KeyListener 
{
    
    private String linea1 = ""; // Primera línea del área de texto
    private String linea2 = ""; // Segunda línea del área de texto
    private String linea3 = ""; // Tercera línea del área de texto
    private JTextArea areaTexto; // Área de texto para mostrar la salida

   
    public MarcoDemoTeclas() 
    {
        super("DIAZ - PACHECO");

        areaTexto = new JTextArea(10, 15); // Crea el objeto JTextArea
        areaTexto.setText("Oprima cualquier tecla en el teclado...");
        areaTexto.setEnabled(false); // Deshabilita la edición del área de texto
        areaTexto.setDisabledTextColor(Color.BLACK); // Establece el color del texto deshabilitado
        add(areaTexto); // Agrega el área de texto al JFrame
        addKeyListener(this); // Permite al marco procesar los eventos de teclas
    }

    // Maneja el evento de oprimir cualquier tecla
    @Override
    public void keyPressed(KeyEvent evento) 
    {
        linea1 = String.format("Tecla oprimida: %s",
                KeyEvent.getKeyText(evento.getKeyCode())); // Muestra la tecla oprimida
        establecerLineas2y3(evento); // Establece las líneas de salida dos y tres
    }

    // Maneja el evento de liberar cualquier tecla
    @Override
    public void keyReleased(KeyEvent evento) 
    {
        linea1 = String.format("Tecla liberada: %s",
                KeyEvent.getKeyText(evento.getKeyCode())); // Muestra la tecla liberada
        establecerLineas2y3(evento); // Establece las líneas de salida dos y tres
    }

    // Maneja el evento de oprimir una tecla de acción (como una tecla especial)
    @Override
    public void keyTyped(KeyEvent evento) 
    {
        linea1 = String.format("Tecla oprimida: %s", evento.getKeyChar()); // Muestra el carácter de la tecla
        establecerLineas2y3(evento); // Establece las líneas de salida dos y tres
    }

    // Establece las líneas de salida dos y tres
    private void establecerLineas2y3(KeyEvent evento) 
    {
        linea2 = String.format("Esta tecla %s es una tecla de acción",
                (evento.isActionKey() ? "" : "no ")); // Indica si la tecla es una tecla de acción

        String temp = KeyEvent.getModifiersExText(evento.getModifiersEx());
        linea3 = String.format("Teclas modificadoras oprimidas: %s",
                (temp.equals("") ? "ninguna" : temp)); // Muestra las teclas modificadoras (Shift, Ctrl, etc.)

        // Imprime las tres líneas de texto en el área de texto
        areaTexto.setText(String.format("%s\n%s\n%s\n", linea1, linea2, linea3));
    }
} // Fin de la clase MarcoDemoTeclas
