/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Animal;
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
 * @author karol
 */
public class AnimalRepositorio implements Repositorio<Animal> {

    @Override
    public void crear(Animal t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "DECLARE @IDANIMAL INT "
                    + "EXEC INSERTAR_ANIMAL ?,?,?,?,?,?,?,?,?,?,?,@ID = @IDANIMAL OUTPUT";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdRaza());
            ps.setString(3, t.getIdClienteDuenio());
            ps.setDate(4, convertirSqlDate(t.getFechaNacimiento()));
            ps.setString(5, t.getTipoSangre());
            ps.setInt(6, t.getIdGenero());
            ps.setInt(7, t.getIdColor());
            ps.setInt(8, t.getEsterilizado());
            ps.setString(9, t.getRutaFoto());
            ps.setString(10, t.getObservaciones());
            ps.setInt(11, 1);
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Animal t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_ANIMAL ?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdAnimal());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setString(8, null);
            ps.setString(9, null);
            ps.setString(10, null);
            ps.setString(11, null);
            ps.setInt(12, 0);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Animal t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_ANIMAL ?,?,?,?,?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdAnimal());
            ps.setString(2, t.getNombre());
            ps.setInt(3, t.getIdRaza());
            ps.setString(4, t.getIdClienteDuenio());
            ps.setDate(5, convertirSqlDate(t.getFechaNacimiento()));
            ps.setString(6, t.getTipoSangre());
            ps.setInt(7, t.getIdGenero());
            ps.setInt(8, t.getIdColor());
            ps.setInt(9, t.getEsterilizado());
            ps.setString(10, t.getRutaFoto());
            ps.setString(11, t.getObservaciones());
            ps.setInt(12, 1);
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Animal buscar(Object id) throws Exception {
        Animal valorRetorno = new Animal();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_ANIMAL " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idAnimal = resultado.getInt("Id_Animal");
                String nombre = resultado.getString("Nombre");
                int idRaza = resultado.getInt("Id_Raza");
                String idClienteDuenio = resultado.getString("Id_Cliente_Duenio");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                String tipoSangre = resultado.getString("Tipo_Sangre");
                int idGenero = resultado.getInt("Id_Genero");
                int idColor = resultado.getInt("Id_Color");
                int esterilizado = resultado.getInt("Esterilizado");
                String rutaFoto = resultado.getString("Ruta_Foto");
                String observaciones = resultado.getString("Observaciones");
                int activo = resultado.getInt("Activo");

                valorRetorno.setIdAnimal(idAnimal);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdRaza(idRaza);
                valorRetorno.setIdClienteDuenio(idClienteDuenio);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setTipoSangre(tipoSangre);
                valorRetorno.setIdGenero(idGenero);
                valorRetorno.setIdColor(idColor);
                valorRetorno.setEsterilizado(esterilizado);
                valorRetorno.setRutaFoto(rutaFoto);
                valorRetorno.setObservaciones(observaciones);
                valorRetorno.setActivo(activo);
            }

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    @Override
    public List<Animal> buscarTodo() throws Exception {
        List<Animal> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Animales";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idAnimal = resultado.getInt("Id_Animal");
                String nombre = resultado.getString("Nombre");
                int idRaza = resultado.getInt("Id_Raza");
                String idClienteDuenio = resultado.getString("Id_Cliente_Duenio");
                Date fechaNacimiento = resultado.getDate("Fecha_Nacimiento");
                String tipoSangre = resultado.getString("Tipo_Sangre");
                int idGenero = resultado.getInt("Id_Genero");
                int idColor = resultado.getInt("Id_Color");
                int esterilizado = resultado.getInt("Esterilizado");
                String rutaFoto = resultado.getString("Ruta_Foto");
                String observaciones = resultado.getString("Observaciones");
                int activo = resultado.getInt("Activo");

                Animal valorRetorno = new Animal();
                valorRetorno.setIdAnimal(idAnimal);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdRaza(idRaza);
                valorRetorno.setIdClienteDuenio(idClienteDuenio);
                valorRetorno.setFechaNacimiento(fechaNacimiento);
                valorRetorno.setTipoSangre(tipoSangre);
                valorRetorno.setIdGenero(idGenero);
                valorRetorno.setIdColor(idColor);
                valorRetorno.setEsterilizado(esterilizado);
                valorRetorno.setRutaFoto(rutaFoto);
                valorRetorno.setObservaciones(observaciones);
                valorRetorno.setActivo(activo);

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

            String sql = "SELECT MAX(Id_Animal) + 1 AS SECUENCIA FROM Animales ";

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
