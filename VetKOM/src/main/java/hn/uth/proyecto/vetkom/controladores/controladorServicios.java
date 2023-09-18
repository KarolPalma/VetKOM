/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Servicio;
import hn.uth.proyecto.vetkom.repositorios.ServicioRepositorio;
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
@WebServlet(name = "controladorServicios", urlPatterns = {"/controladorServicios"})
public class controladorServicios extends HttpServlet {

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
            String idServicio = request.getParameter("idServicio");
            String nombre = request.getParameter("nombreServicio");
            String idEstado = request.getParameter("idEstado");
            String precio = request.getParameter("precio");

            String submit = request.getParameter("insert");

            Servicio servicio = recuperarServicio(idServicio, nombre, idEstado, precio);
            if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                try {
                    if (servicio.getIdServicio() != 0) {
                        ServicioRepositorio servicioRepo = new ServicioRepositorio();
                        servicioRepo.crear(servicio);
                        String msExito = "Registro añadido exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/servicios/registrarServicio.jsp");
                    }
                    request.getSession().setAttribute("servicio", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/servicios/registrarServicio.jsp");
                    ex.printStackTrace();
                }

            }

            if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Servicio")) {
                try {
                    if (servicio.getIdServicio() != 0) {
                        ServicioRepositorio servicioRepo = new ServicioRepositorio();
                        servicioRepo.actualizar(servicio);
                        String msExito = "Registro actualizado exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/servicios/actualizarServicio.jsp");
                    }
                    request.getSession().setAttribute("producto", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/servicios/actualizarServicio.jsp");
                    ex.printStackTrace();
                }

            }
            if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Servicio")) {
                try {
                    if (servicio.getIdServicio() != 0) {
                        ServicioRepositorio servicioRepo = new ServicioRepositorio();
                        servicioRepo.desactivar(servicio);
                        String msExito = "Registro desactivado exitosamente";
                        request.setAttribute("msExito", msExito);
                        ir(request, response, "menuPrincipal.jsp");
                    } else {
                        ir(request, response, "paginas/servicios/actualizarServicio.jsp");
                    }
                    request.getSession().setAttribute("producto", null);

                } catch (Exception ex) {
                    ir(request, response, "paginas/servicios/actualizarServicio.jsp");
                    ex.printStackTrace();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Servicio recuperarServicio(String idServicio, String nombre, String idEstado, String precio) {
        Servicio servicio = new Servicio();
        try {
            int id = 0;
            if (idServicio != null && idServicio.equals("") == false) {
                id = Integer.parseInt(idServicio);
            }
            servicio.setIdServicio(id);
            servicio.setNombre(nombre);

            int idEs = 3;
            if (idEstado != null && idEstado.equals("") == false) {
                idEs = Integer.parseInt(idEstado);
            }
            servicio.setIdEstado(idEs);

            double precioD = 0.0;
            if (precio != null && precio.equals("") == false) {
                precioD = Double.parseDouble(precio);
            }
            servicio.setPrecio(precioD);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return servicio;
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
