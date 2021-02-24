package com.intercorp.clientes.ws.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.MessageSource;

import com.intercorp.clientes.core.base.exceptions.BadRequestException;
import com.intercorp.clientes.core.base.exceptions.EmptyResultException;
import com.intercorp.clientes.core.dto.ClienteDto;
import com.intercorp.clientes.core.service.ClienteService;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetKpiClientes;
import com.intercorp.clientes.ws.controller.resource.response.ResponseGetListaClientes;
import com.intercorp.clientes.ws.util.UtilService;

@RunWith(MockitoJUnitRunner.Silent.class)
@DataJpaTest
public class ClientesControllerImplTest {

	@InjectMocks
	private ClientesControllerImpl clientesControllerImpl;

	@Mock
	private ClienteService clienteService;

	@Mock
	private MessageSource messageSource;
	
	private UtilService util;

	private List<ClienteDto> clientesDtoList;

	@Before
	public void setUp() throws Exception {
		util = new UtilService();
		clientesDtoList = util.getLoadJsonClientes("json/clientes.json");
	}

	@Test(expected = BadRequestException.class)
	public void crear_cliente_body_es_requerido_test() throws BadRequestException {
		clientesControllerImpl.crearCliente(null);
	}

	@Test
	public void obtener_kpi_promedio_cliente_test() throws EmptyResultException {
		boolean esPromedioIgual = false;
		Mockito.when(clienteService.obtenerListaClientes()).thenReturn(clientesDtoList);
		ResponseGetKpiClientes responseGetKpiClientes = clientesControllerImpl.obtenerKpiDeClientes();
		
		if (Double.compare(responseGetKpiClientes.getData().getPromedio(), 35.2) == 0)
			esPromedioIgual = true;
		
		assertTrue(esPromedioIgual);
	}
	
	@Test
	public void obtener_kpi_desviacion_estandar_cliente_test() throws EmptyResultException {
		boolean esPromedioIgual = false;
		Mockito.when(clienteService.obtenerListaClientes()).thenReturn(clientesDtoList);
		ResponseGetKpiClientes responseGetKpiClientes = clientesControllerImpl.obtenerKpiDeClientes();
		
		if (Double.compare(responseGetKpiClientes.getData().getDesviacionEstandar(), 9.91) == 0)
			esPromedioIgual = true;
		
		assertTrue(esPromedioIgual);
	}
	
	@Test
	public void obtener_total_lista_clientes_test() throws EmptyResultException {
		Mockito.when(clienteService.obtenerListaClientes()).thenReturn(clientesDtoList);
		ResponseGetListaClientes responseGetListaClientes = clientesControllerImpl.obtenerListaClientes();
		assertEquals(responseGetListaClientes.getData().getTotal(), 5);
	}
}
