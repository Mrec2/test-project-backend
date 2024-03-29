package servlets;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaBeans.GestorPreguntasJava;
import javaBeans.PreguntaTest;


@WebServlet("/PreguntasJavaServlet")
public class PreguntasJavaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Entra en Get del Servlet Css");
		
		procesar(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Entra en Post del Servlet Css");
		
		procesar(request, response);
		
	}
	
	private void procesar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		
			GestorPreguntasJava gestor = new GestorPreguntasJava();
	        List<PreguntaTest> preguntas = gestor.getPreguntas();
	        Gson gson = new Gson();
	        String json = gson.toJson(preguntas);
	        
	        System.out.println("Esto es lo que se envia " + json); 
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	    
		} catch (IOException e) {
	    
			e.printStackTrace();
	        
	    }
		
	}

}
