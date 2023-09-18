<%-- 
    Document   : buscador
    Created on : Jul 16, 2020, 12:16:33 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorPrincipal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/Logo.ico"> <!--Icono del SitioWeb-->
        <link rel="shortcut icon" type="image/x-icon" href="../imagenes/Logo.ico"> <!--Icono del SitioWeb-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="../estilos/menuPrincipal.css">
        <link rel="stylesheet" href="../estilos/buscador.css">
        <title>Buscador</title>
    </head>
    <!--Desde la pantalla anterior se le debe redireccionar con un action="" de lo que se quiere buscar, ejemplo action="Empleado" e igual debe devolverlo luego de realizar la busqueda-->

    <%
        String action = (String) request.getParameter("action");
        if (action != null) {
            request.getSession().setAttribute("action", action);
        } else {
            action = (String) request.getSession().getAttribute("action");
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
    
    <body>

        <header class="encabezado">
            <div class="encabezadoMenu">
                <nav class="menu">
                    <a href="../menuPrincipal.jsp"><img class="logoMenu" src="../imagenes/Logo2.png"></a>

                    <a class="empleadoMenu" href="usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><p class="empleadoMenu"><%=empleadoSesion.getNombres()%></p></a>

                    <a href="usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><img class="perfilMenu" ></a>

                    <ul>
                        <li><a href="../menuPrincipal.jsp">Inicio</a></li>
                        <li><p>Citas</p>
                            <ul>
                                <li><a href="../paginas/citas/registrarCita.jsp">Crear Cita</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Cita">Buscar Cita</a></li>
                            </ul>
                        </li>
                        <li><p>Facturas</p>
                            <ul>
                                <li><a href="../paginas/facturas/registrarFactura.jsp">Crear Factura</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Factura">Buscar Factura</a></li>
                            </ul>
                        </li>
                        <li><p>Animales</p>
                            <ul>
                                <li><a href="../paginas/animales/registrarAnimal.jsp">Registrar Animal</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Animal">Buscar Animal</a></li>
                            </ul>
                        </li>
                        <li><p>Clientes</p>
                            <ul>
                                <li><a href="../paginas/clientes/registrarCliente.jsp">Registrar Cliente</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Cliente">Buscar Cliente</a></li>
                            </ul>
                        </li>
                        <li><p>Productos</p>
                            <ul>
                                <li><a href="../paginas/productos/registrarProducto.jsp">Crear Producto</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Producto">Buscar Producto</a></li>
                            </ul>
                        </li>
                        <li><p>Servicios</p>
                            <ul>
                                <li><a href="../paginas/servicios/registrarServicio.jsp">Registrar Servicio</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Servicio">Buscar Servicio</a></li>
                            </ul>
                        </li>
                        <li><p>Usuarios</p>
                            <ul>
                                <li><a href="../paginas/usuarios/registrarUsuario.jsp">Crear Usuario</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Usuario">Buscar Usuario</a></li>
                            </ul>
                        </li>
                        <li><p>Empleados</p>
                            <ul>
                                <li><a href="../paginas/empleados/registrarEmpleado.jsp">Registrar Empleado</a></li>
                                <li><a href="../paginas/buscador.jsp?action=Empleado">Buscar Empleado</a></li>
                            </ul>
                        </li>
                        <li><p>▼</p>
                            <ul>
                                <li><a href="usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>">Ver Perfil</a></li>
                                <li><a href="../cerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul> 
                </nav>
            </div>
        </header>

        <div class="principal">
            <div class="buscador">
                <center><h2>Buscar <%=action%></h2></center>
                <div class="formulario">
                    <form>
                        <input class="filtro" type="text" name="filtro"/>
                        <input class='boton' type="submit" value="Buscar"/><br>
                    </form>
                </div>
                <%
                    controladorPrincipal cP = new controladorPrincipal();
                    String filtro = request.getParameter("filtro");
                    if (filtro != null) {
                        out.print(cP.getTablaFromBuscador(filtro, action) + "</table>");
                    }
                %>
            </div>
        </div>

        <footer style="bottom: 0">
            <a href="../menuPrincipal.jsp"><img class="imagenFooter" src="../imagenes/Logo2.png" alt="Logo de el Footer"><br></a>
            <p>© 2020 Universidad Tecnológica de Honduras © VetKOM</p>
            <p class="contactanos">Contáctanos: <br> +504 9837-9065,<br> +504 9880-3121</p>
        </footer>
    </body>
</html>
