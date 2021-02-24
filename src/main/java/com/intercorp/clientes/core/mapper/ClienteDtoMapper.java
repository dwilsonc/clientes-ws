package com.intercorp.clientes.core.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.intercorp.clientes.core.dto.ClienteDto;
import com.intercorp.clientes.core.model.entity.Cliente;

public class ClienteDtoMapper {

	public static Cliente toModel(ClienteDto clienteDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(clienteDto, Cliente.class);
	}

	public static ClienteDto toDto(Cliente cliente) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(cliente, ClienteDto.class);
	}

	public static List<ClienteDto> toDtoList(List<Cliente> clientes) {
		List<ClienteDto> listaClientesDto = clientes.parallelStream().map(c -> {
			ClienteDto clienteDto = new ClienteDto();
			clienteDto.setApellido(c.getApellido());
			clienteDto.setEdad(c.getEdad());
			clienteDto.setNombre(c.getNombre());
			clienteDto.setFechaNacimiento(c.getFechaNacimiento());
			return clienteDto;
		}).collect(Collectors.toList());
		return listaClientesDto;
	}
}