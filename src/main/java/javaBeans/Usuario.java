package javaBeans;


public class Usuario {

	private int id;
	private String nombre;
	private String email;
	private String password;
	
	
	public Usuario(int id, String nombre, String email, String password) {
		
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		
	}
	
	
	// GETTERS y SETTERS
	
	// Atributo id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
	
    //Atributo nombre
    public String getNombre() {
    	return nombre;
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    //Atributo email
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    //Atributo password
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
}
