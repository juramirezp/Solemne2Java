-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-10-2016 a las 02:59:18
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Solemne2Java`
--
CREATE DATABASE IF NOT EXISTS `Solemne2Java` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `Solemne2Java`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoUsuario`
--

DROP TABLE IF EXISTS `tipoUsuario`;
CREATE TABLE `tipoUsuario` (
  `idTipoUsuario` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `glosa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipoUsuario`
--

INSERT INTO `tipoUsuario` (`idTipoUsuario`, `codigo`, `glosa`) VALUES
(1, 1, 'Administrador'),
(2, 2, 'Usuario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `idTipoUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre`, `apellido`, `email`, `usuario`, `pass`, `idTipoUsuario`) VALUES
('Juan', 'Ramirez', 'jua.ramirezp@alumnos.duoc.cl', 'juan', 'juan', 1),
('Pedro', 'Perez', 'pedro@email.com', 'pedro', 'pedro', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `vehiculo` varchar(30) NOT NULL,
  `motor` varchar(30) NOT NULL,
  `precio` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `marca`, `tipo`, `vehiculo`, `motor`, `precio`, `descripcion`, `estado`) VALUES
(1, 'Ford', 'Camioneta', 'tx31', 'motor1', 1000000, 'camioneta ford', 'Rechazado'),
(7, 'Yeep', 'Camion', 'sff', 'sdfsd', 4353245, 'fasdf', 'Pendiente'),
(8, 'Chevrolet', 'Camion', 'vehiculo 1', 'motor 1.3', 10000000, 'Mega Camion', 'Pendiente'),
(9, 'Mini', 'Auto', 'Mini Cooper', 'Motor 3', 12000000, 'Mini Cooper', 'Pendiente'),
(10, 'Mini', 'Auto', 'Mini Cooper', 'Motor 3', 12000000, 'Mini Cooper', 'Pendiente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tipoUsuario`
--
ALTER TABLE `tipoUsuario`
  ADD PRIMARY KEY (`idTipoUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tipoUsuario`
--
ALTER TABLE `tipoUsuario`
  MODIFY `idTipoUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
