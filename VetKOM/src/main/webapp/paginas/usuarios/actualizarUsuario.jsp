<%-- 
    Document   : actualizarUsuario
    Created on : Jul 22, 2020, 2:08:40 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="java.time.Instant"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.UsuarioRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
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
        <title>Actualizar Usuario</title>
    </head>
    <body>
        <%
            String idUsuario = request.getParameter("idUsuario");
            Usuario usuario = new Usuario();
            if (idUsuario != null && idUsuario.equals("") == false) {
                UsuarioRepositorio uR = new UsuarioRepositorio();
                usuario = uR.buscar(idUsuario);
            }

            controladorDatosBD cL = new controladorDatosBD();
            Usuario us = new Usuario();
            if (request.getSession().getAttribute("usuario") != null) {
                us = (Usuario) request.getSession().getAttribute("usuario");
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

        <script type="text/javascript">
            history.forward();
        </script>
        
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
                                <li><a href="../../cerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul> 
                </nav>
            </div>
        </header>

        <div style="margin-top: 15%;" class="principal">
            <div class="formulario">
                <center><h2>Actualizar Usuario</h2></center>
                <form name="formulario" action="../../controladorUsuarios" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> Usuario: </label>
                    <input type="text"  name="idUsuario" required="true" value="<%if (us.getUsuario() != null) {out.print(us.getUsuario());} else {out.print(usuario.getUsuario());}%>"/><br>
                    <label> Empleado: </label>
                    <select name="idEmpleado">
                        <%if (us.getIdEmpleado() != 0) {
                                out.print(cL.getOpcionesJefes(us.getIdEmpleado()));
                            } else {
                                out.print(cL.getOpcionesJefes(usuario.getIdEmpleado()));
                            }%>
                    </select><br>
                    <label> Clave: </label>
                    <input type="password"  name="clave" required="true"  maxlength="50" value='<%if (us.getClave() != null) {out.print(us.getClave());} else {out.print(usuario.getClave());}%>'/><br>
                    <label> Fecha de Registro: </label>
                    <input type="date" name="fechaRegistro" readonly="true" value='<%
                        if (us.getFechaRegistro() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(us.getFechaRegistro());
                            out.print(fechaFinalDate);
                        } else {
                            if (usuario.getFechaRegistro() != null) {
                                String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(usuario.getFechaRegistro());
                                out.print(fechaFinalDate);
                            }
                        }
                           %>'/><br>
                    <label> Fecha de Última Actualización: </label>
                    <input type="date" name="fechaModificacion" readonly="true" value='<%
                        if (us.getFechaModificacion() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(us.getFechaModificacion());
                            out.print(fechaFinalDate);
                        } else {
                            if (usuario.getFechaModificacion() != null) {
                                String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(usuario.getFechaModificacion());
                                out.print(fechaFinalDate);
                            }
                        }
                           %>'/><br>

                    <input class='boton' name="insert" type="submit" value="Actualizar Usuario" name="enviar" />
                    <input class='boton' name="insert" type="submit" value="Desactivar Usuario" name="enviar" />

                </form>
            </div>
        </div>

        <footer style="bottom: 0">
            <a href="../../menuPrincipal.jsp"><img class="imagenFooter" src="../../imagenes/Logo2.png" alt="Logo de el Footer"><br></a>
            <p>© 2020 Universidad Tecnológica de Honduras © VetKOM</p>
            <p class="contactanos">Contáctanos: <br> +504 9837-9065,<br> +504 9880-3121</p>
        </footer> 
    </body>
</html>
