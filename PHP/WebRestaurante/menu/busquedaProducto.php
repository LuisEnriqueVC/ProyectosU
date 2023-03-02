<?php
require('fpdf/fpdf/fpdf.php');

class PDF extends FPDF
{
// Cabecera de página
function Header()
{
    // Logo
    //$this->Image('imagenes/chocolate.png',10,8,33);
    // Arial bold 15
    $this->SetFont('Arial','B',18);
    // Movernos a la derecha
    $this->Cell(80);
    // Título
    $this->Cell(30,10,'Productos',0,0,'C');
    // Salto de línea
    $this->Ln(20);
}

// Pie de página
function Footer()
{
    // Posición: a 1,5 cm del final
    $this->SetY(-15);
    // Arial italic 8
    $this->SetFont('Arial','I',8);
    // Número de página
    $this->Cell(0,10,utf8_decode('Página ').$this->PageNo().'/{nb}',0,0,'C');
}
}
//--- para consulta
include("conexion.php");
//require "Conexion.php";
$link=Conectarse();
$codigo=$_REQUEST['id'];
$var_consulta= "select * from factura where idDesayunos=$codigo";
$pdf = new PDF();
$pdf->AliasNBPages();
$pdf->AddPage();
$pdf->SetFont('Arial','B',12);
$pdf->Cell(90,10,'Nombre Producto',1,0,'C',0);
$pdf->Cell(30,10,'Precio',1,0,'C',0);
$pdf->Cell(30,10,'foto',1,1,'C',0);
//$pdf->Cell(30,10,'total',1,1,'C',0);
$var_query = $link->query($var_consulta);
while ($var_fila=$var_query->fetch_array())
{
    $V2=$var_fila[1];
    $V3=$var_fila[2];
    $V4=$var_fila[3];
   /* $V5=$var_fila[5];
    $V6=$var_fila[6];
    $V7=$var_fila[7];
    $V8=$var_fila[8];
    $V9=$var_fila[9];
*/
$pdf->Cell(90,10,$V2,1,0,'C',0);
$pdf->Cell(30,10,$V3,1,0,'C',0);
$pdf->Cell(30,10,$V4,1,0,'C',0);
//$pdf->Cell(30,10,$V5,1,0,'C',0);
//$pdf->Cell(30,10,$V6,1,0,'C',0);
//$pdf->Cell(30,10,$V7,1,0,'C',0);
//$pdf->Cell(30,10,$V8,1,0,'C',0);
//$pdf->Cell(30,10,$V9,1,1,'C',0);
// Creación del objeto de la clase heredada

}
$pdf->Output();
?>