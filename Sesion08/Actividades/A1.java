package Principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class principal 
{
    public static void main(String[] args) 
    {
        String url = "jdbc:sqlite:ejemplo.db";
        Connection con = null;

        try 
        {
            con = DriverManager.getConnection(url);
            if (con != null) 
            {
                con.setAutoCommit(false);  // Iniciar transaccion

                String createTableSQL = "CREATE TABLE IF NOT EXISTS emp (id INTEGER PRIMARY KEY, name TEXT, age INTEGER);";
                try (PreparedStatement createTableStmt = con.prepareStatement(createTableSQL)) 
                {
                    createTableStmt.execute();
                }

             // Insertar registros
                String insertSQL = "INSERT INTO emp (id, name, age) VALUES (?, ?, ?)";
                try (PreparedStatement insertStmt = con.prepareStatement(insertSQL)) 
                {
                    insertStmt.setInt(1, 1);
                    insertStmt.setString(2, "Fernando");
                    insertStmt.setInt(3, 30);
                    insertStmt.executeUpdate();

                    insertStmt.setInt(1, 2);
                    insertStmt.setString(2, "Leonardo");
                    insertStmt.setInt(3, 25);
                    insertStmt.executeUpdate();
                }
                con.commit(); // Confirmar la transaccion
                System.out.println("Insercion exitosa");

                // Recuperar registros
                String selectSQL = "SELECT * FROM emp";
                try (PreparedStatement selectStmt = con.prepareStatement(selectSQL);
                ResultSet rs = selectStmt.executeQuery()) 
                {
                    while (rs.next()) 
                    {
                        System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getInt("age"));
                    }
                }

                // Actualizar un registro
                String updateSQL = "UPDATE emp SET age = ? WHERE id = ?";
                try (PreparedStatement updateStmt = con.prepareStatement(updateSQL)) 
                {
                    updateStmt.setInt(1, 35);
                    updateStmt.setInt(2, 1);
                    updateStmt.executeUpdate();
                }
                con.commit(); // Confirmar la transaccion
                
                System.out.println("Actualizacion exitosa");

                // Borrar un registro
                String deleteSQL = "DELETE FROM emp WHERE id = ?";
                try (PreparedStatement deleteStmt = con.prepareStatement(deleteSQL)) 
                {
                    deleteStmt.setInt(1, 2);
                    deleteStmt.executeUpdate();
                }
                con.commit(); // Confirmar la transaccion
                System.out.println("Borrado exitoso");

            }
        } catch (SQLException e) 
        {
            System.out.println("Error: " + e.getMessage());
            if (con != null) 
            {
                try 
                {
                    con.rollback(); // Revertir la transaccion en caso de error
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
}
