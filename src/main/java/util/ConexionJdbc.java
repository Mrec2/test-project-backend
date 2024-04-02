package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJdbc {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/quizmatrix";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // Ajusta esto según tu gestor de base de datos

    static {
        try {
            // Cargar el driver JDBC
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Manejo del error en caso de que el driver no esté disponible
        }
    }

    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
    	System.out.println("Entra en obtenerConexion");
    	System.out.println(URL);
    	System.out.println(USER);
    	System.out.println(PASSWORD);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
