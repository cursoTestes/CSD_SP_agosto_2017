package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimulacaoFinanciamentoTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new ChromeDriver();
	}
	
	public void teste_financiamento_prazos_minimos() {
		abrirPaginaSimulacaoFinanciamento();
		fill("#valorBem").with("100000,00");
		fill("#prazoFinanciamento").with("4");
		fill("#prazoCarencia").with("3");
		fill("#spreadAgente").with("9,0");
		click("#btformsimulador");
		
		await().atMost(10000).until("#taxaJuros").areDisplayed();
		Assert.assertEquals("18,20", findFirst("#taxaJuros").getText());					
	}	
	
	@Test
	public void teste_financiamento_prazos_maximos() {
		abrirPaginaSimulacaoFinanciamento();
		digitarValorASerFinanciado("10000000");
		fill("#prazoFinanciamento").with("16");
		fill("#prazoCarencia").with("12");
		fill("#spreadAgente").with("9,0");
		click("#btformsimulador");
		
		await().atMost(10000).until("#taxaJuros").areDisplayed();
		Assert.assertEquals("18,20", findFirst("#taxaJuros").getText());					
	}

	private void abrirPaginaSimulacaoFinanciamento() {
		goTo("http://www.bndes.gov.br/wps/portal/site/home/financiamento/simulador/?productCode=AOI_009");
	}

	private void digitarValorASerFinanciado( String valor) {
		fill("#valorBem").with(valor);
	}
	
	
	public void teste_financiamento_alteracao_pos_simulacao() {
		abrirPaginaSimulacaoFinanciamento();
		fill("#valorBem").with("100000,00");
		fill("#prazoFinanciamento").with("4");
		fill("#prazoCarencia").with("3");
		fill("#spreadAgente").with("9,0");
		click("#btformsimulador");
		
		await().atMost(10000).until("#taxaJuros").areDisplayed();
		Assert.assertEquals("18,20", findFirst("#taxaJuros").getText());					
	}
}
