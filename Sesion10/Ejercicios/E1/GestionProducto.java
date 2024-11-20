package s10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionProducto 
{

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("E1|DIAZ-PACHECO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 250);  
        frame.setLayout(new BorderLayout());

        Producto producto = new Producto("Doritos", 2.50, 5, "Snack");

        JPanel panelEntrada = new JPanel();
        panelEntrada.setLayout(new GridLayout(5, 2));

        JLabel labelNombre = new JLabel("NOMBRE:");
        JTextField textNombre = new JTextField(producto.getNombre());

        JLabel labelPrecio = new JLabel("PRECIO:");
        JTextField textPrecio = new JTextField(String.valueOf(producto.getPrecio()));

        JLabel labelCantidadStock = new JLabel("STOCK:");
        JTextField textCantidadStock = new JTextField(String.valueOf(producto.getCantidadStock()));

        JLabel labelCategoria = new JLabel("CATEGORIA:");
        JTextField textCategoria = new JTextField(producto.getCategoria());

        JButton btnActualizar = new JButton("ACTUALIZAR");

        panelEntrada.add(labelNombre);
        panelEntrada.add(textNombre);
        panelEntrada.add(labelPrecio);
        panelEntrada.add(textPrecio);
        panelEntrada.add(labelCantidadStock);
        panelEntrada.add(textCantidadStock);
        panelEntrada.add(labelCategoria);
        panelEntrada.add(textCategoria);
        panelEntrada.add(btnActualizar);

        JLabel labelInfoProducto = new JLabel("<html><pre>" + producto.obtenerInformacion() + "</pre></html>", SwingConstants.LEFT);

        btnActualizar.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String nombre = textNombre.getText();
                String precioText = textPrecio.getText();
                String cantidadStockText = textCantidadStock.getText();
                String categoria = textCategoria.getText();

               
                if (nombre.isEmpty() || precioText.isEmpty() || cantidadStockText.isEmpty() || categoria.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(frame, "EXISTEN CAMPOS VACIOS", "Error", JOptionPane.ERROR_MESSAGE);
                } else
                {
                    try 
                    {

                        double precio = Double.parseDouble(precioText);
                        int cantidadStock = Integer.parseInt(cantidadStockText);
                        producto.actualizarProducto(nombre, precio, cantidadStock, categoria);
                        labelInfoProducto.setText("<html><pre>" + producto.obtenerInformacion() + "</pre></html>");
                    } catch (NumberFormatException ex) 
                    {

                        JOptionPane.showMessageDialog(frame, "INGRESE DATOS VALIDOS", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(labelInfoProducto, BorderLayout.CENTER);

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }
}
