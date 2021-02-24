package com.intercorp.clientes.core.base.exceptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvalidFields {

	@JsonProperty(value = "message")
	private String mensaje;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty(value = "field-name")
	private String nombreCampo;
}
