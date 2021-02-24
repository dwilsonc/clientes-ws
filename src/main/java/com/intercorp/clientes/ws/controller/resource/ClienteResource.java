package com.intercorp.clientes.ws.controller.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request de crear cliente
 * @author dwilsonc
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResource {
	
	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("apellido")
	private String apellido;
	
	@JsonProperty("edad")
	private String edad;
	
	@JsonProperty("fechaNacimiento")
	private Date fechaNacimiento;
}
