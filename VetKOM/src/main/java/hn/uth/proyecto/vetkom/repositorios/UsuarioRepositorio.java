/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Usuario;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class UsuarioRepositorio implements Repositorio<Usuario> {

    @Override
    public void crear(Usuario t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC INSERTAR_USUARIO ?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getUsuario());
            ps.setInt(2, t.getIdEmpleado());
            ps.setString(3, t.getClave());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Usuario t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_USUARIO ?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getUsuario());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setInt(4, 0);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Usuario t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_USUARIO ?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getUsuario());
            ps.setInt(2, t.getIdEmpleado());
            ps.setString(3, t.getClave());
            ps.setInt(4, 1);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Usuario buscar(Object id) throws Exception {
        Usuario valorRetorno = new Usuario();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_USUARIO '" + id + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String usuario = resultado.getString("Id_Usuario");
                int idEmpleado = resultado.getInt("Id_Empleado");
                String clave = resultado.getString("Clave");
                int activo = resultado.getInt("Activo");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                Date fechaActualizacion = Date.valueOf(LocalDate.now());
                if (resultado.getDate("Ultima_Fecha_Actualizacion") != null) {
                    fechaActualizacion = resultado.getDate("Ultima_Fecha_Actualizacion");
                }

                valorRetorno.setUsuario(usuario);
                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setClave(clave);
                valorRetorno.setActivo(activo);
                valorRetorno.setFechaRegistro(fechaRegistro);
                valorRetorno.setFechaModificacion(fechaActualizacion);

            }

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Usuario> buscarTodo() throws Exception {
        List<Usuario> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Usuarios";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String usuario = resultado.getString("Id_Usuario");
                int idEmpleado = resultado.getInt("Id_Empleado");
                String clave = resultado.getString("Clave");
                int activo = resultado.getInt("Activo");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                Date fechaActualizacion = Date.valueOf(LocalDate.now());
                if (resultado.getDate("Ultima_Fecha_Actualizacion") != null) {
                    fechaActualizacion = resultado.getDate("Ultima_Fecha_Actualizacion");
                }

                Usuario valorRetorno = new Usuario();
                valorRetorno.setUsuario(usuario);
                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setClave(clave);
                valorRetorno.setActivo(activo);
                valorRetorno.setFechaRegistro(fechaRegistro);
                valorRetorno.setFechaModificacion(fechaActualizacion);

                listaRetorno.add(valorRetorno);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }

    public Usuario iniciar(String idUsuario, String claveR) throws Exception {
        Usuario valorRetorno = new Usuario();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Usuarios WHERE Id_Usuario = '" + idUsuario + "' AND Clave = '" + claveR + "' AND Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String usuario = resultado.getString("Id_Usuario");
                int idEmpleado = resultado.getInt("Id_Empleado");
                String clave = resultado.getString("Clave");
                int activo = resultado.getInt("Activo");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                Date fechaActualizacion = Date.valueOf(LocalDate.now());
                if (resultado.getDate("Ultima_Fecha_Actualizacion") != null) {
                    fechaActualizacion = resultado.getDate("Ultima_Fecha_Actualizacion");
                }

                valorRetorno.setUsuario(usuario);
                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setClave(clave);
                valorRetorno.setActivo(activo);
                valorRetorno.setFechaRegistro(fechaRegistro);
                valorRetorno.setFechaModificacion(fechaActualizacion);

            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            valorRetorno = null;
        }
        return valorRetorno;
    }

}
