<!DOCTYPE html>
<html>
         <title>Gracias por su compra!</title>
         <head>
             <title>Gracias por su compra!</title>
             <meta charset = "utf-8">
            <meta name= "keywords" content = "comidas. desayunos. postres, restaurante" >
            <meta name = "author" content = "Brian Orihuela, Felipe Reyes,Luis Vaca">
            <meta name = "copyright" content="Don Polo Inc.">
            <link rel="icon" href="../imagenes/logo2.ico">
            <link rel="stylesheet" type="text/css" href="estilos2.css">
     
        </head>
       
        <body>

            <header>
                <nav>
                    <br><br><br>
                    <div class="logo">
					
                        <img src="../imagenes/logo.jpg"alt="logo">

					</div>
                    
                    <ul class="menu">
                        
                        <li><a href="../Index.html">Inicio</a></li>
                        <li><a href="About.html">Sobre nosotros</a></li>
                        <li><a href="Desayunos.html">Desayunos</a></li>
                        <li><a href="Comidas.html">Comidas</a></li>
                        <li><a href="Cenas.html">Cenas</a></li>
                        <li><a href="Postres.html">Postres</a></li>
						<li><a href="factura.php">Factura</a></li>
                    </ul> 
                   
                </nav>
            </header>

                <STYLE>A {text-decoration: none;} </STYLE>

                <p class="textoI">Gracias por su <b>preferencia</b>, <b>¡Buen Provecho!...</b></p>
				
				
		<?php
include("conexion.php");
$link=Conectarse();
$codigo="45";

$var_consulta= "select * from postres where idPostres=$codigo";

$var_query = $link->query($var_consulta);

while ($var_fila=$var_query->fetch_array())
{
 $porta=$var_fila[3];


  $time=time();
$fecha=date("Y-m-d H:i:s", $time);
 echo "<br>";
 
echo "<form name ='ModificaL' method='POST' action='factuPDF.php'>
<p> 
<img src='../imagenes/crepachoco.png' align='right'>
<i><h2>Datos de la compra</h2></i>
<p><mark><ins><strong>Informacion de la compra</strong><ins></mark></p>
<i>Código del producto:::::::::::::::::::</i>
<input type='text' name='codigo' id='codigo' value='$var_fila[0]' >
<br>
<i>Producto:::::::::::::::::::::::::::::::::::::::::</i>
<input type='text' name='producto' id='producto' value='$var_fila[1]'>
<br>
<i>Disponibilidad::::::::::::::::::::::::::::::</i>
<input type='text' name='disponibilidad' id='disponibilidad' value='$var_fila[2]' >
<br>
<i>Precio::::::::::::::::::::::::::::::::::::::::::::::</i>
<input type='text' name='precio' id='precio' value='$var_fila[3]'>
<br>
<i>Tiempo Elaboracion:::::::::::::::::::</i>
<input type='text' name='tElaboracion' id='tElaboracion' value='$var_fila[4]' >
<br>
<i>Descripcion:::::::::::::::::::::::::::::::::::</i>
<input type='text' size='45' name='Descripcion' id='Descripcion' value='$var_fila[5]' >
<br>

<p><mark><ins><strong>Preferencias del cliente</strong><ins></mark></p>
<i><ins>Ingredientes Extras:</ins>
<br>
<input type='checkbox' name='ingrediente1' id='ingrediente1'>Cremas(+10$)
<br>
<input type='checkbox' name='ingrediente2' id='ingrediente1'>Fresas(+10$)
<br>
<input type='checkbox' name='ingrediente3' id='ingrediente1'>Lechera(+15$)
<br>
<input type='checkbox' name='ingrediente4' id='ingrediente1'>Mermelada(+15$)
<br>
<input type='checkbox' name='ingrediente5' id='ingrediente1'>Miel(+20$)
<br>
<br>
Cantidad:::::::::::::::::::::::::::::::::::::::::
<input type='text' name='cantidad' id='cantidad' >
<br>
Digitos de Tarjeta::::::::::::::::::::::::
<input type='text' name='tarjeta' id='tarjeta' >
<br>
Fecha:::::::::::::::::::::::::::::::::::::::::::::::
<input type='text' name='fecha' id='Fecha' value='$fecha' >
<br>
<input type='submit' value='Comprar'>
<br>

</i>

</p>
</form>

";

}
?>

