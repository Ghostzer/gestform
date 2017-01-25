-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 25, 2017 at 09:32 AM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.13-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `Ecf`
--

CREATE TABLE `Ecf` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `id_formation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Formation`
--

CREATE TABLE `Formation` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Formation`
--

INSERT INTO `Formation` (`id`, `nom`) VALUES
(4, 'DL'),
(5, 'Plaquiste'),
(6, 'Ping-Pong'),
(14, 'Crêpier');

-- --------------------------------------------------------

--
-- Table structure for table `Personne`
--

CREATE TABLE `Personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Personne`
--

INSERT INTO `Personne` (`id`, `nom`, `prenom`) VALUES
(15, 'pouet', 'rico'),
(16, 'pouet', 'Yoann');

-- --------------------------------------------------------

--
-- Table structure for table `Resultat`
--

CREATE TABLE `Resultat` (
  `id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `matricule` int(11) NOT NULL,
  `id_ecf` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Stagiaire`
--

CREATE TABLE `Stagiaire` (
  `matricule` int(11) NOT NULL,
  `id_personne` int(11) NOT NULL,
  `id_formation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Stagiaire`
--

INSERT INTO `Stagiaire` (`matricule`, `id_personne`, `id_formation`) VALUES
(999, 16, 6),
(123456, 15, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Ecf`
--
ALTER TABLE `Ecf`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_formation` (`id_formation`);

--
-- Indexes for table `Formation`
--
ALTER TABLE `Formation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Resultat`
--
ALTER TABLE `Resultat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `matricule` (`matricule`),
  ADD KEY `id_ecf` (`id_ecf`);

--
-- Indexes for table `Stagiaire`
--
ALTER TABLE `Stagiaire`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `id_personne` (`id_personne`),
  ADD KEY `id_formation` (`id_formation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Ecf`
--
ALTER TABLE `Ecf`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Formation`
--
ALTER TABLE `Formation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `Resultat`
--
ALTER TABLE `Resultat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Stagiaire`
--
ALTER TABLE `Stagiaire`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123457;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Ecf`
--
ALTER TABLE `Ecf`
  ADD CONSTRAINT `Ecf_ibfk_1` FOREIGN KEY (`id_formation`) REFERENCES `Formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Resultat`
--
ALTER TABLE `Resultat`
  ADD CONSTRAINT `Resultat_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `Stagiaire` (`matricule`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Resultat_ibfk_2` FOREIGN KEY (`id_ecf`) REFERENCES `Ecf` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Stagiaire`
--
ALTER TABLE `Stagiaire`
  ADD CONSTRAINT `Stagiaire_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Stagiaire_ibfk_2` FOREIGN KEY (`id_formation`) REFERENCES `Formation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
