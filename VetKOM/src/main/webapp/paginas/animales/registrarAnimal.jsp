<%-- 
    Document   : registrarAnimal
    Created on : 07-21-2020, 02:57:12 PM
    Author     : karol
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.AnimalRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Animal"%>
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
        <title>Registrar Animal</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <%
        controladorDatosBD cL = new controladorDatosBD();
        
        Animal ani = new Animal();
        if (request.getSession().getAttribute("animal") != null) {
            ani = (Animal) request.getSession().getAttribute("animal");
        }
        int idEspecie = 0;
        int idRaza = 0;
        int idColor = 0;
        String idClienteDuenio = "";

        if (request.getSession().getAttribute("idEspecie") != null && request.getSession().getAttribute("idEspecie").equals("") == false) {
            String especie = String.valueOf(request.getSession().getAttribute("idEspecie"));
            idEspecie = Integer.valueOf(especie);
        }
        if (request.getSession().getAttribute("idRaza") != null && request.getSession().getAttribute("idRaza").equals("") == false) {
            String raza = String.valueOf(request.getSession().getAttribute("idRaza"));
            idRaza = Integer.valueOf(raza);
        }
        if (request.getSession().getAttribute("idColor") != null && request.getSession().getAttribute("idColor").equals("") == false) {
            String color = String.valueOf(request.getSession().getAttribute("idColor"));
            idColor = Integer.valueOf(color);
        }
        if (request.getSession().getAttribute("idClienteDuenio") != null && request.getSession().getAttribute("idClienteDuenio").equals("") == false) {
            String clienteDuenio = String.valueOf(request.getSession().getAttribute("idClienteDuenio"));
            idClienteDuenio = (clienteDuenio);
        }
        AnimalRepositorio aN = new AnimalRepositorio();
        int numero = 0;
        if (aN.getIdentity() != 0) {
            numero = aN.getIdentity();
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
                <center><h2>Registrar Animal</h2></center>
                <form name="formulario" action="../../controladorAnimales" method="POST">
                    <input type="text"  name="accion" value="nuevo" hidden="true"/>
                    <label> No.Animal: </label>
                    <input type="number"  name="idAnimal" readonly="true" value="<%if (ani.getIdAnimal() != 0) {out.print(ani.getIdAnimal());} else {out.print(numero);}%>"/><br>
                    <label> Nombre: </label>
                    <input type="text"  name="nombreAnimal" required="true" maxlength="50" value='<%if (ani.getNombre() != null) {out.print(ani.getNombre());}%>'/><br>   
                    <label> Especie: </label>
                    <select name="especie" required="true" onchange="formulario.submit()">
                        <option value="">Debe seleccionar una Especie</option>
                        <%out.print(cL.getOpcionesEspecies(idEspecie));%>
                    </select><br>
                    <label> Raza: </label>
                    <select name="razaAnimal" required="true">
                        <option value="">Debe seleccionar una Especie</option>
                        <%out.print(cL.getOpcionesRaza(idEspecie, idRaza));%>
                    </select><br>
                    <label> Dueno del Animal: </label>
                    <select name="clienteDuenio" required="true" >
                        <option value="">Debe seleccionar un Dueño</option>
                        <%out.print(cL.getOpcionesClienteDuenio(idClienteDuenio));%>
                    </select><br>
                    <label> Fecha de Nacimiento: </label>
                    <input type="date" name="fechaNacimientoAnimal" required="true" value='<%
                        if (ani.getFechaNacimiento() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(ani.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        }%>'/><br>
                    <label> Tipo de Sangre: </label>
                    <input type="text"  name="tipoSangre" required="true" maxlength="50" value='<%if (ani.getTipoSangre() != null) {out.print(ani.getTipoSangre());}%>'/><br>
                    <label> Genero: </label>
                    <select name="genero" required="true">
                        <option value="">Debe seleccionar un Genero</option>
                        <%out.print(cL.getOpcionesGeneros(idEspecie));%>
                    </select><br>
                    <label> Color: </label>
                    <select name="color" required="true">
                        <option value="">Debe seleccionar un Color</option>
                        <%out.print(cL.getOpcionesColores(idColor));%>
                    </select><br>
                    <label> Esterilizado </label>
                    <select name="esterilizado" required="true">
                        <option value="">Debe seleccionar una Opción</option>
                        <option value="1">Si</option>
                        <option value="2">No</option>
                    </select><br>
                    <label> Ruta de su fotografia: </label>
                    <input type="text"  name="rutaFoto" maxlength="100" value=''/><br>
                    <label> Observaciones: </label>
                    <textarea rows="4" cols="50"  name="observaciones"></textarea><br>
                    <br>
                    <input class='boton' name="insert" type="submit" value="Guardar Animal" name="enviar" />

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
