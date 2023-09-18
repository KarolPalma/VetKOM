<%-- 
    Document   : actualizarProducto
    Created on : Jul 21, 2020, 4:54:48 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.controladores.controladorDatosBD"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.ProductoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Producto"%>
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
        <title>Actualizar Producto</title>
    </head>
    
    <script type="text/javascript">
        history.forward();
    </script>
    
    <body>
        <%
            String idProducto = request.getParameter("idProducto");
            Producto producto = new Producto();
            if (idProducto != null && idProducto.equals("") == false) {
                ProductoRepositorio pR = new ProductoRepositorio();
                int id = Integer.parseInt(idProducto);
                producto = pR.buscar(id);
            }

            controladorDatosBD cL = new controladorDatosBD();
            
            Producto pro = new Producto();
            if (request.getSession().getAttribute("producto") != null) {
                pro = (Producto) request.getSession().getAttribute("producto");
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
                <center><h2>Actualizar Producto</h2></center>
                <form name="formulario" action="../../controladorProductos" method="POST">
                    <input type="text"  name="accion" value="actualizar" hidden="true"/>
                    <label> No.Producto: </label>
                    <input type="number"  name="idProducto" readonly="true" value="<%if (pro.getIdProducto() != 0) {out.print(pro.getIdProducto());} else {out.print(producto.getIdProducto());}%>"/><br>
                    <label> Nombre del Producto: </label>
                    <input type="text"  name="nombreProducto" required="true" maxlength="50" value='<%if (pro.getNombre() != null) {out.print(pro.getNombre());} else {out.print(producto.getNombre());}%>'/><br>
                    <label> Proveedor: </label>
                    <select name="idProveedor" required="true" >
                        <%if (pro.getIdProveedor() != 0) {
                                out.print(cL.getOpcionesProveedores(pro.getIdProveedor()));
                            } else {
                                out.print(cL.getOpcionesProveedores(producto.getIdProveedor()));
                            }%>
                    </select><br>
                    <label> Categoría del Producto: </label>
                    <select name="idCategoria" required="true" >
                        <%if (pro.getIdCategoria() != 0) {
                                out.print(cL.getOpcionesCategorias(pro.getIdCategoria()));
                            } else {
                                out.print(cL.getOpcionesCategorias(producto.getIdCategoria()));
                            }%>
                    </select><br>
                    <label> Descripción de la Cantidad por Unidad: </label>
                    <input type="text"  name="cantidadUnidad" required="true" maxlength="50" value='<%if (pro.getCantidadUnidad() != null) {out.print(pro.getCantidadUnidad());} else {out.print(producto.getCantidadUnidad());}%>'/><br>

                    <label> Cantidad en Almacén: </label>
                    <input type="number"  name="cantidadAlmacen" required="true" value='<%if (pro.getCantidadAlmacen() != 0) {
                            out.print(pro.getCantidadAlmacen());
                        } else {
                            out.print(producto.getCantidadAlmacen());
                        }%>'/><br>
                    <label> Cantidad Mínima en Almacén: </label>
                    <input type="number"  name="cantidadMinima" required="true" value='<%if (pro.getCantidadMinima() != 0) {
                            out.print(pro.getCantidadMinima());
                        } else {
                            out.print(producto.getCantidadMinima());
                        }%>'/><br>

                    <label> Cantidad Máxima en Almacén: </label>
                    <input type="number"  name="cantidadMaxima" required="true" value='<%if (pro.getCantidadMaxima() != 0) {
                            out.print(pro.getCantidadMaxima());
                        } else {
                            out.print(producto.getCantidadMaxima());
                        }%>'/><br>
                    <label> Precio de la Unidad: </label>
                    <input type="number" name="precio" placeholder="1.00" step="0.01" min="1" required="true" value='<%if (pro.getPrecio() != 0) {
                            out.print(pro.getPrecio());
                        } else {
                            out.print(producto.getPrecio());
                        }%>'/><br>
                    <p class="lempira"> L. </p>

                    <input class='boton' name="insert" type="submit" value="Actualizar Producto" name="enviar" />
                    <input class='boton' name="insert" type="submit" value="Desactivar Producto" name="enviar" />

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
