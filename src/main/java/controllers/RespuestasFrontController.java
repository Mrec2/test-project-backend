package controllers;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/respuestas/")
public class RespuestasFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RespuestasFrontController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 response.setHeader("Access-Control-Allow-Origin", "*");
	     response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
	     response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
	     response.setHeader("Access-Control-Allow-Credentials", "true");
	     response.setHeader("Access-Control-Max-Age", "3600");
		 System.out.println("Entra en respuestas del RespuestasFrontController");
		 
		 
		 
		 
		 BufferedReader reader = request.getReader();
		 String myData = reader.readLine();
		 System.out.println("Estos son mis datos que recibo cuando he pulsado el botón de enviar del front ---> " + myData);
		 
		 // IMPORTANTE "myData" !!! ESTE ES EL JSON QUE SE RECIBE DEL FRONT PARA MANIPULAR LOS DATOS DE RESPUESTAS Y PREGUNTAS DEL USUARIO
		 
		 
		 // PRUEBA PARA DEVOLVER AL FRONT UNA RESPUESTA . ESTO SE BORRA LUEGO 
		 
		 response.getWriter().write("Lo recibe el front?");		 
	}
	
	
	

}
