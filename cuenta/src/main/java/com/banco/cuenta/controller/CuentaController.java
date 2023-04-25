package com.banco.cuenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.cuenta.models.CuentaModel;
import com.banco.cuenta.services.CuentaService;


@RestController
@RequestMapping("/cuenta")
public class CuentaController {
	@Autowired
    private CuentaService cuentaService;

    @GetMapping()
    public List<CuentaModel> obtenerCuentas(){
        return cuentaService.listarCuentas();
    }
    
    @GetMapping( path = "/{id}")
    public ResponseEntity<CuentaModel> obtenerCuenta(@PathVariable("id") Long id) {
    	CuentaModel cuenta = cuentaService.obtenerCuenta(id);
        if(cuenta != null) {
        	return ResponseEntity.ok(cuenta);
        }else {
        	return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping()
    public ResponseEntity<CuentaModel> guardarCuenta(@RequestBody CuentaModel cuenta){
    	CuentaModel nuevaCuenta = cuentaService.guardarCuenta(cuenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCuenta);
    }
    
    @DeleteMapping( path = "/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable("id") Long id){
    	cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<CuentaModel> actualizarCuenta(@PathVariable("id") Long id, @RequestBody CuentaModel cuenta){
    	CuentaModel cuentaActualizado = cuentaService.actualizarCuenta(id, cuenta);
        if(cuentaActualizado != null) {
        	return ResponseEntity.ok(cuentaActualizado);
        }else {
        	return ResponseEntity.notFound().build();
        }
    }
    
    /*@GetMapping( path = "/cliente/{id}")
    public ResponseDTO getClienteById(@PathVariable("id") Long id) {
    	return cuentaService.getClienteById(id);
    }*/
}