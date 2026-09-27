-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2025 at 02:28 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spay`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Aid` int(11) NOT NULL,
  `Aname` varchar(100) NOT NULL,
  `Ausername` varchar(50) NOT NULL,
  `Apassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Aid`, `Aname`, `Ausername`, `Apassword`) VALUES
(1, 'Sarah Davis', 'sarahd', 'hashed_password_3'),
(2, 'Tom Clark', 'tomc', 'hashed_password_4');

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `Cid` int(11) NOT NULL,
  `Cname` varchar(100) NOT NULL,
  `Cemail` varchar(100) NOT NULL,
  `Ccontact` varchar(15) DEFAULT NULL,
  `Cusername` varchar(50) NOT NULL,
  `Cpassword` varchar(255) NOT NULL
) ;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`Cid`, `Cname`, `Cemail`, `Ccontact`, `Cusername`, `Cpassword`) VALUES
(1, 'Alice Johnson', 'alice.j@example.com', '09456789012', 'alicej', 'hashed_password_1'),
(2, 'Bob Wilson', 'bob.w@example.com', '09567890123', 'bobw', 'hashed_password_2');

-- --------------------------------------------------------

--
-- Table structure for table `history`
--

CREATE TABLE `history` (
  `Hid` int(11) NOT NULL,
  `Sid` int(11) NOT NULL,
  `Sname` varchar(100) NOT NULL,
  `Cid` int(11) NOT NULL,
  `Cname` varchar(100) NOT NULL,
  `Tid` int(11) NOT NULL,
  `Tname` varchar(50) NOT NULL,
  `Tamount` decimal(10,2) NOT NULL,
  `Hcreated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ;

--
-- Dumping data for table `history`
--

INSERT INTO `history` (`Hid`, `Sid`, `Sname`, `Cid`, `Cname`, `Tid`, `Tname`, `Tamount`, `Hcreated_at`) VALUES
(4, 1, 'John Doe', 1, 'Alice Johnson', 1, 'Tuition Fee', '5000.00', '2025-05-20 02:00:00'),
(5, 2, 'Jane Smith', 2, 'Bob Wilson', 6, 'Fundamentals of Nursing', '300.00', '2025-05-21 06:30:00'),
(6, 3, 'Michael Brown', 1, 'Alice Johnson', 1, 'Tuition Fee', '5000.00', '2025-05-22 01:15:00');

-- --------------------------------------------------------

--
-- Table structure for table `srecord`
--

CREATE TABLE `srecord` (
  `Srid` int(11) NOT NULL,
  `Sid` int(11) NOT NULL,
  `Sname` varchar(100) NOT NULL,
  `Tid` int(11) NOT NULL,
  `Tbalance` decimal(10,2) NOT NULL
) ;

--
-- Dumping data for table `srecord`
--

INSERT INTO `srecord` (`Srid`, `Sid`, `Sname`, `Tid`, `Tbalance`) VALUES
(10, 1, 'John Doe', 1, '15000.00'),
(11, 1, 'John Doe', 2, '2000.00'),
(12, 1, 'John Doe', 5, '500.00'),
(13, 1, 'John Doe', 9, '150.00'),
(14, 2, 'Jane Smith', 1, '15000.00'),
(15, 2, 'Jane Smith', 2, '2000.00'),
(16, 2, 'Jane Smith', 6, '600.00'),
(17, 3, 'Michael Brown', 1, '10000.00'),
(18, 3, 'Michael Brown', 7, '450.00');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `Sid` int(11) NOT NULL,
  `Sname` varchar(100) NOT NULL,
  `Semail` varchar(100) NOT NULL,
  `Scontact` varchar(15) DEFAULT NULL,
  `Sprogram` varchar(100) NOT NULL COMMENT 'Course program',
  `Ssection` varchar(10) DEFAULT NULL,
  `Syear` int(11) NOT NULL,
  `Ssemester` varchar(20) NOT NULL
) ;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Sid`, `Sname`, `Semail`, `Scontact`, `Sprogram`, `Ssection`, `Syear`, `Ssemester`) VALUES
(1, 'John Doe', 'john.doe@example.com', '09123456789', 'Information Technology', 'IT-A', 1, 'First'),
(2, 'Jane Smith', 'jane.smith@example.com', '09234567890', 'Nursing', 'NUR-B', 2, 'Second'),
(3, 'Michael Brown', 'michael.brown@example.com', '09345678901', 'Business Administration', 'BA-C', 3, 'First');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `Tid` int(11) NOT NULL,
  `Tname` varchar(50) NOT NULL,
  `Tothers` varchar(100) DEFAULT NULL,
  `Tamount` decimal(10,2) NOT NULL,
  `Syear` int(11) NOT NULL,
  `Ssemester` varchar(20) NOT NULL COMMENT 'Semester (ALL, 1ST, 2ND, 3RD)'
) ;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`Tid`, `Tname`, `Tothers`, `Tamount`, `Syear`, `Ssemester`) VALUES
(1, 'Tuition Fee', NULL, '15000.00', 1, '1ST'),
(2, 'Tuition Fee', NULL, '15000.00', 1, '2ND'),
(3, 'Tuition Fee', NULL, '15000.00', 2, '1ST'),
(4, 'Tuition Fee', NULL, '15000.00', 2, '2ND'),
(5, 'Tuition Fee', NULL, '15000.00', 3, '1ST'),
(6, 'Tuition Fee', NULL, '15000.00', 3, '2ND'),
(7, 'Tuition Fee', NULL, '15000.00', 4, '1ST'),
(8, 'Tuition Fee', NULL, '15000.00', 4, '2ND'),
(9, 'Tuition Fee', NULL, '15000.00', 5, '1ST'),
(10, 'Tuition Fee', NULL, '15000.00', 5, '2ND'),
(11, 'Miscellaneous', NULL, '2000.00', 1, '1ST'),
(12, 'Miscellaneous', NULL, '2000.00', 1, '2ND'),
(13, 'Miscellaneous', NULL, '2000.00', 2, '1ST'),
(14, 'Miscellaneous', NULL, '2000.00', 2, '2ND'),
(15, 'Miscellaneous', NULL, '2000.00', 3, '1ST'),
(16, 'Miscellaneous', NULL, '2000.00', 3, '2ND'),
(17, 'Miscellaneous', NULL, '2000.00', 4, '1ST'),
(18, 'Miscellaneous', NULL, '2000.00', 4, '2ND'),
(19, 'Miscellaneous', NULL, '2000.00', 5, '1ST'),
(20, 'Miscellaneous', NULL, '2000.00', 5, '2ND'),
(21, 'Uniform', 'PE Uniform', '800.00', 1, '1ST'),
(22, 'Uniform', 'NSTP Uniform', '800.00', 1, '1ST'),
(23, 'Uniform', 'School Uniform', '1200.00', 1, '1ST'),
(24, 'ID', 'ID Lace', '100.00', 1, '1ST'),
(25, 'ID', 'Whole Id', '150.00', 1, '1ST'),
(26, 'School Reports', 'COR', '200.00', 1, '1ST'),
(27, 'School Reports', 'COG', '200.00', 1, '1ST'),
(28, 'School Reports', 'SOA', '200.00', 1, '1ST'),
(29, 'School Reports', 'FORM 137', '300.00', 1, '1ST'),
(30, 'School Reports', 'FORM 138', '300.00', 1, '1ST'),
(31, 'Books', 'Introduction to Computing', '500.00', 1, '1ST'),
(32, 'Books', 'Programming Logic and Design', '600.00', 1, '1ST'),
(33, 'Books', 'Data Structures and Algorithms', '700.00', 1, '1ST'),
(34, 'Books', 'Database System Concepts', '800.00', 1, '1ST'),
(35, 'Books', 'Operating System Concepts', '900.00', 1, '1ST'),
(36, 'Books', 'Computer Networking', '1000.00', 1, '1ST'),
(37, 'Books', 'Web Development', '1100.00', 1, '1ST'),
(38, 'Events', 'First Tour', '500.00', 1, '1ST'),
(39, 'Events', 'Second Tour', '500.00', 1, '1ST'),
(40, 'Events', 'Third Tour', '500.00', 1, '1ST'),
(41, 'Events', 'Fourth Tour', '500.00', 1, '1ST'),
(42, 'Events', 'Fifth Tour', '500.00', 1, '1ST'),
(43, 'Events', 'Sports Fest', '300.00', 1, '1ST'),
(44, 'Events', 'Stage Play', '400.00', 1, '1ST');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Aid`),
  ADD UNIQUE KEY `Ausername` (`Ausername`);

--
-- Indexes for table `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`Cid`),
  ADD UNIQUE KEY `Cemail` (`Cemail`),
  ADD UNIQUE KEY `Cusername` (`Cusername`);

