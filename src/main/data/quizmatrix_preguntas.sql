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
-- Table structure for table `preguntas`
--

DROP TABLE IF EXISTS `preguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preguntas` (
  `idPregunta` int NOT NULL AUTO_INCREMENT,
  `clasePregunta` varchar(15) NOT NULL,
  `cuerpoPregunta` varchar(200) NOT NULL,
  PRIMARY KEY (`idPregunta`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preguntas`
--

LOCK TABLES `preguntas` WRITE;
/*!40000 ALTER TABLE `preguntas` DISABLE KEYS */;
INSERT INTO `preguntas` VALUES (1,'css','¿Cuál es la versión de CSS que se usa hoy en día?'),(2,'css','¿Qué propiedad CSS se utiliza para cambiar el color de fondo de un elemento?'),(3,'css','¿Qué propiedad CSS se usa para cambiar el color del texto de un elemento?'),(4,'css','¿Cómo se aplica un estilo a un elemento HTML específico usando su ID?'),(5,'css','¿Cuál de las siguientes propiedades NO es una propiedad de flexbox?'),(6,'css','¿Qué función CSS se utiliza para hacer referencia a imágenes como fondo?'),(7,'css','¿Cómo se seleccionan todos los elementos <p> que son directamente hijos de un div?'),(8,'css','¿Cuál es el valor por defecto de la propiedad position?'),(9,'css','¿Qué propiedad se utiliza para establecer el espaciado entre los caracteres de un texto?'),(10,'css','¿Cuál propiedad CSS se utiliza para hacer que los elementos floten y se alineen a un lado?'),(11,'css','¿Qué selector se usa para definir un estilo sobre un elemento HTML cuando está siendo apuntado por el mouse?'),(12,'css','¿Cuál de estas NO es una unidad de medida en CSS?'),(13,'css','¿Qué propiedad CSS se utiliza para crear una sombra alrededor de un elemento?'),(14,'css','¿Cómo se agrega un comentario en un archivo CSS?'),(15,'css','¿Qué propiedad se usa para cambiar la fuente de un texto?'),(16,'css','¿Qué valor de la propiedad display hace que el elemento se comporte como un bloque en línea?'),(17,'css','¿Cuál de las siguientes propiedades se utiliza para establecer la opacidad de un elemento?'),(18,'css','¿Qué propiedad se utiliza para cambiar el estilo del cursor del mouse?'),(19,'css','¿Qué propiedad CSS se utiliza para poner en mayúsculas el texto?'),(20,'css','¿Cuál propiedad CSS elimina el espacio entre los bordes de dos elementos adyacentes?'),(21,'html','¿Qué lenguaje de programación consideras HTML?'),(22,'html','¿Qué etiqueta HTML se utiliza para definir un párrafo?'),(23,'html','¿Cuál es la función de la etiqueta <a> en HTML?'),(24,'html','¿Qué atributo de la etiqueta <img> especifica la URL de la imagen?'),(25,'html','¿Cómo se comenta el código en HTML?'),(26,'html','¿Qué etiqueta HTML se utiliza para definir un encabezado de nivel 1?'),(27,'html','¿Cuál de estas etiquetas HTML se usa para definir una lista ordenada?'),(28,'html','¿Qué atributo se utiliza para abrir un enlace en una nueva pestaña/ventana?'),(29,'html','¿Qué etiqueta se utiliza para insertar un archivo de JavaScript en HTML?'),(30,'html','¿Cuál de estas etiquetas define el cuerpo de un documento HTML?'),(31,'html','¿Qué atributo de la etiqueta <form> especifica el método de envío de datos?'),(32,'html','¿Cómo se especifica un enlace a un archivo de estilo CSS en HTML?'),(33,'html','¿Qué etiqueta HTML se utiliza para definir una imagen?'),(34,'html','¿Cuál es la etiqueta correcta para crear un salto de línea en HTML?'),(35,'html','¿Qué etiqueta HTML se utiliza para crear una tabla?'),(36,'html','¿Cuál de estas opciones NO es un tipo de lista en HTML?'),(37,'html','¿Qué atributo de la etiqueta <input> define el tipo de control a mostrar?'),(38,'html','¿Qué etiqueta HTML se utiliza para definir un título importante o un tema de la página?'),(39,'httml','¿Cómo se define un fragmento de código en HTML que debe ser interpretado como código de computadora?'),(40,'html','¿Qué etiqueta se utiliza para agregar un pie de página a un documento o sección?');
/*!40000 ALTER TABLE `preguntas` ENABLE KEYS */;
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
