/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import static hn.uth.proyecto.vetkom.repositorios.Conexion.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

/**
 *
 * @author Miriam
 */
public class DatosBDRepositorio {

    public static Hashtable getPaises() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Pais, Nombre_Pais FROM Paises";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idPais = resultado.getInt("Id_Pais");
                String nombrePais = resultado.getString("Nombre_Pais");
                datos.put(idPais, nombrePais);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar paises: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getDeptos(int idPais) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Departamento, Nombre_Departamento FROM Departamentos WHERE Id_Pais = " + idPais;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idDepto = resultado.getInt("Id_Departamento");
                String nombreDepto = resultado.getString("Nombre_Departamento");
                datos.put(idDepto, nombreDepto);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar deptos: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getCiudades(int idDepto) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Ciudad, Nombre_Ciudad FROM Ciudades WHERE Id_Departamento = " + idDepto;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCiudad = resultado.getInt("Id_Ciudad");
                String nombreCiudad = resultado.getString("Nombre_Ciudad");
                datos.put(idCiudad, nombreCiudad);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar ciudades: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getCiudad(int idCiudad) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Ciudad, Nombre_Ciudad FROM Ciudades WHERE Id_Ciudad = " + idCiudad;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("Id_Ciudad");
                String nombreCiudad = resultado.getString("Nombre_Ciudad");
                datos.put(id, nombreCiudad);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar ciudad: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getCargos() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Cargo, Nombre_Cargo FROM Cargos";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCargo = resultado.getInt("Id_Cargo");
                String nombreCargo = resultado.getString("Nombre_Cargo");
                datos.put(idCargo, nombreCargo);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar cargos: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getReportaA() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Empleado, Nombres, Apellidos FROM Empleados WHERE Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEmpleado = resultado.getInt("Id_Empleado");
                String nombre = resultado.getString("Nombres") + " " + resultado.getString("Apellidos");
                datos.put(idEmpleado, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar jefes: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getGeneros() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Genero, Nombre_Genero FROM Generos";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idGenero = resultado.getInt("Id_Genero");
                String genero = resultado.getString("Nombre_Genero");
                datos.put(idGenero, genero);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar generos: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getCategoriasProductos() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Categoria, Nombre_Categoria FROM Categorias";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCategoria = resultado.getInt("Id_Categoria");
                String categoria = resultado.getString("Nombre_Categoria");
                datos.put(idCategoria, categoria);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar categorias: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getProveedores() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Proveedor, Nombre_Proveedor FROM Proveedores WHERE Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idProveedor = resultado.getInt("Id_Proveedor");
                String nombre = resultado.getString("Nombre_Proveedor");
                datos.put(idProveedor, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar proveedores: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getColores() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT ID_Color, Nombre_Color FROM Colores";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idColor = resultado.getInt("Id_Color");
                String nombreColor = resultado.getString("Nombre_Color");
                datos.put(idColor, nombreColor);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar colores: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getEspecies() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Especie, Nombre_Especie FROM Especies";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEspecie = resultado.getInt("Id_Especie");
                String nombreEspecie = resultado.getString("Nombre_Especie");
                datos.put(idEspecie, nombreEspecie);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar especies: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getRaza(int idEspecie) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Raza, Nombre_Raza FROM Razas WHERE Id_Especie = " + idEspecie;

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idRaza = resultado.getInt("Id_Raza");
                String nombreRaza = resultado.getString("Nombre_Raza");
                datos.put(idRaza, nombreRaza);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar raza: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getClienteDuenio() throws Exception {
        Hashtable<String, String> datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Cliente, Nombres, Apellidos FROM Clientes WHERE Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                String idCliente = resultado.getString("Id_Cliente");
                String nombre = resultado.getString("Nombres") + " " + resultado.getString("Apellidos");
                datos.put(idCliente, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar dueños: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getAnimalxDuenio(String idDuenio) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Animal, Nombre FROM Animales WHERE Id_Cliente_Duenio = '" + idDuenio + "'"
                    + "AND Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idAnimal = resultado.getInt("Id_Animal");
                String nombre = resultado.getString("Nombre");
                datos.put(idAnimal, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar animales: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getServicios() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Servicio, Nombre_Servicio FROM Servicios WHERE Id_Estado = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idServicio = resultado.getInt("Id_Servicio");
                String nombre = resultado.getString("Nombre_Servicio");
                datos.put(idServicio, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar servicios: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getPersonalServicios(int idServicio) throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Empleado, Nombres, Apellidos "
                    + "FROM Empleados "
                    + "WHERE Id_Empleado IN (SELECT Id_Empleado "
                    + "FROM Servicios_Personal "
                    + "WHERE Id_Servicio = " + idServicio + ") "
                    + "AND Activo = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEmpleado = resultado.getInt("Id_Empleado");
                String nombre = resultado.getString("Nombres") + " " + resultado.getString("Apellidos");
                datos.put(idEmpleado, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar empleados por servicio: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getEstadosCita() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Estado_Cita, Estado_Cita FROM Estados_Cita";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idEstado = resultado.getInt("Id_Estado_Cita");
                String nombre = resultado.getString("Estado_Cita");
                datos.put(idEstado, nombre);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar estados cita: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getNoCitasTodas() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Cita FROM Citas";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCita = resultado.getInt("Id_Cita");
                String noCita = resultado.getString("Id_Cita");
                datos.put(idCita, noCita);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar las citas: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getNoCitas() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Cita FROM Citas WHERE Id_Estado = 1";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idCita = resultado.getInt("Id_Cita");
                String noCita = resultado.getString("Id_Cita");
                datos.put(idCita, noCita);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar las citas: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getMetodosPago() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Metodo_Pago, Metodo_Pago FROM Metodo_Pago";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idMetodo = resultado.getInt("Id_Metodo_Pago");
                String metodo = resultado.getString("Metodo_Pago");
                datos.put(idMetodo, metodo);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar metodos de pago: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getProductos() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Producto, Nombre_Producto FROM Productos WHERE Unidades_Almacen > 0";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idProducto = resultado.getInt("Id_Producto");
                String producto = resultado.getString("Nombre_Producto");
                datos.put(idProducto, producto);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar productos: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getImpuestos() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Impuesto, Nombre_Impuesto FROM Impuestos";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idImpuesto = resultado.getInt("Id_Impuesto");
                String impuesto = resultado.getString("Nombre_Impuesto");
                datos.put(idImpuesto, impuesto);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar impuestos: " + e.toString());
        }
        return datos;
    }

    public static Hashtable getDescuentos() throws Exception {
        Hashtable datos = new Hashtable();
        try {
            Connection cnx = getConnection();

            String sql = "SELECT Id_Descuento, Nombre_Descuento FROM Descuentos";

            Statement st = cnx.createStatement();

            ResultSet resultado = st.executeQuery(sql);

            while (resultado.next()) {
                int idDescuento = resultado.getInt("Id_Descuento");
                String descuento = resultado.getString("Nombre_Descuento");
                datos.put(idDescuento, descuento);
            }

            st.close();
            cnx.close();
        } catch (SQLException e) {
            throw new Exception("Error al buscar descuentos: " + e.toString());
        }
        return datos;
    }

}
