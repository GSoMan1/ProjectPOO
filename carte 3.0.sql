-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 01, 2020 at 01:38 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carte`
--
CREATE DATABASE IF NOT EXISTS `carte` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `carte`;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Poissons'),
(2, 'Viandes'),
(3, 'Végétarien'),
(4, 'Végétalien'),
(5, 'Soupe'),
(6, 'Dessert');

-- --------------------------------------------------------

--
-- Table structure for table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
CREATE TABLE IF NOT EXISTS `dishes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `price` float DEFAULT NULL,
  `catId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dishes`
--

INSERT INTO `dishes` (`id`, `title`, `description`, `price`, `catId`) VALUES
(1, 'Steak au poivre', 'Le steak au poivre ou filet mignon au poivre est composé d\'un filet mignon de bœuf et d\'une sauce au poivre. Les grains de poivre forment une croûte sur le steak une fois cuits', 29.99, 2),
(2, 'Magret de canard', 'Le magret est un filet de viande maigre, découpé à  partir de la poitrine d\'une oie ou d\'un canard gras, engraissé par gavage, les mêmes qui servent à  produire le confit et le foie gras', 25.45, 2),
(3, 'Sole meunière', 'La sole meunière est un plat de poisson  constitué d\'une sole dont on a ôté la peau grise, enrobée de farine et frite dans du beurre à la poêle. ', 14.99, 1),
(4, 'Saumon au four', 'Tranche de saumon cuite au four accompagné de frites ou purée au choix', 13, 1),
(5, 'Incredible Burger', 'Burger Vegan, avec de la mayonnaise vegan, de la moutarde, des champignons cuits avec de la crème de soja et des tomates en tranche', 7.99, 4),
(6, 'Sauté asiatique', 'Sauté contenant du brocoli, du poivron, des pates à ramen et du tofu dans une sauce à base de sauce soja et de sirop d\'érable\r\n', 12.59, 4),
(7, 'Pâtes tomates basilic', 'Pâtes grèques avec de la sauce tomate au basilic et du fromage', 9.99, 3),
(8, 'Hachis parmentier au Quorn', 'Hachis avec du Quorn remplaçant la viande', 12.99, 3),
(9, 'Soupe au tomates', 'Soupe a base de tomates fraiches', 5.11, 5),
(10, 'Soupe aux potirons', 'Potage à base de potiron', 7.5, 5),
(11, 'Mousse au chocolat', 'Faite maison avec du bon chocolat belge', 4.8, 6),
(12, 'Glace au choix', 'Cornet 2 double avec saveur chocolat ou vanille ou fraise', 3, 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
