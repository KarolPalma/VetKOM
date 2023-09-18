<%-- 
    Document   : index
    Created on : Jul 14, 2020, 11:11:33 PM
    Author     : Miriam
--%>

<%@page import="hn.uth.proyecto.vetkom.objetos.Empleado"%>
<%@page import="hn.uth.proyecto.vetkom.repositorios.EmpleadoRepositorio"%>
<%@page import="hn.uth.proyecto.vetkom.PruebaConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <link rel="shortcut icon" type="image/x-icon" href="imagenes/Logo.ico"> <!--Icono del SitioWeb-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
        <link href="https://fonts.googleapis.com/css2?family=Patua+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="estilos/iniciarSesion.css">
    </head>
    <body id="principal">
        <header>

        </header>

        <div>
            <a href="index.jsp"><img class="logoMenu" src="imagenes/Logo2.png" alt="VetKOM"></a>

            <form class="animate__animated animate__slideInUp" action="controladorUsuarios" method="POST">

                <h1>Inicia Sesión</h1><br>
                <input type="text"  name="accion" value="iniciarSesion" hidden="true"/>
                <p class="fas fa-envelope"> Usuario:<br/></p>
                <input type="text" name="idUsuario" placeholder="Ingrese el Usuario"><br><br><br>
                <p class="fas fa-unlock-alt"> Contraseña:<br/></p>
                <input type="password" name="clave" placeholder="Ingrese una contraseña"><br><br><br>

                <input class="centrado" name="insert" type="submit" value="Iniciar Sesion"name="enviar" />

            </form>
        </div>

        <footer>
            <a href="index.jsp"><img class="imagenFooter" src="imagenes/Logo2.png" alt="Logo de el Footer"><br></a>
            <p>© 2020 Universidad Tecnológica de Honduras © VetKOM</p>
            <p class="contactanos">Contáctanos: <br> +504 9837-9065,<br> +504 9880-3121</p>
        </footer>  
    </body>
</html>
