-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 14, 2018 at 09:04 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reminder2`
--

-- --------------------------------------------------------

--
-- Table structure for table `myrem`
--

CREATE TABLE `myrem` (
  `id` int(11) NOT NULL,
  `reminder` text NOT NULL,
  `day` text NOT NULL,
  `time` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `myrem`
--

INSERT INTO `myrem` (`id`, `reminder`, `day`, `time`) VALUES
(3, 'welcome', '2018-10-18', '01:00'),
(4, 'help tom', '2018-10-18', '02:30');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `myrem`
--
ALTER TABLE `myrem`
  ADD PRIMARY KEY (`id`) KEY_BLOCK_SIZE=100;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `myrem`
--
ALTER TABLE `myrem`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
