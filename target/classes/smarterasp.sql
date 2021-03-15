-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-01-2021 a las 22:45:48
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `smarterasp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL COMMENT 'Automático',
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `observacion` varchar(500) NOT NULL,
  `nota` int(11) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `fechanacimiento` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `nombre`, `apellido`, `observacion`, `nota`, `dni`, `fechanacimiento`) VALUES
(1, 'Andrea', 'Chávez Heredia', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 7, '78014137T', '01/01/1990'),
(2, 'Ruth Silvana', 'Cortés Lagunes', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 6, '12345678Z', '01/01/1990'),
(3, 'Ariana', 'de jesús Ramos', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 7, '12345678Z', '01/01/1990'),
(4, 'Luis Felipe', 'Delgado Barrón', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 5, '12345678Z', '01/01/1990'),
(5, 'Hansel Andres', 'Espejo Ramos', 'ad fdfa fd asfd asasdf', 2, '12345678Z', '01/01/1990'),
(6, 'Aniyensy Sarai', 'Flores Aguilar', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 3, '12345678Z', '01/01/1990'),
(7, 'Karla Paulette', 'Flores Silva', 'ad fdfa fd asfd asasdf', 6, '12345678Z', '01/01/1990'),
(8, 'Montserrat Carolina', 'García Arreguín', 'ad fdfa fd asfd asasdf', 9, '12345678Z', '01/01/1990'),
(9, 'Lisset Vianey', 'García Orozco', 'ad fdfa fd asfd asasdf', 8, '12345678Z', '01/01/1990'),
(10, 'José Ignacio', 'Gómez Vargas', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(11, 'Rocio', 'González Díaz', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(12, 'Cipriano Ariel', 'González Trejo', 'ad fdfa fd asfd asasdf', 1, '12345678Z', '01/01/1990'),
(13, 'Miguel Alejandro', 'Guerrero Padrés', 'ad fdfa fd asfd asasdf', 2, '12345678Z', '01/01/1990'),
(14, 'Danna Verónica', 'Hernández González', 'ad fdfa fd asfd asasdf', 3, '12345678Z', '01/01/1990'),
(15, 'Jaime Daniel', 'Hernández Palacios', 'ad fdfa fd asfd asasdf', 6, '12345678Z', '01/01/1990'),
(16, 'Miguel Ángel', 'Hernández Prado', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(17, 'Luis Fernando', 'Herrera Arias', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(18, 'Samanta', 'Lara Agapito', 'ad fdfa fd asfd asasdf', 1, '12345678Z', '01/01/1990'),
(19, 'Julia Andrea', 'Lunar Pérez', 'ad fdfa fd asfd asasdf', 2, '12345678Z', '01/01/1990'),
(20, 'María', 'Maximov Cortés', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(21, 'Pablo', 'Meré Hidalgo', 'ad fdfa fd asfd asasdf', 6, '12345678Z', '01/01/1990'),
(22, 'Diana Laura', 'Morales Gonzalez', 'ad fdfa fd asfd asasdf', 3, '12345678Z', '01/01/1990'),
(23, 'Yaír Jofrá', 'Moreno Chávez', 'ad fdfa fd asfd asasdf', 2, '12345678Z', '01/01/1990'),
(24, 'Aelín', 'Moreno Huitrón', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(25, 'Jessica Liliana', 'Moreno Reveles', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(26, 'Eduardo Elihu', 'Munguía González', 'ad fdfa fd asfd asasdf', 1, '12345678Z', '01/01/1990'),
(27, 'Itzel', 'Nuñez Garcia', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(28, 'Erandhi Claudel', 'Ornelas Guzmán', 'ad fdfa fd asfd asasdf', 9, '12345678Z', '01/01/1990'),
(29, 'Adriana Azzeneth', 'Ortega Romero', 'ad fdfa fd asfd asasdf', 6, '12345678Z', '01/01/1990'),
(30, 'Irma Carolina', 'Parga Fuentes', 'ad fdfa fd asfd asasdf', 7, '12345678Z', '01/01/1990'),
(31, 'Alejandra Berenice', 'Pérez Moreno', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(32, 'Yail Tsayam', 'Reyes Báez', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(33, 'Esteban', 'Reyes Saldaña', 'ad fdfa fd asfd asasdf', 9, '12345678Z', '01/01/1990'),
(34, 'Abigali', 'Rodríguez Jiménez', 'ad fdfa fd asfd asasdf', 6, '12345678Z', '01/01/1990'),
(35, 'Pablo', 'Rosiles Loeza', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(36, 'aranxa', 'Ruiz vasquez', 'ad fdfa fd asfd asasdf', 7, '12345678Z', '01/01/1990'),
(37, 'Mariana', 'Sánchez Cid', 'ad fdfa fd asfd asasdf', 5, '12345678Z', '01/01/1990'),
(38, 'Daniel', 'Torres Rojas', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(39, 'Daniela Ivette', 'Vega Hernández', 'ad fdfa fd asfd asasdf', 2, '12345678Z', '01/01/1990'),
(40, 'Rosa Luz', 'Zamora Peinado', 'ad fdfa fd asfd asasdf', 4, '12345678Z', '01/01/1990'),
(41, 'fasd', 'dfas', 'sdfasdfa fasd fasd sdfa fdsa', 5, '12345678Z', '01/01/1990'),
(42, 'gre', 'fewa', 'efwawefawe fawe fawe fawe fa asdf Lo he modificado otra vez', 3, '12345678Z', '01/01/1990'),
(43, 'efaefa', 'feaeafs', 'efaefaefae fae fasse fae fae fae fae fa', 4, '12345678Z', '01/01/1990'),
(44, 'fgs', 'fgsssg', 'sssgsg s ggguyghgh Se ha modificado Otra vez una enésima vez', 7, '12345678Z', '01/01/1990'),
(47, 'maria', 'gergeasdfa', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 3, '12345678Z', '01/01/1990'),
(48, 'Gregorio', 'Martínez', 'Se ha creado en una bbdd que está en remoto. EN SmarterASP.Net', 10, '12345678z', '12/12/2000'),
(49, 'Amparo', 'Martínez', 'dsfa dasf dasf adfs', 5, '74888518N', '10/11/1982'),
(50, 'Gregorio', 'Martínez', 'fdsfdsa dfas fdsafda s fdasadfs af dsadsf dfsa', 1, '12345678z', '10/11/1982'),
(51, 'Jorge', 'Martínez', 'dasf fdasa fdsfad s fdsa fadsfadsadsffd saafds dasf', 9, '12345678z', '15/12/1956'),
(52, 'Jorge', 'Martínez', 'fdsaafd dfas  dafs afsdfdsadafs fadsf fads', 1, '12345678z', '10/11/1982'),
(53, 'Jorge', 'dsafads fadsfsda ', 'afsd afsdaafddfd ads a dafs fdsa fdaafda ad sdafadf', 3, '12345678z', '15/12/1956');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `capital`
--

CREATE TABLE `capital` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `habitantes` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `capital`
--

INSERT INTO `capital` (`id`, `nombre`, `habitantes`) VALUES
(1, 'Roma', 2873000),
(2, 'Madrid', 6642000),
(3, 'Lisboa', 504718),
(4, 'Paris', 2148000),
(5, 'Berlín', 3769000),
(8, 'Moscú', 11920000),
(9, 'Viena', 1897000),
(10, 'Ámsterdam', 821752),
(11, 'Atenas', 664046);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `ciudad` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `dni`, `ciudad`) VALUES
(1, 'José', 'López Comprador', '78014137T', 'Málaga'),
(2, 'María', 'García Vaquero', '12345678Z', 'Córdoba'),
(3, 'Amparo', 'algo', '12345678Z', 'Cádiz');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dni` varchar(255) NOT NULL,
  `account` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `donut`
