import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.scanner;

public class Testfile
{
    public static void main (String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in)
        System.out.println("Escriba el nombre del archivo o el directorio: ");
        Path ruta = Paths.get(sc.nextLine());
        if (file.exists(ruta))
        {
            System.out.printf("%n%s existe %n", ruta.getFileName())
            System.out.printf("%s un directorio %n", Files.isDirectory(ruta.isAbsolute(ruta)? "Es" : "No es"));
            System.out.printf("Fecha de ultima modificacion: %s%n", Files.getLastModifiedTime(ruta));
            System.out.printf("%n%s Tamaño %n", Files.size(ruta));
            System.out.printf("%n%s Ruta absoluta: %n", ruta.toAbsolutePath());
            if (Files.isDirectory(ruta))
            {
                DirectoryStream<Path> flujoDirectorio = Files.newDirectoryStream(ruta);
                for (Path p : flujoDirectorio)
                {
                    System.out.println(p);
                }
            }
            else
            {
                System.out.printf("%S no existe%n", ruta)
            }
        }
    }
}
