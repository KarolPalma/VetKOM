<%-- 
    Document   : registrarCita
    Created on : Jul 23, 2020, 10:16:18 AM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.CitaRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Cita"%>
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
        <title>Registrar Cita</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <%
        controladorDatosBD cL = new controladorDatosBD();
        
        Cita cit = new Cita();
        if (request.getSession().getAttribute("cita") != null) {
            cit = (Cita) request.getSession().getAttribute("cita");
        }

        CitaRepositorio cR = new CitaRepositorio();
        int numero = 0;
        if (cR.getIdentity() != 0) {
            numero = cR.getIdentity();
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

        <div class="principal">
            <div class="formulario">
                <center><h2>Registrar Cita</h2></center>
                <form name="formulario" action="../../controladorCitas" method="POST">
                    <input type="text"  name="accion" value="nuevo" hidden="true"/>
                    <label> No. Cita: </label>
                    <input type="number"  name="idCita"readonly="true" value="<%if (cit.getIdCita() != 0) {out.print(cit.getIdCita());} else {out.print(numero);}%>"/><br>
                    <label> Cliente: </label>
                    <select name="idDuenio" onchange="formulario.submit()">
                        <%out.print(cL.getOpcionesClienteDuenio(cit.getIdDuenio()));%>
                    </select><br>
                    <label> Mascota: </label>
                    <select name="idAnimal" required="true">
                        <option value="">Debe seleccionar al Dueño</option>
                        <%out.print(cL.getOpcionesAnimales(cit.getIdDuenio(), cit.getIdAnimal()));%>
                    </select><br>
                    <label> Cita para: </label>
                    <select name="idServicio" required="true" onchange="formulario.submit()">
                        <%out.print(cL.getOpcionesServicios(cit.getIdServicioSolicitado()));%>
                    </select><br>
                    <label> Empleado responsable: </label>
                    <select name="idEmpleado" required="true">
                        <%out.print(cL.getOpcionesPersonal(cit.getIdServicioSolicitado(), cit.getIdEmpleado()));%>
                    </select><br>

                    <label> Fecha de la Cita: </label>
                    <input type="date" name="fechaCita" required="true" value='<%
                        if (cit.getFechaCita() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(cit.getFechaCita());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Hora de la Cita: </label>
                    <input type="time" name="horaCita" min="09:00" max="18:00" required="true" value="<%
                        if (cit.getHoraCita() != null && cit.getHoraCita().equals("") == false) {
                            out.print(cit.getHoraCita());
                        }%>"><br>

                    <label> No. Sala: </label>
                    <input type="number"  name="noSala" required="true" value="<%if (cit.getNoSala() != 0) {out.print(cit.getNoSala());}%>"/><br>
                    <label> Estado: </label>
                    <select name="idEstado" required="true" >
                        <%out.print(cL.getOpcionesEstados(cit.getIdEstado()));%>
                    </select><br>

                    <label> Observaciones: </label>
                    <textarea rows="4" cols="50"  name="observaciones"><%if (cit.getObservaciones() != null) {out.print(cit.getObservaciones());}%>
                    </textarea><br>

                    <input class='boton' name="insert" type="submit" value="Guardar Cita" name="enviar" />

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
