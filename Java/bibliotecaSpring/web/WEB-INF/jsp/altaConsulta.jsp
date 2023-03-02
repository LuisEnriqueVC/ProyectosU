<%-- 
    Document   : altaConsulta
    Created on : 23/03/2022, 07:58:08 AM
    Author     : SALA 2-05
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="icon" href="https://images.vexels.com/media/users/3/153537/isolated/preview/691d43624a3f2cbe1268e7e20a030fe8-icono-de-pila-de-libro.png">

        <title>Agregar Consulta</title>
    </head>
    <body>
        <nav class="navbar  navbar-expand-lg navbar-dark bg-dark">

            <a class="navbar-brand" href="index.htm">BIBLIOTECHMEX</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="nav nav-tabs" >
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-expanded="false">Altas</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="altaBiblioteca.htm">Alta Biblioteca</a>
                            <a class="dropdown-item" href="altaEmpleado.htm">Alta Empleado</a>
                            <a class="dropdown-item" href="altaVisitante.htm">Alta Visitante</a>
                            <a class="dropdown-item" href="altaLibro.htm">Alta Libro</a>
                            <a class="dropdown-item" href="altaConsulta.htm">Alta Consulta</a>
                            <div class="dropdown-divider"></div>

                        </div>
                    </li>
                </ul>
                <ul class="nav nav-tabs" class="nav justify-content-center">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="" role="button" aria-expanded="false">Listas</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="listaBiblioteca.htm">Lista Biblioteca</a>
                            <a class="dropdown-item" href="listaEmpleado.htm">Lista Empleado</a>
                            <a class="dropdown-item" href="listaVisitante.htm">Lista Visitante</a>
                            <a class="dropdown-item" href="listaLibro.htm">Lista Libro</a>
                            <a class="dropdown-item" href="listaConsulta.htm">Lista Consulta</a>
                            <div class="dropdown-divider"></div>

                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container mt-4 col-lg-a">
            <div class="card boarder-info">
                <div class="card-header" id="tab" style="text-align: center; ">
                    <h3 style="font-size: 50px;">Nuevo Registro</h3>
                </div>
            </div>
            <div class="card-body" id="tab">
                <form method="POST">
                    <label>Titulo del Libro</label>
                    <input type = "text" name="titulo" class="form-control"/>
                    <label>Fecha del Prestamo</label>
                    <input type = "date" name="fecha" class="form-control"/>
                    <label>Hora del Prestamo</label>
                    <input type = "time" name="hora" class="form-control"/>
                    <label>Fecha estimada para la dvoluciòn</label>
                    <input type = "date" name="devolucion" class="form-control"/>
                    <label>Seccion tomada del libro</label>
                    <input type = "text" name="seccion" class="form-control"/>
                    <label>Genero del Libro</label>
                    <input type = "text" name="generoLibro" class="form-control"/>
                    <label>Se realizo el prestamo?</label>
                    <input type = "text" name="prestamo" class="form-control"/>
                    <label>Estado de la Devoluciòn</label>
                    <input type = "text" name="estadoDevolucion" class="form-control"/>


                    <label>Id del Empleado que realizo el prestamo</label>

                    <select  name="empleado" class="form-control" required="true">

                        <c:forEach var="dato" items="${lista2}">
                            <option value="${dato.idEmpleado}">${dato.nombre}</option>
                        </c:forEach>
                    </select>

                    <label>Id del visitante</label>
                    <select  name="visitante" class="form-control" required="true">

                        <c:forEach var="dato" items="${lista3}">
                            <option value="${dato.idVisitante}">${dato.nombre}</option>
                        </c:forEach>
                    </select>


                    <label>Id del Libro</label>

                    <select  name="libro" class="form-control" required="true">

                        <c:forEach var="dato" items="${lista4}">
                            <option value="${dato.idLibro}">${dato.titulo}</option>
                        </c:forEach>
                    </select>
                    <br>
                    <button type="submit" class="btn btn-success">Agregar</button>
                </form>
            </div>
        </div>
    </div>

    <style type="text/css" media="screen">
        body{
            background: url("https://images.freecreatives.com/wp-content/uploads/2016/03/Opened-Book-Texture.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }
        
        .collapse{
            background-color: white;
            width: 100px;
        }

        .navbar-brand{
            margin-left : 20px;
            margin-right: 60px;
        }
        
        .imagen1 img {
            width: 760px;
            height:600px;
            float: right;
            border-radius: 10px;
            margin-top: 20px;
            margin-right: 10px;
        }
        #tab{
            background: url("https://img.freepik.com/foto-gratis/fondo-azul-degradado-lujo-abstracto-azul-oscuro-liso-vineta-negra_1258-48251.jpg?size=626&ext=jpg&ga=GA1.2.1591037111.1643587200");
            color: white;
            border-color: rgba(0, 151, 255, 0.76);
            border-width: 5px;
            border-style: solid;
            background-repeat: no-repeat;
            background-size: cover;
            font-family: Arial, Helvetica, sans-serif;

        }

        #tab button{
            margin: auto;
            display: block;
            text-align: center;

        }

        #tab input{
            background: rgba(0, 0, 0, 0.5);
            color: white;
        }
    </style>
</body>
</html>
