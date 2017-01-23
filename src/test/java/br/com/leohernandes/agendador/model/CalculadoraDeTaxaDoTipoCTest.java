package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxa;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoC;

public class CalculadoraDeTaxaDoTipoCTest {
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComMaisDeTrintaDias() {
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 02, 01));
		BigDecimal umPontoDois = arredondar(new BigDecimal(1.2));
		Assert.assertEquals(umPontoDois, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteTrintaDias() {
		BigDecimal doisPontoUm = arredondar(new BigDecimal(2.1));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 31));
		Assert.assertEquals(doisPontoUm, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 30));
		Assert.assertEquals(doisPontoUm, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 27));
		Assert.assertEquals(doisPontoUm, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteVinteECincoDias() {
		BigDecimal quatroPontoTres = arredondar(new BigDecimal(4.3));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 26));
		Assert.assertEquals(quatroPontoTres, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 25));
		Assert.assertEquals(quatroPontoTres, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 22));
		Assert.assertEquals(quatroPontoTres, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteVinteDias() {
		BigDecimal cincoPontoQuatro = arredondar(new BigDecimal(5.4));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 21));
		Assert.assertEquals(cincoPontoQuatro, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 20));
		Assert.assertEquals(cincoPontoQuatro, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 17));
		Assert.assertEquals(cincoPontoQuatro, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteQuinzeDias() {
		BigDecimal seisPontoSete = arredondar(new BigDecimal(6.7));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 16));
		Assert.assertEquals(seisPontoSete, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 15));
		Assert.assertEquals(seisPontoSete, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 12));
		Assert.assertEquals(seisPontoSete, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteDezDias() {
		BigDecimal setePontoQuatro = arredondar(new BigDecimal(7.4));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 11));
		Assert.assertEquals(setePontoQuatro, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 10));
		Assert.assertEquals(setePontoQuatro, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 07));
		Assert.assertEquals(setePontoQuatro, calculadora.calcularTaxa(transferencia));
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoCComAteCincoDias() {
		BigDecimal oitoPontoTrez = arredondar(new BigDecimal(8.3));
		CalculadoraDeTaxa calculadora = new CalculadoraDeTaxaDoTipoC();
		Transferencia transferencia = new Transferencia();
		transferencia.setValor(new BigDecimal(100));
		transferencia.setDataDoAgendamento(LocalDate.of(2017, 01, 01));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 06));
		Assert.assertEquals(oitoPontoTrez, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 05));
		Assert.assertEquals(oitoPontoTrez, calculadora.calcularTaxa(transferencia));
		transferencia.setDataDaTransferencia(LocalDate.of(2017, 01, 02));
		Assert.assertEquals(oitoPontoTrez, calculadora.calcularTaxa(transferencia));
	}
	
}
