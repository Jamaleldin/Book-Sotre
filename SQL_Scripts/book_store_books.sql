-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book_store
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `ISBN` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publication_year` year(4) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `no_copies` int(11) DEFAULT NULL,
  `threshold_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`ISBN`),
  KEY `books_pub_fk_idx` (`publisher`),
  KEY `books_cat_fk_idx` (`category`),
  CONSTRAINT `books_cat_fk` FOREIGN KEY (`category`) REFERENCES `books_categories` (`category`),
  CONSTRAINT `books_pub_fk` FOREIGN KEY (`publisher`) REFERENCES `publisher` (`publisher_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'aaa','pub1',2000,57.00,'Art',50,20),(2,'bbb','pub1',2000,60.00,'Religion',20,5),(3,'ccc','pub2',1950,15.00,'Science',150,80),(4,'ddd','pub2',2005,100.00,'Religion',200,20),(5,'eee','pub3',1940,3000.00,'History',55,40),(6,'fff','pub3',1901,2000.00,'Art',22,10),(7,'aaa','pub2',2000,57.00,'Art',5,3);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-09  4:14:51
