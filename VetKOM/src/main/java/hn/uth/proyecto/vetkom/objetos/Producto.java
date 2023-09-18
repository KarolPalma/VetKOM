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
public class Producto {

    private int idProducto;
    private String nombre;
    private int idProveedor;
    private int idCategoria;
    private String cantidadUnidad;
    private int cantidadAlmacen;
    private int cantidadMinima;
    private int cantidadMaxima;
    private int idEstado;
    private double precio;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, int idProveedor, int idCategoria, String cantidadUnidad, int cantidadAlmacen, int cantidadMinima, int cantidadMaxima, int idEstado, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
        this.cantidadUnidad = cantidadUnidad;
        this.cantidadAlmacen = cantidadAlmacen;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
        this.idEstado = idEstado;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCantidadUnidad() {
        return cantidadUnidad;
    }

    public void setCantidadUnidad(String cantidadUnidad) {
        this.cantidadUnidad = cantidadUnidad;
    }

    public int getCantidadAlmacen() {
        return cantidadAlmacen;
    }

    public void setCantidadAlmacen(int cantidadAlmacen) {
        this.cantidadAlmacen = cantidadAlmacen;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
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
