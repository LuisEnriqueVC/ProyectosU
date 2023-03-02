/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import QR.QRCodeUtil;
import com.google.zxing.WriterException;
import config.conexionBD;
import entidades.visitante;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author SALA 2-18
 */
public class controladorVisitante {
    //Instancia para conexion
    conexionBD con = new conexionBD();
    JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView(); //Importar la que dice SERVLET
    
    //Metodo para las vistas - METODO PARA OBTENER VISTAS
    @RequestMapping(value = "altaVisitante.htm", method = RequestMethod.GET)
    public ModelAndView VistaAgregar(){
        mav.addObject(new visitante());
        mav.setViewName("altaVisitante");
        return mav;
    }
    
    //METODO PARA AGREGAR
    @RequestMapping(value = "altaVisitante.htm", method = RequestMethod.POST)
    public ModelAndView Agregar (visitante v){
        String sql = "insert into visitante (nombre,apellidoP,apellidoM,ocupacion,fechaVisita,horaEntrada, "
                + "horaSalida, motivoVisita, numeroAfiliacion, telefono, direccion) values (?,?,?,?,?,?,?,?,?,?,?)";
        this.jdbcTemplate.update(sql, v.getNombre(), v.getApellidoP(), v.getApellidoM(),v.getOcupacion(),v.getFechaVisita(),v.getHoraEntrada(),v.getHoraSalida(),v.getMotivoVisita(),v.getNumeroAfiliacion(),v.getTelefono(),v.getDireccion());
        return new ModelAndView("redirect:/altaVisitante.htm");
    }
    int idVisitante;
    List datos;
    
    @RequestMapping("listaVisitante.htm")
    public ModelAndView Lista(){
        String sql = "select * from visitante";
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("listaVisitante");
        return mav;
    }
    
    @RequestMapping(value = "editarVisitante.htm" , method = RequestMethod.GET)
    public ModelAndView vistaEditar(HttpServletRequest request){
        idVisitante = Integer.parseInt(request.getParameter("idVisitante")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "select * from visitante where idVisitante=" + idVisitante;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("editarVisitante");
        return mav;
    }
    
    //Metodo para editar
    @RequestMapping(value = "editarVisitante.htm", method = RequestMethod.POST)
    public ModelAndView Editar(visitante v){
        String sql = "update visitante set nombre=?,apellidoP=?,apellidoM=?,ocupacion=?,fechaVisita=?,horaEntrada=?,"
                + "horaSalida=?,motivoVisita=?,numeroAfiliacion=?,telefono=?,direccion=? where idVisitante=?";
        this.jdbcTemplate.update(sql,v.getNombre(),v.getApellidoP(),v.getApellidoM(),v.getOcupacion(),v.getFechaVisita(),v.getHoraEntrada(),v.getHoraSalida(),v.getMotivoVisita(),
                v.getNumeroAfiliacion(),v.getTelefono(),v.getDireccion(),idVisitante);
        return new ModelAndView("redirect: listaVisitante.htm");
    }
    
     //Metodo para eliminar
    
    @RequestMapping(value = "eliminarVisitante.htm")
    public ModelAndView Eliminar(HttpServletRequest request){
    idVisitante = Integer.parseInt(request.getParameter("idVisitante")); //Este "codigo" es el nombre a como esrta en la base de datos
        String sql = "delete from visitante where idVisitante=" + idVisitante;
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:/listaVisitante.htm");
    }
     //QR
    @RequestMapping(value = "GeneraQRVisitante.htm", method = RequestMethod.GET)
    public ModelAndView qr(HttpServletRequest request) throws WriterException, FileNotFoundException, IOException, InterruptedException {
        File fichero = new File("C:\\Users\\Luis\\Downloads\\biblioteca2\\biblioteca\\web\\img\\QR.png");
        
        idVisitante = Integer.parseInt(request.getParameter("idVisitante"));
        String sql = "select * from visitante WHERE idVisitante="+idVisitante;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        
        String formato = "png";
        QRCodeUtil generaQR = new QRCodeUtil();
        BufferedImage imagen = generaQR.crearQR("http://192.168.100.10:8080/biblioteca/QRVistaVisitante.htm?idVisitante=" + idVisitante, 300, 300);
        
            ImageIO.write(imagen, formato, fichero);
            System.out.println("Prueba " + fichero.getAbsolutePath());
        System.out.println("Quedo " + fichero.getAbsolutePath());
        Thread.sleep(2000);
        mav.setViewName("GeneraQRVisitante");
        return mav;
    }
    
    @RequestMapping(value = "QRVistaVisitante.htm", method = RequestMethod.GET)
    public ModelAndView vistaQR(HttpServletRequest request) {
        idVisitante = Integer.parseInt(request.getParameter("idVisitante"));
        String sql = "select * from visitante where idVisitante="+idVisitante;
        datos = this.jdbcTemplate.queryForList(sql);
        mav.addObject("lista", datos);
        mav.setViewName("QRVistaVisitante");
        return mav;
    }
}