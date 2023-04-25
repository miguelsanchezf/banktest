package com.banco.cliente.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.cliente.models.ClienteModel;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Long> {

}