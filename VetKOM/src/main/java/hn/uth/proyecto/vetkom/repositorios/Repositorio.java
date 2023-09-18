/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.proyecto.vetkom.repositorios;

import java.util.List;

/**
 *
 * @author Miriam
 */
public interface Repositorio<T> {

    public void crear(T t) throws Exception;

    public void desactivar(T t) throws Exception;

    public void actualizar(T t) throws Exception;

    public T buscar(Object id) throws Exception;

    public List<T> buscarTodo() throws Exception;

}
