-- MySQL dump 10.13  Distrib 5.7.14, for Win64 (x86_64)
--
-- Host: localhost    Database: geography
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP DATABASE IF EXISTS `geography`;
CREATE DATABASE `geography`;
USE `geography`;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `co_code` varchar(3) NOT NULL,
  `co_name` varchar(200) NOT NULL,
  `co_details` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`co_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('IRL','Republic of Ireland','Ireland also described as the Republic of Ireland (Poblacht na hÉireann), is a sovereign state in north-western Europe occupying 26 of 32 counties of the island of Ireland.'),('USA','United States of America','The United States of America , commonly known as the United States (U.S.) or America, is a constitutional federal republic composed of 50 states, a federal district, five major self-governing territories, and various possessions.'),('UK','United Kingdom','The United Kingdom of Great Britain and Northern Ireland, commonly known as the United Kingdom (UK) or Britain, is a sovereign country in western Europe.'),('FRA','France','France is a country in Western Europe with overseas regions and territories');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `co_code` varchar(3) NOT NULL,
  `reg_code` varchar(3) NOT NULL,
  `reg_name` varchar(200) NOT NULL,
  `reg_desc` varchar(400) NOT NULL,
  PRIMARY KEY (`co_code`,`reg_code`),
  FOREIGN KEY (`co_code`) REFERENCES `country`(`co_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES ('IRL','DUB','Co. Dublin','County Dublin is the most populous county in Ireland. It is divided into four administrative areas: Dublin city, Dun Laoghaire–Rathdown, Fingal and South Dublin.'),('IRL','GAL','Co. Galway','County Galway is a county in the West of Ireland. It is part of the province of Connacht. There are several Irish-speaking areas in the west of the county.'),('IRL','WMH','Co. Westmeath','County Westmeath is a county in the province of Leinster. It originally formed part of the historic Kingdom of Meath.'),('USA','NYK','New York','New York is a state in the northeastern United States. New York was one of the original thirteen colonies that formed the United States.'),('UK','LON','London','London is the capital and most populous city of England and the United Kingdom.Standing on the River Thames in the south east of the island of Great Britain, London has been a major settlement for two millennia.'),('UK','KNT','Kent','Kent is a county in South East England and one of the home counties. It borders Greater London to the north west, Surrey to the west and East Sussex to the south west.');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;


--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `cty_code` varchar(3) NOT NULL,
  `co_code` varchar(3) NOT NULL,
  `reg_code` varchar(3) NOT NULL,
  `cty_name` varchar(200) NOT NULL,
  `population` int(20) NOT NULL,
  `isCoastal` enum('true','false') DEFAULT NULL,
  `areaKM` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`cty_code`),
  FOREIGN KEY (`co_code`,`reg_code`) REFERENCES `region`(`co_code`,`reg_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('DUB','IRL','DUB','Dublin',553165,'true',114.99),('SWO','IRL','DUB','Swords',68683,'true',11.35),('GAL','IRL','GAL','Galway',79934,'true',53.35),('LOU','IRL','GAL','Loughrea',5057,'false',25.35),('GOR','IRL','GAL','Gort',2644,'false',19.91),('ATH','IRL','WMH','Athlone',21349,'false',30.00),('MUL','IRL','WMH','Mullingar',20928,'false',28.23),('NYK','USA','NYK','New York',8537673,'true',468.48),('ALB','USA','NYK','Albany',98469,'false',56.20),('GVL','USA','NYK','Greenville',3739,'false',39.10),('LON','UK','LON','London',8673713,'false',1572.00),('MAR','UK','KNT','Margate',61223,'true',23.40),('SAN','UK','KNT','Sandwich',4985,'false',13.00);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-15 10:00:26
