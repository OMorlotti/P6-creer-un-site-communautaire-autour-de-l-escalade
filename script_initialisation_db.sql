-- phpMyAdmin SQL Dump
-- version 4.9.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jan 21, 2021 at 02:54 PM
-- Server version: 5.7.26
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `amisdelescalade`
--

-- --------------------------------------------------------

--
-- Table structure for table `ADDRESS`
--

CREATE TABLE `ADDRESS` (
  `id` int(11) NOT NULL,
  `city` varchar(32) NOT NULL,
  `country` varchar(32) NOT NULL,
  `created` datetime NOT NULL,
  `postalcode` varchar(11) NOT NULL,
  `street` varchar(6) NOT NULL,
  `streetname` varchar(256) NOT NULL,
  `userfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `BOOKING`
--

CREATE TABLE `BOOKING` (
  `id` int(11) NOT NULL,
  `topofk` int(11) DEFAULT NULL,
  `userfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `COMMENT`
--

CREATE TABLE `COMMENT` (
  `id` int(11) NOT NULL,
  `comment` varchar(512) NOT NULL,
  `created` datetime NOT NULL,
  `spotfk` int(11) DEFAULT NULL,
  `userfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `COMMENT`
--

INSERT INTO `COMMENT` (`id`, `comment`, `created`, `spotfk`, `userfk`) VALUES
(1, 'Super lieu de grimpe pour les enfants !', '2021-01-21 11:39:58', 1, 1),
(2, 'Superbe vue sur Lyon !', '2021-01-21 14:07:41', 4, 4),
(3, 'Superbe vue sur la région !', '2021-01-21 14:08:17', 5, 2);

-- --------------------------------------------------------

--
-- Table structure for table `COTATION`
--

CREATE TABLE `COTATION` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `COTATION`
--

INSERT INTO `COTATION` (`id`, `name`) VALUES
(1, '4a'),
(2, '4b'),
(3, '4c'),
(4, '5a'),
(5, '5b'),
(6, '5c'),
(7, '5c+'),
(8, '6a'),
(9, '6b'),
(10, '6c'),
(11, '6c+'),
(12, '7a'),
(13, '7b'),
(14, '7c'),
(15, '7c+'),
(16, '8a'),
(17, '8b'),
(18, '8c'),
(19, '8c+'),
(20, '9a'),
(21, '9b+');

-- --------------------------------------------------------

--
-- Table structure for table `LENGTH`
--

CREATE TABLE `LENGTH` (
  `id` int(11) NOT NULL,
  `numberOfSpits` int(11) NOT NULL,
  `cotationfk` int(11) DEFAULT NULL,
  `voiefk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `LENGTH`
--

INSERT INTO `LENGTH` (`id`, `numberOfSpits`, `cotationfk`, `voiefk`) VALUES
(1, 56, 2, 2),
(2, 12, 3, 3),
(3, 45, 4, 4),
(4, 36, 4, 5),
(5, 10, 2, 6),
(6, 47, 2, 8);

-- --------------------------------------------------------

--
-- Table structure for table `SECTEUR`
--

CREATE TABLE `SECTEUR` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `spotfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `SECTEUR`
--

INSERT INTO `SECTEUR` (`id`, `name`, `spotfk`) VALUES
(1, 'Vercors 1', 3),
(2, 'Saint Jean', 4),
(3, '2', 5),
(4, 'Mercière', 6),
(5, 'Panache', 1),
(6, 'Chemin des Martyrs', 2),
(7, '3', 5);

-- --------------------------------------------------------

--
-- Table structure for table `SPOT`
--

CREATE TABLE `SPOT` (
  `id` int(11) NOT NULL,
  `departement` varchar(128) NOT NULL,
  `isofficial` bit(1) NOT NULL,
  `latitude` varchar(32) NOT NULL,
  `longitude` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  `topofk` int(11) DEFAULT NULL,
  `userfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `SPOT`
--

INSERT INTO `SPOT` (`id`, `departement`, `isofficial`, `latitude`, `longitude`, `name`, `topofk`, `userfk`) VALUES
(1, '38', b'1', '123456', '987655', 'Bastille', 1, 4),
(2, '38', b'0', '123456', '654987', 'Abbé Cuchet', 2, 3),
(3, '38', b'0', '987657', '123456', 'Le Château', 1, 2),
(4, '69', b'1', '786544', '321654', 'Bellecour', 3, 1),
(5, '69', b'1', '951357', '357357', 'Azergues', 4, 4),
(6, '69', b'0', '147357', '852485', 'Saxe', 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `TOPO`
--

CREATE TABLE `TOPO` (
  `id` int(11) NOT NULL,
  `city` varchar(128) NOT NULL,
  `description` varchar(512) NOT NULL,
  `isavailable` bit(1) NOT NULL,
  `name` varchar(128) NOT NULL,
  `postalcode` varchar(11) NOT NULL,
  `releasedate` datetime NOT NULL,
  `userfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TOPO`
--

INSERT INTO `TOPO` (`id`, `city`, `description`, `isavailable`, `name`, `postalcode`, `releasedate`, `userfk`) VALUES
(1, 'Grenoble', 'Les spots grenoblois familiaux', b'1', 'Grenoble', '38000', '2021-01-21 11:18:07', 1),
(2, 'Noyarey', 'Au pied du Parc naturel du Vercos', b'1', 'Noyarey', '38360', '2021-01-21 13:14:31', 1),
(3, 'Lyon', 'A 2 pas de Lyon', b'1', 'Fourvière', '69000', '2021-01-20 23:00:00', 1),
(4, 'Lozanne', 'En agglo lyonnaise', b'1', 'Lozanne', '69380', '2021-01-21 13:55:55', 4);

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE `USER` (
  `id` int(11) NOT NULL,
  `birthdate` datetime NOT NULL,
  `created` datetime NOT NULL,
  `custom` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstname` varchar(128) NOT NULL,
  `lastname` varchar(128) NOT NULL,
  `login` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `role` int(11) NOT NULL,
  `sex` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`id`, `birthdate`, `created`, `custom`, `email`, `firstname`, `lastname`, `login`, `password`, `phone`, `role`, `sex`) VALUES
(1, '1985-02-08 23:00:00', '2021-01-20 22:34:43', NULL, 'o.morlotti@gmail.com', 'Olivier', 'MORLOTTI', 'OMorlotti', '09021985', '0603617719', 3, 1),
(2, '1995-02-08 23:00:00', '2021-01-21 10:28:10', NULL, 'capitaine@tintin.com', 'Haddock', 'Capitaine', 'Haddock', '000000', '0000000000', 1, 1),
(3, '1905-01-31 23:50:39', '2021-01-21 10:41:39', NULL, 'harry@potter.com', 'Harry', 'Potter', 'Harry', '000000', '0000000000', 2, 1),
(4, '2007-08-17 22:00:00', '2021-01-21 13:15:55', NULL, 'l.donteville@gmail.com', 'Lucas', 'DONTEVILLE', 'Lucas', '000000', '0674748038', 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `VOIE`
--

CREATE TABLE `VOIE` (
  `id` int(11) NOT NULL,
  `height` float NOT NULL,
  `sectorfk` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `VOIE`
--

INSERT INTO `VOIE` (`id`, `height`, `sectorfk`) VALUES
(1, 50, 1),
(2, 78, 2),
(3, 60, 3),
(4, 80, 4),
(5, 32, 5),
(6, 47, 6),
(7, 45, 3),
(8, 56, 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ADDRESS`
--
ALTER TABLE `ADDRESS`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdl8ttk55x7varwqui40dpcjt6` (`userfk`);

--
-- Indexes for table `BOOKING`
--
ALTER TABLE `BOOKING`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkx7vfr3n428j18qiyaatpix1j` (`topofk`),
  ADD KEY `FK1io9r7ienjkhxwioygrr6ruv0` (`userfk`);

--
-- Indexes for table `COMMENT`
--
ALTER TABLE `COMMENT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKc2a8bk4orpbdclwrw6vyta1yf` (`spotfk`),
  ADD KEY `FKg4wp28f1ctjkwxnmshu36mepl` (`userfk`);

--
-- Indexes for table `COTATION`
--
ALTER TABLE `COTATION`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_igotsbx17v1kj8o631d2i2irv` (`name`);

--
-- Indexes for table `LENGTH`
--
ALTER TABLE `LENGTH`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKl3ph3owqy3fh0lfdf2iihq9mr` (`cotationfk`),
  ADD KEY `FKgqxs5r4gxqeqra6porywd0uyq` (`voiefk`);

--
-- Indexes for table `SECTEUR`
--
ALTER TABLE `SECTEUR`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa7sh9jm108l73hgm2m45vwu9n` (`spotfk`);

--
-- Indexes for table `SPOT`
--
ALTER TABLE `SPOT`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKou9a1u5j1p29f4iu0dxsxkdo4` (`topofk`),
  ADD KEY `FKipx2afh94etysljlmll7rtih9` (`userfk`);

--
-- Indexes for table `TOPO`
--
ALTER TABLE `TOPO`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg2g109b6gqd6efx2u5a3vadsu` (`userfk`);

--
-- Indexes for table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_oso07pudw19e66bs4yp8hwpux` (`email`),
  ADD UNIQUE KEY `UK_slockai06wyhy7i5c8vnd2o31` (`login`);

--
-- Indexes for table `VOIE`
--
ALTER TABLE `VOIE`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb1qtwtbwb9akxn1btctrr6axa` (`sectorfk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ADDRESS`
--
ALTER TABLE `ADDRESS`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `BOOKING`
--
ALTER TABLE `BOOKING`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `COMMENT`
--
ALTER TABLE `COMMENT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `COTATION`
--
ALTER TABLE `COTATION`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `LENGTH`
--
ALTER TABLE `LENGTH`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `SECTEUR`
--
ALTER TABLE `SECTEUR`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `SPOT`
--
ALTER TABLE `SPOT`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `TOPO`
--
ALTER TABLE `TOPO`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `VOIE`
--
ALTER TABLE `VOIE`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
