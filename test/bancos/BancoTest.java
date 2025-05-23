package bancos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clientes.Cliente;
import creditos.SolicitudCredito;
import creditos.CreditoPersonal;
import creditos.CreditoHipotecario;
import propiedad.Propiedad;

class BancoTest {

	private Propiedad p1;
	private Propiedad p2;
	private Propiedad p3;
	private Banco banco;
	private Cliente carlos;
	private Cliente juan;
	private SolicitudCredito creditoPersonal1;
	private SolicitudCredito creditoPersonal2;
	private SolicitudCredito creditoHipotecario1;
	private SolicitudCredito creditoHipotecario2;
	
	
	@BeforeEach
    public void setup() {
		banco = new Banco();
        carlos = new Cliente("Carlos", "Gonzales", 1400d, LocalDate.parse("1990-02-03"), banco);
        juan = new Cliente("Juan", "Rodriguez", 1700d, LocalDate.parse("1985-01-10"), banco); 
        p1 = new Propiedad(75000d , "Av. Libertador 7300", carlos);
        p2 = new Propiedad(25000d , "Roque Sáenz Peña 300", carlos);
        p3 = new Propiedad(25000d , "Roque Sáenz Peña 300", juan);
        banco.agregarCliente(carlos);
        banco.agregarCliente(juan);
        creditoPersonal1 = new CreditoPersonal(12 , 11000d, carlos);
        creditoHipotecario1 = new CreditoHipotecario(72 , 50000d, carlos);
        creditoPersonal2 = new CreditoPersonal(18, 10000d, juan);
        creditoHipotecario2 = new CreditoHipotecario(96 , 70000d, juan);
    }
	
	@Test
	void testCantidadDePropiedades() {
		assertEquals(2 , carlos.getCantidadDePropiedades());
		assertEquals(1 , juan.getCantidadDePropiedades());

	}
	@Test
	void testGetTitular() {
		assertEquals(carlos, p1.getTitular());
		assertEquals(carlos, p2.getTitular());
		assertEquals(juan, p3.getTitular());
	}
	
	@Test
	void testCarlosSolicitarCreditoPersonalYHipotecario() {
		banco.agregarSolicitudDeCredito(creditoHipotecario1);
		assertEquals(1 , banco.getCantidadDeSolicitudesDeCreditos());
		banco.agregarSolicitudDeCredito(creditoPersonal1);
		assertEquals(2 ,banco.getCantidadDeSolicitudesDeCreditos());
	}
	
	
	//el credito hipotecario2 no se aprueba porque el monto de la propiedad de juan es muy barata a comparacion
	//del monto que pide la solicitud de credito
	@Test
	void testearAprobacionDeCreditos() {
		banco.agregarSolicitudDeCredito(creditoHipotecario1);
		banco.agregarSolicitudDeCredito(creditoPersonal1);
		banco.agregarSolicitudDeCredito(creditoHipotecario2);// no se acepta
		banco.agregarSolicitudDeCredito(creditoPersonal2);
		assertEquals(71000d, banco.calcularTotalDesembolsosAceptados());
	}

}
