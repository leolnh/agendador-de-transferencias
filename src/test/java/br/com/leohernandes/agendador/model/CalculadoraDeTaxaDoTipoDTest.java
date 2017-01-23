package br.com.leohernandes.agendador.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoA;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoB;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoC;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoD;

public class CalculadoraDeTaxaDoTipoDTest {
	
	private final CalculadoraDeTaxaDoTipoD calculadora = new CalculadoraDeTaxaDoTipoD();
	
	private Transferencia transferencia;
	
	@Before
	public void setUp() {
		transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 30));
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorAteVinteECincoMil() {
		transferencia.setValor(new BigDecimal(22000));
		BigDecimal taxaDoTipoA = new CalculadoraDeTaxaDoTipoA().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoA, calculadora.calcularTaxa(transferencia));
		transferencia.setValor(new BigDecimal(24999.50));
		taxaDoTipoA = new CalculadoraDeTaxaDoTipoA().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoA, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorIgualAVinteECincoMil() {
		transferencia.setValor(new BigDecimal(25000));
		BigDecimal taxaDoTipoA = new CalculadoraDeTaxaDoTipoA().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoA, calculadora.calcularTaxa(transferencia));
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorAteCentoEVinteMil() {
		transferencia.setValor(new BigDecimal(25000.50));
		BigDecimal taxaDoTipoB = new CalculadoraDeTaxaDoTipoB().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoB, calculadora.calcularTaxa(transferencia));
		transferencia.setValor(new BigDecimal(119999.50));
		taxaDoTipoB = new CalculadoraDeTaxaDoTipoB().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoB, calculadora.calcularTaxa(transferencia));
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorIgualACentoEVinteMil() {
		transferencia.setValor(new BigDecimal(120000));
		BigDecimal taxaDoTipoB = new CalculadoraDeTaxaDoTipoB().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoB, calculadora.calcularTaxa(transferencia));
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorMaiorQueCentoEVinteMil() {
		transferencia.setValor(new BigDecimal(120000.50));
		BigDecimal taxaDoTipoC = new CalculadoraDeTaxaDoTipoC().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoC, calculadora.calcularTaxa(transferencia));
		transferencia.setValor(new BigDecimal(200000));
		taxaDoTipoC = new CalculadoraDeTaxaDoTipoC().calcularTaxa(transferencia);
		Assert.assertEquals(taxaDoTipoC, calculadora.calcularTaxa(transferencia));
	}
	
}