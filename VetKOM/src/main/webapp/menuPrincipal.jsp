<%-- 
    Document   : menuPrincipal
    Created on : 07-22-2020, 04:38:04 PM
    Author     : karol
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Usuario"%>
<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.PruebaConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/Logo.ico"> <!--Icono del SitioWeb-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="estilos/menuPrincipal.css">

        <title>Menú Principal</title>
    </head>
    <%
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
                <nav class="menu ">
                    <a href="menuPrincipal.jsp"><img class="logoMenu " src="imagenes/Logo2.png"></a>
                    <a class="empleadoMenu" href="paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><p class="empleadoMenu"><%=empleadoSesion.getNombres()%></p></a>

                    <a href="paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>"><img class="perfilMenu" ></a>
                    <ul>
                        <li><a href="menuPrincipal.jsp">Inicio</a></li>
                        <li><p>Citas</p>
                            <ul>
                                <li><a href="paginas/citas/registrarCita.jsp">Crear Cita</a></li>
                                <li><a href="paginas/buscador.jsp?action=Cita">Buscar Cita</a></li>
                            </ul>
                        </li>
                        <li><p>Facturas</p>
                            <ul>
                                <li><a href="paginas/facturas/registrarFactura.jsp">Crear Factura</a></li>
                                <li><a href="paginas/buscador.jsp?action=Factura">Buscar Factura</a></li>
                            </ul>
                        </li>
                        <li><p>Animales</p>
                            <ul>
                                <li><a href="paginas/animales/registrarAnimal.jsp">Registrar Animal</a></li>
                                <li><a href="paginas/buscador.jsp?action=Animal">Buscar Animal</a></li>
                            </ul>
                        </li>
                        <li><p>Clientes</p>
                            <ul>
                                <li><a href="paginas/clientes/registrarCliente.jsp">Registrar Cliente</a></li>
                                <li><a href="paginas/buscador.jsp?action=Cliente">Buscar Cliente</a></li>
                            </ul>
                        </li>
                        <li><p>Productos</p>
                            <ul>
                                <li><a href="paginas/productos/registrarProducto.jsp">Crear Producto</a></li>
                                <li><a href="paginas/buscador.jsp?action=Producto">Buscar Producto</a></li>
                            </ul>
                        </li>
                        <li><p>Servicios</p>
                            <ul>
                                <li><a href="paginas/servicios/registrarServicio.jsp">Registrar Servicio</a></li>
                                <li><a href="paginas/buscador.jsp?action=Servicio">Buscar Servicio</a></li>
                            </ul>
                        </li>
                        <li><p>Usuarios</p>
                            <ul>
                                <li><a href="paginas/usuarios/registrarUsuario.jsp">Crear Usuario</a></li>
                                <li><a href="paginas/buscador.jsp?action=Usuario">Buscar Usuario</a></li>
                            </ul>
                        </li>
                        <li><p>Empleados</p>
                            <ul>
                                <li><a href="paginas/empleados/registrarEmpleado.jsp">Registrar Empleado</a></li>
                                <li><a href="paginas/buscador.jsp?action=Empleado">Buscar Empleado</a></li>
                            </ul>
                        </li>
                        <li><p>▼</p>
                            <ul>
                                <li><a href="paginas/usuarios/actualizarUsuario.jsp?accion=actualizar&idUsuario=<%out.print(usuarioSesion.getUsuario());%>">Ver Perfil</a></li>
                                <li><a href="cerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul> 
                </nav>
            </div>
        </header>
        <div class="principal">

            <div style="z-index: 1" class="contenedorSlider animate__animated animate__pulse"> <!--Slider-->
                <input type="radio" id="1" name="slider-imagen" hidden />
                <input type="radio" id="2" name="slider-imagen" hidden />
                <input type="radio" id="3" name="slider-imagen" hidden />

                <div class="slider"> <!--Imagenes del Slider-->
                    <div class="item-slider">
                        <img src="imagenes/SliderImg1.jpg">
                    </div>
                    <div class="item-slider">
                        <img src="imagenes/SliderImg4.jpg">
                    </div>
                    <div class="item-slider">
                        <img src="imagenes/SliderImg3.jpg">
                    </div>
                </div>

                <div class="paginacion-slider"> <!--Paginación del Slider-->
                    <label class="paginacion-item" for="1">
                        <img src="imagenes/SliderImg1.jpg">
                    </label>
                    <label class="paginacion-item" for="2">
                        <img src="imagenes/SliderImg4.jpg">
                    </label>
                    <label class="paginacion-item" for="3">
                        <img src="imagenes/SliderImg3.jpg">
                    </label>
                </div>
            </div>

            <div class="servicios">
                <center style="padding-top:40px">
                    <div class="iconos">
                        <img src="imagenes/servicios/spa.jpg" alt="Spa"><br>
                        <span><br>SPA Animal</span><br><br>
                        <div class="parrafoServicio">
                            <span class="parrafoServicio">Contamos con un área para atención de salón acondicionada para el relajamiento de nuestros animales.</span>
                        </div>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/cita.jpg" alt="Cíta medica"><br>
                        <span><br>Cíta Médica</span><br><br>
                        <div class="parrafoServicio">
                            <span class="parrafoServicio">En VetKOM ofrecemos el servicio de consulta médica donde contamos con todo el equipo, médicos especializados y capacitados para brindar la mejor atención.</span>
                        </div>
                        <br>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/radiografia.jpg" alt="Radiografía"><br>
                        <center>
                            <span><br>Radiografía</span><br><br>
                            <div class="parrafoServicio">
                                <span class="parrafoServicio">Nuestros laboratorios de Rayos X bridan el servicio de radiografías para detectar lesiones de los animales y poder tratarlas de forma inmediata.</span>
                            </div>
                        </center>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/cirugia.jpg" alt="Cirugía"><br>
                        <center>
                            <span><br>Cirugía</span><br><br>
                            <div class="parrafoServicio">
                                <span class="parrafoServicio"> VetKOM cuenta con el servicio de cirugías mayores y menores. Nos esforzamos para que su mascota tenga la mejor atención y recuperación posible.</span>
                            </div>
                        </center>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/cortePelo.jpg" alt="Corte de pelo"><br>
                        <span><br>Corte de Pelo</span><br><br>
                        <div class="parrafoServicio">
                            <span class="parrafoServicio">Contamos con el servicio de "perruqueria". Cortes de pelo de acuerdo a la raza. Atendemos a perros de todos los tamaños y razas, y gatos.</span>
                        </div>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/limpiezaDental.jpg" alt="Limpieza Dental"><br>
                        <center>
                            <span><br>Limpieza Dental</span><br><br>
                            <div class="parrafoServicio">
                                <span class="parrafoServicio">En VetKOM nos encargamos de la Limpieza Dental de los animales, ya que es indispensable mantener la higiene oral de nuestras mascotas para su salud y la nuestra.</span>
                            </div>
                        </center>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/desparacitacion.jpg" alt="Desparacitación"><br>
                        <center>
                            <span><br>Desparacitación</span><br><br>
                            <div class="parrafoServicio">
                                <span class="parrafoServicio">En VetKOM nos encargamos de desparacitar y vacunar a tus animales, ya que son las maneras más eficaces de prevenir las enfermedades infecciosas y mortales.</span>
                            </div>
                        </center>
                    </div>
                    <div class="iconos">
                        <img src="imagenes/servicios/accesorios.jpg" alt="Accesorios"><br>
                        <center>
                            <span><br>Accesorios</span><br><br>
                            <div class="parrafoServicio">
                                <span class="parrafoServicio">Contamos con una gran variedad de accesorios en todos los tamaños para los animales. Desde juguetes divertidos hasta productos de cuidado animal.</span>
                            </div>
                        </center>
                    </div>
                </center>
            </div>
        </div>
        <footer>
            <a href="menuPrincipal.jsp"><img class="imagenFooter" src="imagenes/Logo2.png" alt="Logo de el Footer"><br></a>
            <p>© 2020 Universidad Tecnológica de Honduras © VetKOM</p>
            <p class="contactanos">Contáctanos: <br> +504 9837-9065,<br> +504 9880-3121</p>
        </footer>        
    </body>

</html>
