package Model;
// Generated 23/09/2021 01:45:14 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Visitante generated by hbm2java
 */
public class Visitante  implements java.io.Serializable {


     private Integer idVisitante;
     private String nombre;
     private String apellidoP;
     private String apellidoM;
     private String ocupacion;
     private Date fechaVisita;
     private Date horaEntrada;
     private Date horaSalida;
     private String motivoVisita;
     private String numeroAfiliacion;
     private Long telefono;
     private String direccion;
     private Set<Consulta> consultas = new HashSet<Consulta>(0);

    public Visitante() {
    }

    public Visitante(String nombre, String apellidoP, String apellidoM, String ocupacion, Date fechaVisita, Date horaEntrada, Date horaSalida, String motivoVisita, String numeroAfiliacion, Long telefono, String direccion, Set<Consulta> consultas) {
       this.nombre = nombre;
       this.apellidoP = apellidoP;
       this.apellidoM = apellidoM;
       this.ocupacion = ocupacion;
       this.fechaVisita = fechaVisita;
       this.horaEntrada = horaEntrada;
       this.horaSalida = horaSalida;
       this.motivoVisita = motivoVisita;
       this.numeroAfiliacion = numeroAfiliacion;
       this.telefono = telefono;
       this.direccion = direccion;
       this.consultas = consultas;
    }
   
    public Integer getIdVisitante() {
        return this.idVisitante;
    }
    
    public void setIdVisitante(Integer idVisitante) {
        this.idVisitante = idVisitante;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoP() {
        return this.apellidoP;
    }
    
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return this.apellidoM;
    }
    
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public String getOcupacion() {
        return this.ocupacion;
    }
    
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public Date getFechaVisita() {
        return this.fechaVisita;
    }
    
    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    public Date getHoraEntrada() {
        return this.horaEntrada;
    }
    
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public Date getHoraSalida() {
        return this.horaSalida;
    }
    
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    public String getMotivoVisita() {
        return this.motivoVisita;
    }
    
    public void setMotivoVisita(String motivoVisita) {
        this.motivoVisita = motivoVisita;
    }
    public String getNumeroAfiliacion() {
        return this.numeroAfiliacion;
    }
    
    public void setNumeroAfiliacion(String numeroAfiliacion) {
        this.numeroAfiliacion = numeroAfiliacion;
    }
    public Long getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set<Consulta> getConsultas() {
        return this.consultas;
    }
    
    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }




}