--

CREATE TABLE `donut` (
  `id_donut` int(11) NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `genero` varchar(20) CHARACTER SET utf8mb4 NOT NULL,
  `edad` int(11) NOT NULL,
  `donuts_comidos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `donut`
--

INSERT INTO `donut` (`id_donut`, `nombre`, `genero`, `edad`, `donuts_comidos`) VALUES
(1, 'Michael', 'Masculino', 12, 5),
(2, 'Elisa', 'Femenino', 20, 7),
(3, 'Robert', 'Masculino', 7, 3),
(4, 'John', 'Masculino', 54, 2),
(5, 'Jessica', 'Femenino', 22, 6),
(6, 'Aaron', 'Masculino', 3, 1),
(7, 'Margareth', 'Femenino', 42, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `id_gen` int(11) NOT NULL,
  `gen` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`id_gen`, `gen`) VALUES
(2, 'Femenino'),
(1, 'Masculino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `informes`
--

CREATE TABLE `informes` (
  `id` int(11) NOT NULL,
  `tema` varchar(100) NOT NULL,
  `contenido` varchar(1000) NOT NULL,
  `fecha` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `informes`
--

INSERT INTO `informes` (`id`, `tema`, `contenido`, `fecha`) VALUES
(1, 'El tema de un informe222', 'Contenido del primer informe creado asdf sdfa sdfa adfs ads', '09/04/2020'),
(2, 'Segundo informe', 'Este es el segundo informe creado', '20/09/2026'),
(5, 'Economía', 'La cosa está mu malita', '12/11/2020'),
(4, '234234234', '234234234 234234234 324234234', '09/04/2002'),
(7, 'fasddfsadfas', 'sdfasdfasd fasdfa dfsasd fasdfa  dfasdfa dfasd fsa fasd fasd fsdaf sda fsda fdasf asdf sdaf sda fsda fdas', '09/04/2008');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `processed` tinyint(4) NOT NULL,
  `customer_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `dorsal` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `posicion` varchar(50) NOT NULL,
  `equipo` varchar(50) NOT NULL,
  `fechanacimiento` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`dorsal`, `nombre`, `posicion`, `equipo`, `fechanacimiento`) VALUES
