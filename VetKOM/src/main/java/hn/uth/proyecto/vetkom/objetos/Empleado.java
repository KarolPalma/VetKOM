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
public class Empleado {

    private int idEmpleado;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaContratacion;
    private Date fechaFinalizacionContrato;
    private int idCargo;
    private int reportaA;
    private String direccion;
    private int idCiudad;
    private int activo;
    private String rutaFoto;
    private String notas;
    private String telefonos;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombres, String apellidos, Date fechaNacimiento, Date fechaContratacion, Date fechaFinalizacionContrato, int idCargo, int reportaA, String direccion, int idCiudad, int activo, String rutaFoto, String notas, String telefonos) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.fechaFinalizacionContrato = fechaFinalizacionContrato;
        this.idCargo = idCargo;
        this.reportaA = reportaA;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
        this.activo = activo;
        this.rutaFoto = rutaFoto;
        this.notas = notas;
        this.telefonos = telefonos;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Date getFechaFinalizacionContrato() {
        return fechaFinalizacionContrato;
    }

    public void setFechaFinalizacionContrato(Date fechaFinalizacionContrato) {
        this.fechaFinalizacionContrato = fechaFinalizacionContrato;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getReportaA() {
        return reportaA;
    }

    public void setReportaA(int reportaA) {
        this.reportaA = reportaA;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

}
