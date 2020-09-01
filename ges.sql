-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-09-2020 a las 18:31:04
-- Versión del servidor: 10.4.13-MariaDB
-- Versión de PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ges`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_administrador` varchar(11) NOT NULL,
  `nombre_administrador` int(255) NOT NULL,
  `clave_administrador` varchar(255) NOT NULL,
  `id_secundaria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `nombre_administrador`, `clave_administrador`, `id_secundaria`) VALUES
('128824936', 0, 'admin', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ipd`
--

CREATE TABLE `ipd` (
  `identificacion` int(10) NOT NULL,
  `nombreCompletoPaciente` varchar(255) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaTermino` date DEFAULT NULL,
  `GES` tinyint(1) DEFAULT NULL,
  `notificacionPacienteGes` tinyint(1) DEFAULT NULL,
  `confirmado` tinyint(1) DEFAULT NULL,
  `descartado` tinyint(1) DEFAULT NULL,
  `exceptuado` tinyint(1) DEFAULT NULL,
  `observacion` varchar(255) DEFAULT NULL,
  `patologia` varchar(255) NOT NULL,
  `registrador` varchar(255) DEFAULT NULL,
  `fechaIngreso` date DEFAULT NULL,
  `secondary_key_paciente` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ipd`
--

INSERT INTO `ipd` (`identificacion`, `nombreCompletoPaciente`, `fechaInicio`, `fechaTermino`, `GES`, `notificacionPacienteGes`, `confirmado`, `descartado`, `exceptuado`, `observacion`, `patologia`, `registrador`, `fechaIngreso`, `secondary_key_paciente`) VALUES
(152361084, 'nomnbre', '1999-02-02', '2019-03-03', 1, 0, 1, 0, 0, 'asdad', '[Diabetes bellitus 1]', '201061911', '2020-09-01', 1),
(171261805, 'legalo', '2019-02-02', '2021-03-03', 1, 1, 1, 0, 0, 'asd', '[Daibetes bellitus 2, Diabetes bellitus 1]', '201061911', '2020-09-01', 3),
(188772129, 'le cambie el nombre y la fecha a 19 de 02 del 2020', '1999-03-03', '2020-02-19', 1, 0, 0, 1, 1, 'osd', '[Enfermedad renal cronica etapa 5]', '201061911', '2020-09-01', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `monitor`
--

CREATE TABLE `monitor` (
  `identificacion` int(10) NOT NULL,
  `nombreCompleto` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `secondary_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `monitor`
--

INSERT INTO `monitor` (`identificacion`, `nombreCompleto`, `clave`, `secondary_id`) VALUES
(44132281, 'luz', 'monitor', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `rut` varchar(12) NOT NULL,
  `nombreCompleto` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`rut`, `nombreCompleto`, `id`) VALUES
('152361084', 'nomnbre', 1),
('188772129', 'le cambie el nombre y la fecha a 19 de 02 del 2020', 2),
('171261805', 'legalo', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patologia`
--

CREATE TABLE `patologia` (
  `identificacion` int(10) NOT NULL,
  `nombrePatologia` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patologia`
--

INSERT INTO `patologia` (`identificacion`, `nombrePatologia`) VALUES
(1, 'Enfermedad renal cronica etapa 4'),
(2, 'Enfermedad renal cronica etapa 5'),
(3, 'Cancer cervico uterino'),
(4, 'Diabetes bellitus 1'),
(5, 'Daibetes bellitus 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo_persona` varchar(255) DEFAULT NULL,
  `clave` varchar(12) DEFAULT NULL,
  `secondary_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `tipo_persona`, `clave`, `secondary_id`) VALUES
(44132281, 'luz', 'MONITOR', 'monitor', 1),
(75929331, 'registrador', 'REGISTRADOR', 'clave', 2),
(128824936, 'admin', 'ADMINISTRADOR', 'admin', 1),
(152361084, 'nomnbre', 'PACIENTE', NULL, 1),
(171261805, 'legalo', 'PACIENTE', NULL, 3),
(188772129, 'le cambie el nombre y la fecha a 19 de 02 del 2020', 'PACIENTE', NULL, 2),
(201061911, 'registreador1', 'REGISTRADOR', 'clave', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrador`
--

CREATE TABLE `registrador` (
  `id` int(10) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `secondary_id` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrador`
--

INSERT INTO `registrador` (`id`, `nombre`, `clave`, `secondary_id`) VALUES
(75929331, 'registrador', 'clave', 2),
(201061911, 'registreador1', 'clave', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `ipd`
--
ALTER TABLE `ipd`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `monitor`
--
ALTER TABLE `monitor`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `rut` (`rut`);

--
-- Indices de la tabla `patologia`
--
ALTER TABLE `patologia`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `registrador`
--
ALTER TABLE `registrador`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `monitor`
--
ALTER TABLE `monitor`
  MODIFY `identificacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44132282;

--
-- AUTO_INCREMENT de la tabla `patologia`
--
ALTER TABLE `patologia`
  MODIFY `identificacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `registrador`
--
ALTER TABLE `registrador`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201061913;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
