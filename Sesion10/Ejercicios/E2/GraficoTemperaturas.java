package s10;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GraficoTemperaturas extends JPanel {
    private int[] temperaturas;
    private static final String[] DIAS = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo"};


    public GraficoTemperaturas(int[] temperaturas) {
        this.temperaturas = temperaturas;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (temperaturas == null) return;


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int ancho = getWidth();
        int altura = getHeight();
        int margen = 50;
        int puntoRadio = 5;


        g2d.drawLine(margen, altura - margen, ancho - margen, altura - margen); // Eje X
        g2d.drawLine(margen, altura - margen, margen, margen); // Eje Y


        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        for (int temp : temperaturas) {
            maxTemp = Math.max(maxTemp, temp);
            minTemp = Math.min(minTemp, temp);
        }
        int rango = maxTemp - minTemp;
        if (rango == 0) rango = 1;


        int espacioEntreDias = (ancho - 2 * margen) / (temperaturas.length - 1);
        int[] puntosX = new int[temperaturas.length];
        int[] puntosY = new int[temperaturas.length];


        for (int i = 0; i < temperaturas.length; i++) {
            puntosX[i] = margen + i * espacioEntreDias;
            puntosY[i] = altura - margen - ((temperaturas[i] - minTemp) * (altura - 2 * margen) / rango);


            g2d.fillOval(puntosX[i] - puntoRadio, puntosY[i] - puntoRadio, puntoRadio * 2, puntoRadio * 2);
            g2d.drawString(DIAS[i], puntosX[i] - 15, altura - margen + 20);
        }


        g2d.setColor(Color.BLUE);
        for (int i = 0; i < temperaturas.length - 1; i++) {
            g2d.drawLine(puntosX[i], puntosY[i], puntosX[i + 1], puntosY[i + 1]);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro de temperaturas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);


        JPanel panelEntrada = new JPanel(new GridLayout(2, 7));
        JTextField[] camposTemperatura = new JTextField[7];
        for (String dia : DIAS) {
            panelEntrada.add(new JLabel(dia));
        }
        for (int i = 0; i < 7; i++) {
            camposTemperatura[i] = new JTextField();
            panelEntrada.add(camposTemperatura[i]);
        }


        JButton botonGraficar = new JButton("Mostrar Grafico");
        JPanel panelControl = new JPanel();
        panelControl.add(botonGraficar);


        GraficoTemperaturas panelGrafico = new GraficoTemperaturas(null);
        panelGrafico.setPreferredSize(new Dimension(800, 400));


        botonGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] temperaturas = new int[7];
                try {
                    for (int i = 0; i < 7; i++) {
                        temperaturas[i] = Integer.parseInt(camposTemperatura[i].getText());
                    }
                    panelGrafico.temperaturas = temperaturas;
                    panelGrafico.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese numeros validos en todos los campos.");
                }
            }
        });


        frame.setLayout(new BorderLayout());
        frame.add(panelEntrada, BorderLayout.NORTH);
        frame.add(panelControl, BorderLayout.CENTER);
        frame.add(panelGrafico, BorderLayout.SOUTH);


        frame.setVisible(true);
    }
}
