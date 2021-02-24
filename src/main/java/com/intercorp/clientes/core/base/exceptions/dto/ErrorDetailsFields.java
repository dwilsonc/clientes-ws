package com.intercorp.clientes.core.base.exceptions.dto;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDetailsFields {

	@JsonProperty(value = "state")
	private final int estado;
	
	@JsonProperty(value = "message")
    private final String mensaje;
	
	@JsonProperty(value = "fields")
    private List<InvalidFields> campos = new ArrayList<>();

    public ErrorDetailsFields(int estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public int getEstado() {
        return estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void agregarCampoError(String mensaje, String nombreCampo) {
    	InvalidFields error = new InvalidFields(mensaje, nombreCampo);
        campos.add(error);
    }

    public List<InvalidFields> getCampos() {
        return campos;
    }
    
    public void setCampos(List<InvalidFields> campos){
    	this.campos = campos;
    }

}
