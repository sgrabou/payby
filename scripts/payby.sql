-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 19 août 2019 à 15:36
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
  `pays` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `address`, `code_postal`, `email`, `first_name`, `last_name`, `pays`, `phone_number`, `ville`) VALUES
(1, '222,dfdf dfdf dfdf Casablanca', '40000', 'ssdsd@dsdsd.sd', 'hola', 'holi', 'Maroc', '065454545', 'taza'),
(2, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(3, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(4, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(5, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(6, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(7, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(8, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(9, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(10, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(11, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(12, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(13, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(14, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(15, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(16, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(17, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(18, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(19, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(20, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(21, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(22, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(23, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(24, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(25, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(26, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(27, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(28, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(29, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(30, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(31, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon'),
(32, '3 rue de 3 septembre 1944, 69009 Lyon', '69009', 's.grabou@gmail.com', 'Samir', 'Grabou', 'France', '645251452', 'Lyon');

-- --------------------------------------------------------

--
-- Structure de la table `merchand`
--

DROP TABLE IF EXISTS `merchand`;
CREATE TABLE IF NOT EXISTS `merchand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `merchand_responseurl` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `mobile_number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `payby_redirectionurl` varchar(255) DEFAULT NULL,
  `payby_version` varchar(255) DEFAULT NULL,
  `private_key` varchar(255) DEFAULT NULL,
  `public_key` varchar(255) DEFAULT NULL,
  `url_website` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `walletid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qrbmtcse4j3lkm4x089bsw738` (`name`),
  UNIQUE KEY `UK_2f53a79kul7fag2e8bk7a26up` (`user_name`),
  KEY `FK273fyxfn6sd88opvxr2grbx5c` (`walletid`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `merchand`
--

INSERT INTO `merchand` (`id`, `description`, `email`, `merchand_responseurl`, `status`, `mobile_number`, `name`, `payby_redirectionurl`, `payby_version`, `private_key`, `public_key`, `url_website`, `user_name`, `logo`, `walletid`) VALUES
(1, 'samirSite', 'ssdsd@sdsds.com', 'http://localhost/prestashop/index.php?fc=module&module=PayBy&controller=reponse', 0, '04545454545', 'samir', 'http://localhost:8034/payby/payment/', '1.0', 'sdsdsdsdsffsfsf', 'sfsfsfsf', 'http://localhost', 'marchandUsername', 'media/merchand/logo_paracasa.jpg', 1);

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_iug6uug61w5fjg3k83ee65udw` (`reference`),
  KEY `FK2ytvysfvwd2ux2vosrj3fdhw0` (`customerid`),
  KEY `FKrsl2idgc6vnov5ggwav708obi` (`merchandid`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement_order`
--

INSERT INTO `paiement_order` (`id`, `amount`, `creation_date`, `merchand_orderid`, `order_details`, `order_status`, `reference`, `customerid`, `merchandid`) VALUES
(1, '300.00', '2019-08-05 01:20:05', '12345', 'e\'t(yrtt', 0, '4b48fd51-4cb6-48e1-96b1-6c9f73c0c109', 1, 1),
(2, '4318.00', '2019-08-05 01:22:23', '6', ' Robe d\'été imprimée ', 0, '91ece03a-9ff7-45c5-ac23-55bc8e67f50a', 2, 1),
(3, '4318.00', '2019-08-05 01:27:55', '6', ' Robe d\'été imprimée ', 0, '7b86ef83-87f4-4e4d-91c3-520ee742646f', 3, 1),
(4, '4318.00', '2019-08-05 01:45:29', '6', ' Robe d\'été imprimée ', 0, 'bfd50ccf-84f4-4df7-81ed-c99839b61db6', 4, 1),
(5, '4318.00', '2019-08-05 01:49:03', '6', ' Robe d\'été imprimée ', 0, 'cb62616b-2ec7-4904-8f6f-c81ce0e86937', 5, 1),
(6, '4318.00', '2019-08-05 01:50:38', '6', ' Robe d\'été imprimée ', 0, 'e37ff570-19b5-4d7e-8e42-4a1370d15ee6', 6, 1),
(7, '4318.00', '2019-08-19 10:37:58', '6', ' Robe d\'été imprimée ', 0, '411119cb-1aaf-4036-8a54-38ce7c69ff0c', 7, 1),
(8, '4318.00', '2019-08-19 10:37:58', '6', ' Robe d\'été imprimée ', 0, 'a6176890-5cf0-401d-8df9-499c6dbf181c', 8, 1),
(9, '4318.00', '2019-08-19 10:41:30', '6', ' Robe d\'été imprimée ', 0, '77e1267b-236f-48af-b9f5-80534c4745fa', 9, 1),
(10, '4318.00', '2019-08-19 11:07:49', '6', ' Robe d\'été imprimée ', 0, '4bb05e68-1fe1-4fe5-b9ef-0b8fc0d10fe5', 10, 1),
(11, '4318.00', '2019-08-19 11:08:38', '6', ' Robe d\'été imprimée ', 0, '43e07faa-ecb9-44c4-a011-12344683daf5', 11, 1),
(12, '4318.00', '2019-08-19 13:02:46', '6', ' Robe d\'été imprimée ', 0, 'fe5d58b9-422d-4853-afc7-7021b2157230', 12, 1),
(13, '4318.00', '2019-08-19 15:13:36', '6', ' Robe d\'été imprimée ', 0, '1bd31605-d196-4535-86bf-525c11b74411', 13, 1),
(14, '4318.00', '2019-08-19 15:18:18', '6', ' Robe d\'été imprimée ', 0, '5813fae8-7d9c-40ec-8648-ed165bd52c26', 14, 1),
(15, '4318.00', '2019-08-19 15:21:05', '6', ' Robe d\'été imprimée ', 0, '931f6888-db0b-4ac3-af2d-fe68b8ba0237', 15, 1),
(16, '4318.00', '2019-08-19 15:29:17', '6', ' Robe d\'été imprimée ', 0, '8d584ab3-f144-49f1-89ee-96c3dbd6b889', 16, 1),
(17, '4318.00', '2019-08-19 15:29:21', '6', ' Robe d\'été imprimée ', 0, 'd2697932-10ed-4873-a9e8-8d5e2ed2f339', 17, 1),
(18, '4318.00', '2019-08-19 15:29:26', '6', ' Robe d\'été imprimée ', 0, '178a07bd-ac2e-4703-9bcd-261bdbb1c8b2', 18, 1),
(19, '4318.00', '2019-08-19 15:29:31', '6', ' Robe d\'été imprimée ', 0, '969cc450-aead-43f4-b3b9-81d44b44205f', 19, 1),
(20, '4318.00', '2019-08-19 15:29:35', '6', ' Robe d\'été imprimée ', 0, 'a1060ac0-8fae-4341-a461-0540f3c4641f', 20, 1),
(21, '4318.00', '2019-08-19 15:29:59', '6', ' Robe d\'été imprimée ', 0, '35028e65-a387-4e7c-ae3c-e1d37c52cfae', 21, 1),
(22, '4318.00', '2019-08-19 15:30:03', '6', ' Robe d\'été imprimée ', 0, '6688abd8-9208-4d40-a2ab-9a909dcc4818', 22, 1),
(23, '4318.00', '2019-08-19 15:30:06', '6', ' Robe d\'été imprimée ', 0, '81b3426e-8974-4c76-a6ca-96c713925d52', 23, 1),
(24, '4318.00', '2019-08-19 15:30:10', '6', ' Robe d\'été imprimée ', 0, '039c76b9-db78-4f8f-acad-cbc3e1c21647', 24, 1),
(25, '4318.00', '2019-08-19 15:30:38', '6', ' Robe d\'été imprimée ', 0, 'a2857457-457f-44df-a20a-b75293bd565e', 25, 1),
(26, '4318.00', '2019-08-19 15:30:42', '6', ' Robe d\'été imprimée ', 0, 'ca2ee195-8a67-4af2-8099-11ade5077360', 26, 1),
(27, '4318.00', '2019-08-19 15:31:17', '6', ' Robe d\'été imprimée ', 0, '9bfdcd39-6adb-4970-8ba6-2faff7ceb3e9', 27, 1),
(28, '4318.00', '2019-08-19 15:31:21', '6', ' Robe d\'été imprimée ', 0, 'c4335c9a-9425-486b-a82d-a3db82272b44', 28, 1),
(29, '4318.00', '2019-08-19 15:31:24', '6', ' Robe d\'été imprimée ', 0, '58eebef4-52db-4d09-911d-735bf57284ce', 29, 1),
(30, '4318.00', '2019-08-19 15:31:28', '6', ' Robe d\'été imprimée ', 0, 'b8cfbf99-0c87-4f5c-9b24-b4a54a5589b9', 30, 1),
(31, '4318.00', '2019-08-19 15:32:20', '6', ' Robe d\'été imprimée ', 0, 'c62773fb-33bb-4020-bb8d-5b4a2f10d469', 31, 1),
(32, '4318.00', '2019-08-19 15:32:24', '6', ' Robe d\'été imprimée ', 0, '93d46b42-5d9d-4d25-b714-a6a0e9ec7e0c', 32, 1);

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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `wallet`
--

INSERT INTO `wallet` (`id`, `api_key`, `private_key`, `public_key`, `wallet_description`, `wallet_name`, `wallet_owner`, `wallet_status`, `logo`) VALUES
(1, 'API_KEY_SDSDSDSD', 'SDSDSDSDSDSD', 'SDSDSDSDSDSD', 'SOPAY', 'SOPAY', 'SG', 1, 'media/wallet/logo_sopay.png');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
