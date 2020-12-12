-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 12, 2020 at 12:37 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id14250915_db_bank`
--
CREATE DATABASE IF NOT EXISTS `id14250915_db_bank` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id14250915_db_bank`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `profileID` int(11) NOT NULL,
  `account_no` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `unique_code` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `cvv` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `expires` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `card_pin` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `account_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `account_balance` decimal(13,2) NOT NULL,
  `isBlocked` varchar(5) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`profileID`, `account_no`, `unique_code`, `cvv`, `expires`, `card_pin`, `account_name`, `account_balance`, `isBlocked`) VALUES
(1, '4506727037185740', '', '740', '11/2025', '', 'Dorothy Pierce', 2030.20, ''),
(4, '5316175796353504', 'IUBKC6', '290', '04/2026', '7890', 'Benjamin Kololli', 2900.50, 'No'),
(9, '5316177038388561', 'K3NE76', '306', '06/2026', '8945', 'Florent Hadergjonaj', 2063.00, 'No');

-- --------------------------------------------------------

--
-- Table structure for table `profiles`
--

CREATE TABLE `profiles` (
  `profileID` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `fullname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `city` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telephone_number` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `profiles`
--


-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int(11) NOT NULL,
  `profileID` int(11) NOT NULL,
  `account_no` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `timestamp` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `sending_account` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `destination_account` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_payee` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_amount` decimal(13,2) NOT NULL,
  `trans_type` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transaction_id`, `profileID`, `account_no`, `timestamp`, `sending_account`, `destination_account`, `transaction_payee`, `transaction_amount`, `trans_type`) VALUES
(4, 4, '5316175796353504', 'Today - 18:21', 'dopeshit', 'dopi', 'test', 20.00, 'deposit'),
(5, 4, '5316177038388561', '2020-12-04 18:21', 'dopeshit', 'dopi', 'test', 150.00, 'transfer'),
(6, 4, '5316177038388561', '2020-12-04 18:21', 'ACC', 'Benjamin Kololli', 'KFC - Albi Mall', 55.50, 'payment'),
(7, 9, '5316177038388561', '2020-07-13 03:15:55', 'Florent Hadergjonaj', 'Benjamin Kololli', 'test', 858.00, 'transfer'),
(8, 9, '5316177038388561', '2020-07-13 03:23:48', 'Florent Hadergjonaj', 'Benjamin Kololli', 'test', 1.00, 'transfer'),
(11, 9, '5316175796353504', '2020-07-13 03:46:15', 'Benjamin Kololli', 'Florent Hadergjonaj', 'test', 5.00, 'transfer'),
(12, 9, '5316177038388561', '2020-07-13 03:46:15', 'Florent Hadergjonaj', 'Benjamin Kololli', 'test', 5.00, 'transfer'),
(13, 4, '5316177038388561', '2020-07-13 03:48:57', 'Florent Hadergjonaj', 'Benjamin Kololli', 'test', 115.00, 'transfer'),
(16, 9, '5316177038388561', '2020-07-13 03:51:28', 'Florent Hadergjonaj', 'Benjamin Kololli', 'test', 1000.00, 'transfer'),
(18, 4, '5316175796353504', '2020-07-13 17:44:53', 'Benjamin Kololli', 'Florent Hadergjonaj', 'test', 40.00, 'transfer'),
(21, 4, '5316177038388561', '2020-24-10 18:21', 'ACC', 'Benjamin Kololli', 'Nike Shop - Albi Mall', 240.00, 'payment'),
(22, 4, '5316175796353504', '2020-22-10 18:21', 'Bank xxx', 'Benjamin Kololli', 'test', 800.00, 'deposit'),
(25, 4, '5316175796353504', '2020-10-24 17:53:13', 'Benjamin Kololli', 'Florent Hadergjonaj', 'test', 50.00, 'transfer'),
(27, 9, '5316177038388561', '2020-10-24 17:53:13', 'Benjamin Kololli', 'Florent Hadergjonaj', 'test', 50.00, 'transfer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`account_no`),
  ADD KEY `profileID` (`profileID`);

--
-- Indexes for table `profiles`
--
ALTER TABLE `profiles`
  ADD PRIMARY KEY (`profileID`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `profileID` (`profileID`),
  ADD KEY `account_no` (`account_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `profiles`
--
ALTER TABLE `profiles`
  MODIFY `profileID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`profileID`) REFERENCES `profiles` (`profileID`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`profileID`) REFERENCES `profiles` (`profileID`),
  ADD CONSTRAINT `transactions_ibfk_2` FOREIGN KEY (`account_no`) REFERENCES `account` (`account_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
