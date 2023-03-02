/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.LibroDao;
import DAO.LibroDaoImplement;
import Model.Libro;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author obria
 */
@ManagedBean
@ViewScoped
public class LibroBean {

    private Libro libro;
    private List<Libro> libros;

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLibros() {
        LibroDao dao = new LibroDaoImplement();
        libros = dao.mostrarLibro();
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {
        libro = new Libro();
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void insertar() {
        LibroDao dao = new LibroDaoImplement();
        dao.insertarLibro(libro);
        libro = new Libro();
        addMessage("Libro Agregado");
    }

}
