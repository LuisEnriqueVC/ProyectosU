-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3307
-- Tiempo de generación: 24-05-2021 a las 09:45:34
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donpolo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cenas`
--

CREATE TABLE `cenas` (
  `idCenas` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Disponibilidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `TiempoElaboracion` double DEFAULT NULL,
  `Descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cenas`
--

INSERT INTO `cenas` (`idCenas`, `Nombre`, `Disponibilidad`, `precio`, `TiempoElaboracion`, `Descripcion`) VALUES
(31, 'Pollo a la plancha con verduras al vapor', 21, 95, 41, 'Orden de filete de pollo con variedad de vejetales'),
(32, 'Esparragos enrollados', 12, 75, 23, 'Orden de esparragos envueltos con tocino '),
(33, 'Bocadillo de Tortillas ', 23, 100, 23, 'Orden de tortilla con lomo y queso '),
(34, 'Panecillos rellenos de huevo y beicon', 5, 110, 18, 'orden de 3 panecillos con beicon en su interior'),
(35, 'Lomo de salmon ', 11, 156, 34, 'orden de lomo de salmon al horno'),
(36, 'Tartaletas de pan ', 7, 75, 19, 'orden de 3 tartaletas con relleno de vegetales'),
(37, 'Tortas con salmon y tortilla', 9, 180, 41, 'orden de 1 torta con salmo y tortilla '),
(38, 'sandwiches de queso, jamos y beicon', 31, 66, 15, 'orden de 2 sandwiches con jamos en su interior'),
(39, 'Caballa marinada ', 11, 89, 22, 'orden de 2 caballas marinadas '),
(40, 'Lomo con queso y pimientos', 31, 1623, 41, 'orden con 2 trosos de lomo cubierto con queso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comidas`
--

