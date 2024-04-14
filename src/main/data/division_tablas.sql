DELIMITER //

DROP PROCEDURE IF EXISTS PREGUNTAS_TO_PREGUNTAS_RESPUESTAS;
CREATE PROCEDURE PREGUNTAS_TO_PREGUNTAS_RESPUESTAS()
BEGIN

    DECLARE done INT DEFAULT FALSE;
    
    DECLARE id INT;
    DECLARE categoria VARCHAR(255);
    DECLARE pregunta VARCHAR(255);
	DECLARE opcion1 VARCHAR(255);
    DECLARE opcion2 VARCHAR(255);
    DECLARE opcion3 VARCHAR(255);
    DECLARE opcion4 VARCHAR(255);
    DECLARE respuesta_correcta VARCHAR(255);    
    DECLARE isCorrecta BOOLEAN DEFAULT FALSE;
    
    
    -- Declarar un cursor para recorrer la tabla
    DECLARE cur CURSOR FOR SELECT * FROM preguntas_a; -- OJO! CAMBIAR A LA TABLA ANTIGUA QUE CONTIENE LAS PREGUNTAS JUNTO CON LAS RESPUESTAS (DEFINIDA POR MARIO COMO QUIZMATRIX.PREGUNTAS)
    
    -- Declarar que queremos manejar errores
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Abrir el cursor
    OPEN cur;

    -- Iniciar el bucle de lectura e insercion
    read_loop: LOOP
        -- Obtener los valores de la fila actual
        FETCH cur INTO id, categoria, pregunta, opcion1, opcion2, opcion3, opcion4, respuesta_correcta;
        
        -- Si la pregunta no existe todavia en tabla preguntas, insertarla
        IF (select COUNT(*) FROM preguntas WHERE cuerpoPregunta = pregunta) = 0 THEN
			
            INSERT INTO preguntas (clasePregunta, cuerpoPregunta) VALUES (categoria, pregunta);
            
		END IF;
        
        
		SELECT @idP := idPregunta FROM preguntas WHERE cuerpoPregunta = pregunta LIMIT 1;
		
        -- Insercion de respuestas por pregunta
		SET isCorrecta = (opcion1=respuesta_correcta);
		insert into respuestas (idPregunta, cuerpoRespuesta, correcta) VALUES (@idP, opcion1, isCorrecta);
		SET isCorrecta = (opcion2=respuesta_correcta);
		insert into respuestas (idPregunta, cuerpoRespuesta, correcta) VALUES (@idP, opcion2, isCorrecta);
		SET isCorrecta = (opcion3=respuesta_correcta);
		insert into respuestas (idPregunta, cuerpoRespuesta, correcta) VALUES (@idP, opcion3, isCorrecta);
		SET isCorrecta = (opcion4=respuesta_correcta);
		insert into respuestas (idPregunta, cuerpoRespuesta, correcta) VALUES (@idP, opcion4, isCorrecta);
        
        
        -- Si no hay más filas, salir del bucle
        IF done THEN
            LEAVE read_loop;
        END IF;
        

    END LOOP;

    -- Cerrar el cursor
    CLOSE cur;
    
END//