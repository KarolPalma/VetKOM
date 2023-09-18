/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.Producto;
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
public class ProductoRepositorio implements Repositorio<Producto> {

    @Override
    public void crear(Producto t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC INSERTAR_PRODUCTO ?,?,?,?,?,?,?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setString(1, t.getNombre());
            ps.setInt(2, t.getIdProveedor());
            ps.setInt(3, t.getIdCategoria());
            ps.setString(4, t.getCantidadUnidad());
            ps.setInt(5, t.getCantidadAlmacen());
            ps.setInt(6, t.getCantidadMinima());
            ps.setInt(7, t.getCantidadMaxima());
            ps.setInt(8, 1);
            ps.setDouble(9, t.getPrecio());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar: " + e.toString());
        }
    }

    @Override
    public void desactivar(Producto t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_PRODUCTO ?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdProducto());
            ps.setString(2, null);
            ps.setString(3, null);
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, null);
            ps.setString(7, null);
            ps.setString(8, null);
            ps.setInt(9, 2);
            ps.setString(10, null);

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al desactivar: " + e.toString());
        }
    }

    @Override
    public void actualizar(Producto t) throws Exception {

        try {
            Connection cnx = getConnection();

            String sql = "EXEC ACTUALIZAR_PRODUCTO ?,?,?,?,?,?,?,?,?,?";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, t.getIdProducto());
            ps.setString(2, t.getNombre());
            ps.setInt(3, t.getIdProveedor());
            ps.setInt(4, t.getIdCategoria());
            ps.setString(5, t.getCantidadUnidad());
            ps.setInt(6, t.getCantidadAlmacen());
            ps.setInt(7, t.getCantidadMinima());
            ps.setInt(8, t.getCantidadMaxima());
            ps.setInt(9, 1);
            ps.setDouble(10, t.getPrecio());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar: " + e.toString());
        }
    }

    @Override
    public Producto buscar(Object id) throws Exception {
        Producto valorRetorno = new Producto();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_PRODUCTO " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idProducto = resultado.getInt("Id_Producto");
                String nombre = resultado.getString("Nombre_Producto");
                int idProveedor = resultado.getInt("Id_Proveedor");
                int idCategoria = resultado.getInt("Id_Categoria");
                String cantidadesUnidad = resultado.getString("Cantidades_Unidad");
                int unidadesAlmacen = resultado.getInt("Unidades_Almacen");
                int cantidadMinima = resultado.getInt("Cantidad_Minima");
                int cantidadMaxima = resultado.getInt("Cantidad_Maxima");
                int idEstado = resultado.getInt("Id_Estado_Concepto");
                Double precio = resultado.getDouble("Precio");

                valorRetorno.setIdProducto(idProducto);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdProveedor(idProveedor);
                valorRetorno.setIdCategoria(idCategoria);
                valorRetorno.setCantidadUnidad(cantidadesUnidad);
                valorRetorno.setCantidadAlmacen(unidadesAlmacen);
                valorRetorno.setCantidadMinima(cantidadMinima);
                valorRetorno.setCantidadMaxima(cantidadMaxima);
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
    public List<Producto> buscarTodo() throws Exception {
        List<Producto> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT * FROM Productos";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idProducto = resultado.getInt("Id_Producto");
                String nombre = resultado.getString("Nombre_Producto");
                int idProveedor = resultado.getInt("Id_Proveedor");
                int idCategoria = resultado.getInt("Id_Categoria");
                String cantidadesUnidad = resultado.getString("Cantidades_Unidad");
                int unidadesAlmacen = resultado.getInt("Unidades_Almacen");
                int cantidadMinima = resultado.getInt("Cantidad_Minima");
                int cantidadMaxima = resultado.getInt("Cantidad_Maxima");
                int idEstado = resultado.getInt("Id_Estado_Concepto");
                Double precio = resultado.getDouble("Precio");

                Producto valorRetorno = new Producto();
                valorRetorno.setIdProducto(idProducto);
                valorRetorno.setNombre(nombre);
                valorRetorno.setIdProveedor(idProveedor);
                valorRetorno.setIdCategoria(idCategoria);
                valorRetorno.setCantidadUnidad(cantidadesUnidad);
                valorRetorno.setCantidadAlmacen(unidadesAlmacen);
                valorRetorno.setCantidadMinima(cantidadMinima);
                valorRetorno.setCantidadMaxima(cantidadMaxima);
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
