-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 14 mars 2020 à 13:13
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `carte`
--

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'poissons'),
(2, 'viandes'),
(3, 'végétarien'),
(4, 'végétalien'),
(5, 'soupe'),
(6, 'dessert');

-- --------------------------------------------------------

--
-- Structure de la table `dishes`
--

DROP TABLE IF EXISTS `dishes`;
CREATE TABLE IF NOT EXISTS `dishes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `description` text,
  `price` float DEFAULT NULL,
  `catId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `dishes`
--

INSERT INTO `dishes` (`id`, `title`, `description`, `category`, `price`, `catId`) VALUES
(1, 'Steak au poivre', 'Le steak au poivre ou filet mignon au poivre est composé d\'un filet mignon de bœuf et d\'une sauce au poivre. Les grains de poivre forment une croûte sur le steak une fois cuits', 29.99, 2),
(2, 'Magret de canard', 'Le magret est un filet de viande maigre, découpé à partir de la poitrine d\'une oie ou d\'un canard gras, engraissé par gavage, les mêmes qui servent à produire le confit et le foie gras', 25.45, 2),
(3, 'Sole meunière', 'La sole meunière est un plat de poisson  constitué d\'une sole dont on a ôté la peau grise, enrobée de farine et frite dans du beurre à la poêle. ', 14.99, 1),
(4, 'Saumon au four', 'Tranche de saumon cuite au four accompagné de frites ou purée au choix', 13, 1),
(5, 'Gazon', 'Herbe fraichement coupée du jardin', 'végétalien', 2.99, 4),
(6, 'Foin', 'Du bon foin tout frais, le régal de tous les vegan', 'végétalien', 4.49, 4),
(7, 'Burger végétarien au steak de carottes ', 'Burger composé de carottes avec tomates ognion dans un petit pain frais', 9.99, 3),
(8, 'Risotto aux tomates végétarien ', 'Plat a base de riz et de tomates', 12.99, 3),
(9, 'Soupe au tomates', 'Soupe a base de tomates fraiches', 5.11, 5),
(10, 'Soupe aux potirons', 'Potage à base de potiron', 7.5, 5),
(11, 'Mousse au chocolat', 'Faite maison avec du bon chocolat belge', 4.8, 6),
(12, 'Glace au choix', 'Cornet 2 double avec saveur chocolat ou vanille ou fraise',  3, 6);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
