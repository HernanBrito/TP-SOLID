package clientes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bancos.Banco;
import propiedad.Propiedad;

public class Cliente {
	private String nombre;
	private String apellido;
	private Double sueldoNetoMensual;
	private LocalDate fecNac;
	private Banco banco;
	private List<Propiedad> propiedades = new ArrayList<Propiedad>();
	
	
	public Cliente(String nombre, String apellido, Double sueldoNetoMensual, LocalDate fecNac, Banco banco) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoNetoMensual = sueldoNetoMensual;
		this.fecNac = fecNac;
		this.banco = banco;
	}
	
	public Banco getBanco() {
		return banco;
	}
	
	public Double getSueldoNetoMensual() {
		return sueldoNetoMensual;
	}
	
	public double getSueldoNetoAnual() {
		return (sueldoNetoMensual*12);
	}
	
	public void setSueldoNetoMensualDouble(Double sueldoNetoMensual) {
		this.sueldoNetoMensual = sueldoNetoMensual;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
    public int getEdad() {
        return (int) ChronoUnit.YEARS.between(fecNac, LocalDate.now());
    }
    
    public void solicitarCreditoPersonal(Double monto , int plazoEnMeses){
    	this.getBanco().solicitarCreditoPersonal(monto, plazoEnMeses, this);
    }
    
    public void solicitarCreditoHipotecario(Double monto , int plazoEnMeses, Propiedad propiedad){
    	this.getBanco().solicitarCreditoHipotecario(monto, plazoEnMeses, this, propiedad);
    }
	
    public void addPropiedad(Propiedad propiedad) {
    	propiedades.add(propiedad);
    }
    
    public int getCantidadDePropiedades() {
    	return propiedades.size();
    }
    
	public Propiedad getPropiedad(int indice) {
		return propiedades.get(indice);
	}
	
	public Propiedad getPropiedadMasValiosa() {
		return Collections.max(propiedades, Comparator.comparing(Propiedad::getValorFiscal));
	}
	
}
