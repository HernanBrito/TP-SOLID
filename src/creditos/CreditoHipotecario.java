package creditos;

import clientes.Cliente;
import propiedad.Propiedad;

public class CreditoHipotecario extends SolicitudCredito{
	
	private Propiedad garantia;

	public CreditoHipotecario(int cantidadDeCuotas, Double montoSolicitado, Cliente solicitante, Propiedad propiedad) {
		super(cantidadDeCuotas, montoSolicitado, solicitante);
		this.garantia = propiedad;
	}

	@Override
	public void checkearCredito() {
		if(this.getMontoSolicitado() < this.garantia.getValorFiscal() &&
				(this.getMontoDeLaCuota() < this.getSolicitante().getSueldoNetoMensual() * 0.5d ) &&
				(this.edadSuficienteParaElCredito())
		   ){
			this.aceptarCredito();
		}
	}
	
	private Boolean edadSuficienteParaElCredito() {
		return ( this.getSolicitante().getEdad() + (getCantidadDeCuotas() / 12) ) <= 65;
	}
	
}
