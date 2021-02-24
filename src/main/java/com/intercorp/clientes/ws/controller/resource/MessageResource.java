package com.intercorp.clientes.ws.controller.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResource {

	@JsonProperty("message")
	private String message;
	
	@JsonProperty("success")
	private boolean success = true;
}
