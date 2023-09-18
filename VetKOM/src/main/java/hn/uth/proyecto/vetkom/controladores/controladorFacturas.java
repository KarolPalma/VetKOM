/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.DetalleFactura;
import hn.uth.proyecto.vetkom.objetos.Factura;
import hn.uth.proyecto.vetkom.objetos.Usuario;
import hn.uth.proyecto.vetkom.repositorios.FacturaRepositorio;
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
@WebServlet(name = "controladorFacturas", urlPatterns = {"/controladorFacturas"})
public class controladorFacturas extends HttpServlet {

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
            String idFactura = request.getParameter("idFactura");
            String idCita = request.getParameter("idCita");
            String fecha = request.getParameter("fechaFactura");
            String idMetodoPago = request.getParameter("idMetodoPago");
            String tipoConcepto = request.getParameter("tipoConcepto");
            String idConcepto = request.getParameter("idConcepto");
            String idImpuesto = request.getParameter("idImpuesto");
            String idDescuento = request.getParameter("idDescuento");
            String subTotal = request.getParameter("subTotal");
            String total = request.getParameter("total");
            //CAMBIAR A OBTENER ATRIBUTO DE SESION
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSesion");

            String submit = request.getParameter("insert");

            if (accion.equals("EliminarDetalle")) {
                try {
                    DetalleFactura detalle = recuperarDetalle(idFactura, tipoConcepto, idConcepto, idDescuento, idImpuesto);
                    FacturaRepositorio facturaRepo = new FacturaRepositorio();
                    facturaRepo.eliminarDetalle(detalle);
                    request.getSession().setAttribute("detalle", null);
                    ir(request, response, "paginas/facturas/registrarFactura.jsp");
                } catch (Exception ex) {
                    ir(request, response, "paginas/facturas/registrarFactura.jsp");
                    ex.printStackTrace();
                }
            }

            if (submit != null && (submit.equals("Guardar Factura") || submit.equals("Actualizar Factura") || submit.equals("Anular Factura") || submit.equals("+"))) {

                Factura factura = recuperarFactura(idFactura, idCita, fecha, idMetodoPago, subTotal, total, usuario.getUsuario());
                if (submit.equals("+")) {
                    try {
                        DetalleFactura detalle = recuperarDetalle(idFactura, tipoConcepto, idConcepto, idDescuento, idImpuesto);
                        FacturaRepositorio facturaRepo = new FacturaRepositorio();

                        int apertura = 0;
                        if (request.getSession().getAttribute("apertura") != null) {
                            apertura = (Integer) request.getSession().getAttribute("apertura");
                        }
                        if (apertura == 0) {
                            facturaRepo.abrirFactura(factura);
                            request.getSession().setAttribute("apertura", 1);
                        }

                        facturaRepo.crearDetalle(detalle);
                        factura.setSubtotal(facturaRepo.getSubTotal(factura));
                        factura.setTotal(facturaRepo.getTotal(factura));
                        request.getSession().setAttribute("detalle", null);
                        request.getSession().setAttribute("factura", factura);

                        ir(request, response, "paginas/facturas/registrarFactura.jsp");
                    } catch (Exception ex) {
                        ir(request, response, "paginas/facturas/registrarFactura.jsp");
                        ex.printStackTrace();
                    }
                }

                if (accion.equals(servletConfiguracion.ACCION_NUEVO) && submit.equals("Guardar Factura")) {
                    try {
                        if (factura.getIdFactura() != 0) {
                            FacturaRepositorio facturaRepo = new FacturaRepositorio();
                            facturaRepo.cerrarFactura(factura);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/facturas/registrarFactura.jsp");
                        }
                        request.getSession().setAttribute("factura", null);
                        request.getSession().setAttribute("detalle", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/facturas/registrarFactura.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Anular Factura")) {
                    try {
                        if (factura.getIdFactura() != 0) {
                            FacturaRepositorio facturaRepo = new FacturaRepositorio();
                            facturaRepo.anularFactura(factura);
                            String msExito = "Registro anulado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/facturas/actualizarFactura.jsp");
                        }
                        request.getSession().setAttribute("factura", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/facturas/actualizarFactura.jsp");
                        ex.printStackTrace();
                    }

                }

            } else {

                Factura factura1 = recuperarFactura(idFactura, idCita, fecha, idMetodoPago, subTotal, total, usuario.getUsuario());
                FacturaRepositorio facturaRepo = new FacturaRepositorio();
                DetalleFactura detalle = recuperarDetalle(idFactura, tipoConcepto, idConcepto, idDescuento, idImpuesto);
                factura1.setSubtotal(facturaRepo.getSubTotal(factura1));
                factura1.setTotal(facturaRepo.getTotal(factura1));

                request.getSession().setAttribute("factura", factura1);
                request.getSession().setAttribute("detalle", detalle);

                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    ir(request, response, "paginas/facturas/registrarFactura.jsp");
                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {
                    ir(request, response, "paginas/facturas/actualizarFactura.jsp");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Factura recuperarFactura(String idFactura, String idCita, String fecha, String idMetodoPago, String subTotal, String total, String usuario) {
        Factura factura = new Factura();
        try {
            Date fechaDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fecha != null && fecha.equals("") == false) {
                fechaDate = format.parse(fecha);
            }

            int id = 0;
            if (idFactura != null && idFactura.equals("") == false) {
                id = Integer.parseInt(idFactura);
            }

            int idCit = 0;
            if (idCita != null && idCita.equals("") == false) {
                idCit = Integer.parseInt(idCita);
            }

            int idMetodo = 0;
            if (idMetodoPago != null && idMetodoPago.equals("") == false) {
                idMetodo = Integer.parseInt(idMetodoPago);
            }

            double subt = 0;
            if (subTotal != null && subTotal.equals("") == false) {
                subt = Double.parseDouble(subTotal);
            }

            double tot = 0;
            if (total != null && total.equals("") == false) {
                tot = Double.parseDouble(total);
            }

            factura.setIdFactura(id);
            factura.setIdCita(idCit);
            factura.setFechaFactura(fechaDate);
            factura.setIdMetodoPago(idMetodo);
            factura.setSubtotal(subt);
            factura.setTotal(tot);
            factura.setUsuario(usuario);
        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return factura;
    }

    private DetalleFactura recuperarDetalle(String idFactura, String tipo, String idConcepto, String idDescuento, String idImpuesto) {
        DetalleFactura detalle = new DetalleFactura();
        try {
            int id = 0;
            if (idFactura != null && idFactura.equals("") == false) {
                id = Integer.parseInt(idFactura);
            }

            int idTipo = 0;
            if (tipo != null && tipo.equals("") == false) {
                idTipo = Integer.parseInt(tipo);
            }

            int idConc = 0;
            if (idConcepto != null && idConcepto.equals("") == false) {
                idConc = Integer.parseInt(idConcepto);
            }

            int idDesc = 0;
            if (idDescuento != null && idDescuento.equals("") == false) {
                idDesc = Integer.parseInt(idDescuento);
            }

            int idImp = 0;
            if (idImpuesto != null && idImpuesto.equals("") == false) {
                idImp = Integer.parseInt(idImpuesto);
            }

            detalle.setIdFactura(id);
            detalle.setTipo(idTipo);
            detalle.setIdConcepto(idConc);
            detalle.setIdDescuento(idDesc);
            detalle.setIdImpuesto(idImp);

        } catch (Exception e) {
            //crar redireccionamiento a otra pagina de error
        }
        return detalle;
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
