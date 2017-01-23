package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoB;

public class CalculadoraDeTaxaDoTipoBTest {
	
	private static final BigDecimal OITO = arredondar(new BigDecimal(8));
	private static final BigDecimal DEZ = arredondar(new BigDecimal(10));
	
	private  final CalculadoraDeTaxaDoTipoB calculadora = new CalculadoraDeTaxaDoTipoB();
	
	private Transferencia transferencia = new Transferencia();
	
	@Before
	public void setUp() {
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComAteTrintaDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 28));
		Assert.assertEquals(DEZ, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComExatosTrintaDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 31));
		BigDecimal dez = arredondar(new BigDecimal(10));
		Assert.assertEquals(dez, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComMaisDeTrintaDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 02, 01));
		Assert.assertEquals(OITO, calculadora.calcularTaxa(transferencia));
	}

}