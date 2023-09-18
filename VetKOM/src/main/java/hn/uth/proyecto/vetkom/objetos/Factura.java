/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.objetos;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Miriam
 */
public class Factura {

    private int idFactura;
    private int idCita;
    private Date fechaFactura;
    private int idMetodoPago;
    private List<DetalleFactura> detalles;
    private double subtotal;
    private double total;
    private String usuario;

    public Factura() {
    }

    public Factura(int idFactura, int idCita, Date fechaFactura, int idMetodoPago, List<DetalleFactura> detalles, double subtotal, double total, String usuario) {
        this.idFactura = idFactura;
        this.idCita = idCita;
        this.fechaFactura = fechaFactura;
        this.idMetodoPago = idMetodoPago;
        this.detalles = detalles;
        this.subtotal = subtotal;
        this.total = total;
        this.usuario = usuario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(int idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
