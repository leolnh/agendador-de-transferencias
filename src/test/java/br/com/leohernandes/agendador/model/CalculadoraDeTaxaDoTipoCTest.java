package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoC;

public class CalculadoraDeTaxaDoTipoCTest {
	
	private static final BigDecimal UM_PONTO_DOIS = arredondar(new BigDecimal(1.2));
	private static final BigDecimal DOIS_PONTO_UM = arredondar(new BigDecimal(2.1));
	private static final BigDecimal QUATRO_PONTO_TRES = arredondar(new BigDecimal(4.3));
	private static final BigDecimal CINCO_PONTO_QUATRO = arredondar(new BigDecimal(5.4));
	private static final BigDecimal OITO_PONTO_TRES = arredondar(new BigDecimal(8.3));
	private static final BigDecimal SETE_PONTO_QUATRO = arredondar(new BigDecimal(7.4));
	private static final BigDecimal SEIS_PONTO_SETE = arredondar(new BigDecimal(6.7));
	
	private final CalculadoraDeTaxaDoTipoC calculadora = new CalculadoraDeTaxaDoTipoC();
	
	private Transferencia transferencia;
	
	@Before
	public void setUp() {
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComMaisDeTrintaDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 02, 01));
		Assert.assertEquals(UM_PONTO_DOIS, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteTrintaDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 31));
		Assert.assertEquals(DOIS_PONTO_UM, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 30));
		Assert.assertEquals(DOIS_PONTO_UM, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 27));
		Assert.assertEquals(DOIS_PONTO_UM, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteVinteECincoDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 26));
		Assert.assertEquals(QUATRO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 25));
		Assert.assertEquals(QUATRO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 22));
		Assert.assertEquals(QUATRO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteVinteDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 21));
		Assert.assertEquals(CINCO_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 20));
		Assert.assertEquals(CINCO_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 17));
		Assert.assertEquals(CINCO_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteQuinzeDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 16));
		Assert.assertEquals(SEIS_PONTO_SETE, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 15));
		Assert.assertEquals(SEIS_PONTO_SETE, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 12));
		Assert.assertEquals(SEIS_PONTO_SETE, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteDezDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 11));
		Assert.assertEquals(SETE_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 10));
		Assert.assertEquals(SETE_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 07));
		Assert.assertEquals(SETE_PONTO_QUATRO, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteCincoDias() {
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 06));
		Assert.assertEquals(OITO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 05));
		Assert.assertEquals(OITO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 02));
		Assert.assertEquals(OITO_PONTO_TRES, calculadora.calcularTaxa(transferencia));
	}
	
}