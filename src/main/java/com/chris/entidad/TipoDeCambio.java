package com.chris.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipodecambio")
public class TipoDeCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "moneda_origen")
	private String monedaOrigen;
	
	@Column(name = "moneda_destino")
	private String monedaDestino;
	
	@Column(name = "monto")
	private Double monto;
	
	@Column(name = "monto_tipo_de_cambio")
	private Double montoTipoDeCambio;
	
	@Column(name = "tipo_de_cambio")
	private Double tipoDeCambio;
		
	public TipoDeCambio() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getMontoTipoDeCambio() {
		return montoTipoDeCambio;
	}

	public void setMontoTipoDeCambio(Double montoTipoDeCambio) {
		this.montoTipoDeCambio = montoTipoDeCambio;
	}

	public Double getTipoDeCambio() {
		return tipoDeCambio;
	}

	public void setTipoDeCambio(Double tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
	}

	@Override
	public String toString() {
		return "TipoDeCambio [id=" + id + ", monedaOrigen=" + monedaOrigen + ", monedaDestino=" + monedaDestino
				+ ", monto=" + monto + ", montoTipoDeCambio=" + montoTipoDeCambio + ", tipoDeCambio=" + tipoDeCambio
				+ "]";
	}

}
