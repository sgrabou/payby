-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 06 oct. 2019 à 08:50
-- Version du serveur :  5.7.23
-- Version de PHP :  7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `payby`
--

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`id`, `name`) VALUES
(1, 'Java'),
(2, 'Node'),
(3, 'Python');

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `code_postal` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `paye` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `address`, `code_postal`, `email`, `first_name`, `last_name`, `paye`, `phone_number`, `ville`, `pays`) VALUES
(1, '222,dfdf dfdf dfdf Casablanca', '40000', 'ssdsd@dsdsd.sd', 'hola', 'holi', 'Maroc', '065454545', 'taza', NULL),
(2, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(3, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(4, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(5, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(6, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(7, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(8, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(9, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(10, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(11, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(12, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(13, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(14, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(15, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(16, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(17, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(18, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(19, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(20, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(21, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(22, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(23, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(24, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(25, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(26, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(27, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(28, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(29, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(30, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(31, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(32, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(33, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(34, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(35, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(36, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(37, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(38, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon', NULL),
(39, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '645251452', 'Lyon', 'France'),
(40, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '645251452', 'Lyon', 'France'),
(41, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(42, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(43, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(44, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(45, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(46, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(47, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(48, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France'),
(49, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', NULL, '0645251452', 'Lyon', 'France');

-- --------------------------------------------------------

--
-- Structure de la table `merchant`
--

DROP TABLE IF EXISTS `merchant`;
CREATE TABLE IF NOT EXISTS `merchant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `merchant_responseurl` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payby_redirectionurl` varchar(255) DEFAULT NULL,
  `payby_version` varchar(255) DEFAULT NULL,
  `private_key` varchar(255) DEFAULT NULL,
  `public_key` varchar(255) DEFAULT NULL,
  `secret_key` varchar(255) DEFAULT NULL,
  `url_website` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `walletid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hpejy4i1nk4u3251c6ba2pmpv` (`name`),
  UNIQUE KEY `UK_datjm3tagd6d7f1bhqr93eest` (`user_name`),
  KEY `FK414k596c3caigdkphkhhhwub6` (`walletid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `merchant`
--

INSERT INTO `merchant` (`id`, `description`, `email`, `logo`, `merchant_responseurl`, `status`, `mobile_number`, `name`, `payby_redirectionurl`, `payby_version`, `private_key`, `public_key`, `secret_key`, `url_website`, `user_name`, `walletid`) VALUES
(1, 'samirSite', 'ssdsd@sdsds.com', 'media/merchant/logo_paracasa.jpg', 'http://localhost/prestashop/index.php?fc=module&module=PayBy&controller=reponse', 0, '04545454545', 'samir', 'http://localhost:8034/payby/payment/', '1.0', 'sdsdsdsdsffsfsf', 'sfsfsfsf', 'paracasabglh65g-sbsp_8mc_n2yv0pn_u7#bk@(mw=6(-$hwl@$h9%2%0payby', 'http://localhost', 'marchantUsername', 1);

-- --------------------------------------------------------

--
-- Structure de la table `paiement_order`
--

DROP TABLE IF EXISTS `paiement_order`;
CREATE TABLE IF NOT EXISTS `paiement_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `merchand_orderid` varchar(255) DEFAULT NULL,
  `order_details` varchar(255) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `customerid` bigint(20) DEFAULT NULL,
  `merchandid` bigint(20) DEFAULT NULL,
  `merchant_orderid` varchar(255) DEFAULT NULL,
  `merchantid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iug6uug61w5fjg3k83ee65udw` (`reference`),
  KEY `FKrsl2idgc6vnov5ggwav708obi` (`merchandid`),
  KEY `FK2ytvysfvwd2ux2vosrj3fdhw0` (`customerid`),
  KEY `FKovjpj21gqelu5v8e5kjt3jgxg` (`merchantid`)
) ENGINE=MyISAM AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement_order`
--

INSERT INTO `paiement_order` (`id`, `amount`, `creation_date`, `merchand_orderid`, `order_details`, `order_status`, `reference`, `customerid`, `merchandid`, `merchant_orderid`, `merchantid`) VALUES
(26, '4318.00', '2019-08-19 15:30:42', '6', ' Robe d\'été imprimée ', 0, 'ca2ee195-8a67-4af2-8099-11ade5077360', 26, 1, NULL, NULL),
(27, '4318.00', '2019-08-19 15:31:17', '6', ' Robe d\'été imprimée ', 0, '9bfdcd39-6adb-4970-8ba6-2faff7ceb3e9', 27, 1, NULL, NULL),
(28, '4318.00', '2019-08-19 15:31:21', '6', ' Robe d\'été imprimée ', 0, 'c4335c9a-9425-486b-a82d-a3db82272b44', 28, 1, NULL, NULL),
(29, '4318.00', '2019-08-19 15:31:24', '6', ' Robe d\'été imprimée ', 0, '58eebef4-52db-4d09-911d-735bf57284ce', 29, 1, NULL, NULL),
(30, '4318.00', '2019-08-19 15:31:28', '6', ' Robe d\'été imprimée ', 0, 'b8cfbf99-0c87-4f5c-9b24-b4a54a5589b9', 30, 1, NULL, NULL),
(31, '4318.00', '2019-08-19 15:32:20', '6', ' Robe d\'été imprimée ', 0, 'c62773fb-33bb-4020-bb8d-5b4a2f10d469', 31, 1, NULL, NULL),
(32, '4318.00', '2019-08-19 15:32:24', '6', ' Robe d\'été imprimée ', 0, '93d46b42-5d9d-4d25-b714-a6a0e9ec7e0c', 32, 1, NULL, NULL),
(33, '4318.00', '2019-08-19 21:49:33', '6', ' Robe d\'été imprimée ', 0, 'cefb3aa2-dcbb-4b18-ad1e-d0728b34b4ee', 33, 1, NULL, NULL),
(34, '4318.00', '2019-08-19 21:50:07', '6', ' Robe d\'été imprimée ', 0, '8f7d2638-000c-4466-8da6-60ac1f05e55e', 34, 1, NULL, NULL),
(35, '4318.00', '2019-08-19 22:08:21', '6', ' Robe d\'été imprimée ', 0, '02450f67-282c-45cf-b829-5ba3126eff12', 35, 1, NULL, NULL),
(36, '4318.00', '2019-08-20 00:40:29', '6', ' Robe d\'été imprimée ', 0, '098aadd1-3576-47eb-b3ec-998c6343ab67', 36, 1, NULL, NULL),
(37, '4318.00', '2019-08-20 21:40:42', '6', ' Robe d\'été imprimée ', 0, 'a97e7640-b4f9-493e-8404-be8f8b9f0ad0', 37, 1, NULL, NULL),
(38, '3660.00', '2019-08-20 23:44:36', '7', ' Robe d\'été imprimée ', 1, 'a4d19540-9d57-4c7e-a8b7-ebae47e859ae', 38, 1, NULL, NULL),
(39, '36.60', '2019-08-21 00:52:41', '8', ' Robe d\'été imprimée ', 1, '7c88df7e-e440-441f-9031-5ef04d07e8db', 39, 1, NULL, NULL),
(40, '36.60', '2019-08-21 02:27:50', '8', ' Robe d\'été imprimée ', 0, '64a76ce1-729c-4f4e-9e88-5ff75da241fd', 40, 1, NULL, NULL),
(41, '36.60', '2019-08-21 02:44:57', '8', ' Robe d\'été imprimée ', 0, '330695fa-8110-44b0-87bd-d31f7415f425', 41, 1, NULL, NULL),
(42, '36.60', '2019-08-21 02:53:14', '8', ' Robe d\'été imprimée ', 1, '23577825-8e87-4127-961f-72a5133b5bb0', 42, 1, NULL, NULL),
(43, '36.60', '2019-08-21 17:11:52', '8', ' Robe d\'été imprimée ', 1, '237c3fac-cf99-41fe-a3aa-df4981faf37a', 43, 1, NULL, NULL),
(44, '71.38', '2019-08-21 23:30:20', NULL, ' Robe d\'été imprimée  - Robe d\'été imprimée ', 1, '25a72a95-1df6-47e0-b5b7-60ef01432378', 44, NULL, '8', 1),
(45, '71.38', '2019-08-21 23:47:09', NULL, ' Robe d\'été imprimée  - Robe d\'été imprimée ', 1, 'bec73745-de9f-4fbc-bfe6-21a41f61f977', 45, NULL, '8', 1),
(46, '36.60', '2019-08-22 00:03:50', NULL, ' Robe d\'été imprimée ', 1, '6277dad9-eb16-4e38-ac98-7bfb04a2fbda', 46, NULL, '9', 1),
(47, '34.78', '2019-08-24 01:50:48', NULL, ' Robe d\'été imprimée ', 0, '94b82797-e785-4ef5-833d-3f24d593fc27', 47, NULL, '10', 1),
(48, '69.55', '2019-08-24 16:46:04', NULL, ' Robe d\'été imprimée ', 1, '857d57a1-7735-4030-92f3-9c3d96e07176', 48, NULL, '10', 1),
(49, '61.19', '2019-09-15 22:47:51', NULL, ' Robe imprimée ', 0, '509cc17d-d0f1-42ce-be3e-b9616a48536a', 49, NULL, '11', 1);

-- --------------------------------------------------------

--
-- Structure de la table `paiement_wallet`
--

DROP TABLE IF EXISTS `paiement_wallet`;
CREATE TABLE IF NOT EXISTS `paiement_wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_status` datetime DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `orderid` bigint(20) DEFAULT NULL,
  `walletid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmatyi4q3jej064kd2tqu03633` (`orderid`),
  KEY `FKctnn8xka8y27d3ej54nral4tt` (`walletid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement_wallet`
--

INSERT INTO `paiement_wallet` (`id`, `date_status`, `order_status`, `orderid`, `walletid`) VALUES
(1, '2019-08-20 21:46:19', 1, 6, NULL),
(2, '2019-08-20 21:46:19', 1, 6, NULL),
(3, '2019-08-20 21:46:19', 1, 6, NULL),
(4, '2019-08-20 21:46:19', 1, 6, NULL),
(5, '2019-08-20 21:46:19', 1, 6, NULL),
(6, '2019-08-20 21:46:19', 1, 6, NULL),
(7, '2019-08-20 21:46:19', 1, 6, NULL),
(8, '2019-08-20 21:46:19', 1, 6, NULL),
(9, '2019-08-20 21:46:19', 1, 6, NULL),
(10, '2019-08-20 21:46:19', 1, 6, NULL),
(11, '2019-08-20 21:46:19', 1, 6, NULL),
(12, '2019-08-20 21:46:19', 1, 6, NULL),
(13, '2019-08-20 21:46:19', 1, 38, NULL),
(14, '2019-08-20 21:46:19', 1, 38, NULL),
(15, '2019-08-20 21:46:19', 1, 39, NULL),
(16, '2019-08-20 21:46:19', 1, 39, NULL),
(17, '2019-08-20 21:46:19', 1, 39, NULL),
(18, '2019-08-20 21:46:19', 1, 39, NULL),
(19, '2019-08-20 21:46:19', 1, 39, NULL),
(20, '2019-08-20 21:46:19', 1, 39, NULL),
(21, '2019-08-20 21:46:19', 1, 39, NULL),
(22, '2019-08-20 21:46:19', 1, 39, NULL),
(23, '2019-08-20 21:46:19', 1, 39, NULL),
(24, '2019-08-20 21:46:19', 1, 39, NULL),
(25, '2019-08-20 21:46:19', 1, 42, NULL),
(26, '2019-08-21 18:08:15', 0, 43, NULL),
(27, '2019-08-21 18:08:15', 1, 43, NULL),
(28, '2019-08-21 23:39:55', 1, 44, NULL),
(29, '2019-08-21 23:39:55', 1, 45, NULL),
(30, '2019-08-21 23:39:55', 1, 45, NULL),
(31, '2019-08-21 23:39:55', 1, 46, NULL),
(32, '2019-08-24 16:46:35', 1, 48, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `roles`) VALUES
(1, 'admin', '$2a$10$aJwV9q32F4y1jFB3HBCTKOaSwdtzGM7o55ncAUUHQGH0TwuOuloe.', 0xaced0005757200135b4c6a6176612e6c616e672e537472696e673badd256e7e91d7b4702000078700000000174000a41444d494e5f524f4c45);

-- --------------------------------------------------------

--
-- Structure de la table `wallet`
--

DROP TABLE IF EXISTS `wallet`;
CREATE TABLE IF NOT EXISTS `wallet` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `api_key` varchar(255) DEFAULT NULL,
  `private_key` varchar(255) DEFAULT NULL,
  `public_key` varchar(255) DEFAULT NULL,
  `wallet_description` varchar(255) DEFAULT NULL,
  `wallet_name` varchar(255) DEFAULT NULL,
  `wallet_owner` varchar(255) DEFAULT NULL,
  `wallet_status` int(11) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `secret_key` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `wallet`
--

INSERT INTO `wallet` (`id`, `api_key`, `private_key`, `public_key`, `wallet_description`, `wallet_name`, `wallet_owner`, `wallet_status`, `logo`, `secret_key`) VALUES
(1, 'API_KEY_SDSDSDSD', 'SDSDSDSDSDSD', 'SDSDSDSDSDSD', 'SOPAY', 'SOPAY', 'SG', 1, 'media/wallet/logo_sopay.png', 'sopayim6(5$macgb3$8*9%ypc6aa8+f$5-o)1ix59ytygn!0umvan!9payby');
