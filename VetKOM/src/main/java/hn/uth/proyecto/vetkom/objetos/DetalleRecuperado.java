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
public class DetalleRecuperado {

    private String idConcepto;
    private String nombre;
    private Double precio;
    private Double descuento;
    private Double impuesto;

    public DetalleRecuperado() {
    }

    public DetalleRecuperado(String idConcepto, String nombre, Double precio, Double descuento, Double impuesto) {
        this.idConcepto = idConcepto;
        this.nombre = nombre;
        this.precio = precio;
        this.descuento = descuento;
        this.impuesto = impuesto;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

}
