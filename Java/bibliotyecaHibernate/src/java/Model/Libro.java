package Model;
// Generated 23/09/2021 01:45:14 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Libro generated by hbm2java
 */
public class Libro  implements java.io.Serializable {


     private Integer idLibro;
     private String titulo;
     private Date horaIngreso;
     private String autor;
     private String editorial;
     private Date fpublicacion;
     private Integer tiemConservacion;
     private String genero;
     private Integer ejemplares;
     private String seccion;
     private Set<Consulta> consultas = new HashSet<Consulta>(0);

    public Libro() {
    }

    public Libro(String titulo, Date horaIngreso, String autor, String editorial, Date fpublicacion, Integer tiemConservacion, String genero, Integer ejemplares, String seccion, Set<Consulta> consultas) {
       this.titulo = titulo;
       this.horaIngreso = horaIngreso;
       this.autor = autor;
       this.editorial = editorial;
       this.fpublicacion = fpublicacion;
       this.tiemConservacion = tiemConservacion;
       this.genero = genero;
       this.ejemplares = ejemplares;
       this.seccion = seccion;
       this.consultas = consultas;
    }
   
    public Integer getIdLibro() {
        return this.idLibro;
    }
    
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getHoraIngreso() {
        return this.horaIngreso;
    }
    
    public void setHoraIngreso(Date horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
    public String getAutor() {
        return this.autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getEditorial() {
        return this.editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public Date getFpublicacion() {
        return this.fpublicacion;
    }
    
    public void setFpublicacion(Date fpublicacion) {
        this.fpublicacion = fpublicacion;
    }
    public Integer getTiemConservacion() {
        return this.tiemConservacion;
    }
    
    public void setTiemConservacion(Integer tiemConservacion) {
        this.tiemConservacion = tiemConservacion;
    }
    public String getGenero() {
        return this.genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public Integer getEjemplares() {
        return this.ejemplares;
    }
    
    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }
    public String getSeccion() {
        return this.seccion;
    }
    
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public Set<Consulta> getConsultas() {
        return this.consultas;
    }
    
    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }




}


