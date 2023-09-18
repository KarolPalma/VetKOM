/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.objetos;

/**
 *
 * @author Miriam
 */
public class Servicio {

    private int idServicio;
    private String nombre;
    private int idEstado;
    private double precio;

    public Servicio() {
    }

    public Servicio(int idServicio, String nombre, int idEstado, double precio) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.idEstado = idEstado;
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
