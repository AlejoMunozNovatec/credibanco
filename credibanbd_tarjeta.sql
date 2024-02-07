-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: credibanbd
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `tarjeta`
--

DROP TABLE IF EXISTS `tarjeta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjeta` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `activada` bit(1) NOT NULL,
  `bloqueada` bit(1) NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `fecha_vencimiento` datetime(6) DEFAULT NULL,
  `nombre_titular` varchar(255) DEFAULT NULL,
  `numero_tarjeta` varchar(255) DEFAULT NULL,
  `saldo` double NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjeta`
--

LOCK TABLES `tarjeta` WRITE;
/*!40000 ALTER TABLE `tarjeta` DISABLE KEYS */;
INSERT INTO `tarjeta` VALUES (1,_binary '',_binary '\0','2024-02-05 19:27:26.241000','2027-02-05 19:27:26.241000','Alejandro Muñoz','1234561234567890123456',0),(2,_binary '\0',_binary '\0','2024-02-05 19:39:31.869000','2027-02-05 19:39:31.869000','Alejandro Muñoz','1234561234567890123456',0),(3,_binary '\0',_binary '\0','2024-02-05 19:39:32.877000','2027-02-05 19:39:32.877000','Alejandro Muñoz','1234561234567890123456',0),(4,_binary '\0',_binary '\0','2024-02-05 19:39:34.137000','2027-02-05 19:39:34.137000','Alejandro Muñoz','1234561234567890123456',0),(5,_binary '\0',_binary '\0','2024-02-05 19:47:40.395000','2027-02-05 19:47:40.395000','Alejandro Muñoz','1234561234567890123456',0),(6,_binary '\0',_binary '\0','2024-02-05 19:53:02.550000','2027-02-05 19:53:02.550000','Alejandro Muñoz','1234561234567890123456',0),(7,_binary '\0',_binary '\0','2024-02-05 20:10:50.249000','2027-02-05 20:10:50.249000','Alejandro Muñoz','1234561234567890123456',0),(8,_binary '\0',_binary '\0','2024-02-05 20:30:27.876000','2027-02-05 20:30:27.876000','Alejandro Muñoz','1234561234567890123456',0);
/*!40000 ALTER TABLE `tarjeta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-05 20:42:05
