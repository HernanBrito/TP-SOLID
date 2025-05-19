package creditos;

import clientes.Cliente;

public abstract class SolicitudCredito {
	private Double montoDeLaCuota;
	private int cantidadDeCuotas;
	private Double montoSolicitado;
	private Cliente solicitante;
	private Boolean aceptada = false;
	
	public Double getMontoDeLaCuota() {
		return montoDeLaCuota;
	}

	public int getCantidadDeCuotas() {
		return cantidadDeCuotas;
	}

	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	public Cliente getSolicitante() {
		return solicitante;
	}

	
	public SolicitudCredito(int cantidadDeCuotas, Double montoSolicitado, Cliente solicitante) {
		this.montoDeLaCuota = montoSolicitado/cantidadDeCuotas;
		this.cantidadDeCuotas = cantidadDeCuotas;
		this.montoSolicitado = montoSolicitado;
		this.solicitante = solicitante;
	}

	abstract public void checkearCredito();
	
	public Boolean fueAceptado() {
		return aceptada;
	}
	
	public void aceptarCredito() {
		aceptada = true;
	}
}
