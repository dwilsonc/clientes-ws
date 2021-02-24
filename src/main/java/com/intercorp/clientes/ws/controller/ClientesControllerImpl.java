package com.intercorp.clientes.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.intercorp.clientes.core.base.exceptions.BadRequestException;
import com.intercorp.clientes.core.base.exceptions.EmptyResultException;
import com.intercorp.clientes.core.base.utils.Constantes;
import com.intercorp.clientes.core.base.utils.Utils;
import com.intercorp.clientes.core.dto.ClienteDto;
import com.intercorp.clientes.core.service.ClienteService;
import com.intercorp.clientes.ws.controller.resource.ClienteResource;
import com.intercorp.clientes.ws.controller.resource.request.RequestPostCrearCliente;
import com.intercorp.clientes.ws.controller.resource.response.ResponseDataCrearCliente;
import com.intercorp.clientes.ws.controller.resource.response.ResponseDataGetKpiClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponseDataGetListaClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetKpiClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetListaClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponsePostCrearCliente;
import com.intercorp.clientes.ws.mapper.ClienteResourceMapper;

import io.swagger.annotations.Api;

/**
 * Clase de clientes
 * 
 * @author dwilsonc
 *
 */
@RestController
@Api(tags = "Clientes")
public class ClientesControllerImpl implements ClientesController {

	@Autowired
	private MessageSource messages;

	@Autowired
	private ClienteService clienteService;

	/**
	 * Crear cliente
	 * 
	 * @param crearClienteDTO {@link ResponsePostCrearCliente}
	 * @return {@link ResponsePostCrearCliente}
	 * @throws BadRequestException throw BadRequestException
	 */
	@Override
	public ResponsePostCrearCliente crearCliente(RequestPostCrearCliente crearClienteDTO) throws BadRequestException {
		if (crearClienteDTO == null)
			throw new BadRequestException(messages.getMessage("body.requerido", null, LocaleContextHolder.getLocale()));

		ClienteDto cliente = clienteService.createCustomer(ClienteResourceMapper.toDto(crearClienteDTO));
		ResponsePostCrearCliente response = new ResponsePostCrearCliente();
		ResponseDataCrearCliente data = new ResponseDataCrearCliente();
		ClienteResource clienteResource = ClienteResourceMapper.toResource(cliente);
		data.setCliente(clienteResource);
		response.setMessage(
				messages.getMessage(Constantes.MENSAJE_CREACION_EXITOSA, null, LocaleContextHolder.getLocale()));
		response.setData(data);
		return response;
	}

	/**
	 * Kpi de clientes
	 * 
	 * @return {@link ResponseGetKpiClientes}
	 * @throws EmptyResultException throw EmptyResultException
	 */
	@Override
	public ResponseGetKpiClientes obtenerKpiDeClientes() throws EmptyResultException {
		List<ClienteDto> listaClienteDto = clienteService.obtenerListaClientes();
		ResponseGetKpiClientes response = new ResponseGetKpiClientes();
		ResponseDataGetKpiClientes data = new ResponseDataGetKpiClientes();
		data.setPromedio(Utils.calcularMedia(listaClienteDto));
		data.setDesviacionEstandar(Utils.calcularDesviacionEstandar(listaClienteDto, data.getPromedio()));
		response.setMessage(
				messages.getMessage(Constantes.MENSAJE_LISTA_EXITOSA, null, LocaleContextHolder.getLocale()));
		response.setData(data);
		return response;
	}

	/**
	 * Listado de clientes
	 * 
	 * @return {@link ResponseGetListaClientes}
	 * @throws EmptyResultException throw EmptyResultException
	 */
	@Override
	public ResponseGetListaClientes obtenerListaClientes() throws EmptyResultException {
		List<ClienteDto> listaClienteDto = clienteService.obtenerListaClientes();
		ResponseGetListaClientes response = new ResponseGetListaClientes();
		ResponseDataGetListaClientes data = new ResponseDataGetListaClientes();
		data.setClientes(ClienteResourceMapper.toResourceList(listaClienteDto));
		data.setTotal(listaClienteDto.size());
		response.setMessage(
				messages.getMessage(Constantes.MENSAJE_LISTA_EXITOSA, null, LocaleContextHolder.getLocale()));
		response.setData(data);
		return response;
	}

}
