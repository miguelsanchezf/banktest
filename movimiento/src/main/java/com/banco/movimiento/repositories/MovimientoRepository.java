package com.banco.movimiento.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banco.movimiento.models.MovimientoModel;

@Repository
public interface MovimientoRepository extends CrudRepository<MovimientoModel, Long> {
    
}