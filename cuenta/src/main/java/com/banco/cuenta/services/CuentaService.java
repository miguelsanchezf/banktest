package com.banco.cuenta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.cuenta.models.CuentaModel;
import com.banco.cuenta.repositories.CuentaRepository;

@Service
public class CuentaService {
	@Autowired
	private CuentaRepository cuentaRepository;
	
	//private RestTemplate restTemplate;
	    
    public List<CuentaModel> listarCuentas(){
        return (List<CuentaModel>) cuentaRepository.findAll();
    }
	    
    public CuentaModel obtenerCuenta(Long id){
        return cuentaRepository.findById(id).orElse(null);
    }

    public CuentaModel guardarCuenta(CuentaModel cuenta){
        return cuentaRepository.save(cuenta);
    }    

    public boolean eliminarCuenta(Long id) {
        try{
        	cuentaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public CuentaModel actualizarCuenta(Long id,CuentaModel cuenta ) {
    	CuentaModel cuentaExistente = cuentaRepository.findById(id).orElse(null);
    	if(cuentaExistente != null) {
    		cuentaExistente.setNumeroCuenta(cuenta.getNumeroCuenta());
    		cuentaExistente.setTipoCuenta(cuenta.getNumeroCuenta());
    		cuentaExistente.setSaldoInicial(cuenta.getSaldoInicial());
    		cuentaExistente.setEstado(cuenta.isEstado());
    		return cuentaRepository.save(cuenta);
    	}else {
    		return null;
    	}
    }

    /*
	public ResponseDTO getClienteById(Long id) {
		ResponseDTO responseDTO = new ResponseDTO();
		CuentaModel cuenta = new CuentaModel();
		cuenta = cuentaRepository.findById(id).get();
		
		ResponseEntity<ClienteDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/cliente"+cuenta.getCliente().getClienteid(), ClienteDTO.class);
    	
		ClienteDTO clienteDTO = responseEntity.getBody();
    			
    	responseDTO.setCuenta(cuenta);
    	responseDTO.setClienteDTO(clienteDTO);
		return responseDTO;
	}*/
}