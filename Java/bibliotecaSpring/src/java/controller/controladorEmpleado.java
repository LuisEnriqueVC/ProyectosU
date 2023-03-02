/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import QR.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.empleado;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author felip
 */
@Controller
public class controladorEmpleado {
    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET
    
    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaEmpleado.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar(){
        mav.addObject(new empleado());
        mav.setViewName("altaEmpleado");
        return mav;
    }
    
    //METODO PARA AGREGAR
    @RequestMapping(value = "altaEmpleado.htm", method = RequestMethod.POST)
    public ModelAndView Agregar (empleado e){
        String sql = "insert into empleado (nombre,apellidoP,apellidoM,telefono,direccion,NIMSS) values (?,?,?,?,?,?)";
        this.jdbc.update(sql, e.getNombre(),e.getApellidoP(),e.getApellidoM(),e.getTelefono(),e.getDireccion(),e.getNIMSS());
        return new ModelAndView("redirect:/altaEmpleado.htm");
    }
    
    int idEmpleado;
    List datos;
    
    @RequestMapping("listaEmpleado.htm")
    public ModelAndView Lista(){
        String sql = "select * from empleado";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("listaEmpleado");
        return mav;
    }
   
    @RequestMapping(value = "editarEmpleado.htm" , method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request){
        idEmpleado = Integer.parseInt(request.getParameter("idEmpleado")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from empleado where idEmpleado=" + idEmpleado;
        datos = this.jdbc.queryForList(sql);
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarEmpleado");
        return mav;
    }
    
    //Metodo para editar
    @RequestMapping(value = "editarEmpleado.htm", method = RequestMethod.POST)
    public ModelAndView Editar(empleado e){
        String sql = "update empleado set nombre=?,apellidoP=?,apellidoM=?,telefono=?,direccion=?,NIMSS=? where idEmpleado=?";
        this.jdbc.update(sql,e.getNombre(),e.getApellidoP(),e.getApellidoM(),e.getTelefono(),e.getDireccion(),e.getNIMSS(),idEmpleado);
        return new ModelAndView("redirect: listaEmpleado.htm");
    }
     
    //Metodo para eliminar
    @RequestMapping(value = "eliminarEmpleado.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    idEmpleado = Integer.parseInt(request.getParameter("idEmpleado")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "delete from empleado where idEmpleado=" + idEmpleado;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaEmpleado.htm");
    }
    
    //QR
    @RequestMapping(value = "GeneraQREmpleado.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        File fichero = new File("C:\\Users\\Luis\\Downloads\\biblioteca2\\biblioteca\\web\\WEB-INF\\img\\QR.png");
        
        idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
        String sql = "select * from empleado WHERE idEmpleado="+idEmpleado;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        /*if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }*/
        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.100.10:8080/biblioteca/QRVistaLibro.htm?idEmpleado=" + idEmpleado, 300, 300);
        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQREmpleado");
        return mav;
    }
    
    @RequestMapping(value = "QRVistaEmpleado.htm", method = RequestMethod.GET)
    public ModelAndView vistaQR(HttpServletRequest request) {
        idEmpleado = Integer.parseInt(request.getParameter("idEmpleado")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from empleado where idEmpleado=" + idEmpleado;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("QRVistaEmpleado");
        return mav;
    }
    
}
