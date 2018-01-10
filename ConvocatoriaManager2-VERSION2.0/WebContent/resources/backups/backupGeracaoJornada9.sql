CREATE DATABASE  IF NOT EXISTS `geracao` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `geracao`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: geracao
-- ------------------------------------------------------
-- Server version	5.7.19-log

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

--
-- Table structure for table `calendar`
--

DROP TABLE IF EXISTS `calendar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendar` (
  `calendarId` int(11) NOT NULL AUTO_INCREMENT,
  `games` varchar(50) DEFAULT NULL,
  `result` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`calendarId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendar`
--

LOCK TABLES `calendar` WRITE;
/*!40000 ALTER TABLE `calendar` DISABLE KEYS */;
INSERT INTO `calendar` VALUES (1,'Geração Paramos - Lobão','25-1'),(2,'Fiães - Geração Paramos','5-6'),(3,'Geração Paramos - Anta','1-4'),(4,'Paços Brandão - Geração Paramos','4-3'),(5,'Geração Paramos - Marfoot ','0-4'),(6,'Geração Paramos - Lourosa ','1-5'),(7,'Espinho - Geração Paramos','2-3'),(8,'Lobão - Geração Paramos','1-10'),(9,'Geração Paramos - Fiães','6-0'),(10,'Anta - Geração Paramos','Por decorrer'),(11,'Paramos - Paços Brandão','Por decorrer'),(12,'Marfoot - Geração Paramos','Por decorrer'),(13,'Lourosa - Geração Paramos','Por decorrer'),(14,'Geração Paramos - Espinho','Por decorrer');
/*!40000 ALTER TABLE `calendar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convocatoria`
--

DROP TABLE IF EXISTS `convocatoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convocatoria` (
  `convId` int(11) NOT NULL AUTO_INCREMENT,
  `adversario` varchar(255) DEFAULT NULL,
  `jornada` int(11) NOT NULL,
  PRIMARY KEY (`convId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convocatoria`
--

LOCK TABLES `convocatoria` WRITE;
/*!40000 ALTER TABLE `convocatoria` DISABLE KEYS */;
INSERT INTO `convocatoria` VALUES (1,'Lobão',1),(2,'Fiães',2),(3,'Anta',3),(4,'Paços Brandão',4),(5,'Marfoot',5),(6,'Lourosa',6),(7,'Espinho',7),(8,'Lobão',8),(9,'Fiães',9);
/*!40000 ALTER TABLE `convocatoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `convocatoria_player`
--

DROP TABLE IF EXISTS `convocatoria_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convocatoria_player` (
  `convocado_convId` int(11) NOT NULL,
  `convocados_playerId` int(11) NOT NULL,
  KEY `FKbv2tt0cks47u5xo4ecur6ub4v` (`convocados_playerId`),
  KEY `FK18lsjv92ecy5lgbnk4h7k4hoy` (`convocado_convId`),
  CONSTRAINT `FK18lsjv92ecy5lgbnk4h7k4hoy` FOREIGN KEY (`convocado_convId`) REFERENCES `convocatoria` (`convId`),
  CONSTRAINT `FKbv2tt0cks47u5xo4ecur6ub4v` FOREIGN KEY (`convocados_playerId`) REFERENCES `player` (`playerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `convocatoria_player`
--

LOCK TABLES `convocatoria_player` WRITE;
/*!40000 ALTER TABLE `convocatoria_player` DISABLE KEYS */;
INSERT INTO `convocatoria_player` VALUES (1,1),(1,10),(1,5),(1,4),(1,6),(1,2),(1,7),(1,9),(1,8),(1,3),(1,12),(1,13),(2,1),(2,10),(2,2),(2,3),(2,4),(2,6),(2,5),(2,7),(2,9),(2,8),(2,16),(2,14),(3,1),(3,10),(3,5),(3,4),(3,6),(3,2),(3,7),(3,11),(3,3),(3,13),(3,15),(3,12),(4,1),(4,10),(4,5),(4,6),(4,2),(4,7),(4,3),(4,9),(4,8),(4,14),(4,12),(4,15),(5,1),(5,10),(5,2),(5,3),(5,5),(5,4),(5,7),(5,9),(5,12),(5,8),(5,13),(5,16),(6,1),(6,10),(6,2),(6,13),(6,6),(6,4),(6,5),(6,8),(6,7),(6,15),(6,3),(6,14),(7,1),(7,2),(7,3),(7,12),(7,5),(7,6),(7,4),(7,8),(7,11),(7,7),(7,9),(7,10),(8,1),(8,2),(8,3),(8,4),(8,6),(8,7),(8,5),(8,8),(8,9),(8,14),(8,11),(8,12),(9,1),(9,10),(9,2),(9,3),(9,4),(9,6),(9,5),(9,7),(9,8),(9,12),(9,9),(9,14);
/*!40000 ALTER TABLE `convocatoria_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `playerId` int(11) NOT NULL AUTO_INCREMENT,
  `fName` varchar(255) DEFAULT NULL,
  `lName` varchar(255) DEFAULT NULL,
  `notCalls` int(11) NOT NULL,
  `numOfCalls` int(11) NOT NULL,
  `ativo` bit(1) DEFAULT b'1',
  PRIMARY KEY (`playerId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'Simão','Sá',0,9,''),(2,'Eduardo','Castro',0,9,''),(3,'Gonçalo','Centeno',0,9,''),(4,'André','Simão',0,8,''),(5,'Tiago','Silva',0,9,''),(6,'Gabriel','Silva',0,8,''),(7,'Gustavo','Santos',0,9,''),(8,'Gabriel','Lopes',0,8,''),(9,'Francisco','Oliveira',0,7,''),(10,'Bernardo','Micheloni',0,8,''),(11,'Gustavo','Castro',1,3,''),(12,'Rodrigo','Ferreira',0,7,''),(13,'Wilson','Tiago',3,4,''),(14,'Eduardo','Campos',0,5,''),(15,'Gabriel','Meireles',3,3,''),(16,'André','Gil',4,2,''),(17,'Player','Teste',9,0,'\0');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,'C:/Users/kukud/Downloads/','123','admin');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-14 13:03:36
