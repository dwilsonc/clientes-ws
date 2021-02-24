package com.intercorp.clientes.ws.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.intercorp.clientes.core.dto.ClienteDto;
import com.intercorp.clientes.ws.controller.resource.ClienteResource;
import com.intercorp.clientes.ws.controller.resource.request.RequestPostCrearCliente;

public class ClienteResourceMapper {

	public static ClienteDto toDto(RequestPostCrearCliente crearClienteDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(crearClienteDto, ClienteDto.class);
	}
	
	public static ClienteResource toResource(ClienteDto clienteDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(clienteDto, ClienteResource.class);
	}	
	
	public static List<ClienteResource> toResourceList(List<ClienteDto> clientesDto) {
		List<ClienteResource> listaClientesResource = clientesDto.parallelStream().map(c -> {
			ClienteResource clienteResource = new ClienteResource();
			clienteResource.setApellido(c.getApellido());
			clienteResource.setEdad(String.valueOf(c.getEdad()));
			clienteResource.setNombre(c.getNombre());
			clienteResource.setFechaNacimiento(c.getFechaNacimiento());
			return clienteResource;
		}).collect(Collectors.toList());
		return listaClientesResource;
	}
}
