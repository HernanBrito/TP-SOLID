package propiedad;

import clientes.Cliente;

public class Propiedad {
	private double valorFiscal;
	private String direccion;
	private Cliente titular;
	
	public double getValorFiscal() {
		return valorFiscal;
	}
	
	public Propiedad(double valorFiscal, String direccion, Cliente titular) {
		super();
		this.valorFiscal = valorFiscal;
		this.direccion = direccion;
		this.titular = titular;
		titular.addPropiedad(this);
	}

	public String getDireccion() {
		return direccion;
	}
	
	public Cliente getTitular() {
		return titular;
	}
}
