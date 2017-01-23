package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxa;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoA;

public class CalculadoraDeTaxaDoTipoATest {
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoA() {
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoA();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		BigDecimal cinco = arredondar(new BigDecimal(5));
		Assert.assertEquals(cinco, calculadora.calcularTaxa(transferencia));
	}

}
