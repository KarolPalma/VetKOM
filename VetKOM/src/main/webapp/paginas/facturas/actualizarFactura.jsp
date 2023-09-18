<%-- 
    Document   : actualizarFactura
    Created on : Jul 29, 2020, 3:30:30 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorPrincipal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.FacturaRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Factura"%>
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
        <title>Ver Factura</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <body>
        <%
            String idFactura = request.getParameter("idFactura");
            controladorPrincipal controladorDetalle = new controladorPrincipal();
            Factura factura = new Factura();
            if (idFactura != null && idFactura.equals("") == false) {
                FacturaRepositorio fR = new FacturaRepositorio();
                int id = Integer.parseInt(idFactura);
                factura = fR.buscar(id);
            }

            controladorDatosBD cL = new controladorDatosBD();
            Factura fac = new Factura();
            if (request.getSession().getAttribute("factura") != null) {
                fac = (Factura) request.getSession().getAttribute("factura");
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

        <div class="principal">
            <div class="formulario">
                <center><h2>Actualizar Factura</h2></center>
                <form name="formulario" action="../../controladorFacturas" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> No. Factura: </label>
                    <input type="number"  required="true" readonly="true" name="idFactura" value="<%if (fac.getIdFactura() != 0) {out.print(fac.getIdFactura());} else {out.print(factura.getIdFactura());}%>"/><br>
                    <label> No. Cita: </label>
                    <select name="idCita" disabled="true" >
                        <%if (fac.getIdCita() != 0) {
                                out.print(cL.getOpcionesCitasTodas(fac.getIdCita()));
                            } else {
                                out.print(cL.getOpcionesCitasTodas(factura.getIdCita()));
                            }%>
                    </select><br>

                    <label> Fecha de la Factura: </label>
                    <input type="date" name="fechaFactura" required="true" readonly="true" value='<%
                        if (fac.getFechaFactura() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(fac.getFechaFactura());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(factura.getFechaFactura());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>

                    <label> Método de Pago: </label>
                    <select name="idMetodoPago" required="true" disabled="true" >
                        <%if (fac.getIdMetodoPago() != 0) {
                                 out.print(cL.getOpcionesMetodosPago(fac.getIdMetodoPago()));
                             } else {
                                 out.print(cL.getOpcionesMetodosPago(factura.getIdMetodoPago()));
                             }%>
                    </select><br>

                    <label> Detalles: </label>
                    <center class="detalles">
                        <%if (fac.getIdFactura() != 0) {
                                out.print(controladorDetalle.verTablaDetalles(fac.getIdFactura(), fac.getFechaFactura()));
                            } else {
                                out.print(controladorDetalle.verTablaDetalles(factura.getIdFactura(), factura.getFechaFactura()));
                            }%>
                        <%out.print("</table>");%>
                    </center><br>

                    <label> SubTotal: </label>
                    <input type="number" name="subTotal" placeholder="1.00" step="0.01" min="1" required="true" readonly="true" value='<%if (fac.getSubtotal() != 0) {out.print(fac.getSubtotal());} else {out.print(factura.getSubtotal());}%>'/><br>
                    <p class="lempira"> L. </p>
                    <label> Total: </label>
                    <input type="number" name="total" placeholder="1.00" step="0.01" min="1" required="true" readonly="true" value='<%if (fac.getTotal() != 0) {out.print(fac.getTotal());} else {out.print(factura.getTotal());}%>'/><br>
                    <p class="lempira"> L. </p>
                    <input class='boton' name="insert" type="submit" value="Anular Factura"/>

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
