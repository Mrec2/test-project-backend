package javaBeans;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {

	private List<Usuario> listaUsuarios;
	
	public GestorUsuarios() {
		this.listaUsuarios = new ArrayList<>();
		cargarUsuarios();
	}
	
	
	public void cargarUsuarios() {
		
		Usuario usuario1 = new Usuario(1, "Juan Alberto", "juanal@correo.com", "123");
		Usuario usuario2 = new Usuario(2, "Alberto", "alberto@correo.com", "456");
		Usuario usuario3 = new Usuario(3, "Mario", "mario@correo.com", "789");
		Usuario usuario4 = new Usuario(4, "Juanma", "juanma@correo.com", "jua");
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaUsuarios.add(usuario3);
		listaUsuarios.add(usuario4);
		
	}
	
	public List<Usuario> getUsuarios() {
		return listaUsuarios;
	}
	
	
	public void imprimeUsuarios() {
		//IMPRIME LOS USUARIOS DESDE LA CLASE
        System.out.println("Usuarios Modificados ");
        
        for(Usuario usuario : listaUsuarios) {
        	System.out.print("Usuario " + usuario.getId());
			System.out.print(" - " + usuario.getNombre());
			System.out.print(" - " + usuario.getEmail());
			System.out.println(" - " + usuario.getPassword());
        }	 
	}
	
	
	public int posicionUsuarioIdEnLista(int id) {
		
		int posicionUsuario = -1;
		int i = 0;
		boolean encontrado = false;
		
		while( !encontrado && i < listaUsuarios.size() ) {
			if( id == listaUsuarios.get(i).getId() ) {
        		posicionUsuario = i;
        		encontrado = true;
        	}
        	
        	i++;
		}
		
		return posicionUsuario;
	}
	
	
	public int posicionUsuarioEmailEnLista(String email) {
		
		int posicionUsuario = -1;
		int i = 0;
		boolean encontrado = false;
		
		while( !encontrado && i < listaUsuarios.size() ) {
			if( email.equals(listaUsuarios.get(i).getEmail()) ) {
        		posicionUsuario = i;
        		encontrado = true;
        	}
        	
        	i++;
		}
	
		return posicionUsuario;
	}
	
	
	public boolean loginUsuario(Usuario usuario) {
		
		//int posicion = posicionUsuarioIdEnLista(usuario.getId());
		int posicion = posicionUsuarioEmailEnLista(usuario.getEmail());
		
		if( posicion >= 0 ) {
			
			if( ( usuario.getEmail().equals(listaUsuarios.get(posicion).getEmail()) ) && 
				( usuario.getPassword().equals(listaUsuarios.get(posicion).getPassword()) )	) {				
				return true;
				
			} else {
				return false;
			}
					
		} else {
			return false;
		}
		
	}
	
	
	public List<Usuario> creaUsuarios(Usuario usuario) {
		
		int identificador = listaUsuarios.size() + 1;
		
		usuario.setId(identificador);
		
		listaUsuarios.add(usuario);
		
		System.out.println("Usuario CREADO EN LA CLASE en la POSICION " + (int)(identificador - 1) + " - " + listaUsuarios.get((int)(identificador - 1)).getNombre());
		//System.out.println("Usuario CREADO EN LA CLASE en la POSICION " + (int)(identificador - 1));
		
		return listaUsuarios;
	}
	
	
	public List<Usuario> modificaUsuarios(Usuario usuario, int posicionUsuario) {
		
		listaUsuarios.get(posicionUsuario).setNombre(usuario.getNombre());
		listaUsuarios.get(posicionUsuario).setEmail(usuario.getEmail());
		listaUsuarios.get(posicionUsuario).setPassword(usuario.getPassword());
		
		System.out.println("Usuario MODIFICANDO EN LA CLASE en la POSICION " + posicionUsuario + " - " + listaUsuarios.get(posicionUsuario).getNombre());
		
		return listaUsuarios;
	}
	
	
	public List<Usuario> borraUsuarios(int posicionUsuario) {
		
		System.out.println("Usuario BORRANDO EN LA CLASE en la POSICION " + posicionUsuario + " - " + listaUsuarios.get(posicionUsuario).getNombre());
		
		listaUsuarios.remove(posicionUsuario);
		
		return listaUsuarios;
	}
	
	
} 
