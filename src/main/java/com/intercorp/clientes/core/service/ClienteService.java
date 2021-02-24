package com.intercorp.clientes.core.service;

import java.util.List;

import com.intercorp.clientes.core.dto.ClienteDto;

public interface ClienteService {

	public ClienteDto createCustomer(ClienteDto clienteDto);
	
	public List<ClienteDto> obtenerListaClientes();

}
