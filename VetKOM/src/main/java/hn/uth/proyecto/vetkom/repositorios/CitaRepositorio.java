/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Cita;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class CitaRepositorio implements Repositorio<Cita> {

    @Override
    public void crear(Cita t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "DECLARE @IDCITA INT "
                    + "EXEC INSERTAR_CITA ?,?,?,?,?,?,?,@ID = @IDCITA OUTPUT";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdAnimal());
            ps.setInt(2, t.getIdServicioSolicitado());
            ps.setInt(3, t.getIdEmpleado());
            ps.setString(4, new SimpleDateFormat("yyyy-MM-dd").format(convertirSqlDate(t.getFechaCita())) + " " + t.getHoraCita());
            ps.setInt(5, t.getNoSala());
            ps.setInt(6, t.getIdEstado());
            ps.setString(7, t.getObservaciones());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Cita t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_CITA ?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdCita());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setInt(8, 2);
            ps.setString(9, null);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Cita t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_CITA ?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdCita());
            ps.setInt(2, t.getIdAnimal());
            ps.setInt(3, t.getIdServicioSolicitado());
            ps.setInt(4, t.getIdEmpleado());
            ps.setDate(5, convertirSqlDate(t.getFechaIngreso()));
            //PROBAR
            ps.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(convertirSqlDate(t.getFechaCita())) + " " + t.getHoraCita());
            ps.setInt(7, t.getNoSala());
            ps.setInt(8, t.getIdEstado());
            ps.setString(9, t.getObservaciones());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Cita buscar(Object id) throws Exception {
        Cita valorRetorno = new Cita();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_CITA " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCita = resultado.getInt("Id_Cita");
                String idCliente = resultado.getString("Id_Cliente_Duenio");
                int idAnimal = resultado.getInt("Id_Animal");
                int idServicio = resultado.getInt("Id_Servicio_Solicitado");
                int idEmpleado = resultado.getInt("Id_Empleado");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                String fechaCitaS = resultado.getString("Fecha_Cita");
                int noSala = resultado.getInt("No_Sala");
                int idEstado = resultado.getInt("Id_Estado");
                String observaciones = resultado.getString("Observaciones");

                String[] fechaHora = fechaCitaS.split(" ");

                valorRetorno.setIdCita(idCita);
                valorRetorno.setIdDuenio(idCliente);
                valorRetorno.setIdAnimal(idAnimal);
                valorRetorno.setIdServicioSolicitado(idServicio);
                valorRetorno.setIdEmpleado(idEmpleado);
                valorRetorno.setFechaIngreso(fechaRegistro);
                //REVISAR
                valorRetorno.setFechaCita(new SimpleDateFormat("yyyy-MM-dd").parse(fechaHora[0]));
                valorRetorno.setHoraCita(fechaHora[1]);
                valorRetorno.setNoSala(noSala);
                valorRetorno.setIdEstado(idEstado);
                valorRetorno.setObservaciones(observaciones);
            }

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Cita> buscarTodo() throws Exception {
        List<Cita> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Citas";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCita = resultado.getInt("Id_Cita");
                int idAnimal = resultado.getInt("Id_Animal");
                int idServicio = resultado.getInt("Id_Servicio_Solicitado");
                Date fechaRegistro = resultado.getDate("Fecha_Registro");
                String fechaCitaS = resultado.getString("Fecha_Cita");
                int noSala = resultado.getInt("No_Sala");
                int idEstado = resultado.getInt("Id_Estado");
                String observaciones = resultado.getString("Observaciones");

                String[] fechaHora = fechaCitaS.split(" ");

                Cita valorRetorno = new Cita();
                valorRetorno.setIdCita(idCita);
                valorRetorno.setIdAnimal(idAnimal);
                valorRetorno.setIdServicioSolicitado(idServicio);
                valorRetorno.setFechaIngreso(fechaRegistro);
                //REVISAR
                valorRetorno.setFechaCita(new SimpleDateFormat("yyyy-MM-dd").parse(fechaHora[0]));
                valorRetorno.setHoraCita(fechaHora[1]);
                valorRetorno.setNoSala(noSala);
                valorRetorno.setIdEstado(idEstado);
                valorRetorno.setObservaciones(observaciones);

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

            String sql = "SELECT MAX(Id_Cita) + 1 AS SECUENCIA FROM Citas";

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
