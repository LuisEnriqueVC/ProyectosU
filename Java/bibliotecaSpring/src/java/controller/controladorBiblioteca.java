/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import QR.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.biblioteca;
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
 * @author SALA 2-01
 */
@Controller
public class controladorBiblioteca {
    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET
    
    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaBiblioteca.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar(){
        mav.addObject(new biblioteca());
        mav.setViewName("altaBiblioteca");
        return mav;
    }
    
    //METODO PARA AGREGAR
    @RequestMapping(value = "altaBiblioteca.htm", method = RequestMethod.POST)
    public ModelAndView Agregar (biblioteca b){
        String sql = "insert into biblioteca (direccion,nombre,telefono,correo,claveTrabajo) values (?,?,?,?,?)";
        this.jdbc.update(sql, b.getDireccion(), b.getNombre(),b.getTelefono(),b.getCorreo(),b.getClaveTrabajo());
        return new ModelAndView("redirect:/altaBiblioteca.htm");
    }
    
    int idBiblioteca;
    List datos;
    
    @RequestMapping("listaBiblioteca.htm")
    public ModelAndView Lista(){
        String sql = "select * from biblioteca";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("listaBiblioteca");
        return mav;
    }
   
    @RequestMapping(value = "editarBiblioteca.htm" , method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request){
        idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from biblioteca where idBiblioteca=" + idBiblioteca;
        datos = this.jdbc.queryForList(sql);
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarBiblioteca");
        return mav;
    }
    
    //Metodo para editar
    @RequestMapping(value = "editarBiblioteca.htm", method = RequestMethod.POST)
    public ModelAndView Editar(biblioteca b){
        String sql = "update biblioteca set direccion=?,nombre=?,telefono=?,correo=?,claveTrabajo=? where idBiblioteca=?";
        this.jdbc.update(sql,b.getDireccion(),b.getNombre(),b.getTelefono(),b.getCorreo(),b.getClaveTrabajo(),idBiblioteca);
        return new ModelAndView("redirect: listaBiblioteca.htm");
    }
     
    
    //Metodo para eliminar
    
    @RequestMapping(value = "eliminarBiblioteca.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "delete from biblioteca where idBiblioteca=" + idBiblioteca;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaBiblioteca.htm");
        
    }
    //QR
    @RequestMapping(value = "GeneraQRBiblioteca.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        File fichero = new File("C:\\Users\\Luis\\Downloads\\biblioteca2\\biblioteca\\web\\img\\QR.png");
        //C:\Users\Luis\Downloads\biblioteca2\biblioteca\web\WEB-INF\img\QR.png
        idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));
        String sql = "select * from biblioteca WHERE idBiblioteca="+idBiblioteca;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.100.10:8080/biblioteca/QRVistaBiblioteca.htm?idBiblioteca=" + idBiblioteca, 300, 300);
        ImageIO.write(imagen, formato, fichero);
        System.out.println("Prueba " + fichero.getPath());
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(20000);
        mav.setViewName("GeneraQRBiblioteca");
        return mav;
    }
    
    @RequestMapping(value = "QRVistaBiblioteca.htm", method = RequestMethod.GET)
    public ModelAndView vistaQR(HttpServletRequest request) {
        idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca"));
        String sql = "select * from biblioteca where idBiblioteca="+idBiblioteca;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("QRVistaBiblioteca");
        return mav;
    }
}
    
    

