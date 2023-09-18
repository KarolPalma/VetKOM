<%-- 
    Document   : actualizarCliente
    Created on : Jul 20, 2020, 4:21:49 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.ClienteRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Cliente"%>
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
        <title>Actualizar Cliente</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <body>
        <%
            String idCliente = request.getParameter("idCliente");
            Cliente cliente = new Cliente();
            if (idCliente != null && idCliente.equals("") == false) {
                ClienteRepositorio eR = new ClienteRepositorio();
                String id = idCliente;
                cliente = eR.buscar(id);
            }

            controladorDatosBD cL = new controladorDatosBD();
            
            Cliente cli = new Cliente();
            if (request.getSession().getAttribute("cliente") != null) {
                cli = (Cliente) request.getSession().getAttribute("cliente");
            }
            int idPais = 0;
            if (request.getSession().getAttribute("idPais") != null && request.getSession().getAttribute("idPais").equals("") == false) {
                String pais = String.valueOf(request.getSession().getAttribute("idPais"));
                idPais = Integer.valueOf(pais);
            }
            int idDepto = 0;
            if (request.getSession().getAttribute("idDepto") != null && request.getSession().getAttribute("idDepto").equals("") == false) {
                String depto = String.valueOf(request.getSession().getAttribute("idDepto"));
                idDepto = Integer.valueOf(depto);
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
                <center><h2>Actualizar Cliente</h2></center>
                <form name="formulario" action="../../controladorClientes" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> No. Identidad del Cliente: </label>
                    <input type="number"  required="true" name="idCliente" value="<%if (cli.getIdCliente() != null) {out.print(cli.getIdCliente());} else {out.print(cliente.getIdCliente());}%>"/><br>
                    <label> Nombres: </label>
                    <input type="text"  name="nombresCliente" required="true" maxlength="50" value='<%if (cli.getNombres() != null) {out.print(cli.getNombres());} else {out.print(cliente.getNombres());}%>'/><br>
                    <label> Apellidos: </label>
                    <input type="text"  name="apellidosCliente" required="true"  maxlength="50" value='<%if (cli.getApellidos() != null) {out.print(cli.getApellidos());} else {out.print(cliente.getApellidos());}%>'/><br>
                    <label> Fecha de Nacimiento: </label>
                    <input type="date" name="fechaNacimientoCliente" required="true" value='<%
                        if (cli.getFechaNacimiento() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(cli.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(cliente.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Fecha de Registro: </label>
                    <input type="date" name="fechaRegistroCliente" required="true" value='<%
                        if (cli.getFechaRegistro() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(cli.getFechaRegistro());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(cliente.getFechaRegistro());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>

                    <label> Género: </label>
                    <select name="idGeneroCliente" required="true" >
                        <%if (cli.getIdGenero() != 0) {
                                out.print(cL.getOpcionesGeneros(cli.getIdGenero()));
                            } else {
                                out.print(cL.getOpcionesGeneros(cliente.getIdGenero()));
                            }%>
                    </select><br>
                    <label> Dirección: </label>
                    <input type="text"  name="direccionCliente" required="true" maxlength="50" value='<%if (cli.getDireccion() != null) {out.print(cli.getDireccion());} else {out.print(cliente.getDireccion());}%>'/><br>

                    <label> País: </label>
                    <select name="paisCliente" onchange="formulario.submit()">
                        <%out.print(cL.getOpcionesPaises(idPais));%>
                    </select><br>

                    <label> Departamento: </label>
                    <select name="departamentoCliente" onchange="formulario.submit()">
                        <option value="">Debe seleccionar un País</option>
                        <%out.print(cL.getOpcionesDepartamentos(idPais, idDepto));%>
                    </select><br>

                    <label> Ciudad: </label>
                    <select name="ciudadCliente" required="true">
                        <option value="">Debe seleccionar un Departamento</option>
                        <%if (idDepto != 0) {
                                out.print(cL.getOpcionesCiudades(idDepto));
                            } else {
                                out.print(cL.getCiudad(cliente.getIdCiudad()));
                            }%>
                    </select><br>

                    <label> Ruta de su fotografia: </label>
                    <input type="text"  name="rutaFoto" maxlength="100" value='<%if (cli.getRutaFoto() != null) {
                            out.print(cli.getRutaFoto());
                        } else {
                            if (cliente.getRutaFoto() != null) {
                                out.print(cliente.getDireccion());
                            }
                        }%>'/><br>

                    <div class="tooltip">
                        <label> Teléfonos: </label>
                        <span class="tooltiptext">Ingresar varios teléfonos, separados por comas (,)</span>
                        <input type="text"  name="telefonos" value='<%if (cli.getTelefonos() != null) {
                                out.print(cli.getTelefonos());
                            } else {
                                if (cliente.getTelefonos() != null) {
                                    out.print(cliente.getTelefonos());
                                }
                            }%>'/><br>
                    </div>
                    <br>

                    <input class='boton' name="insert" type="submit" value="Actualizar Cliente" name="enviar" />
                    <input class='boton' name="insert" type="submit" value="Desactivar Cliente" name="enviar" />

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
