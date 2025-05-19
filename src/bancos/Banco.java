package bancos;

import java.util.ArrayList;
import java.util.List;

import clientes.Cliente;
import creditos.CreditoHipotecario;
import creditos.CreditoPersonal;
import creditos.SolicitudCredito;
import propiedad.Propiedad;

public class Banco {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<SolicitudCredito> creditos = new ArrayList<SolicitudCredito>();
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public int getCantidadDeClientes() {
		return clientes.size();
	}
	public int getCantidadDeSolicitudesDeCreditos() {
		return creditos.size();
	}
	
	public void solicitarCreditoPersonal(Double monto , int plazoEnMeses , Cliente cliente){
		if (clientes.contains(cliente)) {
			creditos.add(new CreditoPersonal(plazoEnMeses , monto , cliente));			
		}else {
			System.out.println("El cliente "+ cliente.getNombre() + cliente.getApellido() + "no se encuentra registrado en el banco.");
		}
	}
	
	public void solicitarCreditoHipotecario(Double monto, int plazoEnMeses, Cliente cliente, Propiedad propiedad) {
		if (clientes.contains(cliente)) {
			creditos.add(new CreditoHipotecario(plazoEnMeses , monto , cliente , propiedad));			
		}else {
			System.out.println("El cliente "+ cliente.getNombre() + cliente.getApellido() + "no se encuentra registrado en el banco.");
		}
	}
	
	public double calcularTotalDesembolsosAceptados() {
		for (SolicitudCredito credito : creditos) {
			credito.checkearCredito();
		}
		double totalValorCreditos = 0d;
		for (SolicitudCredito credito : creditos) {
			if(credito.fueAceptado()) {
				totalValorCreditos += credito.getMontoSolicitado();
			}
		}
		return totalValorCreditos;
	}
	
	
}
