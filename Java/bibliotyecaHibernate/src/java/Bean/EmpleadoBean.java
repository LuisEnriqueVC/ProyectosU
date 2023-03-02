/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.EmpleadoDao;
import DAO.EmpleadoDaoImplement;
import Model.Empleado;
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
public class EmpleadoBean {
    private Empleado empleado;
    private List<Empleado> empleados;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.empleado = Empleado;
    }

    public List<Empleado> getEmpleados() {
        EmpleadoDao dao = new EmpleadoDaoImplement();
        empleados = dao.mostrarEmpleado();
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
        empleado = new Empleado();
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void insertar() {
        EmpleadoDao dao = new EmpleadoDaoImplement();
        dao.insertarEmpleado(empleado);
        empleado = new Empleado();
        addMessage("Empleado Agregado");
    }
    
}
