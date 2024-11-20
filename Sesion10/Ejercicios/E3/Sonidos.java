package s10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonidos 
{

    public static void main(String[] args) 
    {

        JFrame frame = new JFrame("E3 PACHECO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(100, 150);
        frame.setLayout(new FlowLayout());


        JButton btnAplausos = new JButton("Aplausos");
        JButton btnCampana = new JButton("Campana");
        JButton btnExplosion = new JButton("Explosión");


        frame.add(btnAplausos);
        frame.add(btnCampana);
        frame.add(btnExplosion);

        
        btnAplausos.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                playSound("resources/aplausos.wav");
            }
        });

        btnCampana.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                playSound("resources/campana.wav"); 
            }
        });

        btnExplosion.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                playSound("resources/explosion.wav"); 
            }
        });


        frame.setVisible(true);
    }

    private static void playSound(String fileName) 
    {
        try 
        {

            File soundFile = new File(fileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); 
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
