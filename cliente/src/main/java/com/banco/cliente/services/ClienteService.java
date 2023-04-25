package com.banco.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.banco.cliente.dto.ResponseDTO;
import com.banco.cliente.models.ClienteModel;
import com.banco.cliente.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	private RestTemplate restTemplate;
	    
    public List<ClienteModel> listarClientes(){
        return (List<ClienteModel>) clienteRepository.findAll();
    }
	    
    public ClienteModel obtenerCliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public ClienteModel guardarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }    

    public boolean eliminarCliente(Long id) {
        try{
            clienteRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ClienteModel actualizarCliente(Long id,ClienteModel cliente ) {
    	ClienteModel clienteExistente = clienteRepository.findById(id).orElse(null);
    	if(clienteExistente != null) {
    		clienteExistente.setNombre(cliente.getNombre());
    		clienteExistente.setGenero(cliente.getGenero());
    		clienteExistente.setEdad(cliente.getEdad());
    		clienteExistente.setIdentificacion(cliente.getIdentificacion());
    		clienteExistente.setDireccion(cliente.getDireccion());
    		clienteExistente.setTelefono(cliente.getTelefono());
    		clienteExistente.setClienteid(cliente.getClienteid());
    		clienteExistente.setContrasena(cliente.getContrasena());
    		clienteExistente.setEstado(cliente.getEstado());;
    		return clienteRepository.save(clienteExistente);
    	}else {
    		return null;
    	}
    }

}