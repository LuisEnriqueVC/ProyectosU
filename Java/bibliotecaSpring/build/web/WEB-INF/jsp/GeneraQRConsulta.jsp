<%-- 
    Document   : altaProducto
    Created on : 16/02/2022, 07:43:57 AM
    Author     : SALA 2-01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>QR Consultas</title>
    </head>
    <body>
        <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">

            <a class="navbar-brand" href="index.htm">BILIBLIOTECHMEX</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="container mt-4 col-lg-a">
                <div class="card boarder-info">
                    <div class="card-header bg-info">
                        <h3 class="qr0">ESCANEA EL CODIGO QR</h3>
                        <div style="float: right">
                            <a class="btn btn-outline-light" href="listaConsulta.htm">Ver Registro</a>
                            <a class="btn btn-outline-light" href="index.htm">Inicio</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <form method="POST">
                            <img title="QR" src="img/QR.png" width="300" height="300" id="imagenQR"/>
                            <h3 class="qr">CODIGO QR</h3>
                <form method="POST">
                    <label>Titulo del Libro</label>
                        <input type = "text" name="titulo" class="form-control" value="${lista[0].titulo}"/>
                        <label>Fecha del Prestamo</label>
                        <input type = "date" name="fecha" class="form-control" value="${lista[0].fecha}"/>
                        <label>Hora del Prestamo</label>
                        <input type = "time" name="hora" class="form-control" value="${lista[0].hora}"/>
                         <label>Fecha estimada para la dvoluciòn</label>
                        <input type = "date" name="devolucion" class="form-control" value="${lista[0].devolucion}"/>
                        <label>Seccion tomada del libro</label>
                        <input type = "text" name="seccion" class="form-control" value="${lista[0].seccion}"/>
                        <label>Genero del Libro</label>
                        <input type = "text" name="generoLibro" class="form-control" value="${lista[0].generoLibro}"/>
                        <label>Se realizo el prestamo?</label>
                        <input type = "text" name="prestamo" class="form-control" value="${lista[0].prestamo}"/>
                        <label>Estado de la Devoluciòn</label>
                        <input type = "text" name="estadoDevolucion" class="form-control" value="${lista[0].estadoDevolucion}"/>
                        <label>Id del Empleado que realizo el prestamo</label>
                        <input type = "number" name="empleado" class="form-control" value="${lista[0].empleado}"/>
                        <label>Id del visitante</label>
                        <input type = "number" name="visitante" class="form-control" value="${lista[0].visitante}"/>
                        <label>Id del Libro</label>
                        <input type = "number" name="libro" class="form-control" value="${lista[0].libro}"/>
                        <br>
                        
                    </form>
                    </div>
                </div>
            </div>

            <<style type="text/css" media="screen">
            body{
            background: url("https://images.freecreatives.com/wp-content/uploads/2016/03/Opened-Book-Texture.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }
        
        .qr0{
            color: white;
        }
        
        .qr{
            text-align: center
        }

        </style>
    </body>
</html>