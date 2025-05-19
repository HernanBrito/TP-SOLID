package bancos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clientes.Cliente;
import propiedad.Propiedad;

class BancoTest {

	private Propiedad p1;
	private Propiedad p2;
	private Propiedad p3;
	private Banco banco;
	private Cliente carlos;
	private Cliente juan;
	
	@BeforeEach
    public void setup() {
		banco = new Banco();
        carlos = new Cliente("Carlos", "Gonzales", 1400d, LocalDate.parse("1990-02-03"), banco);
        juan = new Cliente("Juan", "Rodriguez", 1000d, LocalDate.parse("1985-01-10"), banco); 
        p1 = new Propiedad(75000d , "Av. Libertador 7300", carlos);
        p2 = new Propiedad(25000d , "Roque Sáenz Peña 300", carlos);
        p3 = new Propiedad(50000d , "Roque Sáenz Peña 300", juan);
        banco.agregarCliente(carlos);
        banco.agregarCliente(juan);
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
		carlos.solicitarCreditoPersonal(11000d, 12);
		assertEquals(1 , banco.getCantidadDeSolicitudesDeCreditos());
		carlos.solicitarCreditoHipotecario(50000d, 36, carlos.getPropiedadMasValiosa());
		assertEquals(2 ,banco.getCantidadDeSolicitudesDeCreditos());
	}
	
	@Test
	void testearAprobacionDeCreditos() {
		carlos.solicitarCreditoPersonal(11000d, 12);
		carlos.solicitarCreditoHipotecario(25000d, 36, carlos.getPropiedadMasValiosa());
		assertEquals(36000d,banco.calcularTotalDesembolsosAceptados());
	}

}
