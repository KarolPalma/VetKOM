/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Servicio;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class ServicioRepositorio implements Repositorio<Servicio> {

    @Override
    public void crear(Servicio t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC INSERTAR_SERVICIO ?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getNombre());
            ps.setInt(2, 3);
            ps.setDouble(3, t.getPrecio());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Servicio t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_SERVICIO ?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdServicio());
            ps.setString(2, null);
            ps.setInt(3, 2);
            ps.setString(4, null);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Servicio t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_SERVICIO ?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdServicio());
            ps.setString(2, t.getNombre());
            if (t.getIdEstado() != 3 && t.getIdEstado() != 0) {
                ps.setInt(3, t.getIdEstado());
            } else {
                ps.setInt(3, 3);
            }

            ps.setDouble(4, t.getPrecio());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Servicio buscar(Object id) throws Exception {
        Servicio valorRetorno = new Servicio();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_SERVICIO " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idServicio = resultado.getInt("Id_Servicio");
                String nombre = resultado.getString("Nombre_Servicio");
                int idEstado = resultado.getInt("Id_Estado");
                Double precio = resultado.getDouble("Precio");

                valorRetorno.setIdServicio(idServicio);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdEstado(idEstado);
                valorRetorno.setPrecio(precio);
            }

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Servicio> buscarTodo() throws Exception {
        List<Servicio> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Servicios";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idServicio = resultado.getInt("Id_Servicio");
                String nombre = resultado.getString("Nombre_Servicio");
                int idEstado = resultado.getInt("Id_Estado");
                Double precio = resultado.getDouble("Precio");

                Servicio valorRetorno = new Servicio();
                valorRetorno.setIdServicio(idServicio);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdEstado(idEstado);
                valorRetorno.setPrecio(precio);

                listaRetorno.add(valorRetorno);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }

    public int getIdentity() throws Exception {
        int valorRetorno = 0;
        try {
            Connection cnx = getConnection();

            String sql = "SELECT MAX(Id_Concepto) + 1 AS SECUENCIA FROM Conceptos_Facturacion";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int secuencia = resultado.getInt("SECUENCIA");
                valorRetorno = secuencia;
            }

            st.close();
            cnx.close();
            if (valorRetorno == 0) {
                valorRetorno = 1;
            }
        } catch (Exception e) {
            throw new Exception("Error al calcular secuencia: " + e.toString());
        }
        return valorRetorno;
    }

}
