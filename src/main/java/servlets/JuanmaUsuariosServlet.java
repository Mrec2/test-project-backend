package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import javaBeans.Usuario;
import javaBeans.RespuestaUsuariosJson;
import javaBeans.GestorUsuarios;


@WebServlet("/usuariosServlet")
public class JuanmaUsuariosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	// GENERO LA LISTA DE USUARIOS
    private GestorUsuarios gestor = new GestorUsuarios();
    private List<Usuario> listaUsuarios = gestor.getUsuarios();
	
    public JuanmaUsuariosServlet() {
        super();
    }

    protected void doGetAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el usuariosServlet GET-ALL");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		try {
	        //GestorUsuarios gestor = new GestorUsuarios();
	        //List<Usuario> listaUsuarios = gestor.getUsuarios();
	        
	        Gson gsonSalida = new Gson();
	        String json = gsonSalida.toJson(listaUsuarios);
	        
	        System.out.println("Esto es lo que se envia " + json); 
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }
		
    } // GET ALL

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el usuariosServlet GET");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		try {
			
			Gson gsonSalida = new Gson();
	        String json="";
			
	        String usuarioId = request.getParameter("usuarioId");
	        if (usuarioId != null) {	
				int posicion = gestor.posicionUsuarioIdEnLista(Integer.parseInt(usuarioId));
				
				if(posicion >= 0) {
					json = gsonSalida.toJson(listaUsuarios.get(posicion));
		        } else {
		        	System.out.println("El Usuario de ID " + usuarioId + " NO SE ENCUENTRA");
		        }    		
				
	        } else {
	        	json = gsonSalida.toJson(listaUsuarios);	        
	        }
	        
	        System.out.println("Esto es lo que se envia " + json); 
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        
	    }
		
	} //GET
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el usuariosServlet PUT");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		BufferedReader miDato = request.getReader();
		String miDatoFinal = miDato.readLine();
		System.out.println("Dato FINAL => " + miDatoFinal);

		
		Gson gsonEntrada = new Gson();
		Usuario objUsuario = gsonEntrada.fromJson(miDatoFinal,Usuario.class);
		
		// GENERO LA LISTA DE USUARIOS
        //GestorUsuarios gestor = new GestorUsuarios();
        //List<Usuario> listaUsuarios = gestor.getUsuarios();
		
		// MODIFICAR UN USUARIO EXISTENTE
		// Comprobar parámetros id != 0, nombre, email, password
		// Posibles problemas : 
		try {
			
			String mensaje;
			   
	        int posicion = gestor.posicionUsuarioIdEnLista(objUsuario.getId());
	        
	        if(posicion >= 0) {
	        	//System.out.println("Usuario Buscado " + listaUsuarios.get(posicion).getNombre());
	        	gestor.modificaUsuarios(objUsuario, posicion);
	        	mensaje="USUARIO MODIFICADO CON EXITO";
	        	
	        } else {
	        	System.out.println("El Usuario " + objUsuario.getNombre() + " de ID " + objUsuario.getId() + " NO SE ENCUENTRA");
	        	mensaje="USUARIO " + objUsuario.getNombre() + " NO EXISTE";
	        }    	        	
	        
	        gestor.imprimeUsuarios();
	        
	        RespuestaUsuariosJson respuestaLogin = new RespuestaUsuariosJson(mensaje, listaUsuarios);
	        
	        Gson gsonSalida = new Gson();
	        String json = gsonSalida.toJson(respuestaLogin);
	        
	        System.out.println("Esto es lo que se envia en PUT " + json); 
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	        
	    } catch (Exception e) {
	        e.printStackTrace();   
	    }
				
	} // PUT
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Estamos en el usuariosServlet DELETE");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		BufferedReader miDato = request.getReader();
		String miDatoFinal = miDato.readLine();
		System.out.println("Dato FINAL => " + miDatoFinal);

		
		Gson gsonEntrada = new Gson();
		Usuario objUsuario = gsonEntrada.fromJson(miDatoFinal,Usuario.class);
		
		// BORRAR UN USUARIO EXISTENTE
		// Comprobar parámetros id != 0, nombre, email, password
		// Posibles problemas : 
		try {
			
			String mensaje;
			
	        int posicion = gestor.posicionUsuarioIdEnLista(objUsuario.getId());
	        
	        if(posicion >= 0) {	        	
	        	//System.out.println("Usuario Buscado " + listaUsuarios.get(posicion).getNombre());
	        	gestor.borraUsuarios(posicion);
	        	mensaje="USUARIO BORRADO CON EXITO";
	        	
	        } else {
	        	System.out.println("El Usuario " + objUsuario.getNombre() + " de ID " + objUsuario.getId() + " NO SE ENCUENTRA");
	        	mensaje="USUARIO " + objUsuario.getNombre() + " NO EXISTE";
	        }
	        
	        gestor.imprimeUsuarios();	  
	        
	        RespuestaUsuariosJson respuestaLogin = new RespuestaUsuariosJson(mensaje, listaUsuarios);
			
			Gson gsonSalida = new Gson();
	        String json = gsonSalida.toJson(respuestaLogin);
			     
	        System.out.println("Esto es lo que se envia en LOGIN " + json);
	         
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	        
	    } catch (Exception e) {
	        e.printStackTrace();   
	    }
		
	} // DELETE


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estamos en el usuariosServlet POST");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		BufferedReader miDato = request.getReader();
		String miDatoFinal = miDato.readLine();
		System.out.println("Dato FINAL => " + miDatoFinal);
		
		Gson gsonEntrada = new Gson();
		Usuario objUsuario = gsonEntrada.fromJson(miDatoFinal,Usuario.class);				
					
		// AÑADIR UN NUEVO USUARIO
		// Comprobar parámetros id = 0, nombre, email, password
		// Posibles problemas : 
		
		try {
			String mensaje;
			
			if( objUsuario.getId() == 0 ) {
				
				// 	QUIERE CREAR UN USUARIO NUEVO
				gestor.creaUsuarios(objUsuario);
	        	gestor.imprimeUsuarios();
	        	
	        	mensaje = "USUARIO CREADO CON EXITO";
	        	System.out.println("CREAR USUARIO NUEVO");
				
			} else {
				
				// QUIERE HACER LOGIN									
				if( gestor.loginUsuario(objUsuario) ) {
					mensaje = "OK";
					System.out.println(mensaje);
					
				} else {
					mensaje="Usuario o contraseña INCORRECTAS";
					System.out.println(mensaje);
				}
       				
			}
			
			// MANDA MENSAJE CON EL RESULTADO
			// A Gson se le debe pasar un objeto Java NO un string. Un array de 2 elementos???
			
			RespuestaUsuariosJson respuestaLogin = new RespuestaUsuariosJson(mensaje, listaUsuarios);
			
			Gson gsonSalida = new Gson();
	        //String json = gsonSalida.toJson(listaUsuarios);
	        String json = gsonSalida.toJson(respuestaLogin);
			
        
	        System.out.println("Esto es lo que se envia en LOGIN " + json);
	         
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write(json);
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();   
	    }

		
	} // POST
	
	
	// NO FUNCIONA
	protected void doPatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Estamos en el usuariosServlet PATCH");
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		
	} // PATCH	


}  // FINAL DE LA CLASE
