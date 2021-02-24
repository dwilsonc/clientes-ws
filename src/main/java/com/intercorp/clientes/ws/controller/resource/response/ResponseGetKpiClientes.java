package com.intercorp.clientes.ws.controller.resource.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercorp.clientes.ws.controller.resource.MessageResource;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseGetKpiClientes extends MessageResource {

	@JsonProperty("data")
	private ResponseDataGetKpiClientes data;
}
