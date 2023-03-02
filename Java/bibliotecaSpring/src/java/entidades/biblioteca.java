/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SALA 2-05
 */
public class biblioteca {

    private int idBiblioteca;
    private String direccion;
    private String nombre;
    private long telefono;
    private String correo;
    private String claveTrabajo;

    public biblioteca() {
    }

    public biblioteca(int idBiblioteca, String direccion, String nombre, long telefono, String correo, String claveTrabajo) {
        this.idBiblioteca = idBiblioteca;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.claveTrabajo = claveTrabajo;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClaveTrabajo() {
        return claveTrabajo;
    }

    public void setClaveTrabajo(String claveTrabajo) {
        this.claveTrabajo = claveTrabajo;
    }
    
}


