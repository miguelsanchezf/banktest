package com.banco.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.cliente.models.ClienteModel;
import com.banco.cliente.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<ClienteModel> obtenerClientes(){
        return clienteService.listarClientes();
    }
    
    @GetMapping( path = "/{id}")
    public ResponseEntity<ClienteModel> obtenerCliente(@PathVariable("id") Long id) {
    	ClienteModel cliente = clienteService.obtenerCliente(id);
        if(cliente != null) {
        	return ResponseEntity.ok(cliente);
        }else {
        	return ResponseEntity.notFound().build();
        }
        
    }

    @PostMapping()
    public ResponseEntity<ClienteModel> guardarCliente(@RequestBody ClienteModel cliente){
    	ClienteModel nuevocliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevocliente);
    }
    
    @DeleteMapping( path = "/{id}")
    public ResponseEntity<Void> eliminarcliente(@PathVariable("id") Long id){
    	clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping( path = "/{id}")
    public ResponseEntity<ClienteModel> actualizarcliente(@PathVariable("id") Long id, @RequestBody ClienteModel cliente){
    	ClienteModel clienteActualizado = clienteService.actualizarCliente(id, cliente);
        if(clienteActualizado != null) {
        	return ResponseEntity.ok(clienteActualizado);
        }else {
        	return ResponseEntity.notFound().build();
        }
    }
}