package com.banco.cuenta.models;

import javax.persistence.*;

@Entity
@Table(name = "cuenta")
public class CuentaModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuentaId")
    private Long cuentaId;

    @Column(name = "numeroCuenta")
    private String numeroCuenta;

    @Column(name = "tipoCuenta")
    private String tipoCuenta;

    @Column(name = "saldoInicial")
    private Float saldoInicial;

    @Column(name = "estado")
    private boolean estado;
    
    /*@ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ClienteDTO cliente;
*/
	public Long getCuentaId() {
		return cuentaId;
	}

	public void setId(Long cuentaid) {
		this.cuentaId = cuentaid;
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

	/*public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	 */
	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}
    

}