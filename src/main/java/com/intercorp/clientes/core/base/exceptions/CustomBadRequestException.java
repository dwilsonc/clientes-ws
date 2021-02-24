package com.intercorp.clientes.core.base.exceptions;

import java.util.List;

import com.intercorp.clientes.core.base.exceptions.dto.InvalidFields;

@SuppressWarnings("serial")
public class CustomBadRequestException extends Exception {

	private List<InvalidFields> camposErroneos;

	public List<InvalidFields> getCamposErroneos() {
		return camposErroneos;
	}

	public void setCamposErroneos(List<InvalidFields> camposErroneos) {
		this.camposErroneos = camposErroneos;
	}

	public CustomBadRequestException(List<InvalidFields> camposErroneos) {
		super();
		this.camposErroneos = camposErroneos;
	}
}