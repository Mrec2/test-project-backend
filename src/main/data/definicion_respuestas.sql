CREATE TABLE `respuestas` (
  `idRespuesta` int NOT NULL AUTO_INCREMENT,
  `idPregunta` int DEFAULT NULL,
  `cuerpoRespuesta` varchar(250) DEFAULT NULL,
  `correcta` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idRespuesta`),
  KEY `idPregunta` (`idPregunta`),
  CONSTRAINT `respuestas_ibfk_1` FOREIGN KEY (`idPregunta`) REFERENCES `preguntas` (`idPregunta`) ON DELETE CASCADE
)