(1, 'Iker Casillas', 'Portero', 'Real Madrid', '10/11/1986'),
(2, 'Raúl Albiol', 'Defensa', 'Real Madrid', '01/01/1990'),
(3, 'Gerard Piqué', 'Defensa', 'Barcelona', '15/12/1956'),
(4, 'Carlos Marchena', 'Defensa', 'Valencia', '01/01/1990'),
(5, 'Carles Puyol', 'Defensa', 'Barcelona', '01/01/1990'),
(6, 'Andrés Iniesta', 'Mediocampista', 'Barcelona', '01/01/1990'),
(7, 'David Villa', 'Delantero', 'Valencia', '01/01/1984'),
(8, 'Xavi Hernández', 'Mediocampista', 'Barcelona', '01/01/1984'),
(9, 'Fernando Torres', 'Delantero', 'Liverpool', '01/03/1984'),
(10, 'Cesc Fàbregas', 'Mediocampista', 'Arsenal', '08/01/1984'),
(11, 'Joan Capdevila', 'Defensa', 'Villarreal', '08/01/1984'),
(12, 'Víctor Valdés', 'Portero', 'Barcelona', '08/01/1984'),
(13, 'Juan Mata', 'Delantero', 'Valencia', '08/01/1984'),
(14, 'Xabi Alonso', 'Mediocampista', 'Real Madrid', '08/07/1985'),
(15, 'Sergio Ramos', 'Defensa', 'Real Madrid', '08/07/1985'),
(16, 'Sergio Busquets', 'Mediocampista', 'Barcelona', '08/07/1985'),
(17, 'Álvaro Arbeloa', 'Defensa', 'Real Madrid', '08/07/1985'),
(18, 'Pedro Rodríguez', 'Delantero', 'Barcelona', '08/07/1985'),
(19, 'Fernando Llorente', 'Delantero', 'Athletic Club', '08/07/1986'),
(20, 'Javi Martínez', 'Mediocampista', 'Athletic Club', '28/08/1985'),
(21, 'David Silva', 'Mediocampista', 'Valencia', '28/08/1985'),
(22, 'Jesús Navas', 'Delantero', 'Sevilla', '28/08/1985'),
(23, 'Pepe Reina', 'Portero', 'Liverpool', '28/08/1985');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `ID` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`ID`, `titulo`, `genero`, `autor`) VALUES
(1, 'Primerorr', 'Programación', 'Yo pispo'),
(2, 'yyyyy', 'ggggg', 'ffff'),
(3, 'TercerrrrRoooo', 'Terror Que Te Cagas', 'Ellos Pispos'),
(8, 'XXXXXX', 'LLLLL', 'Yo que se'),
(9, 'Spring', 'Fantástico', 'Bill Gate'),
(10, 'Somedop', 'AAAAA', 'Ellllll'),
(11, 'Nuevorrr', 'Dramaaaaa', 'NoSeeee'),
(12, 'Nuevorrr44', 'Hertiu', 'swifer'),
(13, 'Lord of The Ring', 'Realidad', 'The Best'),
(15, 'Siiiiii', 'lllll', 'Somedop'),
(16, 'Con Command', 'TeAgasss', 'Uffffffff'),
(17, 'Viva el betis', 'gggggg', 'Lopera'),
(19, 'eeee', 'sssss', 'el autor!'),
(20, 'Command Object', 'Terrorífico', 'Cenec'),
(21, 'adsfdadfsa', 'sdfadfassdfa', 'sdfasdfasdfa'),
(22, 'dfas', 'sdfa', 'sdfa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motor`
--

CREATE TABLE `motor` (
  `idnum` int(11) NOT NULL,
  `id` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `combustible` varchar(100) NOT NULL,
  `potencia` int(11) NOT NULL,
  `cilindrada` int(11) NOT NULL,
  `cantidadcilindros` int(11) NOT NULL,
  `turbo` tinyint(4) NOT NULL,
  `intercooler` tinyint(4) NOT NULL,
  `carburador` tinyint(4) NOT NULL,
  `fechacreacion` varchar(20) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `valvulas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `motor`
--

INSERT INTO `motor` (`idnum`, `id`, `tipo`, `combustible`, `potencia`, `cilindrada`, `cantidadcilindros`, `turbo`, `intercooler`, `carburador`, `fechacreacion`, `descripcion`, `valvulas`) VALUES
(1, 'abc-26-ññ-9876', 'Enchufable', 'Diesel', 150, 2200, 6, 0, 1, 0, '16/11/2020', 'Hola dsposdf sdfpo sdfposd fposdf psdfo dfsposd fdsfadfas d fasd fasasdf sd fadfas  fasd. Modifica', 5),
(3, 'EGR-12-EL-1985', 'Enchufable', 'Electricidad', 150, 0, 0, 0, 0, 0, '06/01/2020', 'adfs  dfasj fdlkj fdsalkjdf aslkfdjsa fdlaskj dfaslkjdfsa ldkfsaj dfslakj dfsalkjfds ladfskj ñewlk ñdflk lñjnmcewc ñlkjf qweñlkn dsañslkjh frewñlkjnh dsfva', 5),
(4, 'abc-99-EL-6666', 'Enchufable', 'Electricidad', 180, 0, 0, 0, 0, 0, '22/02/2020', ' adsd dfsaokij fdsñadfskj dfsñalkjdfsa ñlfdkasj dfsñlkfjd asñvhjpoi ehr ftkneret oiutrbe oerhbtre lkntbre repoijtber retlñkjmbn vfpojvhndf pvuioh fpoknwe qpkjn fdvpñokvjn èroinv fdñlkn ew dsaf', 5),
(5, 'abc-26-dñ-4865', 'Enchufable', 'Diesel', 180, 2200, 5, 1, 1, 0, '21/07/2019', 'adsf ads adsff adsfasd fadsf asdf adsf asd fasdf asdf asdf asdfasdfads fasdfdas afdsadfs dasf', 5),
(6, 'abc-26-dñ-3223', 'Enchufable', 'Electricidad', 110, 2000, 0, 0, 1, 0, '07/12/2029', 'd afs fdsa dfsadf das f asdf asdf sdaf ads fdsa fadsf adf adsf ads fadsf dsaf dsaf dsaf dsafsd a', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `poblacion` int(11) NOT NULL,
  `comida` varchar(255) NOT NULL,
  `capital_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id`, `name`, `poblacion`, `comida`, `capital_id`) VALUES
(1, 'Spain', 46000000, 'Jamón', 2),
(2, 'Francia', 66990000, 'Queso', 4),
(3, 'Portugal', 10280000, 'Bacalao', 3),
(4, 'Italia', 60360000, 'Pizza', 1),
(7, 'Alemania', 83020000, 'Salchica con birra', 5),
(8, 'Grecia', 10720000, 'Musaca', 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `ID` int(11) NOT NULL,
  `nombreP` varchar(100) NOT NULL,
  `cursoP` varchar(100) NOT NULL,
  `edadP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`ID`, `nombreP`, `cursoP`, `edadP`) VALUES
(1, 'Juan', 'Java', 33),
(3, 'Juan', 'Cssss', 99),
(5, 'Pedro', 'XML', 22),
(7, 'Susana', 'SpringL', 55),
(8, 'Antonio', 'Php 77', 65),
(10, 'Eva', 'Java spring', 77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'ANONYMOUS'),
(2, 'USER'),
(3, 'ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`, `enabled`) VALUES
(1, 'nacho', 'jjjj@gamil.com', '$2y$12$XmviZfwGrb/QvzEwbIrsMuA5LEfIrZbayx1BkPGUSGic.tFioQFuq', 1),
(2, 'juan', 'kkkk@gamil.com', '$2y$12$CEoX82DpvtmNb4J4hVLsZuUkX23M3dhzxlTvJGjaVQuckrk9VV6Qi', 1),
(3, 'desco', 'dddd@gamil.com', '$2y$12$dtSQ3nYfS0Nlq1TuS1OiYepg5aC0hNQOzehT/V.0b9IEZ0rEPvTx.', 1),
(4, 'nuevorr', 'lllll@yahoo.es9999', '$2y$12$493IUFW2Z.6EIc8enfsUBuZwuS2OMwPvzcqngO5PfZcLx5r2KKsD2', 1),
(8, 'registro', 'registro@hotmail.comhola', '$2y$12$075NJQB9UDZtgjhtYG9F5.QAMv0C.0XjIELvK4l3aE87omK2yr2tu', 1),
(9, 'probando', 'dfasfdafd@hodsfam.com1234', '$2y$12$CEoX82DpvtmNb4J4hVLsZuUkX23M3dhzxlTvJGjaVQuckrk9VV6Qi', 1),
(10, 'usuario', 'mariaanyelina25@gmail.com', '$2a$10$N3Sjl8nwOvNCobOW138hHOX1V6oZaCggWHZE8C4EZrpODCYHY3DGm', 1),
(11, 'administrador', 'administrador', '$2a$10$qQyA/qiH4LwgmW11P5XUJO/XJ4EuRRInhTHhaaMAU9aRQO775mC7C', 1),
(12, 'admin', 'admin@admin.es', '$2a$10$in6c0uJiTZimKIVhb6HHtOEkoJXozPMJ9KVVNo9eAfPzhyh31Q5IG', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(1, 3),
(2, 2),
(3, 2),
(2, 3),
(4, 3),
(5, 3),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 2),
(11, 3),
(11, 2),
(12, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `capital`
--
ALTER TABLE `capital`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `donut`
--
ALTER TABLE `donut`
  ADD PRIMARY KEY (`id_donut`),
  ADD KEY `FK_GENERO` (`genero`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`id_gen`),
  ADD KEY `gen_index` (`gen`);

--
-- Indices de la tabla `informes`
--
ALTER TABLE `informes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`dorsal`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `motor`
--
ALTER TABLE `motor`
  ADD PRIMARY KEY (`idnum`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pais_capital` (`capital_id`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Automático', AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `capital`
--
ALTER TABLE `capital`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `donut`
--
ALTER TABLE `donut`
  MODIFY `id_donut` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `id_gen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `informes`
--
ALTER TABLE `informes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `dorsal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `motor`
--
ALTER TABLE `motor`
  MODIFY `idnum` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `donut`
--
ALTER TABLE `donut`
  ADD CONSTRAINT `FK_GENERO` FOREIGN KEY (`genero`) REFERENCES `genero` (`gen`);

--
-- Filtros para la tabla `pais`
--
ALTER TABLE `pais`
  ADD CONSTRAINT `fk_pais_capital` FOREIGN KEY (`capital_id`) REFERENCES `capital` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
