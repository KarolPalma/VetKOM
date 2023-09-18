/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miriam
 */
public class PruebaConexion {
    
    public String conexion() {
        String mensaje = "";
        try {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            String connectionUrl = "jdbc:sqlserver://DESKTOP-R7UAJG0\\SQLEXPRESS01:1433;databaseName=BD2_Veterinaria";
            Connection con = DriverManager.getConnection(connectionUrl, "sa", "Sephiroth51342");
            System.out.println("Conectado.");
            mensaje = "Conectado";
            
            String SPsql = "DECLARE @IDEMPLEADO INT "
                        + "EXEC INSERTAR_EMPLEADO ?,?,?,?,?,?,?,?,?,?,?,@ID = @IDEMPLEADO OUTPUT";
            PreparedStatement ps = con.prepareStatement(SPsql);
            ps.setEscapeProcessing(true);
            ps.setQueryTimeout(10);
            ps.setString(1, "Miriam");
            ps.setString(2, "Mondragon");
            ps.setString(3, "10-23-2000");
            ps.setString(4, "10-23-2019");
            ps.setString(5, "10-23-2020");
            ps.setInt(6, 1);
            ps.setString(7, null);
            ps.setString(8, "Col.Torocagua");
            ps.setInt(9, 1);
            ps.setString(10, null);
            ps.setString(11, "Graduada de la UTH Tegucigalpa");
            
            ps.execute();


            ps.close();
            con.close();
            mensaje = "SP logrado sin errores";
        } catch (SQLException ex) {
            System.out.println("Error.");
            mensaje = "Error: " + ex.toString();
        }
        return mensaje;
    }
    
}
