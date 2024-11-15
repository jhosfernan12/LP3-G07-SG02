package s9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasaje extends JFrame {

    // Declaracion de componentes
    private JTextField txtNombre, txtDocumento, txtFecha;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JRadioButton rbPrimerPiso, rbSegundoPiso;
    private JComboBox<String> cbOrigen, cbDestino;
    private JList<String> listaServicio;
    private JButton btnMostrar, btnReiniciar;

    public CompraPasaje() {
        // Configuracion de la ventana principal
        setTitle("Pasajes - Diaz, Pacheco");
        setLayout(new BorderLayout(10, 10));

        // Panel principal donde organizamos los campos en columnas
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(0, 2, 5, 5));  // 2 columnas, ajusta la cantidad de filas automaticamente

        // Inicializacion de los componentes
        initComponents(panelPrincipal);

        // Panel de botones al final
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(btnMostrar);
        panelBotones.add(btnReiniciar);

        // Anadir el panel principal y los botones a la ventana principal
        add(panelPrincipal, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Configuracion final de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 900);  // Aumentado el tamano para mejorar la disposicion
        setVisible(true);
    }

    private void initComponents(JPanel panelPrincipal) {
        // Campos de texto
        panelPrincipal.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelPrincipal.add(txtNombre);

        panelPrincipal.add(new JLabel("Documento:"));
        txtDocumento = new JTextField();
        panelPrincipal.add(txtDocumento);

        panelPrincipal.add(new JLabel("Fecha de Viaje:"));
        txtFecha = new JTextField();
        panelPrincipal.add(txtFecha);

        // Servicios opcionales
        panelPrincipal.add(new JLabel("Servicios Opcionales:"));
        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS)); // Poner los servicios en una columna
        chkAudifonos = new JCheckBox("Audifonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);;
        panelPrincipal.add(panelServicios);

        // Piso de preferencia
        panelPrincipal.add(new JLabel("Piso de Preferencia:"));
        JPanel panelPiso = new JPanel();
        panelPiso.setLayout(new FlowLayout(FlowLayout.LEFT)); // Alineacion de los botones
        rbPrimerPiso = new JRadioButton("1er Piso");
        rbSegundoPiso = new JRadioButton("2do Piso");
        ButtonGroup bgPiso = new ButtonGroup();
        bgPiso.add(rbPrimerPiso);
        bgPiso.add(rbSegundoPiso);
        panelPiso.add(rbPrimerPiso);
        panelPiso.add(rbSegundoPiso);
        panelPrincipal.add(panelPiso);

        // Origen y Destino
        panelPrincipal.add(new JLabel("Origen:"));
        cbOrigen = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C", ""});
        panelPrincipal.add(cbOrigen);

        panelPrincipal.add(new JLabel("Destino:"));
        cbDestino = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});
        panelPrincipal.add(cbDestino);

        // Tipo de Servicio
        panelPrincipal.add(new JLabel("Tipo de Servicio:"));
        listaServicio = new JList<>(new String[]{"Economico", "Standard", "VIP"});
        panelPrincipal.add(new JScrollPane(listaServicio));

        // Botones de accion
        btnMostrar = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar");

        // ActionListener para mostrar resumen
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarResumen();
            }
        });

        // ActionListener para reiniciar campos
        btnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarCampos();
            }
        });
    }

    // Metodo para mostrar el resumen de la compra
    private void mostrarResumen() {
        // Validaciones de campos
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ingreso nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ingreso documento", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se ingreso fecha de viaje", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Servicios opcionales
        String servicios = (chkAudifonos.isSelected() ? "Audifonos " : "") +
                           (chkManta.isSelected() ? "Manta " : "") +
                           (chkRevistas.isSelected() ? "Revistas" : "");


       
        if (servicios.isEmpty()) 
        {
            servicios = "Ninguno";
        }

        // Validacion de piso seleccionado
        String piso = "";
        if (rbPrimerPiso.isSelected()) {
            piso = "1er Piso";
        } else if (rbSegundoPiso.isSelected()) {
            piso = "2do Piso";
        } 
        else {
            JOptionPane.showMessageDialog(this, "No se selecciono piso de preferencia", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validacion de origen y destino
        String origen = (String) cbOrigen.getSelectedItem();
        String destino = (String) cbDestino.getSelectedItem();
        if (origen == null || destino == null) {
            JOptionPane.showMessageDialog(this, "No se seleccionaron origen y destino", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validacion de tipo de servicio
        String tipoServicio = listaServicio.getSelectedValue();
        if (tipoServicio == null) {
            JOptionPane.showMessageDialog(this, "No se selecciono tipo de servicio", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Si todo esta bien, mostramos el resumen
        String mensaje = String.format("Resumen de Compra:\nNombre: %s\nDocumento: %s\nFecha: %s\n" +
                "Servicios: %s\nPiso: %s\nOrigen: %s\nDestino: %s\nTipo de Servicio: %s",
                txtNombre.getText(), txtDocumento.getText(), txtFecha.getText(), servicios, piso, origen, destino, tipoServicio);

        JOptionPane.showMessageDialog(this, mensaje, "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
    }

    // Metodo para reiniciar los campos
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
