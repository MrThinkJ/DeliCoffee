-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: delicoffee
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `username` text,
  `password` text,
  `role` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'thinh','123','manager'),(2,'staff','staff','staff'),(3,'manager','manager','manager'),(4,'admin','admin','admin');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chi_nhanh`
--

DROP TABLE IF EXISTS `chi_nhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chi_nhanh` (
  `maChiNhanh` int NOT NULL AUTO_INCREMENT,
  `tenChiNhanh` text,
  `maChucVu` int DEFAULT NULL,
  `ngayBatDau` date DEFAULT NULL,
  `maNhanVien` int DEFAULT NULL,
  `doanhThu` int DEFAULT NULL,
  `ngayTongKet` date DEFAULT NULL,
  PRIMARY KEY (`maChiNhanh`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chi_nhanh`
--

LOCK TABLES `chi_nhanh` WRITE;
/*!40000 ALTER TABLE `chi_nhanh` DISABLE KEYS */;
INSERT INTO `chi_nhanh` VALUES (1,NULL,NULL,NULL,NULL,900000,'2022-12-12'),(2,NULL,NULL,NULL,NULL,1520000,'2023-01-10'),(3,NULL,NULL,NULL,NULL,5843369,'2023-01-10'),(4,NULL,NULL,NULL,NULL,900000,'2022-12-12'),(5,NULL,NULL,NULL,NULL,2126738,'2023-01-08');
/*!40000 ALTER TABLE `chi_nhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drink`
--

DROP TABLE IF EXISTS `drink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drink` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `price` int DEFAULT NULL,
  `name` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drink`
--

LOCK TABLES `drink` WRITE;
/*!40000 ALTER TABLE `drink` DISABLE KEYS */;
INSERT INTO `drink` VALUES (1,1123,'Nước Xoi'),(2,40000,'Nước Cam'),(3,40000,'Bạc Xỉu'),(4,1400000,'Chivas 18');
/*!40000 ALTER TABLE `drink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_vien`
--

DROP TABLE IF EXISTS `nhan_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_vien` (
  `maNhanVien` int NOT NULL AUTO_INCREMENT,
  `hoVaTen` text,
  `ngaySinh` date DEFAULT NULL,
  `soDienThoai` text,
  `diaChi` text,
  `gioiTinh` tinyint(1) DEFAULT NULL,
  `chucVu` text,
  `tienLuong` text,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_vien`
--

LOCK TABLES `nhan_vien` WRITE;
/*!40000 ALTER TABLE `nhan_vien` DISABLE KEYS */;
INSERT INTO `nhan_vien` VALUES (3,'Thinh','2023-01-06','99999','Da Nang',0,'adjwi','9999'),(4,'Duong','2023-01-06','123421','Hai chau',1,'1wedsa','null');
/*!40000 ALTER TABLE `nhan_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdrink`
--

DROP TABLE IF EXISTS `orderdrink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdrink` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `drinkId` int DEFAULT NULL,
  `tableId` int DEFAULT '0',
  PRIMARY KEY (`ID`),
  KEY `drinkId` (`drinkId`),
  KEY `tableId` (`tableId`),
  CONSTRAINT `orderdrink_ibfk_1` FOREIGN KEY (`drinkId`) REFERENCES `drink` (`ID`),
  CONSTRAINT `orderdrink_ibfk_2` FOREIGN KEY (`tableId`) REFERENCES `t_table` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdrink`
--

LOCK TABLES `orderdrink` WRITE;
/*!40000 ALTER TABLE `orderdrink` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdrink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlog`
--

DROP TABLE IF EXISTS `orderlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlog` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `drinkId` int DEFAULT NULL,
  `drinkQuantity` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `drinkId` (`drinkId`),
  CONSTRAINT `orderlog_ibfk_1` FOREIGN KEY (`drinkId`) REFERENCES `drink` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlog`
--

LOCK TABLES `orderlog` WRITE;
/*!40000 ALTER TABLE `orderlog` DISABLE KEYS */;
INSERT INTO `orderlog` VALUES (3,'2023-01-05 00:00:00',1,1),(4,'2023-01-05 00:00:00',1,1),(5,'2023-01-05 00:00:00',2,3),(6,'2023-01-07 00:00:00',1,1),(7,'2023-01-07 00:00:00',1,1),(8,'2023-01-07 00:00:00',1,1),(9,'2023-01-07 00:00:00',1,2),(10,'2023-01-07 00:00:00',1,1),(11,'2023-01-07 00:00:00',2,2),(13,'2023-01-07 00:00:00',1,1),(14,'2023-01-07 00:00:00',2,1),(16,'2023-01-07 00:00:00',1,1),(17,'2023-01-07 00:00:00',1,1),(19,'2023-01-08 00:00:00',1,1),(20,'2023-01-08 00:00:00',2,3),(22,'2023-01-08 00:00:00',1,3),(23,'2023-01-08 00:00:00',3,3),(25,'2023-01-08 00:00:00',2,2),(26,'2023-01-08 00:00:00',1,1),(27,'2023-01-08 00:00:00',3,2),(29,'2023-01-08 00:00:00',3,1),(30,'2023-01-08 00:00:00',2,1),(32,'2023-01-08 00:00:00',2,2),(33,'2023-01-08 00:00:00',1,1),(34,'2023-01-08 00:00:00',2,2),(35,'2023-01-08 00:00:00',2,2),(36,'2023-01-08 00:00:00',4,1),(37,'2023-01-10 00:00:00',2,3),(38,'2023-01-10 00:00:00',4,1),(40,'2023-01-10 00:00:00',1,3),(41,'2023-01-10 00:00:00',2,3),(43,'2023-01-10 00:00:00',4,3),(44,'2023-01-10 00:00:00',4,3),(45,'2023-01-10 00:00:00',3,3),(47,'2023-01-11 00:00:00',3,3);
/*!40000 ALTER TABLE `orderlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_table`
--

DROP TABLE IF EXISTS `t_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_table` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_table`
--

LOCK TABLES `t_table` WRITE;
/*!40000 ALTER TABLE `t_table` DISABLE KEYS */;
INSERT INTO `t_table` VALUES (0,0),(1,0),(2,0),(3,0),(4,0),(5,0),(6,0);
/*!40000 ALTER TABLE `t_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-21 20:10:07
