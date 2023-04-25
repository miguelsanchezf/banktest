package com.banco.cuenta.dto;

import com.banco.cuenta.models.CuentaModel;

public class ResponseDTO {

	private CuentaModel cuenta;
	private ClienteDTO clienteDTO;
	
	public CuentaModel getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaModel cuenta) {
		this.cuenta = cuenta;
	}
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	
}
