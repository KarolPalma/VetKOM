<%-- 
    Document   : registrarFactura
    Created on : Jul 28, 2020, 8:48:58 AM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.DetalleFactura"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorPrincipal"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.FacturaRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Factura"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="../../imagenes/Logo.ico"> <!--Icono del SitioWeb-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../../estilos/menuPrincipal.css">
        <link rel="stylesheet" href="../../estilos/registro.css">
        <title>Crear Factura</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <%
        controladorDatosBD cL = new controladorDatosBD();
        controladorPrincipal controladorDetalle = new controladorPrincipal();

        Factura fac = new Factura();
        DetalleFactura det = new DetalleFactura();
        if (request.getSession().getAttribute("factura") != null) {
            fac = (Factura) request.getSession().getAttribute("factura");
        }
        if (request.getSession().getAttribute("detalle") != null) {
            det = (DetalleFactura) request.getSession().getAttribute("detalle");
        }

        FacturaRepositorio fR = new FacturaRepositorio();
        int numero = 0;
        if (fR.getIdentity() != 0) {
            numero = fR.getIdentity();
        }

        Empleado empleadoSesion = new Empleado();
        if (request.getSession().getAttribute("empleadoSesion") != null) {
            empleadoSesion = (Empleado) request.getSession().getAttribute("empleadoSesion");
        }
        Usuario usuarioSesion = new Usuario();
        if (request.getSession().getAttribute("usuarioSesion") != null) {
            usuarioSesion = (Usuario) request.getSession().getAttribute("usuarioSesion");
        }
    %>
    <body>
        <header class="encabezado">
            <div class="encabezadoMenu">
                <nav class="menu">
                    <a href="../../menuPrincipal.jsp"><img class="logoMenu" src="../../imagenes/Logo2.png"></a>
                    <a class="empleadoMenu" href="../../paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><p class="empleadoMenu"><%=empleadoSesion.getNombres()%></p></a>
                    <a href="../../paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><img class="perfilMenu" ></a>
                    <ul>
                        <li><a href="../../menuPrincipal.jsp">Inicio</a></li>
                        <li><p>Citas</p>
                            <ul>
                                <li><a href="../../paginas/citas/registrarCita.jsp">Crear Cita</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Cita">Buscar Cita</a></li>
                            </ul>
                        </li>
                        <li><p>Facturas</p>
                            <ul>
                                <li><a href="../../paginas/facturas/registrarFactura.jsp">Crear Factura</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Factura">Buscar Factura</a></li>
                            </ul>
                        </li>
                        <li><p>Animales</p>
                            <ul>
                                <li><a href="../../paginas/animales/registrarAnimal.jsp">Registrar Animal</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Animal">Buscar Animal</a></li>
                            </ul>
                        </li>
                        <li><p>Clientes</p>
                            <ul>
                                <li><a href="../../paginas/clientes/registrarCliente.jsp">Registrar Cliente</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Cliente">Buscar Cliente</a></li>
                            </ul>
                        </li>
                        <li><p>Productos</p>
                            <ul>
                                <li><a href="../../paginas/productos/registrarProducto.jsp">Crear Producto</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Producto">Buscar Producto</a></li>
                            </ul>
                        </li>
                        <li><p>Servicios</p>
                            <ul>
                                <li><a href="../../paginas/servicios/registrarServicio.jsp">Registrar Servicio</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Servicio">Buscar Servicio</a></li>
                            </ul>
                        </li>
                        <li><p>Usuarios</p>
                            <ul>
                                <li><a href="../../paginas/usuarios/registrarUsuario.jsp">Crear Usuario</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Usuario">Buscar Usuario</a></li>
                            </ul>
                        </li>
                        <li><p>Empleados</p>
                            <ul>
                                <li><a href="../../paginas/empleados/registrarEmpleado.jsp">Registrar Empleado</a></li>
                                <li><a href="../../paginas/buscador.jsp?action=Empleado">Buscar Empleado</a></li>
                            </ul>
                        </li>
                        <li><p>▼</p>
                            <ul>
                                <li><a href="../../paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>">Ver Perfil</a></li>
                                <li><a href="../../index.jsp">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul> 
                </nav>
            </div>
        </header>

        <div style="margin-left: 10%; margin-right: 10%;" class="principal">
            <div class="formulario">
                <center><h2>Registrar Factura</h2></center>
                <form name="formulario" action="../../controladorFacturas" method="POST">
                    <input type="text"  name="accion" value="nuevo" hidden="true"/>
                    <label> No. Factura: </label>
                    <input type="number"  readonly="true" required="true" name="idFactura" value="<%if (fac.getIdFactura() != 0) {out.print(fac.getIdFactura());} else {out.print(numero);}%>"/><br>
                    <label> No. Cita: </label>
                    <select name="idCita" required="true" >
                        <%out.print(cL.getOpcionesCitas(fac.getIdCita()));%>
                    </select><br>
                    <label> Fecha de la Factura: </label>
                    <input type="date" name="fechaFactura" required="true" readonly="true" value='<%
                        if (fac.getFechaFactura() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(fac.getFechaFactura());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(Instant.now()));
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>

                    <label> Método de Pago: </label>
                    <select name="idMetodoPago" required="true" >
                        <%out.print(cL.getOpcionesMetodosPago(fac.getIdMetodoPago()));%>
                    </select><br>

                    <div>
                        <label> Detalles: </label>
                        <%if (fac.getIdFactura() != 0) {
                                out.print(controladorDetalle.getTablaDetalles(fac.getIdFactura(), Date.from(Instant.now())));
                            } else {
                                out.print(controladorDetalle.getTablaDetalles(numero, Date.from(Instant.now())));
                            }
                            out.print("<tr><td> Tipo de concepto: </td>");
                            out.print("<td> Descripción: </td>");
                            out.print("<td></td>");
                            out.print("<td> Impuesto: </td>");
                            out.print("<td> Descuento: </td></tr>");

                            out.print("<tr><td>");%>
                        
                        <select name="tipoConcepto" onchange="formulario.submit()">
                            <option value="1" <%if (det.getTipo() == 1) {out.print("selected");}%>>Producto</option>
                            <option value="2" <%if (det.getTipo() == 2) {out.print("selected");}%>>Servicio</option>
                        </select>
                        
                            <%out.print("</td>");%>
                            <%out.print("<td>");%>
                            
                        <select name="idConcepto" onchange="formulario.submit()">
                            <option value="">Debe seleccionar un tipo de concepto</option>
                            <%
                                if (det.getTipo() != 0) {
                                    out.print(cL.getOpcionesConceptos(det.getTipo(), det.getIdConcepto()));
                                }
                            %>
                        </select>
                        
                            <%out.print("</td>");%>
                            <%out.print("<td></td>");%>
                            <%out.print("<td>");%>
                        
                        <select name="idImpuesto" required="true">
                            <%out.print(cL.getOpcionesImpuestos(det.getIdImpuesto()));%>
                        </select>
                        
                            <%out.print("</td>");%>
                            <%out.print("<td>");%>
                            
                        <select name="idDescuento" required="true">
                            <%out.print(cL.getOpcionesDescuentos(det.getIdDescuento()));%>
                        </select>
                        
                            <%out.print("</td>");%>
                            <%out.print("<td>");%>

                        <input class='botonDetalle' name="insert" type="submit" value="+"/><br>

                        <%out.print("</td>");%>
                        <%out.print("</tr>");%>
                        <%out.print("</table>");%>
                    </div><br>

                    <label> SubTotal: </label>
                    <input type="number" name="subTotal" placeholder="1.00" step="0.01" min="1" required="true" readonly="true" value='<%if (fac.getSubtotal() != 0) {out.print(fac.getSubtotal());}%>'/><br>
                    <p class="lempira"> L. </p>

                    <label> Total: </label>
                    <input type="number" name="total" placeholder="1.00" step="0.01" min="1" required="true" readonly="true" value='<%if (fac.getTotal() != 0) {out.print(fac.getTotal());}%>'/><br>
                    <p class="lempira"> L. </p>

                    <input class='boton' name="insert" type="submit" value="Guardar Factura" />

                </form>
            </div>
        </div>

        <footer>
            <a href="../../menuPrincipal.jsp"><img class="imagenFooter" src="../../imagenes/Logo2.png" alt="Logo de el Footer"><br></a>
            <p>© 2020 Universidad Tecnológica de Honduras © VetKOM</p>
            <p class="contactanos">Contáctanos: <br> +504 9837-9065,<br> +504 9880-3121</p>
        </footer>   
    </body>
</html>