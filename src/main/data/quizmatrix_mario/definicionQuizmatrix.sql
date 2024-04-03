CREATE TABLE preguntas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    categoria VARCHAR(255) NOT NULL,
    pregunta TEXT NOT NULL,
    opcion1 VARCHAR(255) NOT NULL,
    opcion2 VARCHAR(255) NOT NULL,
    opcion3 VARCHAR(255) NOT NULL,
    opcion4 VARCHAR(255) NOT NULL,
    respuesta_correcta VARCHAR(255) NOT NULL
);
