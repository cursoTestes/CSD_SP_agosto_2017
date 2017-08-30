package br.com.k21;

import org.junit.Test;

import br.com.k21.dao.VendaDAO;
import br.com.k21.infra.BaseDBTest;
import junit.framework.Assert;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotalVendasParaVendedorComVendasEmAnosDiferentes() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 600.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testTotalVendasParaVendaCompartilhadaComDoisVendedores() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 6;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2014;
		double resultado;
		double esperado = 600.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);

		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testVendedorSemVenda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2001;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		try {
			VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
			fail();
		} catch (RuntimeException e) {
			Assert.assertEquals("Sem venda", e.getMessage());
		}
	}
	

}

