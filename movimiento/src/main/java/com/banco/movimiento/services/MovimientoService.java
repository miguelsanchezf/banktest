package com.banco.movimiento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.movimiento.models.MovimientoModel;
import com.banco.movimiento.repositories.MovimientoRepository;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoRepository movimientoRepository;
	    
    public List<MovimientoModel> listarMovimientos(){
        return (List<MovimientoModel>) movimientoRepository.findAll();
    }
	    
    public MovimientoModel obtenerMovimientoId(Long id){
        return movimientoRepository.findById(id).orElse(null);
    }

    public MovimientoModel crearMovimiento(MovimientoModel movimiento){
        return movimientoRepository.save(movimiento);
    }    

    public boolean eliminarMovimiento(Long id) {
        try{
        	movimientoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public MovimientoModel actualizarMovimiento(Long id,MovimientoModel movimiento ) {
    	MovimientoModel movimientoExistente = movimientoRepository.findById(id).orElse(null);
    	if(movimientoExistente != null) {
    		movimientoExistente.setFecha(movimiento.getFecha());
    		movimientoExistente.setTipoMovimiento(movimiento.getTipoMovimiento());
    		movimientoExistente.setValor(movimiento.getValor());
    		movimientoExistente.setSaldo(movimiento.getSaldo());
    		return movimientoRepository.save(movimiento);
    	}else {
    		return null;
    	}
    }
}