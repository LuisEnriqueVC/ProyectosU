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
public class visitante {
    Date dat = new java.util.Date();//Declaramos un objeto date
    SimpleDateFormat simpleDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat simpleHora = new java.text.SimpleDateFormat("HH:mm:ss");
    
    private int idVisitante;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String ocupacion;
    private String fechaVisita= simpleDate.format(dat);
    private String horaEntrada = simpleHora.format(dat);
    private String horaSalida = simpleHora.format(dat);
    private String motivoVisita;
    private String numeroAfiliacion;
    private long telefono;
    private String direccion;

    public visitante() {
    }

    public visitante(int idVisitante, String nombre, String apellidoP, String apellidoM, String ocupacion, String motivoVisita, String numeroAfiliacion, long telefono, String direccion) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.ocupacion = ocupacion;
        this.motivoVisita = motivoVisita;
        this.numeroAfiliacion = numeroAfiliacion;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public int getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(int idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getMotivoVisita() {
        return motivoVisita;
    }

    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }

    public String getNumeroAfiliacion() {
        return numeroAfiliacion;
    }

    public void setNumeroAfiliacion(String numeroAfiliacion) {
        this.numeroAfiliacion = numeroAfiliacion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
