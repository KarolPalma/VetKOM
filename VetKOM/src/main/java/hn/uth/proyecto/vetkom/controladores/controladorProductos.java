/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Producto;
import hn.uth.proyecto.vetkom.repositorios.ProductoRepositorio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miriam
 */
@WebServlet(name = "controladorProductos", urlPatterns = {"/controladorProductos"})
public class controladorProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            String idProducto = request.getParameter("idProducto");
            String nombre = request.getParameter("nombreProducto");
            String idProveedor = request.getParameter("idProveedor");
            String idCategoria = request.getParameter("idCategoria");
            String cantidadUnidad = request.getParameter("cantidadUnidad");
            String cantidadAlmacen = request.getParameter("cantidadAlmacen");
            String cantidadMinima = request.getParameter("cantidadMinima");
            String cantidadMaxima = request.getParameter("cantidadMaxima");
            String precio = request.getParameter("precio");

            String submit = request.getParameter("insert");

            Producto producto = recuperarProducto(idProducto, nombre, idProveedor, idCategoria, cantidadUnidad, cantidadAlmacen, cantidadMinima, cantidadMaxima, precio);
            if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                try {
                    if (producto.getIdProducto() != 0) {
                        ProductoRepositorio productoRepo = new ProductoRepositorio();
                        productoRepo.crear(producto);
                        String msExito = "Registro añadido exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/productos/registrarProducto.jsp");
                    }
                    request.getSession().setAttribute("producto", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/productos/registrarProducto.jsp");
                    ex.printStackTrace();
                }

            }

            if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Producto")) {
                try {
                    if (producto.getIdProducto() != 0) {
                        ProductoRepositorio productoRepo = new ProductoRepositorio();
                        productoRepo.actualizar(producto);
                        String msExito = "Registro actualizado exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/productos/actualizarProducto.jsp");
                    }
                    request.getSession().setAttribute("producto", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/productos/actualizarProducto.jsp");
                    ex.printStackTrace();
                }

            }
            if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Producto")) {
                try {
                    if (producto.getIdProducto() != 0) {
                        ProductoRepositorio productoRepo = new ProductoRepositorio();
                        productoRepo.desactivar(producto);
                        String msExito = "Registro desactivado exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/productos/actualizarProducto.jsp");
                    }
                    request.getSession().setAttribute("producto", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/productos/actualizarProducto.jsp");
                    ex.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Producto recuperarProducto(String idProducto, String nombre, String idProveedor, String idCategoria, String cantidadUnidad, String cantidadAlmacen,
            String cantidadMinima, String cantidadMaxima, String precio) {
        Producto producto = new Producto();
        try {
            int id = 0;
            if (idProducto != null && idProducto.equals("") == false) {
                id = Integer.parseInt(idProducto);
            }
            producto.setIdProducto(id);
            producto.setNombre(nombre);
            int idProvee = 0;
            if (idProveedor != null && idProveedor.equals("") == false) {
                idProvee = Integer.parseInt(idProveedor);
            }
            producto.setIdProveedor(idProvee);
            int idCate = 0;
            if (idCategoria != null && idCategoria.equals("") == false) {
                idCate = Integer.parseInt(idCategoria);
            }
            producto.setIdCategoria(idCate);
            producto.setCantidadUnidad(cantidadUnidad);
            int idCA = 0;
            if (cantidadAlmacen != null && cantidadAlmacen.equals("") == false) {
                idCA = Integer.parseInt(cantidadAlmacen);
            }
            producto.setCantidadAlmacen(idCA);
            int idCMin = 0;
            if (cantidadMinima != null && cantidadMinima.equals("") == false) {
                idCMin = Integer.parseInt(cantidadMinima);
            }
            producto.setCantidadMinima(idCMin);
            int idCMax = 0;
            if (cantidadMaxima != null && cantidadMaxima.equals("") == false) {
                idCMax = Integer.parseInt(cantidadMaxima);
            }
            producto.setCantidadMaxima(idCMax);
            double precioD = 0.0;
            if (precio != null && precio.equals("") == false) {
                precioD = Double.parseDouble(precio);
            }
            producto.setPrecio(precioD);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return producto;
    }

    private void ir(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(url);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
