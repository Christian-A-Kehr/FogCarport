CREATE DATABASE  IF NOT EXISTS `Fog` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `Fog`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 174.138.1.102    Database: Fog
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Customers`
--

DROP TABLE IF EXISTS `Customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Customers` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `E-mail` varchar(45) DEFAULT NULL,
  `Adress` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customers`
--

LOCK TABLES `Customers` WRITE;
/*!40000 ALTER TABLE `Customers` DISABLE KEYS */;
INSERT INTO `Customers` VALUES (1,'Chris','Chris@Chris.com','LangpokkerIvold');
/*!40000 ALTER TABLE `Customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Delivery`
--

DROP TABLE IF EXISTS `Delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Delivery` (
  `Delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `Delivery_Location` varchar(100) NOT NULL,
  `Delivery_Price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Delivery_id`),
  UNIQUE KEY `Delivery_Location_UNIQUE` (`Delivery_Location`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Delivery`
--

LOCK TABLES `Delivery` WRITE;
/*!40000 ALTER TABLE `Delivery` DISABLE KEYS */;
INSERT INTO `Delivery` VALUES (1,'Sjælland',0),(2,'Fyn',1475),(3,'Jylland',1875),(4,'Andet',5000);
/*!40000 ALTER TABLE `Delivery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Materials`
--

DROP TABLE IF EXISTS `Materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Materials` (
  `Material_Name` varchar(200) DEFAULT '-',
  `Vare_nummer` int(20) NOT NULL AUTO_INCREMENT,
  `Help_Description` varchar(200) DEFAULT '-',
  `Length` int(11) DEFAULT '0',
  `Height` int(11) DEFAULT '0',
  `Width` int(11) DEFAULT '0',
  `Price` double DEFAULT '0',
  `Material` varchar(45) DEFAULT '-',
  `Type` varchar(45) DEFAULT '-',
  PRIMARY KEY (`Vare_nummer`),
  UNIQUE KEY `Vare_nummer_UNIQUE` (`Vare_nummer`)
) ENGINE=InnoDB AUTO_INCREMENT=517 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Materials`
--

LOCK TABLES `Materials` WRITE;
/*!40000 ALTER TABLE `Materials` DISABLE KEYS */;
INSERT INTO `Materials` VALUES ('theTest',1,'-',0,0,0,0,'-','9'),('1',2,'3',4,5,6,7,'8','9'),('Tagsten i stålprofil',3,'Fra 15° til 30° -> 350mm | Fra 30° til 45° -> 700 mm',1880,0,1100,154.6,'Stål','Tagbeklædning'),('RØDE VINGETAGSTEN',4,'Lægteafstand: 325-331 mm.',404,0,236,200,'Tegl','Tagbeklædning'),('Benders palema sort',5,'lægteafstand på 375 mm.',420,0,330,39.87,'Beton','Tagbeklædning'),('Stolpe træ',6,'-',1000,150,150,50,'Trykimprægneret','Stolpe'),('Stolpe stål',7,'-',2100,0,150,100,'Stål','Stolpe'),('Spær i bjælkespær C18 ',8,'Skæres selv på mål',6000,100,45,67,'Bjælkespær','Spær'),('Spær C18',9,'Skæres selv på mål',4000,100,45,47,'Spærtræ','Spær'),('Træ behandlet',10,'skæres på mål',1000,0,100,40,'Trykimprægneret ','Beklædning'),('Træ udbehandlet',11,'skæres på mål',1000,0,100,50,'Trykimprægneret ','Beklædning'),('IBF Havefliser ',12,'Grå 40x40x5 cm',400,50,400,92.5,'Beton','Gulv'),('IBF Flise',13,'-',250,50,250,80,'Beton','Gulv'),('Spærtræ rem',14,'Rem, Kan bruges ved rejsning',1000,45,195,80,'Spærtræ','Rem'),('Egetræ rem',15,'Rem anbefaldes til tung belastning',1000,45,195,100,'Eg','Rem'),('Trapezplade',16,'PLASTMO Handy-Lite klar',1200,0,800,19.95,'Trapezplade ','Tagbeklædning'),('Ydre tagBeklædning',17,'Standart ydre tagbeklædning for alle tag',6000,150,45,30,'Trykimprægneret','Ydretagbeklædning'),('Lægte Spærtræ',18,'Behandlet',6000,100,100,20,'Spærtræ','Lægte');
/*!40000 ALTER TABLE `Materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MaterialsTest`
--

DROP TABLE IF EXISTS `MaterialsTest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `MaterialsTest` (
  `Material_Name` varchar(200) DEFAULT '-',
  `Vare_nummer` int(20) NOT NULL AUTO_INCREMENT,
  `Help_Description` varchar(200) DEFAULT '-',
  `Length` int(11) DEFAULT '0',
  `Height` int(11) DEFAULT '0',
  `Width` int(11) DEFAULT '0',
  `Price` double DEFAULT '0',
  `Material` varchar(45) DEFAULT '-',
  `Type` varchar(45) DEFAULT '-',
  PRIMARY KEY (`Vare_nummer`),
  UNIQUE KEY `Vare_nummer_UNIQUE` (`Vare_nummer`)
) ENGINE=InnoDB AUTO_INCREMENT=508 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MaterialsTest`
--

LOCK TABLES `MaterialsTest` WRITE;
/*!40000 ALTER TABLE `MaterialsTest` DISABLE KEYS */;
INSERT INTO `MaterialsTest` VALUES ('Woodpost',500,'Test',2100,10,100,100,'Trykimprægneret ','Stolpe'),('Væg beklædning',501,'Test',1000,0,100,10,'Trykimprægneret ','Beklædning'),('IBF Flise',502,'Test',1000,50,1000,25,'Beton','Gulv'),('Spærtræ rem',503,'Test',0,45,195,80,'Spærtræ','Rem'),('Spær C18',504,'Test',4000,100,45,47,'Spærtræ','Spær'),('Stolpe',505,'-',2100,0,250,100,'Stål','Stolpe'),('Lægte Spærtræ',506,'Bhandlet',6000,100,100,20,'Spærtræ','Lægte'),('Trapezplade',507,'PLASTMO Handy-Lite klar',1200,0,800,19.95,'Trapezplade ','Tagbeklædning');
/*!40000 ALTER TABLE `MaterialsTest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Package`
--

DROP TABLE IF EXISTS `Package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Package` (
  `Package_number` int(11) DEFAULT NULL,
  `Package_Name` varchar(45) DEFAULT NULL,
  `Package_Price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Package`
--

LOCK TABLES `Package` WRITE;
/*!40000 ALTER TABLE `Package` DISABLE KEYS */;
INSERT INTO `Package` VALUES (1,'package1',500),(2,'package2',1000),(3,'package3',1500);
/*!40000 ALTER TABLE `Package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Roofs`
--

DROP TABLE IF EXISTS `Roofs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Roofs` (
  `Roof_id` int(11) NOT NULL AUTO_INCREMENT,
  `Roof_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Roof_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Roofs`
--

LOCK TABLES `Roofs` WRITE;
/*!40000 ALTER TABLE `Roofs` DISABLE KEYS */;
INSERT INTO `Roofs` VALUES (1,'Fladt tag'),(2,'Tag med Rejsning');
/*!40000 ALTER TABLE `Roofs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Variabler`
--

DROP TABLE IF EXISTS `Variabler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Variabler` (
  `idVariabler` int(11) NOT NULL AUTO_INCREMENT,
  `Varibable_name` varchar(100) DEFAULT 'Ikke navngivet',
  `Measurements` int(20) DEFAULT '0',
  PRIMARY KEY (`idVariabler`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Variabler`
--

LOCK TABLES `Variabler` WRITE;
/*!40000 ALTER TABLE `Variabler` DISABLE KEYS */;
INSERT INTO `Variabler` VALUES (1,'Udhæng_max',150),(2,'Lægte_max',4000),(3,'afstand mellem spær ved bjælkeafstand på 4000 mm ',600),(4,'Tykkelse på spær ved spærafstand på 600 ',195),(5,'Bræde afstand med 2,5 mm overlap',150),(6,'StopeBrede',150),(7,'Udhæng_max2',150);
/*!40000 ALTER TABLE `Variabler` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-28  9:06:31
