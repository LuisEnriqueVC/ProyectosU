/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Libro;
import java.util.List;

/**
 *
 * @author obria
 */
public interface LibroDao {
    public void insertarLibro(Libro libro);
    public void modificarLibro(Libro libro);
    public void eliminarLibro(Libro libro);
    public List<Libro> mostrarLibro();
}
