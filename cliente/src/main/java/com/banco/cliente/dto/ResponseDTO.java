package com.banco.cliente.dto;

import com.banco.cliente.models.ClienteModel;

public class ResponseDTO {

	private ClienteModel cliente;
	private CuentaDTO cuentaDTO;
	
	public ClienteModel getCliente() {
		return cliente;
	}
	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}
	public CuentaDTO getCuentaDTO() {
		return cuentaDTO;
	}
	public void setCuentaDTO(CuentaDTO cuentaDTO) {
		this.cuentaDTO = cuentaDTO;
	}
	
	
}
