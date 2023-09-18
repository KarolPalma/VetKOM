/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.objetos.Animal;
import hn.uth.proyecto.vetkom.repositorios.AnimalRepositorio;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karol
 */
@WebServlet(name = "controladorAnimales", urlPatterns = {"/controladorAnimales"})
public class controladorAnimales extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String accion = request.getParameter("accion");
            String idAnimal = request.getParameter("idAnimal");
            String nombre = request.getParameter("nombreAnimal");
            String raza = request.getParameter("razaAnimal");
            String clienteDuenio = request.getParameter("clienteDuenio");
            String fechaNacimiento = request.getParameter("fechaNacimientoAnimal");
            String tipoSangre = request.getParameter("tipoSangre");
            String genero = request.getParameter("genero");
            String color = request.getParameter("color");
            String esterilizado = request.getParameter("esterilizado");
            String ruta = request.getParameter("rutaFoto");
            String observaciones = request.getParameter("observaciones");
            String especie = request.getParameter("especie");

            String submit = request.getParameter("insert");

            if (submit != null && (submit.equals("Guardar Animal") || submit.equals("Actualizar Animal") || submit.equals("Desactivar Animal"))) {
                Animal animal = recuperarAnimal(idAnimal, nombre, raza, clienteDuenio, fechaNacimiento, tipoSangre, genero, color, esterilizado, ruta, observaciones, especie);
                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    try {
                        if (animal.getIdAnimal() != 0) {
                            AnimalRepositorio animalRepo = new AnimalRepositorio();
                            animalRepo.crear(animal);
                            String msExito = "Registro añadido exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/animales/registrarAnimal.jsp");
                        }
                        request.getSession().setAttribute("animal", null);
                        request.getSession().setAttribute("idEspecie", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/animales/registrarAnimal.jsp");
                        ex.printStackTrace();
                    }

                }

                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Actualizar Animal")) {
                    try {
                        if (animal.getIdAnimal() != 0) {
                            AnimalRepositorio animalRepo = new AnimalRepositorio();
                            animalRepo.actualizar(animal);
                            String msExito = "Registro actualizado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/animales/actualizarAnimal.jsp");
                        }
                        request.getSession().setAttribute("animal", null);
                        request.getSession().setAttribute("idEspecie", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/animales/actualizarAnimal.jsp");
                        ex.printStackTrace();
                    }

                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR) && submit.equals("Desactivar Animal")) {
                    try {
                        if (animal.getIdAnimal() != 0) {
                            AnimalRepositorio animalRepo = new AnimalRepositorio();
                            animalRepo.desactivar(animal);
                            String msExito = "Registro desactivado exitosamente";
                            request.setAttribute("msExito", msExito);
                            ir(request, response, "menuPrincipal.jsp");
                        } else {
                            ir(request, response, "paginas/animales/actualizarAnimal.jsp");
                        }
                        request.getSession().setAttribute("animal", null);
                        request.getSession().setAttribute("idEspecie", null);

                    } catch (Exception ex) {
                        ir(request, response, "paginas/animales/actualizarAnimal.jsp");
                        ex.printStackTrace();
                    }

                }

            } else {

                Animal animal = recuperarAnimalNoInsert(idAnimal, nombre, raza, clienteDuenio, fechaNacimiento, tipoSangre, genero, color,
                        esterilizado, ruta, observaciones, especie);

                int idEspecie = 0;
                if (especie != null && especie.equals("") == false) {
                    idEspecie = Integer.parseInt(especie);
                }

                request.getSession().setAttribute("animal", animal);
                if (idEspecie != 0) {
                    request.getSession().setAttribute("idEspecie", idEspecie);
                }

                if (accion.equals(servletConfiguracion.ACCION_NUEVO)) {
                    ir(request, response, "paginas/animales/registrarAnimal.jsp");
                }
                if (accion.equals(servletConfiguracion.ACCION_ACTUALIZAR)) {
                    ir(request, response, "paginas/animales/actualizarAnimal.jsp");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Animal recuperarAnimal(String idAnimal, String nombre, String raza, String clienteDuenio, String fechaNacimiento, String tipoSangre, String genero,
            String color, String esterilizado, String ruta, String observaciones, String especie) {
        Animal animal = new Animal();
        try {
            Date fechaNacimientoDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }

            int id = 0;
            if (idAnimal != null && idAnimal.equals("") == false) {
                id = Integer.parseInt(idAnimal);
            }
            animal.setIdAnimal(id);
            animal.setNombre(nombre);
            animal.setIdRaza(Integer.parseInt(raza));
            animal.setIdClienteDuenio(clienteDuenio);
            animal.setFechaNacimiento(fechaNacimientoDate);
            animal.setTipoSangre(tipoSangre);
            animal.setIdGenero(Integer.parseInt(genero));
            animal.setIdColor(Integer.parseInt(color));
            if (esterilizado.equals("2")) {
                animal.setEsterilizado(0);
            } else {
                animal.setEsterilizado(Integer.parseInt(esterilizado));
            }
            animal.setRutaFoto(ruta);

            if (ruta.equals("")) {
                animal.setRutaFoto(null);
            } else {
                animal.setRutaFoto(ruta);
            }

            if (observaciones.equals("")) {
                animal.setObservaciones(null);
            } else {
                animal.setObservaciones(observaciones);
            }

        } catch (Exception e) {
            //crear redireccionamiento a otra pagina de error
        }
        return animal;
    }

    private Animal recuperarAnimalNoInsert(String idAnimal, String nombre, String raza, String clienteDuenio, String fechaNacimiento, String tipoSangre, String genero,
            String color, String esterilizado, String ruta, String observaciones, String especie) {
        Animal animal = new Animal();
        try {
            Date fechaNacimientoDate = null;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            if (fechaNacimiento != null && fechaNacimiento.equals("") == false) {
                fechaNacimientoDate = format.parse(fechaNacimiento);
            }

            int id = 0;
            if (idAnimal != null && idAnimal.equals("") == false) {
                id = Integer.parseInt(idAnimal);
            }
            animal.setIdAnimal(id);
            animal.setNombre(nombre);
            animal.setIdClienteDuenio(clienteDuenio);
            animal.setFechaNacimiento(fechaNacimientoDate);
            animal.setTipoSangre(tipoSangre);
            animal.setIdGenero(Integer.parseInt(genero));
            animal.setIdColor(Integer.parseInt(color));
            animal.setEsterilizado(Integer.parseInt(esterilizado));
            animal.setRutaFoto(ruta);
            animal.setObservaciones(observaciones);
            animal.setIdEspecie(Integer.parseInt(especie));

        } catch (Exception e) {
            //crar redireccionamiento a otra pagina de error
        }
        return animal;
    }

    private void ir(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(url);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
