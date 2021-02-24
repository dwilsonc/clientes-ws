package com.intercorp.clientes.core.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

	private Long customerId;
	
	private String nombre;

	private String apellido;

	private Integer edad;

	private Date fechaNacimiento;
}
