package creditos;

import clientes.Cliente;

public abstract class SolicitudCredito {
	private Double montoDeLaCuota;
	private int cantidadDeCuotas;
	private Double montoSolicitado;
	private Cliente solicitante;
	
	public Double getMontoDeLaCuota() {
		return montoDeLaCuota;
	}

	public int getCantidadDeCuotas() {
		return cantidadDeCuotas;
	}

	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	
	public SolicitudCredito(int cantidadDeCuotas, Double montoSolicitado, Cliente solicitante) {
		this.montoDeLaCuota = montoSolicitado/cantidadDeCuotas;
		this.cantidadDeCuotas = cantidadDeCuotas;
		this.montoSolicitado = montoSolicitado;
		this.solicitante = solicitante;
	}

	abstract public boolean checkearCredito();

	public Cliente getSolicitante() {
		return solicitante;
	}

}
