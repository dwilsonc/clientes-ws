package com.intercorp.clientes.core.model;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.intercorp.clientes.core.model.entity.Cliente;

/**
 * Repositorio del cliente
 * 
 * @author Dennis Wilson
 *
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

}
