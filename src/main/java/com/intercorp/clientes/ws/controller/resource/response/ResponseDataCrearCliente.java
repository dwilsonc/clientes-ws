package com.intercorp.clientes.ws.controller.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercorp.clientes.ws.controller.resource.ClienteResource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDataCrearCliente {

	@JsonProperty("cliente")
	private ClienteResource cliente;
}
