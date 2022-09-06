-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-09-2022 a las 07:30:56
-- Versión del servidor: 8.0.30
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `farmaciatyt`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesos`
--

CREATE TABLE `accesos` (
  `id` int NOT NULL,
  `tipo_acceso` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `accesos`
--

INSERT INTO `accesos` (`id`, `tipo_acceso`) VALUES
(1, 'admin'),
(2, 'cajero'),
(3, 'bodeguero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acceso_usuarios`
--

CREATE TABLE `acceso_usuarios` (
  `id` int NOT NULL,
  `usuario_id` int NOT NULL,
  `acceso_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `acceso_usuarios`
--

INSERT INTO `acceso_usuarios` (`id`, `usuario_id`, `acceso_id`) VALUES
(1, 1, 1),
(2, 2, 3),
(3, 3, 2),
(20, 26, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `cedula` varchar(10) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `cedula`, `numero`, `direccion`) VALUES
(1, 'Gabriel', 'Velazco', '1708980129', '0995673456', 'Rumichaca-AS-33'),
(2, 'Alexandra', 'Asimbaya', '1980238900', '0987651234', 'Ruminahgui-SD-44'),
(3, 'Alison', 'Gutierrez', '1099892390', '0987123983', 'Caupicho-S67-B'),
(4, 'Henry', 'Tates', '1708008170', '0987814188', 'QuillaNan S44B');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribuidores`
--

CREATE TABLE `distribuidores` (
  `id` int NOT NULL,
  `distribuidor` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `distribuidores`
--

INSERT INTO `distribuidores` (`id`, `distribuidor`) VALUES
(1, 'Pfizer'),
(2, 'Inlo'),
(3, 'Bronw'),
(4, 'Dove'),
(5, 'Ego'),
(6, 'Snegrif'),
(7, 'Brija Labs'),
(8, 'Germinol'),
(9, 'Valles SA'),
(10, 'Germon'),
(11, 'Listol'),
(12, 'Durin'),
(13, 'Blizer'),
(14, 'Labs Copr'),
(15, 'Ecuador Labs');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribuidor_producto`
--

CREATE TABLE `distribuidor_producto` (
  `id` int NOT NULL,
  `producto_id` int NOT NULL,
  `distribuidor_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `distribuidor_producto`
--

INSERT INTO `distribuidor_producto` (`id`, `producto_id`, `distribuidor_id`) VALUES
(1, 5, 1),
(2, 4, 2),
(3, 3, 3),
(4, 2, 4),
(5, 1, 5),
(6, 10, 15),
(7, 9, 14),
(8, 8, 13),
(9, 7, 12),
(10, 6, 11),
(11, 20, 9),
(12, 19, 8),
(13, 18, 7),
(14, 17, 6),
(15, 16, 4),
(16, 11, 2),
(17, 12, 1),
(18, 13, 12),
(19, 14, 14),
(20, 15, 15),
(21, 25, 1),
(22, 24, 2),
(23, 23, 3),
(24, 22, 4),
(25, 21, 5),
(26, 26, 15),
(27, 27, 14),
(28, 28, 13),
(29, 29, 12),
(30, 30, 11),
(31, 35, 9),
(32, 34, 8),
(33, 33, 7),
(34, 32, 6),
(35, 31, 4),
(36, 36, 2),
(37, 37, 1),
(38, 38, 12),
(39, 39, 14),
(40, 40, 15),
(41, 45, 1),
(42, 44, 2),
(43, 43, 3),
(44, 42, 4),
(45, 41, 5),
(46, 46, 15),
(47, 47, 14),
(48, 48, 13),
(49, 49, 12),
(50, 50, 11),
(51, 55, 9),
(52, 54, 8),
(53, 53, 7),
(54, 52, 6),
(55, 51, 4),
(56, 56, 2),
(57, 57, 1),
(58, 58, 12),
(59, 59, 14),
(60, 60, 15),
(61, 65, 1),
(62, 64, 2),
(63, 63, 3),
(64, 62, 4),
(65, 61, 5),
(66, 66, 15),
(67, 67, 14),
(68, 68, 13),
(69, 69, 12),
(70, 70, 11),
(71, 75, 9),
(72, 74, 8),
(73, 73, 7),
(74, 72, 6),
(75, 71, 4),
(76, 76, 2),
(77, 77, 1),
(78, 78, 12),
(79, 79, 14),
(80, 80, 15),
(81, 85, 1),
(82, 84, 2),
(83, 83, 3),
(84, 82, 4),
(85, 81, 5),
(86, 86, 15),
(87, 87, 14),
(88, 88, 13),
(89, 89, 12),
(90, 80, 11),
(91, 95, 9),
(92, 94, 8),
(93, 93, 7),
(94, 92, 6),
(95, 91, 4),
(96, 96, 2),
(97, 97, 1),
(98, 98, 12),
(99, 99, 14),
(100, 100, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `cantidad` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `precio`, `cantidad`) VALUES
(1, '30gr pertizol', '0.34', 23),
(2, '30gr buscapina', '0.25', 23),
(3, '25ml cortizol', '0.80', 24),
(4, '30gr oaracetamol', '0.15', 23),
(5, '50gr amoxcilina', '1.25', 23),
(6, '36gr resfrin', '0.56', 34),
(7, '20gr loratadina', '0.34', 32),
(8, '10gr losartan', '0.67', 12),
(9, '30gr sertal', '0.20', 12),
(10, '50gr bactrim', '0.17', 23),
(11, '12gr fidelin', '0.98', 23),
(12, '120ml losirtol', '1.23', 34),
(13, '20gr alivion', '1.15', 23),
(14, '34gr lesion', '1.46', 12),
(15, '25gr dolsarin', '1.90', 12),
(16, '60ml lemonfluu', '2.34', 23),
(17, '35ml emusion', '0.34', 34),
(18, '12gr lural', '1.25', 45),
(19, '500gr vaquita', '3.34', 54),
(20, '34gr glicina', '0.34', 32),
(21, '30gr fluracin', '0.25', 23),
(22, '30gr alucin ', '0.25', 23),
(23, '25ml fuertozol', '0.80', 12),
(24, '30gr heterogermina', '0.15', 22),
(25, 'Morfina', '0.23', 13),
(26, '36gr resfrin', '0.56', 33),
(27, '20gr baterium', '0.34', 34),
(28, '10gr aspirina', '0.67', 32),
(29, '30gr cocaina', '0.20', 23),
(30, '50gr marihuana', '0.17', 12),
(31, '12gr loratadina', '0.98', 23),
(32, '120ml mr musculo', '1.23', 34),
(33, '20gr buprex', '1.15', 23),
(34, '56mg Traidol', '1.46', 11),
(35, '25gr pinolin', '1.90', 23),
(36, '60ml finalin', '2.34', 24),
(37, '35ml drogadil', '0.34', 25),
(38, '12gr mecionin', '1.25', 25),
(39, '500gr meolol', '3.34', 23),
(40, '34gr comepro', '0.34', 34),
(41, '30gr arcon', '0.25', 43),
(42, '25ml aluviol', '0.80', 32),
(43, '30gr cojin', '0.15', 23),
(44, '50gr luares', '1.25', 12),
(45, '200gr cicatricure', '5.46', 23),
(46, '20gr adores', '0.34', 23),
(47, '10gr ihnladres', '0.67', 34),
(48, '30gr escuchin', '0.20', 23),
(49, '50gr piolin', '0.17', 34),
(50, '12gr trcusl', '0.98', 32),
(51, '120ml metsmot', '1.23', 43),
(52, '20gr hyplex', '1.15', 23),
(53, '34gr freetol', '1.46', 23),
(54, '25gr frenols', '1.90', 43),
(55, '60ml frogons', '2.34', 23),
(56, '35ml mentol chino', '2.34', 12),
(57, '12gr desplin', '1.25', 22),
(58, '500gr cremasol', '3.34', 11),
(59, '34gr sinviol', '0.34', 23),
(60, '30gr maolin', '0.46', 234),
(61, '30gr octol', '0.25', 34),
(62, '25ml alucinol', '0.80', 45),
(63, '30gr tricolor', '0.15', 56),
(64, '50gr luaslol', '1.25', 34),
(65, '36gr enferemin', '0.56', 44),
(66, '20gr mrdocsol', '0.34', 33),
(67, '10gr hptyen', '0.67', 34),
(68, '30gr bactrim forte', '0.20', 45),
(69, '50gr getions', '0.17', 34),
(70, '12gr pulgatol', '0.98', 23),
(71, '120ml mulgatol', '1.23', 23),
(72, '20gr blader', '1.15', 34),
(73, '34gr scroll', '1.46', 45),
(74, '25gr splot', '1.90', 43),
(75, '60ml vrgonol', '2.34', 23),
(76, '35ml climatol', '0.34', 34),
(77, '12gr lematrol', '1.25', 54),
(78, '500gr ibuprofeno', '3.34', 45),
(79, '34gr loxican', '0.34', 34),
(80, '30gr adolipino', '0.46', 54),
(81, '30gr anglobipino', '0.25', 65),
(82, '25ml cefalexina', '0.80', 34),
(83, '30gr ciproflaxino', '0.15', 23),
(84, '50gr melasol', '1.25', 33),
(85, '36gr huropol', '0.56', 32),
(86, '20gr agripal', '0.34', 23),
(87, '10gr pinalin forte', '0.67', 34),
(88, '30gr sertal compuesto', '0.20', 23),
(89, '50gr omepraxol', '0.17', 43),
(90, '12gr cepacol', '0.98', 45),
(91, '120ml anaproxeno', '1.23', 56),
(92, '20gr biczrbonato', '1.15', 49),
(93, '34gr heroina', '1.46', 49),
(94, '25gr suavitel', '1.90', 34),
(95, '60ml esquifil', '2.34', 39),
(96, '35ml clarotrivina', '0.34', 29),
(97, '12gr supersol', '1.25', 27),
(98, '500gr sistagina', '3.34', 38),
(99, '34gr laproxin', '0.34', 34),
(100, '30oml sunchine', '23.23', 33),
(102, '34mg Conrtisol', '0.54', 23);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock_ingresos`
--

CREATE TABLE `stock_ingresos` (
  `id` int NOT NULL,
  `fecha_ingreso` timestamp NOT NULL,
  `cantidad` int NOT NULL,
  `usuarios_id` int NOT NULL,
  `productos_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `stock_ingresos`
--

INSERT INTO `stock_ingresos` (`id`, `fecha_ingreso`, `cantidad`, `usuarios_id`, `productos_id`) VALUES
(1, '2022-03-22 17:23:23', 20, 1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `stock_salida`
--

CREATE TABLE `stock_salida` (
  `id` int NOT NULL,
  `fecha_salida` timestamp NOT NULL,
  `cantidad` int NOT NULL,
  `usuarios_id` int NOT NULL,
  `productos_id` int NOT NULL,
  `cliente_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `stock_salida`
--

INSERT INTO `stock_salida` (`id`, `fecha_salida`, `cantidad`, `usuarios_id`, `productos_id`, `cliente_id`) VALUES
(0, '2022-09-23 17:34:01', 5, 2, 12, 1),
(1, '2022-03-23 20:34:45', 12, 2, 26, 2),
(2, '2022-09-12 17:23:33', 2, 2, 45, 1),
(3, '2022-09-12 17:23:33', 2, 2, 45, 3),
(4, '2022-09-23 17:34:01', 5, 2, 12, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `password` varchar(12) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `email` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `password`, `nickname`, `email`) VALUES
(1, '12345', 'joelgt', 'gabrielasimbaya82@gmail.com'),
(2, '09876', 'omarst', 'omar.toro@epn.edu.ec'),
(3, '050619', 'palaciosbt', 'palaciosbt@gmail.com'),
(13, '12345', 'Ricardo', 'nasimbayaxte@gmail.com'),
(26, '12345', 'Alison', 'alison@ejemplo.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `accesos`
--
ALTER TABLE `accesos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `acceso_usuarios`
--
ALTER TABLE `acceso_usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `accesousuario_usuario_idx` (`usuario_id`),
  ADD KEY `accesousuario_acceso_idx` (`acceso_id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `distribuidores`
--
ALTER TABLE `distribuidores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `distribuidor_producto`
--
ALTER TABLE `distribuidor_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `distribuidorpro_productos_idx` (`producto_id`),
  ADD KEY `distribuidorpro_distribuidor_idx` (`distribuidor_id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `stock_ingresos`
--
ALTER TABLE `stock_ingresos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stock_usuarios_idx` (`usuarios_id`),
  ADD KEY `stock_productos_idx` (`productos_id`);

--
-- Indices de la tabla `stock_salida`
--
ALTER TABLE `stock_salida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stock_sal_usuarios_idx` (`usuarios_id`),
  ADD KEY `stock_sal_productos_idx` (`productos_id`),
  ADD KEY `stok_salida-client` (`cliente_id`) USING BTREE;

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `accesos`
--
ALTER TABLE `accesos`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `acceso_usuarios`
--
ALTER TABLE `acceso_usuarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `distribuidores`
--
ALTER TABLE `distribuidores`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT de la tabla `stock_ingresos`
--
ALTER TABLE `stock_ingresos`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `acceso_usuarios`
--
ALTER TABLE `acceso_usuarios`
  ADD CONSTRAINT `accesousuario_acceso` FOREIGN KEY (`acceso_id`) REFERENCES `accesos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `accesousuario_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `distribuidor_producto`
--
ALTER TABLE `distribuidor_producto`
  ADD CONSTRAINT `distribuidorpro_distribuidor` FOREIGN KEY (`distribuidor_id`) REFERENCES `distribuidores` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `distribuidorpro_productos` FOREIGN KEY (`producto_id`) REFERENCES `productos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `stock_ingresos`
--
ALTER TABLE `stock_ingresos`
  ADD CONSTRAINT `stock_productos` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `stock_usuarios` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `stock_salida`
--
ALTER TABLE `stock_salida`
  ADD CONSTRAINT `stock_sal_productos` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stock_sal_usuarios` FOREIGN KEY (`usuarios_id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
