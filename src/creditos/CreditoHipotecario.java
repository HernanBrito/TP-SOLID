package creditos;

import clientes.Cliente;
import propiedad.Propiedad;

public class CreditoHipotecario extends SolicitudCredito{
	
	private Propiedad garantia;

	public CreditoHipotecario(int cantidadDeCuotas, Double montoSolicitado, Cliente solicitante) {
		super(cantidadDeCuotas, montoSolicitado, solicitante);
		this.garantia = this.getSolicitante().getPropiedadMasValiosa();
	}

	@Override
	public boolean checkearCredito() {
		if(this.getMontoSolicitado() <= this.garantia.getValorFiscal() * 0.7 &&
		  (this.getMontoDeLaCuota() <= this.getSolicitante().getSueldoNetoMensual() * 0.5d ) &&
		  (this.edadSuficienteParaElCredito())
		   ){
			return true;
		}
		return false;
	}
	
	private Boolean edadSuficienteParaElCredito() {
		return ( this.getSolicitante().getEdad() + (getCantidadDeCuotas() / 12) ) <= 65;
	}
	
}
