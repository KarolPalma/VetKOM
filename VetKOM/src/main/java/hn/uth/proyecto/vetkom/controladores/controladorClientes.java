/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Cliente;
import hn.uth.proyecto.vetkom.repositorios.ClienteRepositorio;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
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
@WebServlet(name = "controladorClientes", urlPatterns = {"/controladorClientes"})
public class controladorClientes extends HttpServlet {

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
            String idCliente = request.getParameter("idCliente");
            String nombres = request.getParameter("nombresCliente");
            String apellidos = request.getParameter("apellidosCliente");
            String fechaNacimiento = request.getParameter("fechaNacimientoCliente");
            String fechaRegistro = request.getParameter("fechaRegistroCliente");
            String idGenero = request.getParameter("idGeneroCliente");
            String direccion = request.getParameter("direccionCliente");
            String pais = request.getParameter("paisCliente");
            String departamento = request.getParameter("departamentoCliente");
            String ciudad = request.getParameter("ciudadCliente");
            String ruta = request.getParameter("rutaFoto");
            String telefonos = request.getParameter("telefonos");
            String correos = request.getParameter("correos");

            String submit = request.getParameter("insert");

            if (submit != null && (submit.equals("Guardar Cliente") || submit.equals("Actualizar Cliente") || submit.equals("Desactivar Cliente"))) {
                Cliente cliente = recuperarCliente(idCliente, nombres, apellidos, fechaRegistro, fechaNacimiento, idGenero, direccion, ciudad, ruta, telefonos, correos);
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    try {
                        if (cliente.getIdCliente().equals("") == false) {
                            ClienteRepositorio clienteRepo = new ClienteRepositorio();
                            cliente.setFechaRegistro(Date.from(Instant.now()));
                            clienteRepo.crear(cliente);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/clientes/registrarCliente.jsp");
                        }
                        request.getSession().setAttribute("cliente", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/clientes/registrarCliente.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Cliente")) {
                    try {
                        if (cliente.getIdCliente().equals("") == false) {
                            ClienteRepositorio clienteRepo = new ClienteRepositorio();
                            clienteRepo.actualizar(cliente);
                            String msExito = "Registro actualizado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/clientes/actualizarCliente.jsp");
                        }
                        request.getSession().setAttribute("cliente", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/clientes/actualizarCliente.jsp");
                        ex.printStackTrace();
                    }

                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Cliente")) {
                    try {
                        if (cliente.getIdCliente().equals("") == false) {
                            ClienteRepositorio clienteRepo = new ClienteRepositorio();
                            clienteRepo.desactivar(cliente);
                            String msExito = "Registro desactivado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/clientes/actualizarCliente.jsp");
                        }
                        request.getSession().setAttribute("empleado", null);
                        request.getSession().setAttribute("idPais", null);
                        request.getSession().setAttribute("idDepto", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/clientes/actualizarCliente.jsp");
                        ex.printStackTrace();
                    }

                }

            } else {

                Cliente cliente = recuperarClienteNoInsert(idCliente, nombres, apellidos, fechaRegistro, fechaNacimiento, idGenero, direccion, pais,
                        departamento, ciudad, ruta, telefonos, correos);
                int idPais = 0;
                int idDepto = 0;
                if (pais != null && pais.equals("") == false) {
                    idPais = Integer.parseInt(pais);
                }
                if (departamento != null && departamento.equals("") == false) {
                    idDepto = Integer.parseInt(departamento);
                }

                request.getSession().setAttribute("cliente", cliente);
                if (idPais != 0) {
                    request.getSession().setAttribute("idPais", idPais);
                }
                if (idDepto != 0) {
                    request.getSession().setAttribute("idDepto", idDepto);
                }
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    ir(request, response, "paginas/clientes/registrarCliente.jsp");
                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {
                    ir(request, response, "paginas/clientes/actualizarCliente.jsp");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Cliente recuperarCliente(String idCliente, String nombres, String apellidos, String fechaRegistro, String fechaNacimiento,
            String idGenero, String direccion, String ciudad, String ruta, String telefonos, String correos) {
        Cliente cliente = new Cliente();
        try {
            Date fechaNacimientoDate = null;
            Date fechaRegistroDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }
            if (fechaRegistro != null && fechaRegistro.equals("") == false) {
                fechaRegistroDate = format.parse(fechaRegistro);
            }

            String id = "";
            if (idCliente != null && idCliente.equals("") == false) {
                id = idCliente;
            }
            cliente.setIdCliente(id);
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setFechaNacimiento(fechaNacimientoDate);
            cliente.setFechaRegistro(fechaRegistroDate);
            cliente.setIdGenero(Integer.parseInt(idGenero));
            cliente.setDireccion(direccion);

            int idCiudad = 0;
            if (ciudad != null && ciudad.equals("") == false) {
                idCiudad = Integer.parseInt(ciudad);
            }
            cliente.setIdCiudad(idCiudad);

            if (ruta.equals("")) {
                cliente.setRutaFoto(null);
            } else {
                cliente.setRutaFoto(ruta);
            }

            cliente.setTelefonos(telefonos);
            cliente.setCorreos(correos);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return cliente;
    }

    private Cliente recuperarClienteNoInsert(String idCliente, String nombres, String apellidos, String fechaRegistro, String fechaNacimiento,
            String idGenero, String direccion, String pais, String departamento, String ciudad, String ruta, String telefonos, String correos) {
        Cliente cliente = new Cliente();
        try {
            Date fechaNacimientoDate = null;
            Date fechaRegistroDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }
            if (fechaRegistro != null && fechaRegistro.equals("") == false) {
                fechaRegistroDate = format.parse(fechaRegistro);
            }

            String id = "";
            if (idCliente != null && idCliente.equals("") == false) {
                id = idCliente;
            }
            cliente.setIdCliente(id);
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setFechaNacimiento(fechaNacimientoDate);
            cliente.setFechaRegistro(fechaRegistroDate);
            cliente.setIdGenero(Integer.parseInt(idGenero));
            cliente.setDireccion(direccion);
            cliente.setRutaFoto(ruta);
            cliente.setTelefonos(telefonos);
            cliente.setCorreos(correos);
        } catch (Exception e) {
            //crar redireccionamiento a otra pagina de error
        }
        return cliente;
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
