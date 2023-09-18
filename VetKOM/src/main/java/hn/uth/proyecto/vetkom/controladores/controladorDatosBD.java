/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.controladores;

import hn.uth.proyecto.vetkom.repositorios.DatosBDRepositorio;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miriam
 */
public class controladorDatosBD {

    DatosBDRepositorio lr = new DatosBDRepositorio();

    public String getOpcionesPaises(int seleccionado) {
        Hashtable paises = new Hashtable();
        String opcion = "";
        try {
            paises = lr.getPaises();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(paises.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + paises.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + paises.get(i.intValue()).toString() + "</option>";
            }
        }

        /*for (Object key : paises.keySet()){
            out.print("<option value='" + key.toString() + "'>" + paises.get(key).toString() + "</option>"); 
        }
         */
        return opcion;
    }

    public String getOpcionesDepartamentos(int idPais, int seleccionado) {
        Hashtable deptos = new Hashtable();
        String opcion = "";
        try {
            deptos = lr.getDeptos(idPais);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(deptos.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + deptos.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + deptos.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesCiudades(int idDepto) {
        Hashtable ciudades = new Hashtable();
        String opcion = "";
        try {
            ciudades = lr.getCiudades(idDepto);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(ciudades.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            opcion += "<option value='" + i.toString() + "'>" + ciudades.get(i.intValue()).toString() + "</option>";
        }

        return opcion;
    }

    public String getCiudad(int idCiudad) {
        Hashtable ciudades = new Hashtable();
        String opcion = "";
        try {
            ciudades = lr.getCiudad(idCiudad);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(ciudades.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            opcion += "<option value='" + i.toString() + "' selected>" + ciudades.get(i.intValue()).toString() + "</option>";
        }

        return opcion;
    }

    public String getOpcionesCargos(int seleccionado) {
        Hashtable cargos = new Hashtable();
        String opcion = "";
        try {
            cargos = lr.getCargos();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(cargos.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + cargos.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + cargos.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesJefes(int seleccionado) {
        Hashtable reporta = new Hashtable();
        String opcion = "";
        try {
            reporta = lr.getReportaA();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(reporta.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + reporta.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + reporta.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesGeneros(int seleccionado) {
        Hashtable generos = new Hashtable();
        String opcion = "";
        try {
            generos = lr.getGeneros();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(generos.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + generos.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + generos.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesProveedores(int seleccionado) {
        Hashtable proveedores = new Hashtable();
        String opcion = "";
        try {
            proveedores = lr.getProveedores();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(proveedores.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + proveedores.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + proveedores.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesCategorias(int seleccionado) {
        Hashtable categorias = new Hashtable();
        String opcion = "";
        try {
            categorias = lr.getCategoriasProductos();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(categorias.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + categorias.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + categorias.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getOpcionesColores(int seleccionado) {
        Hashtable colores = new Hashtable();
        String opcion = "";
        try {
            colores = lr.getColores();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(colores.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + colores.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + colores.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesEspecies(int seleccionado) {
        Hashtable especies = new Hashtable();
        String opcion = "";
        try {
            especies = lr.getEspecies();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(especies.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + especies.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + especies.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesRaza(int idEspecie, int seleccionado) {
        Hashtable raza = new Hashtable();
        String opcion = "";
        try {
            raza = lr.getRaza(idEspecie);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(raza.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + raza.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + raza.get(i.intValue()).toString() + "</option>";
            }
        }

        return opcion;
    }

    public String getRaza(int idRaza) {
        Hashtable razas = new Hashtable();
        String opcion = "";
        try {
            razas = lr.getRaza(idRaza);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(razas.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            opcion += "<option value='" + i.toString() + "' selected>" + razas.get(i.intValue()).toString() + "</option>";
        }

        return opcion;
    }

    public String getOpcionesClienteDuenio(String seleccionado) {
        Hashtable<String, String> cliente = new Hashtable();
        String opcion = "";
        try {
            cliente = lr.getClienteDuenio();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        String llave = "";
        Enumeration duenio = cliente.keys();
        while (duenio.hasMoreElements()) {
            llave = (String) duenio.nextElement();
            if (seleccionado != null && seleccionado.equals(llave)) {
                opcion += "<option value='" + llave.toString() + "' selected>" + cliente.get(llave).toString() + "</option>";
            } else {
                opcion += "<option value='" + llave.toString() + "'>" + cliente.get(llave).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesAnimales(String idDuenio, int seleccionado) {
        Hashtable animales = new Hashtable();
        String opcion = "";
        try {
            animales = lr.getAnimalxDuenio(idDuenio);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(animales.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + animales.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + animales.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesServicios(int seleccionado) {
        Hashtable servicios = new Hashtable();
        String opcion = "";
        try {
            servicios = lr.getServicios();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(servicios.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + servicios.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + servicios.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesPersonal(int idServicio, int seleccionado) {
        Hashtable personal = new Hashtable();
        String opcion = "";
        try {
            personal = lr.getPersonalServicios(idServicio);
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(personal.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + personal.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + personal.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesEstados(int seleccionado) {
        Hashtable estados = new Hashtable();
        String opcion = "";
        try {
            estados = lr.getEstadosCita();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(estados.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + estados.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + estados.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesCitas(int seleccionado) {
        Hashtable citas = new Hashtable();
        String opcion = "";
        try {
            citas = lr.getNoCitas();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(citas.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + citas.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + citas.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesCitasTodas(int seleccionado) {
        Hashtable citas = new Hashtable();
        String opcion = "";
        try {
            citas = lr.getNoCitasTodas();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(citas.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + citas.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + citas.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesMetodosPago(int seleccionado) {
        Hashtable metodosPago = new Hashtable();
        String opcion = "";
        try {
            metodosPago = lr.getMetodosPago();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(metodosPago.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + metodosPago.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + metodosPago.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesConceptos(int tipoConcepto, int seleccionado) {
        Hashtable conceptos = new Hashtable();
        String opcion = "";
        if (tipoConcepto == 1) {
            try {
                conceptos = lr.getProductos();
            } catch (Exception ex) {
                Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Integer> listaOrdenada = Collections.list(conceptos.keys());
            Collections.sort(listaOrdenada);
            Iterator<Integer> it = listaOrdenada.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                if (seleccionado != 0 && seleccionado == i.intValue()) {
                    opcion += "<option value='" + i.toString() + "' selected>" + conceptos.get(i.intValue()).toString() + "</option>";
                } else {
                    opcion += "<option value='" + i.toString() + "'>" + conceptos.get(i.intValue()).toString() + "</option>";
                }
            }
        } else {
            try {
                conceptos = lr.getServicios();
            } catch (Exception ex) {
                Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Integer> listaOrdenada = Collections.list(conceptos.keys());
            Collections.sort(listaOrdenada);
            Iterator<Integer> it = listaOrdenada.iterator();
            while (it.hasNext()) {
                Integer i = it.next();
                if (seleccionado != 0 && seleccionado == i.intValue()) {
                    opcion += "<option value='" + i.toString() + "' selected>" + conceptos.get(i.intValue()).toString() + "</option>";
                } else {
                    opcion += "<option value='" + i.toString() + "'>" + conceptos.get(i.intValue()).toString() + "</option>";
                }
            }
        }
        return opcion;
    }

    public String getOpcionesImpuestos(int seleccionado) {
        Hashtable impuestos = new Hashtable();
        String opcion = "";
        try {
            impuestos = lr.getImpuestos();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(impuestos.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + impuestos.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + impuestos.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

    public String getOpcionesDescuentos(int seleccionado) {
        Hashtable descuentos = new Hashtable();
        String opcion = "";
        try {
            descuentos = lr.getDescuentos();
        } catch (Exception ex) {
            Logger.getLogger(controladorDatosBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Integer> listaOrdenada = Collections.list(descuentos.keys());
        Collections.sort(listaOrdenada);
        Iterator<Integer> it = listaOrdenada.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (seleccionado != 0 && seleccionado == i.intValue()) {
                opcion += "<option value='" + i.toString() + "' selected>" + descuentos.get(i.intValue()).toString() + "</option>";
            } else {
                opcion += "<option value='" + i.toString() + "'>" + descuentos.get(i.intValue()).toString() + "</option>";
            }
        }
        return opcion;
    }

}
