package com.intercorp.clientes.ws.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.intercorp.clientes.core.base.exceptions.BadRequestException;
import com.intercorp.clientes.core.base.exceptions.EmptyResultException;
import com.intercorp.clientes.core.base.exceptions.dto.ErrorDetailsFields;
import com.intercorp.clientes.ws.controller.resource.request.RequestPostCrearCliente;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetKpiClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetListaClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponsePostCrearCliente;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping("/api")
public interface ClientesController {

	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Creacion de cliente", notes = "Servicio que crea un cliente", response = ResponsePostCrearCliente.class)
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Se creo el cliente con exito.", response = ResponsePostCrearCliente.class),
			@ApiResponse(code = 400, message = "El request no puede ser interpretado por sintaxis invalida.", response = ErrorDetailsFields.class) })
	@PostMapping(value = "/v1/crearcliente")
	ResponsePostCrearCliente crearCliente(
			@ApiParam(value = "Informacion necesaria del cliente", required = true) @Valid @RequestBody(required = false) RequestPostCrearCliente crearClienteDTO)
			throws BadRequestException;

	@ApiOperation(value = "Kpi de clientes", notes = "Servicio que obtiene la media y desviacion estandar de las edades de los clientes", response = ResponseGetKpiClientes.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operacion exitosa.", response = ResponseGetKpiClientes.class),
			@ApiResponse(code = 204, message = "Lista vacia.", response = void.class) })
	@GetMapping(value = "/v1/kpideclientes")
	ResponseGetKpiClientes obtenerKpiDeClientes() throws EmptyResultException;

	@ApiOperation(value = "Listado de clientes", notes = "Servicio que obtiene el listado de clientes con todos su datos.", response = ResponseGetListaClientes.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Operacion exitosa.", response = ResponseGetListaClientes.class),
			@ApiResponse(code = 204, message = "Lista vacia.", response = void.class) })
	@GetMapping(value = "/v1/listclientes")
	ResponseGetListaClientes obtenerListaClientes() throws EmptyResultException;
}
