<%-- 
    Document   : actualizarAnimal
    Created on : 07-21-2020, 02:56:58 PM
    Author     : karol
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.AnimalRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Animal"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <link rel="stylesheet" href="../../estilos/tooltip.css">
        <title>Actualizar Animal</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <body>
        <%
            String idAnimal = request.getParameter("idAnimal");
            Animal animal = new Animal();
            if (idAnimal != null && idAnimal.equals("") == false) {
                AnimalRepositorio aN = new AnimalRepositorio();
                int id = Integer.parseInt(idAnimal);
                animal = aN.buscar(id);
            }

            controladorDatosBD cL = new controladorDatosBD();
            int idEspecie = 0;
            int idRaza = 0;

            Animal ani = new Animal();
            if (request.getSession().getAttribute("animal") != null) {
                ani = (Animal) request.getSession().getAttribute("animal");
            }

            if (request.getSession().getAttribute("idEspecie") != null && request.getSession().getAttribute("idEspecie").equals("") == false) {
                String especie = String.valueOf(request.getSession().getAttribute("idEspecie"));
                idEspecie = Integer.valueOf(especie);
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
                <center><h2>Actualizar Animal</h2></center>
                <form name="formulario" action="../../controladorAnimales" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> No.Animal: </label>
                    <input type="number"  name="idAnimal"readonly="true" value="<%if (ani.getIdAnimal() != 0) {out.print(ani.getIdAnimal());} else {out.print(animal.getIdAnimal());}%>"/><br>
                    <label> Nombre: </label>
                    <input type="text"  name="nombreAnimal" required="true" maxlength="50" value='<%if (ani.getNombre() != null) {out.print(ani.getNombre());} else {out.print(animal.getNombre());}%>'/><br>
                    <label> Especie </label>
                    <select name="especie" onchange="formulario.submit()">
                        <option value="">Debe seleccionar una Especie</option>
                        <%out.print(cL.getOpcionesEspecies(idEspecie));%>
                    </select><br>
                    <label> Raza: </label>
                    <select name="razaAnimal" required="true">
                        <option value="">Debe seleccionar una Especie</option>
                        <%if (idEspecie != 0) {
                                out.print(cL.getOpcionesRaza(idEspecie, idRaza));
                            } else {
                                out.print(cL.getRaza(animal.getIdRaza()));
                            }%>
                    </select><br>


                    <label> Dueno del Animal: </label>
                    <select name="clienteDuenio" required="true" >
                        <%if (ani.getIdClienteDuenio() != null && ani.getIdClienteDuenio() != "") {
                                out.print(cL.getOpcionesClienteDuenio(ani.getIdClienteDuenio()));
                            } else {
                                out.print(cL.getOpcionesClienteDuenio(animal.getIdClienteDuenio()));
                            }%> 
                    </select><br>
                    <label> Fecha de Nacimiento: </label>
                    <input type="date" name="fechaNacimientoAnimal" required="true" value='<%
                        if (ani.getFechaNacimiento() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(ani.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(animal.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Tipo de Sangre: </label>
                    <input type="text"  name="tipoSangre" required="true" maxlength="50" value='<%if (ani.getTipoSangre() != null) {out.print(ani.getTipoSangre());} else {out.print(animal.getTipoSangre());}%>'/><br>
                    <label> Genero: </label>
                    <select name="genero" required="true">
                        <%if (ani.getIdGenero() != 0) {
                                out.print(cL.getOpcionesGeneros(ani.getIdGenero()));
                            } else {
                                out.print(cL.getOpcionesGeneros(animal.getIdGenero()));
                            }%>
                    </select><br>
                    <label> Color: </label>
                    <select name="color" required="true">
                        <%if (ani.getIdColor() != 0) {
                                out.print(cL.getOpcionesColores(ani.getIdColor()));
                            } else {
                                out.print(cL.getOpcionesColores(animal.getIdColor()));
                            }%>
                    </select><br>  
                    <label> Esterilizado </label>
                    <select name="esterilizado" required="true">
                        <option value="1" <%if (ani.getEsterilizado() == 1) {out.print("selected");}%>> Si </option>
                        <option value="2" <%if (ani.getEsterilizado() == 0) {out.print("selected");}%>> No </option>
                    </select><br>

                    <label> Ruta de su fotografia: </label>
                    <input type="text"  name="rutaFoto" maxlength="100" value='<%if (ani.getRutaFoto() != null) {
                            out.print(ani.getRutaFoto());
                        } else {
                            if (animal.getRutaFoto() != null) {
                                out.print(animal.getRutaFoto());
                            }
                        }%>'/><br>

                    <label> Observaciones: </label> 
                    <textarea rows="4" cols="50"  name="observaciones"><%if (ani.getObservaciones() != null) {
                            out.print(ani.getObservaciones());
                        } else {
                            if (animal.getObservaciones() != null) {
                                out.print(animal.getObservaciones());
                            }
                        }%>
                    </textarea><br>

                    <br>

                    <input class='boton' name="insert" type="submit" value="Actualizar Animal" name="enviar" />
                    <input class='boton' name="insert" type="submit" value="Desactivar Animal" name="enviar" />

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
