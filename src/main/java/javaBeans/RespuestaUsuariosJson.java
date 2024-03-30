package javaBeans;

import java.util.List;

public class RespuestaUsuariosJson {

	private String mensaje;
	private List<Usuario> listaUsuarios;
	
	
	public RespuestaUsuariosJson(String mensaje, List<Usuario> listaUsuarios) {
		
		this.mensaje = mensaje;
		this.listaUsuarios = listaUsuarios;
		
	}
	
	
	// GETTERS y SETTERS
	
    //Atributo mensaje
    public String getMensaje() {
    	return mensaje;
    }
    
    public void setNombre(String mensaje) {
    	this.mensaje = mensaje;
    }
    
    
    //Atributo listaUsuarios
    public List<Usuario> getListaUsuarios() {
    	return listaUsuarios;
    }
    
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
    	this.listaUsuarios = listaUsuarios;
    }
    
    
}