<div class="loop-grid mb-30">
<div class="row">
<div class="col-lg-8 mb_30">
<div class="carausel-post-1 hover-up border-radius-10 overflow-hidden transition-normal position-relative wow fadeInUp animated">
<div class="arrow-cover"></div>
<div class="slide-fade">
<div class="position-relative post-thumb">
<div class="thumb-overlay img-hover-slide position-relative" style="background-image: url(../imagenes/publicidad.gif) ">
<a class="img-link" href="index.html"></a>
<span class="top-left-icon bg-danger"><i class="elegant-icon icon_image"></i></span>
<div class="post-content-ovelay text-blue ml-30 mr-30 pb-30">
<div class="entry-meta meta-0 font-small mb-20">
<a href="index.html"><span class="post-cat text-info text-uppercase"></span></a>
</div>
<h3 class="post-title font-weight-900 mb-20">
<a class="text-blue" href="index.html"></a>
</h3>
<div class="entry-meta meta-1 font-small text-blue mt-10 pr-5 pl-5">
<span class="post-on">26-Mayo-2021</span>
<br>
<span class="hit-count has-dot">18k views</span>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</div>
</div>


            <footer class="container-footer-all">
                <div class = "container-body">
                    <div class="columna1">
                        <h1>Mas información de la compañia</h1>
                        <p>Somos una compañia rstauranterra enfocada en mejoras nuestros productos para asi satisfacer satisfactoriamente el paladar de nuestros clientes con el objetivo de ser la mejor compañia restaurantera mexicana del mundo</p>
                    </div>
                    <div class="columna2">
                        <h1>Redes sociales</h1>
                        <div class = "row">
                            <a href="https://facebook.com">
                            <img src="../imagenes/facebook.png" alt="">
                            </a>
                            <label>Siguenos en Facebook</label>
                        </div>
                        <div class = "row">
                            <a href="https://twitter.com">
                            <img src="../imagenes/twitter.png" alt="">
                            </a>
                            <label>Siguenos en Twitter</label>
                        </div>
                        <div class = "row">
                            <a href="https://instagram.com">
                            <img src="../imagenes/insta.png" alt="">
                             </a>
                            <label>Siguenos en Instagram</label>
                        </div>
                        <div class = "row">
                            <a href="https://youtube.com">
                            <img src="../imagenes/youtube.png" alt="">
                            </a>
                            <label>Siguenos en Youtube</label>
                        </div>
                        <div class = "row">
                            <a href="https://twitch.com">
                            <img src="../imagenes/twitch.png" alt="">
                            </a>
                            <label>Siguenos en Twitch</label>
                        </div>

                    </div>
                    <div class="columna3">
                        <h1>Contacto</h1>
                        
                        <div class="row2">
                            <img src="../imagenes/domicilio.png" alt="">
                            <label>Valle de Chalco Sol. 
                                Estado de México, 
                                Sucursal Plaza Patio 
                                Local #97</label>
                        </div>
                        <div class="row2">
                            <img src="../imagenes/telefono.png" alt="">
                            <label>+52_5531166769</label>
                        </div>
                        <div class="row2">
                            <img src="../imagenes/email.png" alt="">
                            <label>DonPoloRes@gmail.com</label>
                        </div>
                    </div>
                   
                </div>

                <div class="container-footer">
                    <div class = "copyright">
                        ©2021 Todos los derechos reservados | UAEMEX
                    </div>
                    <div class="information">
                        Informacion de la compañia | Privación y politica | Términos y condiciones
                    </div>
                </div>

            </footer>

        </body>

</html>