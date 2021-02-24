package com.intercorp.clientes.ws.controller.resource.request;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Request de crear cliente
 * @author dwilsonc
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class RequestPostCrearCliente {
	
	@Size(max = 30)
	@NotNull
	@NotBlank
	@ApiModelProperty(required = true, value = "", example = "Dennis")
	@JsonProperty("nombre")
	private String nombre;
	
	@Size(max = 30)
	@NotNull
	@NotBlank
	@ApiModelProperty(required = true, value = "", example = "Wilson")
	@JsonProperty("apellido")
	private String apellido;
	
	@Size(max = 2)
	@NotNull
	@NotBlank
	@Pattern(message="Only Numbers" , regexp = "[+-]?(([0-9][0-9]*)|(0))([.,][0-9]+)?|(^$)")
	@ApiModelProperty(required = true, value = "", example = "31")
	@JsonProperty("edad")
	private String edad;
	
	@NotNull
	@ApiModelProperty(required = true, value = "", example = "1989-07-19")
	@JsonProperty("fechaNacimiento")
	private Date fechaNacimiento;
}
