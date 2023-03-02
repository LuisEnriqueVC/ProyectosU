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
                            <a class="btn btn-outline-light" href="listaEmpleado.htm">Ver Registro</a>
                            <a class="btn btn-outline-light" href="index.htm">Inicio</a>
                        </div>
                    </div>
                    <div class="card-body">
                        <form method="POST">
                            <img title="QR" src="img/QR.png" width="300" height="300"/>
                            <h3 class="qr">CODIGO QR</h3>
                            <label>Nombre</label>
                            <input type = "text" name="nombre" class="form-control" value="${lista[0].nombre}"/>
                            <label>Apellido Paterno</label>
                            <input type = "text" name="apellidoP" class="form-control" value="${lista[0].apellidoP}"/>
                            <label>Apellido Materno</label>
                            <input type = "text" name="apellidoM" class="form-control" value="${lista[0].apellidoM}"/>
                            <label>Telefono</label>
                            <input type = "number" name="telefono" class="form-control" value="${lista[0].telefono}"/>
                            <label>Direcciòn</label>
                            <input type = "text" name="direccion" class="form-control" value="${lista[0].direccion}"/>
                            <label>NIMSS</label>
                            <input type = "text" name="NIMSS" class="form-control" value="${lista[0].NIMSS}"/>
                            <br>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>