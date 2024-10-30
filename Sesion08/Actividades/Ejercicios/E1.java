package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestiondeJuegos
{

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Connection con = null;

        try 
        {
            con = DriverManager.getConnection("jdbc:sqlite:juegos.db");
            con.setAutoCommit(false);

            String createTableSQL = "CREATE TABLE IF NOT EXISTS videojuegos (id INTEGER PRIMARY KEY, titulo TEXT, plataforma TEXT, anioSalida INTEGER);";
            try (PreparedStatement createTableStmt = con.prepareStatement(createTableSQL)) 
            {
                createTableStmt.execute();
            }

            boolean salir = false;
            while (!salir) 
            {
                System.out.println("Menu:");
                System.out.println("1) Ingresar videojuego");
                System.out.println("2) Borrar videojuego");
                System.out.println("3) Actualizar videojuego");
                System.out.println("4) Mostrar videojuegos");
                System.out.println("5) Salir");
                System.out.print("Seleccione opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) 
                {
                    case 1:
                        System.out.print("Ingrese titulo del videojuego: ");
                        String titulo = scanner.nextLine();
                        System.out.print("Ingrese plataforma: ");
                        String plataforma = scanner.nextLine();
                        System.out.print("Ingrese ano de lanzamiento: ");
                        int anio = scanner.nextInt();
                        scanner.nextLine();
                        ingresarVideojuego(con, titulo, plataforma, anio);
                        break;
                    case 2:
                        if (!hayVideojuegos(con)) {
                            System.out.println("No hay videojuegos registrados para borrar.");
                        } else {
                            System.out.print("Ingrese ID del videojuego a borrar: ");
                            int idBorrar = scanner.nextInt();
                            scanner.nextLine();
                            borrarVideojuego(con, idBorrar);
                        }
                        break;
                    case 3:
                        if (!hayVideojuegos(con)) {
                            System.out.println("No hay videojuegos registrados para actualizar.");
                        } else {
                            System.out.print("Ingrese ID del videojuego que se desee actualizar: ");
                            int idActualizar = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Ingrese nuevo titulo: ");
                            String nuevoTitulo = scanner.nextLine();
                            System.out.print("Ingrese nueva plataforma: ");
                            String nuevaPlataforma = scanner.nextLine();
                            System.out.print("Ingrese nuevo ano de lanzamiento: ");
                            int nuevoAnio = scanner.nextInt();
                            scanner.nextLine();
                            actualizarVideojuego(con, idActualizar, nuevoTitulo, nuevaPlataforma, nuevoAnio);
                        }
                        break;
                    case 4:
                        mostrarVideojuegos(con);
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opcion invalida");
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
            if (con != null) 
            {
                try 
                {
                    con.rollback();
                } 
                catch (SQLException rollbackEx) 
                {
                    System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
                }
            }
        } 
        finally 
        {
            try 
            {
                if (con != null) 
                {
                    con.close();
                }
            } 
            catch (SQLException e) 
            {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

    private static boolean hayVideojuegos(Connection con) 
    {
        String countSQL = "SELECT COUNT(*) FROM videojuegos";
        try (PreparedStatement countStmt = con.prepareStatement(countSQL);
             ResultSet rs = countStmt.executeQuery()) 
        {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error al comprobar videojuegos: " + e.getMessage());
        }
        return false;
    }

    private static void ingresarVideojuego(Connection con, String titulo, String plataforma, int anio) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave para confirmar la insercion: ");
        String clave = scanner.nextLine();

        if (clave.equals("admin123")) 
        {
            String insertSQL = "INSERT INTO videojuegos (titulo, plataforma, anioSalida) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) 
            {
                insertStmt.setString(1, titulo);
                insertStmt.setString(2, plataforma);
                insertStmt.setInt(3, anio);
                insertStmt.executeUpdate();
                con.commit();
                System.out.println("Videojuego ingresado exitosamente.");
            } 
            catch (SQLException e) 
            {
                System.out.println("Error al ingresar el videojuego: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("Clave incorrecta. No se ha realizado la insercion.");
        }
    }

    private static void borrarVideojuego(Connection con, int id) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave para confirmar la eliminacion: ");
        String clave = scanner.nextLine();

        if (clave.equals("admin123")) 
        {
            String deleteSQL = "DELETE FROM videojuegos WHERE id = ?";
            try (PreparedStatement deleteStmt = con.prepareStatement(deleteSQL)) 
            {
                deleteStmt.setInt(1, id);
                int filasAfectadas = deleteStmt.executeUpdate();
                if (filasAfectadas > 0) 
                {
                    con.commit();
                    System.out.println("Videojuego borrado exitosamente.");
                } 
                else 
                {
                    System.out.println("No se encontro el videojuego con ID: " + id);
                }
            } 
            catch (SQLException e) 
            {
                System.out.println("Error al borrar el videojuego: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("Clave incorrecta. No se ha realizado la eliminacion.");
        }
    }

    private static void actualizarVideojuego(Connection con, int id, String nuevoTitulo, String nuevaPlataforma, int nuevoAnio) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la clave para confirmar la actualizacion: ");
        String clave = scanner.nextLine();

        if (clave.equals("admin123")) 
        {
            String updateSQL = "UPDATE videojuegos SET titulo = ?, plataforma = ?, anioSalida = ? WHERE id = ?";
            try (PreparedStatement updateStmt = con.prepareStatement(updateSQL)) 
            {
                updateStmt.setString(1, nuevoTitulo);
                updateStmt.setString(2, nuevaPlataforma);
                updateStmt.setInt(3, nuevoAnio);
                updateStmt.setInt(4, id);
                int filasAfectadas = updateStmt.executeUpdate();
                if (filasAfectadas > 0) 
                {
                    con.commit();
                    System.out.println("Videojuego actualizado exitosamente.");
                } 
                else 
                {
                    System.out.println("No se encontro el videojuego con ID: " + id);
                }
            } 
            catch (SQLException e) 
            {
                System.out.println("Error al actualizar el videojuego: " + e.getMessage());
            }
        } 
        else 
        {
            System.out.println("Clave incorrecta. No se ha realizado la actualizacion.");
        }
    }

    private static void mostrarVideojuegos(Connection con) 
    {
        String selectSQL = "SELECT * FROM videojuegos";
        try (PreparedStatement selectStmt = con.prepareStatement(selectSQL);
             ResultSet rs = selectStmt.executeQuery()) 
        {
            if (!rs.isBeforeFirst()) 
            {
                System.out.println("No hay juegos agregados aun");
            } 
            else 
            {
                System.out.println("Juegos en la base de datos:");
                while (rs.next()) 
                {
                    System.out.println(rs.getInt("id") + " | " + rs.getString("titulo") + " | " + rs.getString("plataforma") + " | " + rs.getInt("anioSalida"));
                }
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Error al mostrar los videojuegos: " + e.getMessage());
        }
    }
}
