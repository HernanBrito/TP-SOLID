package bancos;

import java.util.ArrayList;
import java.util.List;

import clientes.Cliente;
import creditos.SolicitudCredito;

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
	
	public void agregarSolicitudDeCredito(SolicitudCredito credito){
			creditos.add(credito);			
	}
	
	public double calcularTotalDesembolsosAceptados() {
		double totalValorCreditos = 0d;
		for (SolicitudCredito credito : creditos) {
			if(credito.checkearCredito()) {
				totalValorCreditos += credito.getMontoSolicitado();
			}
		}
		return totalValorCreditos;
	}
	
	
}
