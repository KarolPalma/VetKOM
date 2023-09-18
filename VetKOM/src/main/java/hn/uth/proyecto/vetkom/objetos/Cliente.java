/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.objetos;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Miriam
 */
public class Cliente {

    private String idCliente;
    private String nombres;
    private String apellidos;
    private Date fechaRegistro;
    private Date fechaNacimiento;
    private int idGenero;
    private String direccion;
    private int idCiudad;
    private int activo;
    private String rutaFoto;
    private String correos;
    private String telefonos;

    public Cliente() {
    }

    public Cliente(String idCliente, String nombres, String apellidos, Date fechaRegistro, Date fechaNacimiento, int idGenero, String direccion, int idCiudad, int activo, String rutaFoto, String correos, String telefonos) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaRegistro = Date.from(Instant.now());
        this.fechaNacimiento = fechaNacimiento;
        this.idGenero = idGenero;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
        this.activo = activo;
        this.rutaFoto = rutaFoto;
        this.correos = correos;
        this.telefonos = telefonos;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
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

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

}
