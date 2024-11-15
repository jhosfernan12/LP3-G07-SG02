package s9;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CompraPasaje extends JFrame {


    private JTextField txtNombre, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaServicio;
    private JButton btnMostrar, btnReiniciar;


    public CompraPasaje() {
        setTitle("Compra de Pasajes - Nombre Integrante 1, Nombre Integrante 2");
        setLayout(new GridLayout(6, 2, 5, 5));


        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);


        add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        add(txtDocumento);


        add(new JLabel("Fecha de Viaje:"));
        txtFecha = new JTextField();
        add(txtFecha);


        add(new JLabel("Servicios Opcionales:"));
        JPanel panelServicios = new JPanel();
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        add(panelServicios);


        add(new JLabel("Piso de Preferencia:"));
        rbPrimerPiso = new JRadioButton("1er Piso");
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup bgPiso = new ButtonGroup();
        bgPiso.add(rbPrimerPiso);
        bgPiso.add(rbSegundoPiso);
        JPanel panelPiso = new JPanel();
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        add(panelPiso);


        add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});
        add(cbOrigen);


        add(new JLabel("Destino:"));
        cbDestino = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});
        add(cbDestino);


        add(new JLabel("Tipo de Servicio:"));
        listaServicio = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        add(new JScrollPane(listaServicio));


        btnMostrar = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar");
        add(btnMostrar);
        add(btnReiniciar);


        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });


        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarCampos();
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }


    private void mostrarResumen() {
        String nombre = txtNombre.getText();
        String documento = txtDocumento.getText();
        String fecha = txtFecha.getText();
        String servicios = (chkAudifonos.isSelected() ? "Audífonos " : "") +
                           (chkManta.isSelected() ? "Manta " : "") +
                           (chkRevistas.isSelected() ? "Revistas" : "");
        String piso = rbPrimerPiso.isSelected() ? "1er Piso" : "2do Piso";
        String origen = (String) cbOrigen.getSelectedItem();
        String destino = (String) cbDestino.getSelectedItem();
        String tipoServicio = listaServicio.getSelectedValue();


        String mensaje = String.format("Resumen de Compra:\nNombre: %s\nDocumento: %s\nFecha: %s\n" +
                "Servicios: %s\nPiso: %s\nOrigen: %s\nDestino: %s\nTipo de Servicio: %s",
                nombre, documento, fecha, servicios, piso, origen, destino, tipoServicio);


        JOptionPane.showMessageDialog(this, mensaje, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }


    private void reiniciarCampos() {
        txtNombre.setText("");
        txtDocumento.setText("");
        txtFecha.setText("");
        chkAudifonos.setSelected(false);
        chkManta.setSelected(false);
        chkRevistas.setSelected(false);
        rbPrimerPiso.setSelected(false);
        rbSegundoPiso.setSelected(false);
        cbOrigen.setSelectedIndex(0);
        cbDestino.setSelectedIndex(0);
        listaServicio.clearSelection();
    }


    public static void main(String[] args) {
        new CompraPasaje();
    }
}
