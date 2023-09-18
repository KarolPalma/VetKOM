<%-- 
    Document   : actualizarEmpleado
    Created on : Jul 16, 2020, 11:17:58 AM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
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
        <title>Actualizar Empleado</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <body>
        <%
            String idEmpleado = request.getParameter("idEmpleado");
            Empleado empleado = new Empleado();
            if (idEmpleado != null && idEmpleado.equals("") == false) {
                EmpleadoRepositorio eR = new EmpleadoRepositorio();
                int id = Integer.parseInt(idEmpleado);
                empleado = eR.buscar(id);
            }

            controladorDatosBD cL = new controladorDatosBD();
            
            Empleado em = new Empleado();
            if (request.getSession().getAttribute("empleado") != null) {
                em = (Empleado) request.getSession().getAttribute("empleado");
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
                <center><h2>Actualizar Empleado</h2></center>
                <form name="formulario" action="../../controladorEmpleados" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> No.Empleado: </label>
                    <input type="number"  name="idEmpleado"readonly="true" value="<%if (em.getIdEmpleado() != 0) {out.print(em.getIdEmpleado());} else {out.print(empleado.getIdEmpleado());}%>"/><br>
                    <label> Nombres: </label>
                    <input type="text"  name="nombresEmpleado" required="true" maxlength="50" value='<%if (em.getNombres() != null) {out.print(em.getNombres());} else {out.print(empleado.getNombres());}%>'/><br>
                    <label> Apellidos: </label>
                    <input type="text"  name="apellidosEmpleado" required="true"  maxlength="50" value='<%if (em.getApellidos() != null) {out.print(em.getApellidos());} else {out.print(empleado.getApellidos());}%>'/><br>
                    <label> Fecha de Nacimiento: </label>
                    <input type="date" name="fechaNacimientoEmpleado" required="true" value='<%
                        if (em.getFechaNacimiento() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(em.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(empleado.getFechaNacimiento());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Fecha de Contratación: </label>
                    <input type="date" name="fechaContratacionEmpleado" required="true" value='<%
                        if (em.getFechaContratacion() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(em.getFechaContratacion());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(empleado.getFechaContratacion());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Fecha de Finalización de Contrato: </label>
                    <input type="date" name="fechaFinalizacionContratoEmpleado" required="true" value='<%
                        if (em.getFechaFinalizacionContrato() != null) {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(em.getFechaFinalizacionContrato());
                            out.print(fechaFinalDate);
                        } else {
                            String fechaFinalDate = new SimpleDateFormat("yyyy-MM-dd").format(empleado.getFechaFinalizacionContrato());
                            out.print(fechaFinalDate);
                        }
                           %>'/><br>
                    <label> Cargo: </label>
                    <select name="cargoEmpleado" required="true" >
                        <%if (em.getIdCargo() != 0) {
                                out.print(cL.getOpcionesCargos(em.getIdCargo()));
                            } else {
                                out.print(cL.getOpcionesCargos(empleado.getIdCargo()));
                            }%>
                    </select><br>
                    <label> Reporta a: </label>
                    <select name="reportaEmpleado">
                        <option value="0">Ninguno</option>
                        <%if (em.getReportaA() != 0) {
                                out.print(cL.getOpcionesJefes(em.getReportaA()));
                            } else {
                                out.print(cL.getOpcionesJefes(empleado.getReportaA()));
                            }%>
                    </select><br>
                    <label> Dirección: </label>
                    <input type="text"  name="direccionEmpleado" required="true" maxlength="50" value='<%if (em.getDireccion() != null) {out.print(em.getDireccion());} else {out.print(empleado.getDireccion());}%>'/><br>

                    <label> País: </label>
                    <select name="paisEmpleado" onchange="formulario.submit()">
                        <%out.print(cL.getOpcionesPaises(idPais));%>
                    </select><br>

                    <label> Departamento: </label>
                    <select name="departamentoEmpleado" onchange="formulario.submit()">
                        <option value="">Debe seleccionar un País</option>
                        <%out.print(cL.getOpcionesDepartamentos(idPais, idDepto));%>
                    </select><br>

                    <label> Ciudad: </label>
                    <select name="ciudadEmpleado" required="true">
                        <option value="">Debe seleccionar un Departamento</option>
                        <%if (idDepto != 0) {
                                out.print(cL.getOpcionesCiudades(idDepto));
                            } else {
                                out.print(cL.getCiudad(empleado.getIdCiudad()));
                            }%>
                    </select><br>

                    <label> Ruta de su fotografia: </label>
                    <input type="text"  name="rutaFoto" maxlength="100" value='<%if (em.getRutaFoto() != null) {
                            out.print(em.getRutaFoto());
                        } else {
                            if (empleado.getRutaFoto() != null) {
                                out.print(empleado.getDireccion());
                            }
                        }%>'/><br>
                    <!--TEXT AREA PARA NOTAS-->
                    <label> Notas: </label>
                    <textarea rows="4" cols="50"  name="notas"><%if (em.getNotas() != null) {
                            out.print(em.getNotas());
                        } else {
                            if (empleado.getNotas() != null) {
                                out.print(empleado.getNotas());
                            }
                        }%></textarea><br>

                    <div class="tooltip">
                        <label> Teléfonos: </label>
                        <span class="tooltiptext">Ingresar varios teléfonos, separados por comas (,)</span>
                        <input type="text"  name="telefonos" value='<%if (em.getTelefonos() != null) {
                                out.print(em.getTelefonos());
                            } else {
                                if (empleado.getTelefonos() != null) {
                                    out.print(empleado.getTelefonos());
                                }
                            }%>'/><br>
                    </div>
                    <br>

                    <input class='boton' name="insert" type="submit" value="Actualizar Empleado" name="enviar" />
                    <input class='boton' name="insert" type="submit" value="Desactivar Empleado" name="enviar" />

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
