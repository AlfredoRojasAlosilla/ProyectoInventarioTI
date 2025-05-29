/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoinventarioTI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    
     public static Connection getConexion() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=InventarioTI;encrypt=true;trustServerCertificate=true";
            String user = "sa"; 
            String password = "Experian2025$";  

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos: " + e.getMessage());
            return null;
        }
    }
    
}
