package creditos;

import clientes.Cliente;

public class CreditoPersonal extends SolicitudCredito {
	
	
	public CreditoPersonal(int cantidadDeCuotas, Double montoSolicitado, Cliente solicitante) {
		super(cantidadDeCuotas, montoSolicitado, solicitante);
	}

	@Override
	public boolean checkearCredito() {
		if(this.getSolicitante().getSueldoNetoAnual() > 15000d &&
				(this.getMontoDeLaCuota() < this.getSolicitante().getSueldoNetoMensual() * 0.7d )
		   ){
			return true;
		}
		return false;
	}
	
}
