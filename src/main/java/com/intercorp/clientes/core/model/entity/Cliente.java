package com.intercorp.clientes.core.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENTE")
public class Cliente {

	/**
	 * Identificador de cliente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long customerId;

	/**
	 * Nombre
	 */
	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;
	
	/**
	 * Apellido
	 */
	@Column(name = "apellido", length = 30, nullable = false)
	private String apellido;
	
	/**
	 * Edad
	 */
	@Column(name = "edad", length = 3, nullable = false)
	private Integer edad;
	
	/**
	 * Fecha de nacimiento
	 */
	@Column(name = "fechaNacimiento", nullable = false)
	private Date fechaNacimiento;
}
