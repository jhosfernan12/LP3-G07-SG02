public class DemoJFileChooser extends JFrame 
{
    private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException 
    {
        super("Demo de JFileChooser");
        areaSalida = new JTextArea();
        add(new JScrollPane(areaSalida));
        analizarRuta();
    }

    public void analizarRuta() throws IOException 
    {
        Path ruta = obtenerRutaArchivoDirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();
            builder.append(String.format("Es %s%n", ruta.getFileName()));
            builder.append(String.format("Es una dirección? %s%n", Files.isDirectory(ruta) ? "Sí" : "No es"));
            builder.append(String.format("Es una ruta absoluta? %s%n", ruta.isAbsolute() ? "Sí" : "No es"));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Tamaño: %s%n", Files.size(ruta)));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));

            if (Files.isDirectory(ruta)) 
            {
                builder.append(String.format("%nContenido del directorio:%n"));
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);

                for (Path p : flujoDirectorio) 
                {
                    builder.append(String.format("%s%n", p));
                }
            }
            areaSalida.setText(builder.toString());
        } 
        else 
        {
            JOptionPane.showMessageDialog(this, ruta.getFileName() + " no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoDirectorio() 
    {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int resultado = selectorArchivos.showOpenDialog(this);

        if (resultado == JFileChooser.CANCEL_OPTION) 
        {
            System.exit(0);
        }
        return selectorArchivos.getSelectedFile().toPath();
    }
}

public class PruebaFileChooser 
{
    public static void main(String[] args) throws IOException 
    {
        DemoJFileChooser aplicacion = new DemoJFileChooser();
        aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.setVisible(true);
    }
}
