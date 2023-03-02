/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author felip
 */
public class libro {
    Date dat = new java.util.Date();//Declaramos un objeto date
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleHora = new java.text.SimpleDateFormat("HH:mm:ss");
    private int idLibro;
    private String titulo;
    private String horaIngreso = simpleHora.format(dat);
    private String autor;
    private String editorial;
    private String fPublicacion= simpleDate.format(dat);
    private int tiemConservacion;
    private String genero;
    private int ejemplares;
    private String seccion;

    public libro() {
    }

    public libro(int idLibro, String titulo, String autor, String editorial, int tiemConservacion, String genero, int ejemplares, String seccion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.tiemConservacion = tiemConservacion;
        this.genero = genero;
        this.ejemplares = ejemplares;
        this.seccion = seccion;
    }

    public Date getDat() {
        return dat;
    }

    public void setDat(Date dat) {
        this.dat = dat;
    }

    public SimpleDateFormat getSimpleDate() {
        return simpleDate;
    }

    public void setSimpleDate(SimpleDateFormat simpleDate) {
        this.simpleDate = simpleDate;
    }

    public SimpleDateFormat getSimpleHora() {
        return simpleHora;
    }

    public void setSimpleHora(SimpleDateFormat simpleHora) {
        this.simpleHora = simpleHora;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getfPublicacion() {
        return fPublicacion;
    }

    public void setfPublicacion(String fPublicacion) {
        this.fPublicacion = fPublicacion;
    }

    public int getTiemConservacion() {
        return tiemConservacion;
    }

    public void setTiemConservacion(int tiemConservacion) {
        this.tiemConservacion = tiemConservacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    
}
