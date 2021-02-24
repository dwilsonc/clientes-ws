package com.intercorp.clientes.ws.controller.resource.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercorp.clientes.ws.controller.resource.ClienteResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDataGetListaClientes {

	@JsonProperty("clientes")
	private List<ClienteResource> clientes;
	
	@JsonProperty("total")
	private int total;
}