--
-- Indexes for table `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`Hid`),
  ADD KEY `Cid` (`Cid`),
  ADD KEY `Tid` (`Tid`),
  ADD KEY `idx_history_sid` (`Sid`),
  ADD KEY `idx_history_hcreated_at` (`Hcreated_at`);

--
-- Indexes for table `srecord`
--
ALTER TABLE `srecord`
  ADD PRIMARY KEY (`Srid`),
  ADD KEY `Tid` (`Tid`),
  ADD KEY `idx_srecord_sid` (`Sid`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Sid`),
  ADD UNIQUE KEY `Semail` (`Semail`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`Tid`),
  ADD UNIQUE KEY `uk_type` (`Tname`,`Tothers`,`Syear`,`Ssemester`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `Aid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cashier`
--
ALTER TABLE `cashier`
  MODIFY `Cid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `history`
--
ALTER TABLE `history`
  MODIFY `Hid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `srecord`
--
ALTER TABLE `srecord`
  MODIFY `Srid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `Sid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `Tid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`Sid`) REFERENCES `students` (`Sid`) ON DELETE CASCADE,
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`Cid`) REFERENCES `cashier` (`Cid`),
  ADD CONSTRAINT `history_ibfk_3` FOREIGN KEY (`Tid`) REFERENCES `type` (`Tid`);

--
-- Constraints for table `srecord`
--
ALTER TABLE `srecord`
  ADD CONSTRAINT `srecord_ibfk_1` FOREIGN KEY (`Sid`) REFERENCES `students` (`Sid`) ON DELETE CASCADE,
  ADD CONSTRAINT `srecord_ibfk_2` FOREIGN KEY (`Tid`) REFERENCES `type` (`Tid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
