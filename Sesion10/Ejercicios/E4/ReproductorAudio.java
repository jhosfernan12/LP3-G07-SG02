package s10;




import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;




public class ReproductorAudio {
    private static Clip clip;
    private static long clipPosition = 0;




    public static void main(String[] args) {
        JFrame frame = new JFrame("Reproductor de musica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);




        JButton playButton = new JButton("Reproducir");
        JButton pauseButton = new JButton("Pausar");
        JButton resumeButton = new JButton("Reanudar");




        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(resumeButton);




        playButton.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            clipPosition = 0;
            playAudio("Resources/musica.wav"); 
        });




        pauseButton.addActionListener(e -> {
            if (clip != null && clip.isRunning()) {
                clipPosition = clip.getMicrosecondPosition();
                clip.stop();
            }
        });




        resumeButton.addActionListener(e -> {
            if (clip != null && !clip.isRunning()) {
                clip.setMicrosecondPosition(clipPosition);
                clip.start();
            }
        });




        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }




    private static void playAudio(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            JOptionPane.showMessageDialog(null, "Error al reproducir el audio: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
