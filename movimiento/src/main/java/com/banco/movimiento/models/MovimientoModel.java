package com.banco.movimiento.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "movimiento")
public class MovimientoModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimiento_id")
    private Long id;

	@Column(name = "fecha")
    private Date fecha;

    @Column(name = "tipomovimiento")
    private String tipoMovimiento;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "saldo")
    private Float saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	
    

}