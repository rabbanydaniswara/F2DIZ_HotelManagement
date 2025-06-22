-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2025 at 12:54 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `kamar`
--

CREATE TABLE `kamar` (
  `nomor_kamar` varchar(50) NOT NULL,
  `tipe` varchar(50) DEFAULT NULL,
  `harga_kamar` decimal(10,2) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `kamar`
--

INSERT INTO `kamar` (`nomor_kamar`, `tipe`, `harga_kamar`, `status`) VALUES
('A101', 'Standard', 350000.00, 'Tersedia'),
('A102', 'Standard', 350000.00, 'Ditempati'),
('A103', 'Standard', 350000.00, 'Tersedia'),
('A104', 'Standard', 350000.00, 'Maintenance'),
('A105', 'Standard', 350000.00, 'Reserved'),
('A106', 'Standard', 350000.00, 'Tersedia'),
('A107', 'Standard', 350000.00, 'Ditempati'),
('B201', 'Deluxe', 500000.00, 'Ditempati'),
('B202', 'Deluxe', 500000.00, 'Reserved'),
('B203', 'Deluxe', 500000.00, 'Ditempati'),
('B204', 'Deluxe', 500000.00, 'Tersedia'),
('B205', 'Deluxe', 500000.00, 'Maintenance'),
('B206', 'Deluxe', 500000.00, 'Tersedia'),
('B207', 'Deluxe', 500000.00, 'Tersedia'),
('C301', 'Suite', 750000.00, 'Tersedia'),
('C302', 'Suite', 750000.00, 'Reserved'),
('C303', 'Suite', 750000.00, 'Ditempati'),
('C304', 'Suite', 750000.00, 'Tersedia'),
('C305', 'Suite', 750000.00, 'Maintenance');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(50) NOT NULL,
  `nama_pegawai` varchar(100) DEFAULT NULL,
  `nik` varchar(50) DEFAULT NULL,
  `jenis_kelamin` varchar(10) DEFAULT NULL,
  `alamat` text DEFAULT NULL,
  `no_tlp` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `jabatan` varchar(50) DEFAULT NULL,
  `akses_sistem` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama_pegawai`, `nik`, `jenis_kelamin`, `alamat`, `no_tlp`, `email`, `jabatan`, `akses_sistem`) VALUES
('P000', 'UnitTest', '0000000000000', 'Laki-laki', 'testing', '088888888888', 'unittest@email.com', 'Manager', 'ya'),
('P001', 'Ilham Sholahuddin', '3201011234560001', 'Laki-laki', 'Tangerang', '085882566944', 'ilhamsholahuddin161@gmail.com', 'Manager', 'Ya'),
('P002', 'Bulan', '3671031708020002', 'Perempuan', 'Jakarta', '0851667822900', 'bulan@gmail.com', 'Receptionist', 'Ya'),
('P003', 'Dedi Santoso', '3201031234560003', 'Laki-laki', 'Surabaya', '081223344556', 'dedi.santoso@email.com', 'Manajer', 'Tidak'),
('P004', 'Lina Marlina', '3201041234560004', 'Perempuan', 'Yogyakarta', '081312345678', 'lina.marlina@email.com', 'Resepsionis', 'Ya'),
('P005', 'Fajar Pratama', '3201051234560005', 'Laki-laki', 'Medan', '081365432100', 'fajar.pratama@email.com', 'Teknisi', 'Tidak'),
('P006', 'Sinta Dewi', '3201061234560006', 'Perempuan', 'Semarang', '081278945612', 'sinta.dewi@email.com', 'Housekeeper', 'Ya'),
('P008', 'Tika Wulandari', '3201081234560008', 'Perempuan', 'Bali', '081288776655', 'tika.wulandari@email.com', 'Resepsionis', 'Ya');

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `id_reservasi` int(11) NOT NULL,
  `nomor_kamar` varchar(50) DEFAULT NULL,
  `id_tamu` int(11) DEFAULT NULL,
  `tanggal_check_in` date DEFAULT NULL,
  `tanggal_check_out` date DEFAULT NULL,
  `status_reservasi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`id_reservasi`, `nomor_kamar`, `id_tamu`, `tanggal_check_in`, `tanggal_check_out`, `status_reservasi`) VALUES
(4, 'A101', 1111, '2025-06-20', '2025-06-23', 'Reserved'),
(6, 'A102', 1113, '2025-06-22', '2025-06-23', 'Reserved'),
(7, 'A103', 1114, '2025-06-29', '2025-06-30', 'Reserved'),
(8, 'B201', 1115, '2025-06-27', '2025-06-30', 'Reserved');

-- --------------------------------------------------------

--
-- Table structure for table `tamu`
--

CREATE TABLE `tamu` (
  `id_tamu` int(11) NOT NULL,
  `nama_tamu` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `no_tlp` varchar(20) DEFAULT NULL,
  `alamat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tamu`
--

INSERT INTO `tamu` (`id_tamu`, `nama_tamu`, `email`, `no_tlp`, `alamat`) VALUES
(1111, 'Farhan', 'anom@gmail.com', '0865654433', 'Langsung'),
(1113, 'Udin', 'madin@gmail.com', '0865654411', 'Tidak Langsung'),
(1114, 'Patapim', 'tung@gmail.com', '08777333444', 'JL. BallerinaCapuccina'),
(1115, 'Bombardilo', 'bomb@gmail.com', '0855665456', 'JL. TungTungTung');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_reservasi` int(11) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `pembayaran` varchar(50) DEFAULT NULL,
  `tanggal_transaksi` date DEFAULT NULL,
  `status_transaksi` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `usersistem`
--

CREATE TABLE `usersistem` (
  `id_user` int(11) NOT NULL,
  `id_pegawai` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `nama_pegawai` varchar(100) DEFAULT NULL,
  `akses` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `usersistem`
--

INSERT INTO `usersistem` (`id_user`, `id_pegawai`, `username`, `password`, `nama_pegawai`, `akses`) VALUES
(3, 'P001', 'ilhamsholahuddin', 'd8ecb253d1e2d74814d0d142e3af4de190b1e3d56dc7346ab85314e079f66408', 'Ilham Sholahuddin', 'Manager'),
(5, 'P000', 'testing', 'b822f1cd2dcfc685b47e83e3980289fd5d8e3ff3a82def24d7d1d68bb272eb32', 'UnitTest', 'Manager');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`nomor_kamar`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`id_reservasi`),
  ADD KEY `nomor_kamar` (`nomor_kamar`),
  ADD KEY `id_tamu` (`id_tamu`);

--
-- Indexes for table `tamu`
--
ALTER TABLE `tamu`
  ADD PRIMARY KEY (`id_tamu`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_reservasi` (`id_reservasi`);

--
-- Indexes for table `usersistem`
--
ALTER TABLE `usersistem`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `id_reservasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tamu`
--
ALTER TABLE `tamu`
  MODIFY `id_tamu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1116;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `usersistem`
--
ALTER TABLE `usersistem`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD CONSTRAINT `reservasi_ibfk_1` FOREIGN KEY (`nomor_kamar`) REFERENCES `kamar` (`nomor_kamar`),
  ADD CONSTRAINT `reservasi_ibfk_2` FOREIGN KEY (`id_tamu`) REFERENCES `tamu` (`id_tamu`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_reservasi`) REFERENCES `reservasi` (`id_reservasi`);

--
-- Constraints for table `usersistem`
--
ALTER TABLE `usersistem`
  ADD CONSTRAINT `usersistem_ibfk_1` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
