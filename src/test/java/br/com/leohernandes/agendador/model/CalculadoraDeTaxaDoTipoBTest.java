package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxa;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoB;

public class CalculadoraDeTaxaDoTipoBTest {
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComAteTrintaDias() {
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoB();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 28));
		BigDecimal dez = arredondar(new BigDecimal(10));
		Assert.assertEquals(dez, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComExatosTrintaDias() {
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoB();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 31));
		BigDecimal dez = arredondar(new BigDecimal(10));
		Assert.assertEquals(dez, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoBComMaisDeTrintaDias() {
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoB();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 02, 01));
		BigDecimal oito = arredondar(new BigDecimal(8));
		Assert.assertEquals(oito, calculadora.calcularTaxa(transferencia));
	}

}
