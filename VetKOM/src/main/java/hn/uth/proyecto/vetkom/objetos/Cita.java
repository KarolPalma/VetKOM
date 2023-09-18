/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.objetos;

import java.util.Date;

/**
 *
 * @author Miriam
 */
public class Cita {

    private int idCita;
    private String idDuenio;
    private int idAnimal;
    private int idServicioSolicitado;
    private int idEmpleado;
    private Date fechaIngreso;
    private Date fechaCita;
    private String horaCita;
    private int noSala;
    private int idEstado;
    private String observaciones;

    public Cita() {
    }

    public Cita(int idCita, String idDuenio, int idAnimal, int idServicioSolicitado, int idEmpleado, Date fechaIngreso, Date fechaCita, String horaCita, int noSala, int idEstado, String observaciones) {
        this.idCita = idCita;
        this.idDuenio = idDuenio;
        this.idAnimal = idAnimal;
        this.idServicioSolicitado = idServicioSolicitado;
        this.idEmpleado = idEmpleado;
        this.fechaIngreso = fechaIngreso;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.noSala = noSala;
        this.idEstado = idEstado;
        this.observaciones = observaciones;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getIdDuenio() {
        return idDuenio;
    }

    public void setIdDuenio(String idDuenio) {
        this.idDuenio = idDuenio;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdServicioSolicitado() {
        return idServicioSolicitado;
    }

    public void setIdServicioSolicitado(int idServicioSolicitado) {
        this.idServicioSolicitado = idServicioSolicitado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public int getNoSala() {
        return noSala;
    }

    public void setNoSala(int noSala) {
        this.noSala = noSala;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
