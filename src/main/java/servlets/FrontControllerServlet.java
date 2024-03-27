package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/testServlet/*")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FrontControllerServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Estamos en el servlet GET");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("Estamos en el servlet POST");
		System.out.println("Esto es pathInfo ----> " + request.getPathInfo());
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		BufferedReader miDato = request.getReader();
		String miDatoFinal = miDato.readLine();
//		System.out.println(miDatoFinal);
		
		String pathInfo = request.getPathInfo();
		
		if(pathInfo == null || pathInfo.equals("/")) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("No se ha especificado ninguna operación");
			return;
		} 
		
		String [] palabraPath = pathInfo.split("/");
		System.out.println("Esto es palabraPath -----> " + palabraPath[1]);
		System.out.println("Esto es tamaño de palabraPath -----> " + palabraPath.length);
		
		if (!palabraPath[1].equals("html") && !palabraPath[1].equals("css") && 
			    !palabraPath[1].equals("js") && !palabraPath[1].equals("java")) {
			    System.out.println("entra en el if de length 2?");
			    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			    response.getWriter().write("URL inválida");
			    return;
			}

		
		String operacion = palabraPath[1];
        switch (operacion) {
            case "css":
            	System.out.println("entra en el dispatcher de css");
                request.getRequestDispatcher("/PreguntasCssServlet").forward(request, response);
                break;
            case "html":
            	System.out.println("entra en el dispatcher de html");
                request.getRequestDispatcher("/PreguntasHtmlServlet").forward(request, response);
                break;
            case "js":
            	System.out.println("entra en el dispatcher de js");
                request.getRequestDispatcher("/PreguntasJsServlet").forward(request, response);
                break;
            case "java":
            	System.out.println("entra en el dispatcher de java");
                request.getRequestDispatcher("/PreguntasJavaServlet").forward(request, response);
                break;
            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("Operación no válida.");
        }
		
//		if (miDatoFinal.equals("js")) {
//		    try {
//		        GestorPreguntasJavascript gestor = new GestorPreguntasJavascript();
//		        List<PreguntaTest> preguntas = gestor.getPreguntas();
//		        Gson gson = new Gson();
//		        String json = gson.toJson(preguntas);
//		        
//		        System.out.println("Esto es lo que se envia " + json); 
//		        response.setContentType("application/json");
//		        response.setCharacterEncoding("UTF-8");
//		        response.getWriter().write(json);
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		        
//		    }
//		}else if (miDatoFinal.equals("html")) {
//			try {
//				GestorPreguntasHTML gestor = new GestorPreguntasHTML();
//		        List<PreguntaTest> preguntas = gestor.getPreguntas();
//		        Gson gson = new Gson();
//		        String json = gson.toJson(preguntas);
//		        
//		        System.out.println("Esto es lo que se envia " + json); 
//		        response.setContentType("application/json");
//		        response.setCharacterEncoding("UTF-8");
//		        response.getWriter().write(json);
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		        
//		    }
//		}else if (miDatoFinal.equals("css")) {
//			try {
//				GestorPreguntasCss gestor = new GestorPreguntasCss();
//		        List<PreguntaTest> preguntas = gestor.getPreguntas();
//		        Gson gson = new Gson();
//		        String json = gson.toJson(preguntas);
//		        
//		        System.out.println("Esto es lo que se envia " + json); 
//		        response.setContentType("application/json");
//		        response.setCharacterEncoding("UTF-8");
//		        response.getWriter().write(json);
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		        
//		    }
//		}else if (miDatoFinal.equals("java")) {
//			try {
//				GestorPreguntasJava gestor = new GestorPreguntasJava();
//		        List<PreguntaTest> preguntas = gestor.getPreguntas();
//		        Gson gson = new Gson();
//		        String json = gson.toJson(preguntas);
//		        
//		        System.out.println("Esto es lo que se envia " + json); 
//		        response.setContentType("application/json");
//		        response.setCharacterEncoding("UTF-8");
//		        response.getWriter().write(json);
//		    } catch (IOException e) {
//		        e.printStackTrace();
//		        
//		    }
//		}

		
	
		
		
		
	}

}
