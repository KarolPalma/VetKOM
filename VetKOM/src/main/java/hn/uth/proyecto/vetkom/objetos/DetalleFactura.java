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
public class DetalleFactura {

    private int idFactura;
    private int tipo;
    private int idConcepto;
    private int idDescuento;
    private int idImpuesto;

    public DetalleFactura() {
    }

    public DetalleFactura(int idFactura, int tipo, int idConcepto, int idDescuento, int idImpuesto) {
        this.idFactura = idFactura;
        this.tipo = tipo;
        this.idConcepto = idConcepto;
        this.idDescuento = idDescuento;
        this.idImpuesto = idImpuesto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

}
