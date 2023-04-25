package com.banco.cliente.dto;

public class CuentaDTO {

	private Long cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private Float saldoInicial;
    private boolean estado;
    
	public Long getCuentaId() {
		return cuentaId;
	}
	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	public Float getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(Float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
    
}
