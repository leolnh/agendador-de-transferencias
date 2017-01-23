package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoA;

public class CalculadoraDeTaxaDoTipoATest {
	
private Transferencia transferencia;

	private final static BigDecimal CINCO = arredondar(new BigDecimal(5));

	private final CalculadoraDeTaxaDoTipoA calculadora = new CalculadoraDeTaxaDoTipoA();

	@Before
	public void setUp() {
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoA() {
		Assert.assertEquals(CINCO, calculadora.calcularTaxa(transferencia));
	}

}
