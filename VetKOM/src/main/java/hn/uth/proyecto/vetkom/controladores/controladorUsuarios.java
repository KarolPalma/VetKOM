/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Empleado;
import hn.uth.proyecto.vetkom.objetos.Usuario;
import hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio;
import hn.uth.proyecto.vetkom.repositorios.UsuarioRepositorio;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Miriam
 */
@WebServlet(name = "controladorUsuarios", urlPatterns = {"/controladorUsuarios"})
public class controladorUsuarios extends HttpServlet {

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
            String idUsuario = request.getParameter("idUsuario");
            String idEmpleado = request.getParameter("idEmpleado");
            String clave = request.getParameter("clave");
            String fechaRegistro = request.getParameter("fechaRegistro");
            String fechaModificacion = request.getParameter("fechaModificacion");

            String submit = request.getParameter("insert");

            if (submit != null && submit.equals("Iniciar Sesion")) {
                try {
                    UsuarioRepositorio usuarioRepositorio = new UsuarioRepositorio();
                    EmpleadoRepositorio empleadoRepositorio = new EmpleadoRepositorio();

                    Usuario usuarioSesion = usuarioRepositorio.iniciar(idUsuario, clave);
                    Empleado empleadoSesion = empleadoRepositorio.buscar(usuarioSesion.getIdEmpleado());
                    if (usuarioSesion.getIdEmpleado() != 0 && empleadoSesion != null) {
                        request.getSession().setAttribute("usuarioSesion", usuarioSesion);
                        request.getSession().setAttribute("empleadoSesion", empleadoSesion);
                        response.sendRedirect("menuPrincipal.jsp");
                    } else {
                        response.sendRedirect("index.jsp");
                    }
                } catch (Exception ex) {
                    ir(request, response, "index.jsp");
                    ex.printStackTrace();
                }
            }

            if (submit != null && (submit.equals("Guardar Usuario") || submit.equals("Actualizar Usuario") || submit.equals("Desactivar Usuario"))) {
                Usuario usuario = recuperarUsuario(idUsuario, idEmpleado, clave, fechaRegistro, fechaModificacion);
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    try {
                        if (usuario.getUsuario() != null) {
                            UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
                            usuarioRepo.crear(usuario);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/usuarios/registrarUsuario.jsp");
                        }
                        request.getSession().setAttribute("usuario", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/usuarios/registrarUsuario.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Usuario")) {
                    try {
                        if (usuario.getUsuario() != null) {
                            UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
                            usuarioRepo.actualizar(usuario);
                            String msExito = "Registro actualizado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/usuarios/actualizarUsuario.jsp");
                        }
                        request.getSession().setAttribute("usuario", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/usuarios/actualizarUsuario.jsp");
                        ex.printStackTrace();
                    }

                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Usuario")) {
                    try {
                        if (usuario.getUsuario() != null) {
                            UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
                            usuarioRepo.desactivar(usuario);
                            String msExito = "Registro desactivado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/usuarios/actualizarUsuario.jsp");
                        }
                        request.getSession().setAttribute("empleado", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/usuarios/actualizarUsuario.jsp");
                        ex.printStackTrace();
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Usuario recuperarUsuario(String usuario, String idEmpleado, String clave, String fechaRegistro, String fechaActualizacion) {
        Usuario usuarioO = new Usuario();
        try {
            Date fechaRegistroDate = null;
            Date fechaActualizacionDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaRegistro != null && fechaRegistro.equals("") == false) {
                fechaRegistroDate = format.parse(fechaRegistro);
            }
            if (fechaActualizacion != null && fechaActualizacion.equals("") == false) {
                fechaActualizacionDate = format.parse(fechaActualizacion);
            }

            int id = 0;
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                id = Integer.parseInt(idEmpleado);
            }
            usuarioO.setUsuario(usuario);
            usuarioO.setIdEmpleado(id);
            usuarioO.setClave(clave);
            usuarioO.setFechaRegistro(fechaRegistroDate);
            usuarioO.setFechaModificacion(fechaActualizacionDate);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
            e.printStackTrace();
        }
        return usuarioO;
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
