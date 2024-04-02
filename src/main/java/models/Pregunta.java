package models;

import java.io.Serializable;
import java.util.List;

public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String pregunta;
    private List<String> opciones;
    private String respuestaCorrecta;

    public Pregunta() {
        
    }

    public Pregunta(String pregunta, List<String> opciones, String respuestaCorrecta) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    // Getters y setters
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    
    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestaCorrecta != null && respuestaCorrecta.equals(respuesta);
    }

    

}
