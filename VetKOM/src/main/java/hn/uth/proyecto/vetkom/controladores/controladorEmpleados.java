/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Empleado;
import hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio;
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
@WebServlet(name = "controladorEmpleados", urlPatterns = {"/controladorEmpleados"})
public class controladorEmpleados extends HttpServlet {

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
            String idEmpleado = request.getParameter("idEmpleado");
            String nombres = request.getParameter("nombresEmpleado");
            String apellidos = request.getParameter("apellidosEmpleado");
            String fechaNacimiento = request.getParameter("fechaNacimientoEmpleado");
            String fechaContratacion = request.getParameter("fechaContratacionEmpleado");
            String fechaFinalizacionContrato = request.getParameter("fechaFinalizacionContratoEmpleado");
            String cargo = request.getParameter("cargoEmpleado");
            String reporta = request.getParameter("reportaEmpleado");
            String direccion = request.getParameter("direccionEmpleado");
            String pais = request.getParameter("paisEmpleado");
            String departamento = request.getParameter("departamentoEmpleado");
            String ciudad = request.getParameter("ciudadEmpleado");
            String ruta = request.getParameter("rutaFoto");
            String notas = request.getParameter("notas");
            String telefonos = request.getParameter("telefonos");

            String submit = request.getParameter("insert");

            if (submit != null && (submit.equals("Guardar Empleado") || submit.equals("Actualizar Empleado") || submit.equals("Desactivar Empleado"))) {
                Empleado empleado = recuperarEmpleado(idEmpleado, nombres, apellidos, fechaNacimiento, fechaContratacion, fechaFinalizacionContrato, cargo,
                        reporta, direccion, ciudad, ruta, notas, telefonos);
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    try {
                        if (empleado.getIdEmpleado() != 0) {
                            EmpleadoRepositorio empleadoRepo = new EmpleadoRepositorio();
                            empleadoRepo.crear(empleado);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/empleados/registrarEmpleado.jsp");
                        }
                        request.getSession().setAttribute("empleado", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/empleados/registrarEmpleado.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Empleado")) {
                    try {
                        if (empleado.getIdEmpleado() != 0) {
                            EmpleadoRepositorio empleadoRepo = new EmpleadoRepositorio();
                            empleadoRepo.actualizar(empleado);
                            String msExito = "Registro actualizado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/empleados/actualizarEmpleado.jsp");
                        }
                        request.getSession().setAttribute("empleado", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/empleados/actualizarEmpleado.jsp");
                        ex.printStackTrace();
                    }

                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Empleado")) {
                    try {
                        if (empleado.getIdEmpleado() != 0) {
                            EmpleadoRepositorio empleadoRepo = new EmpleadoRepositorio();
                            empleadoRepo.desactivar(empleado);
                            String msExito = "Registro desactivado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/empleados/actualizarEmpleado.jsp");
                        }
                        request.getSession().setAttribute("empleado", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/empleados/actualizarEmpleado.jsp");
                        ex.printStackTrace();
                    }

                }

            } else {

                Empleado empleado = recuperarEmpleadoNoInsert(idEmpleado, nombres, apellidos, fechaNacimiento, fechaContratacion, fechaFinalizacionContrato, cargo,
                        reporta, direccion, pais, departamento, ciudad, ruta, notas, telefonos);
                int idPais = 0;
                int idDepto = 0;
                if (pais != null && pais.equals("") == false) {
                    idPais = Integer.parseInt(pais);
                }
                if (departamento != null && departamento.equals("") == false) {
                    idDepto = Integer.parseInt(departamento);
                }

                request.getSession().setAttribute("empleado", empleado);
                if (idPais != 0) {
                    request.getSession().setAttribute("idPais", idPais);
                }
                if (idDepto != 0) {
                    request.getSession().setAttribute("idDepto", idDepto);
                }
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    ir(request, response, "paginas/empleados/registrarEmpleado.jsp");
                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {
                    ir(request, response, "paginas/empleados/actualizarEmpleado.jsp");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Empleado recuperarEmpleado(String idEmpleado, String nombres, String apellidos, String fechaNacimiento, String fechaContratacion, String fechaFinalizacionContrato,
            String cargo, String reporta, String direccion, String ciudad, String ruta, String notas, String telefonos) {
        Empleado empleado = new Empleado();
        try {
            Date fechaNacimientoDate = null;
            Date fechaContratacionDate = null;
            Date fechaFinalizacionContratoDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }
            if (fechaContratacion != null && fechaContratacion.equals("") == false) {
                fechaContratacionDate = format.parse(fechaContratacion);
            }
            if (fechaFinalizacionContrato != null && fechaFinalizacionContrato.equals("") == false) {
                fechaFinalizacionContratoDate = format.parse(fechaFinalizacionContrato);
            }

            int id = 0;
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                id = Integer.parseInt(idEmpleado);
            }
            empleado.setIdEmpleado(id);
            empleado.setNombres(nombres);
            empleado.setApellidos(apellidos);
            empleado.setFechaNacimiento(fechaNacimientoDate);
            empleado.setFechaContratacion(fechaContratacionDate);
            empleado.setFechaFinalizacionContrato(fechaFinalizacionContratoDate);
            empleado.setIdCargo(Integer.parseInt(cargo));
            if (reporta.equals("0")) {
                empleado.setReportaA(0);
            } else {
                empleado.setReportaA(Integer.parseInt(reporta));
            }
            empleado.setDireccion(direccion);

            int idCiudad = 0;
            if (ciudad != null && ciudad.equals("") == false) {
                idCiudad = Integer.parseInt(ciudad);
            }
            empleado.setIdCiudad(idCiudad);

            if (ruta.equals("")) {
                empleado.setRutaFoto(null);
            } else {
                empleado.setRutaFoto(ruta);
            }

            if (notas.equals("")) {
                empleado.setNotas(null);
            } else {
                empleado.setNotas(notas);
            }
            empleado.setTelefonos(telefonos);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return empleado;
    }

    private Empleado recuperarEmpleadoNoInsert(String idEmpleado, String nombres, String apellidos, String fechaNacimiento, String fechaContratacion, String fechaFinalizacionContrato,
            String cargo, String reporta, String direccion, String pais, String departamento, String ciudad, String ruta, String notas, String telefonos) {
        Empleado empleado = new Empleado();
        try {
            Date fechaNacimientoDate = null;
            Date fechaContratacionDate = null;
            Date fechaFinalizacionContratoDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }
            if (fechaContratacion != null && fechaContratacion.equals("") == false) {
                fechaContratacionDate = format.parse(fechaContratacion);
            }
            if (fechaFinalizacionContrato != null && fechaFinalizacionContrato.equals("") == false) {
                fechaFinalizacionContratoDate = format.parse(fechaFinalizacionContrato);
            }

            int id = 0;
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                id = Integer.parseInt(idEmpleado);
            }
            empleado.setIdEmpleado(id);
            empleado.setNombres(nombres);
            empleado.setApellidos(apellidos);
            empleado.setFechaNacimiento(fechaNacimientoDate);
            empleado.setFechaContratacion(fechaContratacionDate);
            empleado.setFechaFinalizacionContrato(fechaFinalizacionContratoDate);
            empleado.setIdCargo(Integer.parseInt(cargo));
            empleado.setReportaA(Integer.parseInt(reporta));
            empleado.setDireccion(direccion);
            empleado.setRutaFoto(ruta);
            empleado.setNotas(notas);
            empleado.setTelefonos(telefonos);
        } catch (Exception e) {
            //crar redireccionamiento a otra pagina de error
        }
        return empleado;
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
