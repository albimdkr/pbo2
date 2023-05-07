-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2023 at 09:04 PM
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
-- Database: `db_uts_pbo2_21552011235`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblalat`
--

CREATE TABLE `tblalat` (
  `kodeAlat` varchar(10) NOT NULL,
  `namaAlat` varchar(30) NOT NULL,
  `biayaProduksi` int(11) NOT NULL,
  `hargaJual` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbldivisi`
--

CREATE TABLE `tbldivisi` (
  `idDivisi` int(11) NOT NULL,
  `namaDivisi` enum('Produksi','Marketing') NOT NULL,
  `gapok` int(11) NOT NULL,
  `tunjangan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbldivisi`
--

INSERT INTO `tbldivisi` (`idDivisi`, `namaDivisi`, `gapok`, `tunjangan`) VALUES
(1, 'Produksi', 5000000, 500000),
(2, 'Marketing', 3500000, 350000);

-- --------------------------------------------------------

--
-- Table structure for table `tblpegawai`
--

CREATE TABLE `tblpegawai` (
  `kodePegawai` varchar(15) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `jk` enum('Pria','Wanita') NOT NULL,
  `tglMasuk` date NOT NULL,
  `alamat` text NOT NULL,
  `idUser` varchar(10) NOT NULL,
  `idDivisi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblpegawai`
--

INSERT INTO `tblpegawai` (`kodePegawai`, `nama`, `jk`, `tglMasuk`, `alamat`, `idUser`, `idDivisi`) VALUES
('PRO29022020001', 'Albi Mudakar Nasyabi', 'Pria', '2020-02-29', 'Kp. Bojong Reungas Desa Majalaya Kec. Majalaya Kab. Bandung', 'USER001', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tblpenjualan`
--

CREATE TABLE `tblpenjualan` (
  `kodeJual` varchar(15) NOT NULL,
  `kodeAlat` varchar(10) NOT NULL,
  `kodePegawai` varchar(15) NOT NULL,
  `tglJual` date NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbluser`
--

CREATE TABLE `tbluser` (
  `idUser` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `level` enum('Admin','Produksi','Marketing') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbluser`
--

INSERT INTO `tbluser` (`idUser`, `email`, `password`, `level`) VALUES
('USER001', 'Admin@gmail.com', 'Admin@12', 'Admin'),
('USER002', 'Produksi@gmail.com', 'Produksi@13', 'Produksi'),
('USER003', 'Marketing@gmail.com', 'Marketing@14', 'Marketing');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblalat`
--
ALTER TABLE `tblalat`
  ADD PRIMARY KEY (`kodeAlat`);

--
-- Indexes for table `tbldivisi`
--
ALTER TABLE `tbldivisi`
  ADD PRIMARY KEY (`idDivisi`);

--
-- Indexes for table `tblpegawai`
--
ALTER TABLE `tblpegawai`
  ADD PRIMARY KEY (`kodePegawai`),
  ADD KEY `idUser` (`idUser`),
  ADD KEY `idDivisi` (`idDivisi`);

--
-- Indexes for table `tblpenjualan`
--
ALTER TABLE `tblpenjualan`
  ADD PRIMARY KEY (`kodeJual`),
  ADD KEY `kodePegawai` (`kodePegawai`),
  ADD KEY `tblpenjualan_ibfk_1` (`kodeAlat`);

--
-- Indexes for table `tbluser`
--
ALTER TABLE `tbluser`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbldivisi`
--
ALTER TABLE `tbldivisi`
  MODIFY `idDivisi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblpegawai`
--
ALTER TABLE `tblpegawai`
  ADD CONSTRAINT `tblpegawai_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `tbluser` (`idUser`),
  ADD CONSTRAINT `tblpegawai_ibfk_2` FOREIGN KEY (`idDivisi`) REFERENCES `tbldivisi` (`idDivisi`);

--
-- Constraints for table `tblpenjualan`
--
ALTER TABLE `tblpenjualan`
  ADD CONSTRAINT `tblpenjualan_ibfk_1` FOREIGN KEY (`kodeAlat`) REFERENCES `tblalat` (`kodeAlat`),
  ADD CONSTRAINT `tblpenjualan_ibfk_2` FOREIGN KEY (`kodePegawai`) REFERENCES `tblpegawai` (`kodePegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
