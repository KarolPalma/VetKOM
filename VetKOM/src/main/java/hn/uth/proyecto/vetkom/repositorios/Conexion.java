/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miriam
 */
public class Conexion {

    public static Connection getConnection() throws Exception {
        try {

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }

            String connectionUrl = "jdbc:sqlserver://DESKTOP-81AR53A\\SQLEXPRESS2017:1433;databaseName=BD2_Veterinaria";
            return DriverManager.getConnection(connectionUrl, "sa", "kp198103");

            //String connectionUrl = "jdbc:sqlserver://DESKTOP-R7UAJG0\\SQLEXPRESS01:1433;databaseName=BD2_Veterinaria";
            //return DriverManager.getConnection(connectionUrl, "sa", "Sephiroth51342");
        } catch (SQLException e) {
            throw new Exception("No se pudo establecer la conexión: " + e.toString());
        }
    }

}
