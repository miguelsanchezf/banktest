package com.banco.cuenta.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.cuenta.models.CuentaModel;

@Repository
public interface CuentaRepository extends CrudRepository<CuentaModel, Long> {

}