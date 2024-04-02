package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Pregunta;

public class PreguntaDAO {

    private Connection connection;

    // Constructor que recibe la conexión a la base de datos
    public PreguntaDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener un número específico de preguntas de una categoría determinada de forma aleatoria
    public List<Pregunta> getNQuestionsByCategory(String categoria, int limit) throws SQLException {
        List<Pregunta> preguntas = new ArrayList<>();
        // Se añade ORDER BY RAND() para obtener resultados aleatorios
        final String sql = "SELECT * FROM preguntas WHERE categoria = ? ORDER BY RAND() LIMIT ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoria);
            statement.setInt(2, limit);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String preguntaText = resultSet.getString("pregunta");
                    List<String> opciones = Arrays.asList(
                            resultSet.getString("opcion1"),
                            resultSet.getString("opcion2"),
                            resultSet.getString("opcion3"),
                            resultSet.getString("opcion4"));
                    String respuestaCorrecta = resultSet.getString("respuesta_correcta");
                    Pregunta pregunta = new Pregunta(preguntaText, opciones, respuestaCorrecta);
                    preguntas.add(pregunta);
                }
            }
        }
        return preguntas;
    }
}
