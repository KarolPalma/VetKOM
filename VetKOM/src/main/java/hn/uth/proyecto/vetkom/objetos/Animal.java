/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.objetos;

import java.util.Date;

/**
 *
 * @author Karol
 */
public class Animal {

    private int idAnimal;
    private String nombre;
    private int idRaza;
    private String idClienteDuenio;
    private Date fechaNacimiento;
    private String tipoSangre;
    private int idGenero;
    private int idColor;
    private int Esterilizado;
    private String rutaFoto;
    private String observaciones;
    private int activo;
    private int idEspecie;

    public Animal() {
    }

    public Animal(int idAnimal, String nombre, int idRaza, String idClienteDuenio, Date fechaNacimiento, String tipoSangre, int idGenero, int idColor, int Esterilizado, String rutaFoto, String observaciones, int activo, int idEspecie) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.idRaza = idRaza;
        this.idClienteDuenio = idClienteDuenio;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        this.idGenero = idGenero;
        this.idColor = idColor;
        this.Esterilizado = Esterilizado;
        this.rutaFoto = rutaFoto;
        this.observaciones = observaciones;
        this.activo = activo;
        this.idEspecie = idEspecie;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRaza() {
        return idRaza;
    }

    public void setIdRaza(int idRaza) {
        this.idRaza = idRaza;
    }

    public String getIdClienteDuenio() {
        return idClienteDuenio;
    }

    public void setIdClienteDuenio(String idClienteDuenio) {
        this.idClienteDuenio = idClienteDuenio;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public int getEsterilizado() {
        return Esterilizado;
    }

    public void setEsterilizado(int Esterilizado) {
        this.Esterilizado = Esterilizado;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(int idEspecie) {
        this.idEspecie = idEspecie;
    }

}
