package com.intercorp.clientes.ws.controller.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDataGetKpiClientes {

	@JsonProperty("promedio")
	private Double promedio;
	
	@JsonProperty("desviacionEstandar")
	private Double desviacionEstandar;
}
