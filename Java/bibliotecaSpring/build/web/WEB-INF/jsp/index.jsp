<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="icon" href="https://images.vexels.com/media/users/3/153537/isolated/preview/691d43624a3f2cbe1268e7e20a030fe8-icono-de-pila-de-libro.png">
        
    </head>

    <body>

    <nav class="navbar  navbar-expand-lg navbar-dark bg-dark" class="nav justify-content-center">

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
   
    <section class="imagen1">
        <img src="https://www.comunidadbaratz.com/wp-content/uploads/2021/06/Futuro-de-la-biblioteca.jpg" alt="">
        <div class="posicion">

            <p>
            <h1>Bienvenido a BIBLIOTECHMEX</h1>
            </p>
            <br>
            <p>
            <h2>
                La herramienta ideal para el manejo del control de toda la biblioteca, con el fin de poder hacerle más facil su trabajo. 
            </h2>
            </p>
        </div>
    </section>
   
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

        .posicion {
            
            display: table-cell;
            width: calc(
                50vw - 100px
                ); /*calculo para que quede centrado sin importar el tamaño de la pagina*/
            height: calc(
                50vh - 5px
                ); /*calculo para que quede centrado sin importar el tamaño de la pagina*/
            vertical-align: middle;
        }
        .posicion h1 {
            font-family: Arial, Helvetica, sans-serif;
            max-width: 80%;
            margin: 10px auto;
            text-align: left;
            color: #09183A;
            font-weight: 700;
            font-size: 50px;
        }
        .posicion h2 {
            font-family: Arial, Helvetica, sans-serif;
            max-width: 80%;
            margin: 10px auto;
            text-align: justify;
            color: black;
            font-weight: 700;
            font-size: 20px;
        }
    </style>
</body>
</html>
