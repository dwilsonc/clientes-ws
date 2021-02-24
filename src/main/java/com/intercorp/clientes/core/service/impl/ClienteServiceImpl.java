package com.intercorp.clientes.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intercorp.clientes.core.dto.ClienteDto;
import com.intercorp.clientes.core.mapper.ClienteDtoMapper;
import com.intercorp.clientes.core.model.ClienteRepository;
import com.intercorp.clientes.core.model.entity.Cliente;
import com.intercorp.clientes.core.service.ClienteService;

/**
 * Servicio principal del cliente
 * 
 * @author Dennis Wilson
 *
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/**
	 * Creacion de cliente
	 * 
	 * @param clienteDto {@link ClienteDto}
	 */
	@Override
	public ClienteDto createCustomer(ClienteDto clienteDto) {
		Cliente cliente = ClienteDtoMapper.toModel(clienteDto);
		return ClienteDtoMapper.toDto(clienteRepository.save(cliente));
	}

	/**
	 * Obtener listado de clientes
	 * 
	 * @param {@link List<ClienteDto>}
	 */
	@Override
	public List<ClienteDto> obtenerListaClientes() {
		List<Cliente> listaClientes= (List<Cliente>) clienteRepository.findAll();
		return ClienteDtoMapper.toDtoList(listaClientes);
	}

}
