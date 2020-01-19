-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 07, 2019 at 03:08 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csci112`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `snum` char(8) NOT NULL,
  `lastName` varchar(25) NOT NULL,
  `firstName` varchar(25) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(25) NOT NULL,
  `state` char(3) NOT NULL,
  `zip` char(5) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `major` varchar(25) NOT NULL,
  `gpa` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`snum`, `lastName`, `firstName`, `street`, `city`, `state`, `zip`, `phone`, `major`, `gpa`) VALUES
('S00188', 'Smith', 'John', '111 Oak Ave.', 'Princeton', 'NJ', '08541', '555-1111', 'CIS', 3.43),
('S03154', 'Jones', 'Mary', '212 Maple St.', 'Hanover', 'NH', '03755', '555-2222', 'Computer Science', 3.62),
('S10843', 'Jarvs', 'Fred', '123 Spruce St.', 'Providence', 'RI', '02901', '555-4321', 'English', 3.07),
('S11013', 'Ali', 'Ben', '327 Pine St.', 'Cambridge', 'MA', '02140', '555-121', 'Accounting', 2.91),
('S11783', 'Washington', 'Martha', '419 Beech Lane', 'New York', 'NT', '10027', '555-1532', 'History', 3.67),
('S36912', 'Williams', 'Cathy', '231 Ash Terrace', 'New Haven', 'CT', '06520', '555-3251', 'Biology', 2.64),
('S41134', 'Franklin', 'Richard', '213 Birch Drive', 'Philadelphia', 'PA', '19104', '555-1334', 'Finance', 3.14),
('S72394', 'Banner', 'Blythe', '222 Larch St.', 'Ithaca', 'NY', '14853', '555-4422', 'Argiculture', 3.01);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
