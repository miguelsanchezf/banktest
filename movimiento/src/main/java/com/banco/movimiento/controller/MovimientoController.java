package com.banco.movimiento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.movimiento.models.MovimientoModel;
import com.banco.movimiento.services.MovimientoService;


@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
	@Autowired
    private MovimientoService movimientoService;

    @GetMapping()
    public List<MovimientoModel> obtenerMovimientos(){
        return movimientoService.listarMovimientos();
    }
    
    @GetMapping( path = "/{id}")
    public ResponseEntity<MovimientoModel> obtenerMovimientoId(@PathVariable("id") Long id) {
    	MovimientoModel movimiento = movimientoService.obtenerMovimientoId(id);
        if(movimiento != null) {
        	return ResponseEntity.ok(movimiento);
        }else {
        	return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping()
    public ResponseEntity<MovimientoModel> crearMovimiento(@RequestBody MovimientoModel movimiento){
    	MovimientoModel movimientoNuevo = movimientoService.crearMovimiento(movimiento);
               
        if (movimiento.getTipoMovimiento().equals("Credito") && movimiento.getValor() < 0) {
            return ResponseEntity.badRequest().build();
        } else if (movimiento.getTipoMovimiento().equals("Débito") && movimiento.getValor() > 0) {
            movimiento.setValor(-movimiento.getValor()); 
        } else {
            movimiento.setValor(Math.abs(movimiento.getValor()));
        } 
        return ResponseEntity.status(HttpStatus.CREATED).body(movimientoNuevo);
    }
    
    @DeleteMapping( path = "/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable("id") Long id){
    	movimientoService.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<MovimientoModel> actualizarMovimiento(@PathVariable("id") Long id, @RequestBody MovimientoModel movimiento){
    	MovimientoModel movimientoActualizado = movimientoService.actualizarMovimiento(id, movimiento);
        if(movimientoActualizado != null) {
        	return ResponseEntity.ok(movimientoActualizado);
        }else {
        	return ResponseEntity.notFound().build();
        }
    }
}