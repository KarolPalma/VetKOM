/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import hn.uth.proyecto.vetkom.objetos.DetalleFactura;
import hn.uth.proyecto.vetkom.objetos.DetalleRecuperado;
import hn.uth.proyecto.vetkom.objetos.Factura;
import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class FacturaRepositorio {

    public void abrirFactura(Factura t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "DECLARE @IDFACTURA INT "
                    + "EXEC OPEN_FACTURA ?,?,?,?,?, @ID = @IDFACTURA OUTPUT";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdCita());
            ps.setDate(2, convertirSqlDate(t.getFechaFactura()));
            ps.setInt(3, t.getIdMetodoPago());
            ps.setDouble(4, t.getSubtotal());
            ps.setDouble(5, t.getTotal());
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al abrir: " + e.toString());
        }
    }

    public void crearDetalle(DetalleFactura t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC INSERTAR_DETALLE_FACTURA ?,?,?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdFactura());
            ps.setInt(2, t.getIdConcepto());
            ps.setInt(3, t.getIdDescuento());
            ps.setInt(4, t.getIdImpuesto());
            ps.setInt(5, 0);
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al insertar detalle: " + e.toString());
        }
    }

    public void eliminarDetalle(DetalleFactura t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC ELIMINAR_DETALLE ?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdFactura());
            ps.setInt(2, t.getIdConcepto());
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar detalle: " + e.toString());
        }
    }

    public void cerrarFactura(Factura t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC CERRAR_FACTURA ?,?,?,?,?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdCita());
            ps.setDate(2, convertirSqlDate(t.getFechaFactura()));
            ps.setInt(3, t.getIdMetodoPago());
            ps.setDouble(4, t.getSubtotal());
            ps.setDouble(5, t.getTotal());
            ps.setInt(6, t.getIdFactura());
            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al cerrar: " + e.toString());
        }
    }

    public void anularFactura(Factura t) throws Exception {
        try {
            Connection cnx = getConnection();

            String SPsql = "EXEC ANULAR_FACTURA ?,?";
            PreparedStatement ps = cnx.prepareStatement(SPsql);
            ps.setInt(1, t.getIdFactura());
            ps.setString(2, t.getUsuario());

            ps.execute();
            ps.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al anular: " + e.toString());
        }
    }

    public Factura buscar(Object id) throws Exception {
        Factura valorRetorno = new Factura();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC CONSULTAR_FACTURA " + id;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idFactura = resultado.getInt("Id_Factura");
                int idCita = resultado.getInt("Id_Cita");
                Date fechaFactura = resultado.getDate("Fecha_Factura");
                int idMetodoPago = resultado.getInt("Id_Metodo_Pago");
                double subTotal = resultado.getDouble("SubTotal");
                double total = resultado.getDouble("Total");

                valorRetorno.setIdFactura(idFactura);
                valorRetorno.setIdCita(idCita);
                valorRetorno.setFechaFactura(fechaFactura);
                valorRetorno.setIdMetodoPago(idMetodoPago);
                valorRetorno.setSubtotal(subTotal);
                valorRetorno.setTotal(total);
            }

            st.close();
            cnx.close();

        } catch (SQLException e) {
            throw new Exception("Error al buscar el registro: " + e.toString());
        }
        return valorRetorno;
    }

    public int getIdentity() throws Exception {
        int valorRetorno = 0;
        try {
            Connection cnx = getConnection();

            String sql = "SELECT MAX(Id_Factura) + 1 AS SECUENCIA FROM Facturas";

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

    public List<DetalleRecuperado> buscarTodo(int idFactura, Date fecha) throws Exception {
        List<DetalleRecuperado> listaRetorno = new ArrayList<>();
        try {
            Connection cnx = getConnection();

            String sql = "EXEC RECUPERAR_DETALLE " + idFactura + ", '" + new SimpleDateFormat("yyyy-MM-dd").format(fecha) + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String idConcepto = resultado.getString("Id_Concepto_Facturacion");
                String nombre = resultado.getString("Nombre_Concepto");
                Double precio = resultado.getDouble("Precio");
                Double impuesto = resultado.getDouble("Impuesto");
                Double descuento = resultado.getDouble("Descuento");

                DetalleRecuperado valorRetorno = new DetalleRecuperado();
                valorRetorno.setIdConcepto(idConcepto);
                valorRetorno.setNombre(nombre);
                valorRetorno.setPrecio(precio);
                valorRetorno.setImpuesto(impuesto);
                valorRetorno.setDescuento(descuento);

                listaRetorno.add(valorRetorno);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar detalles: " + e.toString());
        }
        return listaRetorno;
    }

    public double getSubTotal(Factura t) throws Exception {
        double valorRetorno = 0;
        try {
            Connection cnx = getConnection();

            String sql = "EXEC RECUPERAR_SUBTOTAL_TOTAL " + t.getIdFactura() + ", '" + new SimpleDateFormat("yyyy-MM-dd").format(t.getFechaFactura()) + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);
            if (resultado != null) {
                while (resultado.next()) {
                    double subtotal = resultado.getDouble("SubTotal");
                    valorRetorno = subtotal;
                }
            }
            st.close();
            cnx.close();
        } catch (Exception e) {
            valorRetorno = 0;
        }
        return valorRetorno;
    }

    public double getTotal(Factura t) throws Exception {
        double valorRetorno = 0;
        try {
            Connection cnx = getConnection();

            String sql = "EXEC RECUPERAR_SUBTOTAL_TOTAL " + t.getIdFactura() + ", '" + new SimpleDateFormat("yyyy-MM-dd").format(t.getFechaFactura()) + "'";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);
            if (resultado != null) {
                while (resultado.next()) {
                    double total = resultado.getDouble("Total");
                    valorRetorno = total;
                }
            }
            st.close();
            cnx.close();
        } catch (Exception e) {
            valorRetorno = 0;
        }
        return valorRetorno;
    }

    private java.sql.Date convertirSqlDate(java.util.Date fecha) {
        return new java.sql.Date(fecha.getTime());
    }

}
