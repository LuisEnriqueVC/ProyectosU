<%-- 
    Document   : listaBiblioteca
    Created on : 14/03/2022, 06:48:27 PM
    Author     : felip
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="icon" href="https://images.vexels.com/media/users/3/153537/isolated/preview/691d43624a3f2cbe1268e7e20a030fe8-icono-de-pila-de-libro.png">
        
        <title>Lista General</title>
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
    </nav>
        <div class="container mt-4">
            <div class="card boarder-info">
                <div class="card-header " id="tab" style="text-align: center; ">
                    <h3 style="font-size: 50px;">Lista general</h3>
                    
                </div>
                <div class="card-body" id="tab">
                    <input class="form-control" id="myInput" type="text" placeholder="Buscar..">
                    <table class="table table-hover">
                        <thead class="letras">
                            <tr>
                                <th>Identificación</th>
                                <th>Direccion</th>
                                <th>Nombre de la Biblioteca</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th>Clave de Trabajo</th>
                            </tr>
                        </thead>
                        <tbody id="myTable" class="letras">
                            <c:forEach var="dato" items="${lista}">
                                <tr>
                                    <td>${dato.idBiblioteca}</td>
                                    <td>${dato.direccion}</td>
                                    <td>${dato.nombre}</td>  
                                  
                                    <td>${dato.telefono}</td>
                                    <td>${dato.correo}</td>
                                    <td>${dato.claveTrabajo}</td>
                                    <td>
                                        <a href="editarBiblioteca.htm?idBiblioteca=${dato.idBiblioteca}"
                                           class="btn btn-warning">Editar</a>
                                           
                                        <a href="eliminarBiblioteca.htm?idBiblioteca=${dato.idBiblioteca}"
                                           class="btn btn-danger">Eliminar</a>
                                        
                                    </td>
                                    <td>
                                        <a href="GeneraQRBiblioteca.htm?idBiblioteca=${dato.idBiblioteca}" class="btn btn-success">QR</a>
                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
       <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)

                    });
                });
            });
        </script>
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
            .letras{
                color: white;
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

