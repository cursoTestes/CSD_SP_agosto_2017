package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QualOperadoraTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		if()
		return new ChromeDriver();
	}
	
	@Test
	public void teste_operadora_tim() {
		abrirPaginaQualOperadora();
		preencherNumeroTelefone("82999201870");
		click("#bto");
		String operadora = findFirst(".resultado img").getAttribute("title");
		Assert.assertEquals("TIM", operadora);					
	}


	@Test
	public void teste_operadora_vivo() {
		abrirPaginaQualOperadora();
		preencherNumeroTelefone("82999201810");
		click("#bto");
		String operadora = findFirst(".resultado img").getAttribute("title");
		Assert.assertEquals("VIVO", operadora);					
	}	
	
	private void abrirPaginaQualOperadora() {
		goTo("http://qualoperadora.info/");
	}	


	private void preencherNumeroTelefone(String numero) {
		fill("#tel").with(numero);
	}

}
