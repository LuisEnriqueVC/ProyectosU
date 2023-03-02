/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import QR.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.consulta;
import entidades.empleado;
import entidades.libro;
import entidades.visitante;
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
public class controladorConsulta {

    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbc = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET

    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaConsulta.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar() {
        ///Lista de id de los empleado
        String sql1 = "select * from empleado";
        datos = this.jdbc.queryForList(sql1);
        mav.addObject("lista2", datos);
        ///Lista de id de los visitantes
        String sql2 = "select * from visitante";
        datos = this.jdbc.queryForList(sql2);
        mav.addObject("lista3", datos);

        ///Lista de id de los libros
        String sql3 = "select * from libro";
        datos = this.jdbc.queryForList(sql3);
        mav.addObject("lista4", datos);

        mav.addObject(new consulta());
        mav.setViewName("altaConsulta");
        return mav;
    }

    //METODO PARA AGREGAR
    @RequestMapping(value = "altaConsulta.htm", method = RequestMethod.POST)
    public ModelAndView Agregar(consulta c) {
        String sql = "insert into consulta (titulo,fecha,hora,devolucion,seccion,generoLibro,prestamo,estadoDevolucion,empleado,visitante,libro) values (?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbc.update(sql, c.getTitulo(), c.getFecha(), c.getHora(), c.getDevolucion(), c.getSeccion(), c.getGeneroLibro(), c.getPrestamo(), c.getEstadoDevolucion(), c.getEmpleado(), c.getVisitante(), c.getLibro());
        return new ModelAndView("redirect:/altaConsulta.htm");
    }

    int idConsulta;
    List datos;
    List datos2;

    @RequestMapping("listaConsulta.htm")
    public ModelAndView Lista() {
        String sql = "select * from consulta";
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("listaConsulta");
        return mav;
    }

    @RequestMapping(value = "editarConsulta.htm", method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request) {
        idConsulta = Integer.parseInt(request.getParameter("idConsulta")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from consulta where idConsulta=" + idConsulta;
        datos = this.jdbc.queryForList(sql);
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarConsulta");
        return mav;
    }

    //Metodo para editar
    @RequestMapping(value = "editarConsulta.htm", method = RequestMethod.POST)
    public ModelAndView Editar(consulta c) {
        String sql = "update consulta set titulo=?,fecha=?,hora=?,devolucion=?,seccion=?,generoLibro=?,prestamo=?,estadoDevolucion=?,empleado=?,visitante=?,libro=? where idConsulta=?";
        this.jdbc.update(sql, c.getTitulo(), c.getFecha(), c.getHora(), c.getDevolucion(), c.getSeccion(), c.getGeneroLibro(), c.getPrestamo(), c.getEstadoDevolucion(), c.getEmpleado(), c.getVisitante(), c.getLibro(), idConsulta);
        return new ModelAndView("redirect: listaConsulta.htm");
    }

    /*
    //Metodo para eliminar
    
    @RequestMapping(value = "eliminarBiblioteca.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    idBiblioteca = Integer.parseInt(request.getParameter("idBiblioteca")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "delete from biblioteca where idBiblioteca=" + idBiblioteca;
        this.jdbc.update(sql);
        return new ModelAndView("redirect:/listaBiblioteca.htm");
    }*/
    //QR
    @RequestMapping(value = "GeneraQRConsulta.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        File fichero = new File("C:\\Users\\Luis\\Downloads\\biblioteca2\\biblioteca\\web\\img\\QR.png");
        
        idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
        String sql = "select * from consulta WHERE idConsulta="+idConsulta;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        
        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.100.10:8080/biblioteca/QRVistaConsulta.htm?idConsulta=" + idConsulta, 300, 300);
        
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(20000);
        mav.setViewName("GeneraQRConsulta");
        return mav;
    }
    
    @RequestMapping(value = "QRVistaConsulta.htm", method = RequestMethod.GET)
    public ModelAndView vistaQR(HttpServletRequest request) {
        idConsulta = Integer.parseInt(request.getParameter("idConsulta"));
        String sql = "select * from consulta where idConsulta="+idConsulta;
        datos = this.jdbc.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("QRVistaConsulta");
        return mav;
    }
}
    
    

