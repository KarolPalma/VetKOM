/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Cliente;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
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
public class ClienteRepositorio implements Repositorio<Cliente> {

    @Override
    public void crear(Cliente t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC INSERTAR_CLIENTE ?,?,?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getIdCliente());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setDate(4, convertirSqlDate(t.getFechaRegistro()));
            ps.setDate(5, convertirSqlDate(t.getFechaNacimiento()));
            ps.setInt(6, t.getIdGenero());
            ps.setString(7, t.getDireccion());
            ps.setInt(8, t.getIdCiudad());
            ps.setString(9, t.getRutaFoto());
            if (t.getTelefonos() != null) {
                ps.setString(10, t.getTelefonos());
            } else {
                ps.setString(10, "");
            }
            if (t.getCorreos() != null) {
                ps.setString(11, t.getCorreos());
            } else {
                ps.setString(11, "");
            }
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Cliente t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_CLIENTE ?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getIdCliente());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setString(8, null);
            ps.setInt(9, 0);
            ps.setString(10, null);
            ps.setString(11, null);
            ps.setString(12, null);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Cliente t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_CLIENTE ?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, t.getIdCliente());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setDate(4, convertirSqlDate(t.getFechaRegistro()));
            ps.setDate(5, convertirSqlDate(t.getFechaNacimiento()));
            ps.setInt(6, t.getIdGenero());
            ps.setString(7, t.getDireccion());
            ps.setInt(8, t.getIdCiudad());
            ps.setInt(9, 1);
            ps.setString(10, t.getRutaFoto());
            ps.setString(11, t.getTelefonos());
            ps.setString(12, t.getCorreos());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Cliente buscar(Object id) throws Exception {
        Cliente valorRetorno = new Cliente();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_CLIENTE '" + id + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String idCliente = resultado.getString("Id_Cliente");
                String nombres = resultado.getString("Nombres");
                String apellidos = resultado.getString("Apellidos");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                int idGenero = resultado.getInt("Id_Genero");
                String direccion = resultado.getString("Direccion");
                int idCiudad = resultado.getInt("Id_Ciudad");
                int activo = resultado.getInt("Activo");
                String rutaFoto = resultado.getString("Ruta_Foto");

                valorRetorno.setIdCliente(idCliente);
                valorRetorno.setNombres(nombres);
                valorRetorno.setApellidos(apellidos);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setFechaRegistro(fechaRegistro);
                valorRetorno.setIdGenero(idGenero);
                valorRetorno.setDireccion(direccion);
                valorRetorno.setIdCiudad(idCiudad);
                valorRetorno.setActivo(activo);
                valorRetorno.setRutaFoto(rutaFoto);
            }

            valorRetorno.setTelefonos(getTelefonos(id));
            valorRetorno.setCorreos(getCorreos(id));
            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Cliente> buscarTodo() throws Exception {
        List<Cliente> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Clientes";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String idCliente = resultado.getString("Id_Cliente");
                String nombres = resultado.getString("Nombres");
                String apellidos = resultado.getString("Apellidos");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                int idGenero = resultado.getInt("Id_Genero");
                String direccion = resultado.getString("Direccion");
                int idCiudad = resultado.getInt("Id_Ciudad");
                int activo = resultado.getInt("Activo");
                String rutaFoto = resultado.getString("Ruta_Foto");

                Cliente valorRetorno = new Cliente();
                valorRetorno.setIdCliente(idCliente);
                valorRetorno.setNombres(nombres);
                valorRetorno.setApellidos(apellidos);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setFechaRegistro(fechaRegistro);
                valorRetorno.setIdGenero(idGenero);
                valorRetorno.setDireccion(direccion);
                valorRetorno.setIdCiudad(idCiudad);
                valorRetorno.setActivo(activo);
                valorRetorno.setRutaFoto(rutaFoto);

                valorRetorno.setTelefonos(getTelefonos(idCliente));
                valorRetorno.setCorreos(getCorreos(idCliente));

                listaRetorno.add(valorRetorno);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar todos: " + e.toString());
        }
        return listaRetorno;
    }

    private Date convertirSqlDate(java.util.Date fecha) {
        return new java.sql.Date(fecha.getTime());
    }

    public String getTelefonos(Object id) throws Exception {
        String telefono = "";
        List<String> telefonos = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Telefono FROM Clientes_Telefonos WHERE Id_Cliente = '" + id + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                telefono = resultado.getString("Telefono");
                telefonos.add(telefono);
            }
            st.close();
            cnx.close();

            for (int i = 0; i < telefonos.size(); i++) {
                if (i == 0) {
                    telefono = telefonos.get(i);
                } else {
                    telefono += "," + telefonos.get(i);
                }

            }

        } catch (SQLException e) {
            throw new Exception("Error al buscar telefonos: " + e.toString());
        }
        return telefono;
    }

    public String getCorreos(Object id) throws Exception {
        String correo = "";
        List<String> correos = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Correo FROM Clientes_Correos WHERE Id_Cliente = '" + id + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                correo = resultado.getString("Correo");
                correos.add(correo);
            }
            st.close();
            cnx.close();

            for (int i = 0; i < correos.size(); i++) {
                if (i == 0) {
                    correo = correos.get(i);
                } else {
                    correo += "," + correos.get(i);
                }

            }

        } catch (SQLException e) {
            throw new Exception("Error al buscar telefonos: " + e.toString());
        }
        return correo;
    }
}
