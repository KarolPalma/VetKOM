/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Cita;
import hn.uth.proyecto.vetkom.repositorios.CitaRepositorio;
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
@WebServlet(name = "controladorCitas", urlPatterns = {"/controladorCitas"})
public class controladorCitas extends HttpServlet {

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
            String idCita = request.getParameter("idCita");
            String idDuenio = request.getParameter("idDuenio");
            String idAnimal = request.getParameter("idAnimal");
            String idServicio = request.getParameter("idServicio");
            String idEmpleado = request.getParameter("idEmpleado");
            String fechaIngreso = request.getParameter("fechaIngreso");
            String fechaCita = request.getParameter("fechaCita");
            String horaCita = request.getParameter("horaCita");
            String noSala = request.getParameter("noSala");
            String idEstado = request.getParameter("idEstado");
            String observaciones = request.getParameter("observaciones");

            String submit = request.getParameter("insert");

            if (submit != null && (submit.equals("Guardar Cita") || submit.equals("Actualizar Cita") || submit.equals("Desactivar Cita"))) {
                Cita cita = recuperarCita(idCita, idDuenio, idAnimal, idServicio, idEmpleado, fechaIngreso, fechaCita, horaCita, noSala, idEstado, observaciones);
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    try {
                        if (cita.getIdCita() != 0) {
                            CitaRepositorio citaRepo = new CitaRepositorio();
                            citaRepo.crear(cita);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/citas/registrarCita.jsp");
                        }
                        request.getSession().setAttribute("cita", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/citas/registrarCita.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Cita")) {
                    try {
                        if (cita.getIdCita() != 0) {
                            CitaRepositorio citaRepo = new CitaRepositorio();
                            citaRepo.actualizar(cita);
                            String msExito = "Registro actualizado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/citas/actualizarCita.jsp");
                        }
                        request.getSession().setAttribute("cita", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/citas/actualizarCita.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Cita")) {
                    try {
                        if (cita.getIdCita() != 0) {
                            CitaRepositorio citaRepo = new CitaRepositorio();
                            citaRepo.desactivar(cita);
                            String msExito = "Registro desactivado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/citas/actualizarCita.jsp");
                        }
                        request.getSession().setAttribute("cita", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/citas/actualizarCita.jsp");
                        ex.printStackTrace();
                    }

                }

            } else {

                Cita cita = recuperarCitaNoInsert(idCita, idDuenio, idAnimal, idServicio, idEmpleado, fechaIngreso, fechaCita, horaCita, noSala, idEstado, observaciones);

                request.getSession().setAttribute("cita", cita);

                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    ir(request, response, "paginas/citas/registrarCita.jsp");
                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {
                    ir(request, response, "paginas/citas/actualizarCita.jsp");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Cita recuperarCita(String idCita, String idDuenio, String idAnimal, String idServicio, String idEmpleado, String fechaIngreso,
            String fechaCita, String horaCita, String noSala, String idEstado, String observaciones) {
        Cita cita = new Cita();
        try {
            Date fechaRegistroDate = null;
            Date fechaCitaDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaIngreso != null && fechaIngreso.equals("") == false) {
                fechaRegistroDate = format.parse(fechaIngreso);
            }
            if (fechaCita != null && fechaCita.equals("") == false) {
                fechaCitaDate = format.parse(fechaCita);
            }

            int id = 0;
            if (idCita != null && idCita.equals("") == false) {
                id = Integer.parseInt(idCita);
            }

            int idAni = 0;
            if (idAnimal != null && idAnimal.equals("") == false) {
                idAni = Integer.parseInt(idAnimal);
            }

            int idSer = 0;
            if (idServicio != null && idServicio.equals("") == false) {
                idSer = Integer.parseInt(idServicio);
            }

            int idEmpl = 0;
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                idEmpl = Integer.parseInt(idEmpleado);
            }

            int noSal = 0;
            if (noSala != null && noSala.equals("") == false) {
                noSal = Integer.parseInt(noSala);
            }

            int idEst = 0;
            if (idEstado != null && idEstado.equals("") == false) {
                idEst = Integer.parseInt(idEstado);
            }

            cita.setIdCita(id);
            cita.setIdDuenio(idDuenio);
            cita.setIdAnimal(idAni);
            cita.setIdServicioSolicitado(idSer);
            cita.setIdEmpleado(idEmpl);
            cita.setFechaIngreso(fechaRegistroDate);
            cita.setFechaCita(fechaCitaDate);
            cita.setHoraCita(horaCita);
            cita.setNoSala(noSal);
            cita.setIdEstado(idEst);
            if (observaciones.equals("")) {
                cita.setObservaciones(null);
            } else {
                cita.setObservaciones(observaciones);
            }
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return cita;
    }

    private Cita recuperarCitaNoInsert(String idCita, String idDuenio, String idAnimal, String idServicio, String idEmpleado, String fechaIngreso,
             String fechaCita, String horaCita, String noSala, String idEstado, String observaciones) {
        Cita cita = new Cita();
        try {
            Date fechaRegistroDate = null;
            Date fechaCitaDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaIngreso != null && fechaIngreso.equals("") == false) {
                fechaRegistroDate = format.parse(fechaIngreso);
            }
            if (fechaCita != null && fechaCita.equals("") == false) {
                fechaCitaDate = format.parse(fechaCita);
            }

            int id = 0;
            if (idCita != null && idCita.equals("") == false) {
                id = Integer.parseInt(idCita);
            }

            int idAni = 0;
            if (idAnimal != null && idAnimal.equals("") == false) {
                idAni = Integer.parseInt(idAnimal);
            }

            int idSer = 0;
            if (idServicio != null && idServicio.equals("") == false) {
                idSer = Integer.parseInt(idServicio);
            }

            int idEmpl = 0;
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                idEmpl = Integer.parseInt(idEmpleado);
            }

            int noSal = 0;
            if (noSala != null && noSala.equals("") == false) {
                noSal = Integer.parseInt(noSala);
            }

            int idEst = 0;
            if (idEstado != null && idEstado.equals("") == false) {
                idEst = Integer.parseInt(idEstado);
            }

            cita.setIdCita(id);
            cita.setIdDuenio(idDuenio);
            cita.setIdAnimal(idAni);
            cita.setIdServicioSolicitado(idSer);
            cita.setIdEmpleado(idEmpl);
            cita.setFechaIngreso(fechaRegistroDate);
            cita.setFechaCita(fechaCitaDate);
            cita.setHoraCita(horaCita);
            cita.setNoSala(noSal);
            cita.setIdEstado(idEst);
            cita.setObservaciones(observaciones);

        } catch (Exception e) {
            //crar redireccionamiento a otra pagina de error
        }
        return cita;
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
