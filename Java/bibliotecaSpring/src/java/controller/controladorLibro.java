/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import QR.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.libro;
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
 * @author obria
 */
@Controller
public class controladorLibro {
    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET
    
    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaLibro.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar(){
        mav.addObject(new libro());
        mav.setViewName("altaLibro");
        return mav;
    }
    
    //METODO PARA AGREGAR
    @RequestMapping(value = "altaLibro.htm", method = RequestMethod.POST)
    public ModelAndView Agregar (libro e){
        String sql = "insert into libro (titulo,horaIngreso,autor,editorial,fPublicacion,tiemConservacion,genero,ejemplares,seccion) values (?,?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, e.getTitulo(),e.getHoraIngreso(),e.getAutor(),e.getEditorial(),e.getfPublicacion(),e.getTiemConservacion(),e.getGenero(),e.getEjemplares(),e.getSeccion());
        return new ModelAndView("redirect:/altaLibro.htm");
    }
    
    int idLibro;
    List datos;
    
    @RequestMapping("listaLibro.htm")
    public ModelAndView Lista(){
        String sql = "select * from libro";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("listaLibro");
        return mav;
    }
   
    @RequestMapping(value = "editarLibro.htm" , method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request){
        idLibro = Integer.parseInt(request.getParameter("idLibro")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from libro where idLibro=" + idLibro;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarLibro");
        return mav;
    }
    
    //Metodo para editar
    @RequestMapping(value = "editarLibro.htm", method = RequestMethod.POST)
    public ModelAndView Editar(libro e){
        String sql = "update libro set titulo=?,horaIngreso=?,autor=?,editorial=?,fPublicacion=?,tiemConservacion=?,genero=?,ejemplares=?,seccion=? where idLibro=?";
        this.jdbc.update(sql,e.getTitulo(),e.getHoraIngreso(),e.getAutor(),e.getEditorial(),e.getfPublicacion(),e.getTiemConservacion(),e.getGenero(),e.getEjemplares(),e.getSeccion(),idLibro);
        return new ModelAndView("redirect: listaLibro.htm");
    }

    //Metodo para eliminar
    @RequestMapping(value = "eliminarLibro.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    idLibro = Integer.parseInt(request.getParameter("idLibro")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "delete from libro where idLibro=" + idLibro;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaLibro.htm");
    }
    //QR
    @RequestMapping(value = "GeneraQRLibro.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        File fichero = new File("C:\\Users\\Luis\\Downloads\\biblioteca2\\biblioteca\\web\\WEB-INF\\img\\QR.png");
        
        idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String sql = "select * from libro WHERE idLibro="+idLibro;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        /*if (fichero.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero no pudó ser borrado");
        }*/
        
        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.100.10:8080/biblioteca/QRVistaLibro.htm?idLibro=" + idLibro, 300, 300);
        try {
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(5000);
        mav.setViewName("GeneraQRLibro");
        return mav;
    }
    
    @RequestMapping(value = "QRVistaLibro.htm", method = RequestMethod.GET)
    public ModelAndView vistaQR(HttpServletRequest request) {
        idLibro = Integer.parseInt(request.getParameter("idLibro"));
        String sql = "select * from libro where idLibro="+idLibro;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("QRVistaLibro");
        return mav;
    }
}