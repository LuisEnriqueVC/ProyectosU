<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
  <h1>restaurante</h1>
 <meta charset="UTF-8">
<title>don polo</title>
<?php
include("conexion.php");
$link=Conectarse();

$var_consulta= "select * from cenas";

$var_query = $link->query($var_consulta);

echo "<table align =center border=1 bgcolor=#6B6BFF>";
echo"<tr>";
echo "<td> idCenas </td>";
echo "<td> Nombre </td>";
echo "<td> Disponibilidad</td>";
echo "<td> precio </td>";
echo "<td> TiempoElaboracion </td>";
echo "<td> Descripcion </td>";
echo"</tr>";
while ($var_fila=$var_query->fetch_array())
{
$idCenas=$var_fila[0];
$Nombre=$var_fila[1];
$Disponibilidad=$var_fila[2];
$precio=$var_fila[3];
$TiempoElaboracion=$var_fila[4];
$Descripcion=$var_fila[5];

echo "<td>",$idCenas,"</td>";
echo "<td>",$Nombre,"</td>";
echo "<td>",$Disponibilidad,"</td>";
echo "<td>",$precio,"</td>";
echo "<td>",$TiempoElaboracion,"</td>";
echo "<td>",$Descripcion,"</td>";

echo "<tr><br>";
}
echo "</table>";

$link->close();
  ?>

</body>
</html>