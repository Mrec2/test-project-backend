-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: quizmatrix
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
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `respuestas` (
  `idRespuesta` int NOT NULL AUTO_INCREMENT,
  `idPregunta` int NOT NULL,
  `cuerpoRespuesta` varchar(100) NOT NULL,
  `correcta` tinyint NOT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `idPregunta_idx` (`idPregunta`),
  CONSTRAINT `idPregunta` FOREIGN KEY (`idPregunta`) REFERENCES `preguntas` (`idPregunta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
INSERT INTO `respuestas` VALUES (1,1,'Default',0),(2,1,'10.0',0),(3,1,'CSS3',1),(4,1,'Legacy version',0),(5,2,'background-color',1),(6,2,'color',0),(7,2,'bgcolor',0),(8,2,'background-image',0),(9,3,'text-color',0),(10,3,'color',1),(11,3,'font-color',0),(12,3,'text-style',0),(13,4,'Con un . antes del nombre del ID',0),(14,4,'Con un # antes del nombre del ID',1),(15,4,'Con un $ antes del nombre del ID',0),(16,4,'Directamente el nombre del ID',0),(17,5,'flex-direction',0),(18,5,'align-items',0),(19,5,'justify-content',0),(20,5,'float',1),(21,6,'url()',1),(22,6,'src()',0),(23,6,'href()',0),(24,6,'link()',0),(25,7,'div p',0),(26,7,'div > p',1),(27,7,'div + p',0),(28,7,'p > div',0),(29,8,'relative',0),(30,8,'fixed',0),(31,8,'absolute',0),(32,8,'static',1),(33,9,'letter-spacing',1),(34,9,'text-spacing',0),(35,9,'character-spacing',0),(36,9,'spacing',0),(37,10,'margin',0),(38,10,'align',0),(39,10,'float',1),(40,10,'clear',0),(41,11,':hover',1),(42,11,':active',0),(43,11,':focus',0),(44,11,':visited',0),(45,12,'pixels',0),(46,12,'centimeters',0),(47,12,'liters',1),(48,12,'em',0),(49,13,'box-shadow',1),(50,13,'text-shadow',0),(51,13,'border-shadow',0),(52,13,'shadow',0),(53,14,'<!-- comentario -->',0),(54,14,'/* comentario */',1),(55,14,'// comentario',0),(56,14,'\" comentario \"',0),(57,15,'font-style',0),(58,15,'text-font',0),(59,15,'font-family',1),(60,15,'font-weight',0),(61,16,'block',0),(62,16,'inline',0),(63,16,'inline-block',1),(64,16,'none',0),(65,17,'opacity',1),(66,17,'visibility',0),(67,17,'alpha',0),(68,17,'transparent',0),(69,18,'cursor-style',0),(70,18,'pointer',0),(71,18,'cursor',1),(72,18,'mouse-style',0),(73,19,'text-transform',1),(74,19,'text-decoration',0),(75,19,'font-style',0),(76,19,'text-uppercase',0),(77,20,'margin-collapse',0),(78,20,'border-collapse',1),(79,20,'padding-collapse',0),(80,20,'collapse',0),(81,21,'Marcado',0),(82,21,'De inglés',0),(83,21,'Alto nivel',0),(84,21,'No es un lenguaje de programación',1),(85,22,'<p>',1),(86,22,'<h1>',0),(87,22,'<body>',0),(88,22,'<title>',0),(89,23,'Insertar imágenes',0),(90,23,'Crear enlaces',1),(91,23,'Formatear texto',0),(92,23,'Definir encabezados',0),(93,24,'src',1),(94,24,'href',0),(95,24,'alt',0),(96,24,'link',0),(97,25,'<!-- comentario -->',1),(98,25,'// comentario',0),(99,25,'/* comentario */',0),(100,25,'# comentario',0),(101,26,'<h1>',1),(102,26,'<header>',0),(103,26,'<head>',0),(104,26,'<h6>',0),(105,27,'<ul>',0),(106,27,'<ol>',1),(107,27,'<li>',0),(108,27,'<dl>',0),(109,28,'newtab',0),(110,28,'target=\"_blank\"',1),(111,28,'open',0),(112,28,'hrefnew',0),(113,29,'<js>',0),(114,29,'<script>',1),(115,29,'<javascript>',0),(116,29,'<link>',0),(117,30,'<body>',1),(118,30,'<main>',0),(119,30,'<div>',0),(120,30,'<section>',0),(121,31,'method',1),(122,31,'type',0),(123,31,'action',0),(124,31,'enctype',0),(125,32,'<link rel=\"stylesheet\" type=\"text/css\" href=\"estilo.css\">',1),(126,32,'<css src=\"estilo.css\">',0),(127,32,'<style src=\"estilo.css\"',0),(128,32,'<stylesheet>estilo.css</stylesheet>',0),(129,33,'<img>',1),(130,33,'<image>',0),(131,33,'<pic>',0),(132,33,'<picture>',0),(133,34,'<lb>',0),(134,34,'<break>',0),(135,34,'<br>',1),(136,34,'<linebreak>',0),(137,35,'<table>',1),(138,35,'<tab>',0),(139,35,'<tl>',0),(140,35,'<tb>',0),(141,36,'Lista desordenada',0),(142,36,'Lista ordenada',0),(143,36,'Lista de definiciones\"',0),(144,36,'Lista de tablas',1),(145,37,'formtype',0),(146,37,'type',1),(147,37,'inputtype',0),(148,37,'controltype',0),(149,38,'<title>',1),(150,38,'<meta>',0),(151,38,'<head>',0),(152,38,'<header>',0),(153,39,'<code>',1),(154,39,'<pre>',0),(155,39,'<block>',0),(156,39,'<coding>',0),(157,40,'<footer>',1),(158,40,'<bottom>',0),(159,40,'<foot>',0),(160,40,'<end>\"',0);
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-01 18:03:42