CREATE TABLE `comidas` (
  `idComidas` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Disponibilidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `TiempoElaboracion` double DEFAULT NULL,
  `Descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comidas`
--

INSERT INTO `comidas` (`idComidas`, `Nombre`, `Disponibilidad`, `precio`, `TiempoElaboracion`, `Descripcion`) VALUES
(21, 'Arrachera Norteña', 15, 195, 43, 'Orden de Arrachera con vegetales al vapor '),
(22, 'Carne Asada', 7, 185, 23, 'Orden de con un filete asado, papas y vegetales al vapor'),
(23, 'Enchiladas suizas con pollo ', 23, 59, 18, 'Orden de 3 enchiladas con pollo e ingrediente extra'),
(24, 'Enchiladas de Mole con Pollo ', 15, 67, 15, 'orden de 3 enchiladas de mole e ingrediente extra'),
(25, 'Pechuga a las finas Hierbas ', 21, 71, 13, 'orden de 2 filetes de pechuga, nopales asados y jitomate'),
(26, 'Pechuga con mole poblano ', 21, 85, 34, 'orden de pechuga con mole poblano y arroz rojo'),
(27, 'Tacos dorados de pollo', 15, 47, 8, 'orden con 3 tacos dorados, crema y salsa'),
(28, 'Tostadas de pollo ', 14, 36, 7, 'orden de 3 tostadas con pollo,lechuga y crema '),
(29, 'Milanesas de pollo ', 20, 59, 23, 'orden de 1 milanesa con papas a la francesa'),
(30, 'Alitas de pollo', 15, 63, 41, 'orden con 5 alitas de pollo marinadas con salsa y papas a la francesa ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentas`
--

CREATE TABLE `cuentas` (
  `Folio` int(11) NOT NULL,
  `cuenta` varchar(30) CHARACTER SET utf32 COLLATE utf32_spanish_ci NOT NULL,
  `producto` varchar(30) CHARACTER SET ucs2 COLLATE ucs2_spanish_ci NOT NULL,
  `precio` decimal(5,0) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` decimal(5,0) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuentas`
--

INSERT INTO `cuentas` (`Folio`, `cuenta`, `producto`, `precio`, `cantidad`, `total`, `fecha`) VALUES
(1, '14', 'Hot cakes Tradicionales', '0', 2, '300', '2021-05-24 01:58:54'),
(2, '1', 'Hot cakes Tradicionales', '0', 2, '300', '2021-05-24 02:17:45'),
(3, '10', 'Hot cakes Tradicionales', '0', 2, '320', '2021-05-24 02:17:45'),
(4, '73', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(5, '62', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(6, '94', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(7, '94', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(8, '6', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(9, '85', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(10, '72', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(11, '92', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(12, '88', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(13, '13', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(14, '1', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(15, '6', 'Hot cakes Tradicionales', '120', 3, '525', '2021-05-24 02:17:45'),
(21, '2', 'Hot cakes Tradicionales', '120', 5, '600', '2021-05-24 05:42:42'),
(22, '94', 'Hot cakes Tradicionales', '120', 2, '270', '2021-05-24 05:44:37'),
(23, '50', 'Hot cakes Tradicionales', '120', 2, '270', '2021-05-24 05:44:37'),
(24, '69', 'Molletes Universitarios', '100', 2, '200', '2021-05-24 07:11:21'),
(25, '45', 'Molletes Universitarios de Cho', '150', 1, '195', '2021-05-24 07:14:03'),
(26, '66', 'Molletes Universitarios de Cho', '150', 1, '160', '2021-05-24 07:27:44'),
(27, '4', 'Homeletts con champiñones ', '145', 2, '310', '2021-05-24 07:28:24'),
(28, '36', 'Tortilla de claras balanceado ', '130', 4, '560', '2021-05-24 07:28:57'),
(29, '51', 'Huevos motuleños ', '195', 4, '860', '2021-05-24 07:30:27'),
(30, '2', 'Arrachera Norteña', '195', 1, '205', '2021-05-24 07:36:16'),
(31, '24', 'Carne Asada', '185', 3, '555', '2021-05-24 07:52:22'),
(32, '92', 'Enchiladas suizas con pollo ', '59', 2, '118', '2021-05-24 07:52:57'),
(33, '89', 'Enchiladas de Mole con Pollo ', '67', 1, '102', '2021-05-24 07:54:27'),
(34, '24', 'Pechuga a las finas Hierbas ', '71', 2, '202', '2021-05-24 07:55:00'),
(35, '95', 'Pechuga con mole poblano ', '85', 5, '500', '2021-05-24 07:55:34'),
(36, '97', 'Tacos dorados de pollo', '47', 5, '235', '2021-05-24 07:56:10'),
(37, '82', 'Tostadas de pollo ', '36', 6, '366', '2021-05-24 07:56:41'),
(38, '78', 'Milanesas de pollo ', '59', 1, '119', '2021-05-24 07:58:06'),
(39, '41', 'Pollo a la plancha con verdura', '95', 2, '210', '2021-05-24 08:06:09'),
(40, '36', 'Esparragos enrollados', '75', 6, '660', '2021-05-24 08:19:15'),
(41, '67', 'Bocadillo de Tortillas ', '100', 2, '340', '2021-05-24 08:19:53'),
(42, '36', 'Panecillos rellenos de huevo y', '110', 5, '650', '2021-05-24 08:21:24'),
(43, '34', 'Lomo de salmon ', '156', 3, '498', '2021-05-24 08:22:13'),
(44, '13', 'Tartaletas de pan ', '75', 2, '170', '2021-05-24 08:23:17'),
(45, '40', 'Tortas con salmon y tortilla', '180', 6, '1170', '2021-05-24 08:23:49'),
(46, '5', 'Pay de limon', '67', 3, '231', '2021-05-24 08:39:47'),
(47, '44', 'Cheese cake de trufa ', '55', 3, '255', '2021-05-24 08:48:58'),
(48, '63', ' Crepa de cajeta', '70', 4, '420', '2021-05-24 08:49:33'),
(49, '39', ' Cheese cake de fresa', '45', 6, '270', '2021-05-24 08:50:09'),
(50, '10', 'Pastel de chocolate', '45', 7, '315', '2021-05-24 08:50:38');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desayunos`
--

CREATE TABLE `desayunos` (
  `idDesayuno` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Disponibilidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `TiempoElaboracion` double DEFAULT NULL,
  `Descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `desayunos`
--

INSERT INTO `desayunos` (`idDesayuno`, `Nombre`, `Disponibilidad`, `precio`, `TiempoElaboracion`, `Descripcion`) VALUES
(11, 'Hot cakes Tradicionales', 12, 120, 15.3, '1 orden de 5 hot cakes con Mantequilla y Miel'),
(12, 'Molletes Universitarios', 35, 100, 30, '1 orden de 4 Molletes '),
(13, 'Molletes Universitarios de Chorizo ', 10, 150, 34.3, '1 orden de 4 Molletes con chorizo y jamon'),
(14, 'Homeletts con champiñones ', 12, 145, 13.8, '1 orden de homelen con champiñones e ingredientes extras'),
(15, 'Tortilla de claras balanceado ', 31, 130, 8.5, 'orden de 5 tortillas'),
(16, 'Huevos motuleños ', 7, 195, 8.5, 'orden de 2 huevos al estilo motuleño');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `idFactura` int(11) NOT NULL,
  `idDesayuno` int(11) DEFAULT NULL,
  `idComidas` int(11) DEFAULT NULL,
  `idCenas` int(11) DEFAULT NULL,
  `idPostres` int(11) DEFAULT NULL,
  `FechaPago` date DEFAULT NULL,
  `CantidadTotal` double DEFAULT NULL,
  `ServicioDomicilio` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `postres`
--

CREATE TABLE `postres` (
  `idPostres` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Disponibilidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `TiempoElaboracion` double DEFAULT NULL,
  `Descripcion` varchar(70) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `postres`
--

INSERT INTO `postres` (`idPostres`, `Nombre`, `Disponibilidad`, `precio`, `TiempoElaboracion`, `Descripcion`) VALUES
(41, 'Pay de limon', 15, 67, 45, 'Rebanada de pay de limon '),
(42, 'Cheese cake de trufa ', 23, 55, 34, 'Rebanada de cake de trufa '),
(43, ' Crepa de cajeta', 54, 70, 13, '3 crepas pequeñas de cajeta'),
(44, ' Cheese cake de fresa', 21, 45, 32, 'Rebanada de cake de fresa'),
(45, 'Crepa de chocolate con fresa', 15, 80, 45, '3 Crepas chicas de chocolate con fresas'),
(46, 'Pastel de chocolate', 62, 45, 45, 'Una revanada de pastel');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cenas`
--
ALTER TABLE `cenas`
  ADD PRIMARY KEY (`idCenas`);

--
-- Indices de la tabla `comidas`
--
ALTER TABLE `comidas`
  ADD PRIMARY KEY (`idComidas`);

--
-- Indices de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  ADD PRIMARY KEY (`Folio`);

--
-- Indices de la tabla `desayunos`
--
ALTER TABLE `desayunos`
  ADD PRIMARY KEY (`idDesayuno`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`idFactura`),
  ADD KEY `idDesayuno` (`idDesayuno`),
  ADD KEY `idComidas` (`idComidas`),
  ADD KEY `idCenas` (`idCenas`),
  ADD KEY `idPostres` (`idPostres`);

--
-- Indices de la tabla `postres`
--
ALTER TABLE `postres`
  ADD PRIMARY KEY (`idPostres`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cuentas`
--
ALTER TABLE `cuentas`
  MODIFY `Folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idDesayuno`) REFERENCES `desayunos` (`idDesayuno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_2` FOREIGN KEY (`idComidas`) REFERENCES `comidas` (`idComidas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_3` FOREIGN KEY (`idCenas`) REFERENCES `cenas` (`idCenas`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `factura_ibfk_4` FOREIGN KEY (`idPostres`) REFERENCES `postres` (`idPostres`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
