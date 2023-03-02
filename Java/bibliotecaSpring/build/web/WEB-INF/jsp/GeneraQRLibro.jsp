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
        <title>QR Libros</title>
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
                            <a class="btn btn-outline-light" href="listaLibro.htm">Ver Registro</a>
                            <a class="btn btn-outline-light" href="index.htm">Inicio</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <form method="POST">
                            <img title="QR" src="img/QR.png" width="300" height="300" id="imagenQR"/>
                            <h3 class="qr">CODIGO QR</h3>
                            <label>Titulo</label>
                            <input type = "text" name="titulo" class="form-control" value="${lista[0].titulo}"/>
                            <label>Hora de ingreso</label>
                            <input type = "text" name="horaIngreso" class="form-control" value="${lista[0].horaIngreso}"/>
                            <label>Autor</label>
                            <input type = "text" name="autor" class="form-control" value="${lista[0].autor}"/>
                            <label>Editorial</label>
                            <input type = "text" name="editorial" class="form-control" value="${lista[0].editorial}"/>
                            <label>Fecha de publicación</label>
                            <input type = "date" name="fPublicacion" class="form-control" value="${lista[0].fPublicacion}"/>
                            <label>Tiempo de conservación (Años)</label>
                            <input type = "number" name="tiemConservacion" class="form-control" value="${lista[0].tiemConservacion}"/>
                            <label>Genero</label>
                            <input type = "text" name="genero" class="form-control" value="${lista[0].genero}"/>
                            <label>Ejemplares</label>
                            <input type = "text" name="ejemplares" class="form-control" value="${lista[0].ejemplares}"/>
                            <label>Seccion</label>
                            <input type = "text" name="seccion" class="form-control" value="${lista[0].seccion}"/>
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