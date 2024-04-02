package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import dao.PreguntaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Pregunta;
import util.ConexionJdbc;

@WebServlet("/preguntas/*")
public class PreguntaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PreguntaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Configurar encabezados CORS para permitir solicitudes desde cualquier origen
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");

        // Configurar el tipo de contenido de la respuesta
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Connection conexion = null;
        try {
            conexion = ConexionJdbc.obtenerConexion();

            String pathInfo = request.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("No se ha especificado ningún tipo de pregunta.");
                return;
            }

            String tipoPregunta = pathInfo.substring(1); // Elimina el primer '/' del pathInfo
            System.out.println("Tipo pregunta -----> " + tipoPregunta);

            // Crear el objeto PreguntaDAO y obtener las preguntas
            PreguntaDAO preguntaDao = new PreguntaDAO(conexion);
            List<Pregunta> listaPreguntas = preguntaDao.getNQuestionsByCategory(tipoPregunta, 20);

            // Convertir la lista de preguntas a JSON y enviarla como respuesta
            String json = new Gson().toJson(listaPreguntas);
            response.getWriter().write(json);
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Cantidad de preguntas no válida.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error al conectar con la base de datos");
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Reenviar la solicitud POST como una solicitud GET al método doGet
        doGet(request, response);
    }
}
