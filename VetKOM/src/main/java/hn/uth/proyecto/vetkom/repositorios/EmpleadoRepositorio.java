/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Empleado;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Miriam
 */
public class EmpleadoRepositorio implements Repositorio<Empleado> {

    @Override
    public void crear(Empleado t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "DECLARE @IDEMPLEADO INT "
                    + "EXEC INSERTAR_EMPLEADO ?,?,?,?,?,?,?,?,?,?,?,?,@ID = @IDEMPLEADO OUTPUT";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setDate(3, convertirSqlDate(t.getFechaNacimiento()));
            ps.setDate(4, convertirSqlDate(t.getFechaContratacion()));
            ps.setDate(5, convertirSqlDate(t.getFechaFinalizacionContrato()));
            ps.setInt(6, t.getIdCargo());
            if (t.getReportaA() != 0) {
                ps.setInt(7, t.getReportaA());
            } else {
                ps.setString(7, null);
            }
            ps.setString(8, t.getDireccion());
            ps.setInt(9, t.getIdCiudad());
            ps.setString(10, t.getRutaFoto());
            ps.setString(11, t.getNotas());
            if (t.getTelefonos() != null) {
                ps.setString(12, t.getTelefonos());
            } else {
                ps.setString(12, "");
            }
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Empleado t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_EMPLEADO ?,?,?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdEmpleado());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setString(8, null);
            ps.setString(9, null);
            ps.setString(10, null);
            ps.setInt(11, 0);
            ps.setString(12, null);
            ps.setString(13, null);
            ps.setString(14, null);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Empleado t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_EMPLEADO ?,?,?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdEmpleado());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setDate(4, convertirSqlDate(t.getFechaNacimiento()));
            ps.setDate(5, convertirSqlDate(t.getFechaContratacion()));
            ps.setDate(6, convertirSqlDate(t.getFechaFinalizacionContrato()));
            ps.setInt(7, t.getIdCargo());
            if (t.getReportaA() != 0) {
                ps.setInt(8, t.getReportaA());
            } else {
                ps.setString(8, null);
            }
            ps.setString(9, t.getDireccion());
            ps.setInt(10, t.getIdCiudad());
            ps.setInt(11, 1);
            ps.setString(12, t.getRutaFoto());
            ps.setString(13, t.getNotas());
            ps.setString(14, t.getTelefonos());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Empleado buscar(Object id) throws Exception {
        Empleado valorRetorno = new Empleado();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_EMPLEADO " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEmpleado = resultado.getInt("Id_Empleado");
                String nombres = resultado.getString("Nombres");
                String apellidos = resultado.getString("Apellidos");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                Date fechaContratacion = resultado.getDate("Fecha_Contratacion");
                Date fechaFinalizacionContrato = resultado.getDate("Fecha_Finalizacion_Contrato");
                int idCargo = resultado.getInt("Id_Cargo");
                String reportaA = String.valueOf(resultado.getInt("Reporta_A"));
                String direccion = resultado.getString("Direccion");
                int idCiudad = resultado.getInt("Id_Ciudad");
                int activo = resultado.getInt("Activo");
                String rutaFoto = resultado.getString("Ruta_Foto");
                String notas = resultado.getString("Notas");

                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setNombres(nombres);
                valorRetorno.setApellidos(apellidos);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setFechaContratacion(fechaContratacion);
                valorRetorno.setFechaFinalizacionContrato(fechaFinalizacionContrato);
                valorRetorno.setIdCargo(idCargo);
                if (reportaA != null) {
                    valorRetorno.setReportaA(Integer.valueOf(reportaA));
                } else {
                    valorRetorno.setReportaA(0);
                }
                valorRetorno.setDireccion(direccion);
                valorRetorno.setIdCiudad(idCiudad);
                valorRetorno.setActivo(activo);
                valorRetorno.setRutaFoto(rutaFoto);
                valorRetorno.setNotas(notas);
            }

            valorRetorno.setTelefonos(getTelefonos(id));

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar todos: " + e.toString());
            
        }
        return valorRetorno;
    }

    @Override
    public List<Empleado> buscarTodo() throws Exception {
        List<Empleado> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Empleados";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEmpleado = resultado.getInt("Id_Empleado");
                String nombres = resultado.getString("Nombres");
                String apellidos = resultado.getString("Apellidos");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                Date fechaContratacion = resultado.getDate("Fecha_Contratacion");
                Date fechaFinalizacionContrato = resultado.getDate("Fecha_Finalizacion_Contrato");
                int idCargo = resultado.getInt("Id_Cargo");
                String reportaA = String.valueOf(resultado.getInt("Reporta_A"));
                String direccion = resultado.getString("Direccion");
                int idCiudad = resultado.getInt("Id_Ciudad");
                int activo = resultado.getInt("Activo");
                String rutaFoto = resultado.getString("Ruta_Foto");
                String notas = resultado.getString("Notas");

                Empleado valorRetorno = new Empleado();
                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setNombres(nombres);
                valorRetorno.setApellidos(apellidos);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setFechaContratacion(fechaContratacion);
                valorRetorno.setFechaFinalizacionContrato(fechaFinalizacionContrato);
                valorRetorno.setIdCargo(idCargo);
                if (reportaA != null) {
                    valorRetorno.setReportaA(Integer.valueOf(reportaA));
                } else {
                    valorRetorno.setReportaA(0);
                }
                valorRetorno.setDireccion(direccion);
                valorRetorno.setIdCiudad(idCiudad);
                valorRetorno.setActivo(activo);
                valorRetorno.setRutaFoto(rutaFoto);
                valorRetorno.setNotas(notas);
                valorRetorno.setTelefonos(getTelefonos(idEmpleado));

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

    public int getIdentity() throws Exception {
        int valorRetorno = 0;
        try {
            Connection cnx = getConnection();

            String sql = "SELECT MAX(Id_Empleado) + 1 AS SECUENCIA FROM Empleados ";

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

    public String getTelefonos(Object id) throws Exception {
        String telefono = "";
        List<String> telefonos = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Telefono FROM Telefonos_Empleados WHERE Id_Empleado = " + id;

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
}
