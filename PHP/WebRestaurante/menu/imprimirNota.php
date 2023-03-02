<?php
require('fpdf/fpdf.php');

class PDF extends FPDF
{
// Cabecera de página
function Header()
{
    // Logo
    //$this->Image('hmlt/imagenes/logo.jpg',10,8,33);
    // Arial bold 15
    $this->SetFont('Arial','B',18);
    // Movernos a la derecha
    $this->Cell(80);
    // Título
    $this->Cell(30,10,'Factura',0,0,'C');
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
$var_consulta= "select * from cuentas where cuenta=$codigo";
$pdf = new PDF();
$pdf->AliasNBPages();
$pdf->AddPage();
$pdf->SetFont('Arial','B',12);
$pdf->Cell(100,10,utf8_decode('Restaurant Don Polo.'));
$pdf->Ln();
$pdf->Cell(100,10,utf8_decode('Agradece su preferencia deseándole un excelente día !!!'));
$pdf->Ln();
                                                      







//$pdf->Cell(30,10,'total',1,1,'C',0);


$var_query = $link->query($var_consulta);
while ($var_fila=$var_query->fetch_array())
{
    $V2=$var_fila[0];
    $V3=$var_fila[1];
    $V4=$var_fila[3];
   $V5=$var_fila[4];
    $V6=$var_fila[5];
    $V7=$var_fila[6];
;

$pdf->Cell(100,10,utf8_decode('-----------------------------------------------------------------------------------------------------'));
$pdf->Ln();
$pdf->SetFont('Arial','B',12);
//$pdf->Cell(90,10,utf8_decode('hello'));
$pdf->Cell(30,10,'Folio:');
$pdf->Cell(30,10,$V2);
$pdf->Ln();
$pdf->Cell(30,10,'Cuenta:');
$pdf->Cell(30,10,$V3);
$pdf->Ln();
$pdf->Cell(30,10,'Precio:');
$pdf->Cell(30,10,$V4);
$pdf->Ln();
$pdf->Cell(30,10,'Cantidad:');
$pdf->Cell(30,10,$V5);
$pdf->Ln();
$pdf->Cell(30,10,'Total:');
$pdf->Cell(30,10,$V6);
$pdf->Ln();
$pdf->Cell(30,10,'Fecha:');
$pdf->Cell(30,10,$V7);
$pdf->Ln();
$pdf->Cell(100,10,utf8_decode('-----------------------------------------------------------------------------------------------------'));
$pdf->Ln();
$pdf->SetFont('Arial','B',12);
$pdf->Cell(100,10,utf8_decode('Sucursal: Valle de Chalco Sol. Estado de México, Plaza Patio Local #97'));
$pdf->Ln();
$pdf->SetFont('Arial','B',12);
$pdf->Cell(100,10,utf8_decode('Teléfonos: 55-59-34-88-36 y 55-39-04-07-15'));
$pdf->Ln();

//$pdf->Cell(30,10,$V8,1,0,'C',0);
//$pdf->Cell(30,10,$V9,1,1,'C',0);
// Creación del objeto de la clase heredada


}
$pdf->Output();
?>




