package s10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;

public class AplicacionSwing 
{


    private static JDialog dialog = null;

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("DIAZ - PACHECO ACTIVIDAD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 350);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());

        JPanel panelBinding = new JPanel();
        panelBinding.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel labelTexto = new JLabel("TEXTO A GRABAR:");
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 30));

        JLabel labelResultado = new JLabel("TEXTO GRABADO:");

        JButton btnGrabar = new JButton("GRABAR");
        JButton btnMostrarTexto = new JButton("MOSTRAR");


        final StringBuilder textoGrabado = new StringBuilder();

        btnGrabar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {

                textoGrabado.setLength(0); 
                textoGrabado.append(textField.getText()); 
                labelResultado.setText("TEXTO GRABADO: " + textoGrabado.toString()); 
            }
        });

        btnMostrarTexto.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {

                if (textoGrabado.length() == 0) 
                {
                    JOptionPane.showMessageDialog(frame, "AUN NO HAY TEXTO GRABADO =(", "Informacion", JOptionPane.WARNING_MESSAGE);
                } 
                else 
                {
                    mostrarTextoDialogo(textoGrabado.toString()); 
                }
            }
        });

        panelBinding.add(labelTexto);
        panelBinding.add(textField);
        panelBinding.add(btnGrabar);
        panelBinding.add(btnMostrarTexto);
        panelBinding.add(labelResultado);

        JPanel panelGrafico = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                g.setColor(Color.MAGENTA);
                g.fillRect(500, 50, 100, 100);
                g.setColor(Color.BLUE);
                g.drawLine(20, 50, 450, 250);
                g.drawLine(20, 50, 450, 350);
                g.drawLine(20, 50, 450, 450);
            }
        };

        JPanel panelMultimedia = new JPanel();
        JButton playButton = new JButton("HONK");
        playButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                playAudio("resources/sonido.wav"); 
            }
        });
        panelMultimedia.add(playButton);

        panelPrincipal.add(panelBinding, BorderLayout.NORTH);
        panelPrincipal.add(panelGrafico, BorderLayout.CENTER);
        panelPrincipal.add(panelMultimedia, BorderLayout.SOUTH);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

    private static void playAudio(String filePath) 
    {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    private static void mostrarTextoDialogo(String texto) 
    {

        if (dialog == null) 
        {
            dialog = new JDialog();
            dialog.setTitle("BINDING");
            dialog.setSize(200, 150);
            dialog.setLocationRelativeTo(null); 

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            JLabel label = new JLabel(texto, SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);


            JButton closeButton = new JButton("CERRAR");
            closeButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e)
                {
                    dialog.dispose();  
                    dialog = null;  
                }
            });
            panel.add(closeButton, BorderLayout.SOUTH);

            dialog.add(panel);
        }

        dialog.setVisible(true);  
    }
}
