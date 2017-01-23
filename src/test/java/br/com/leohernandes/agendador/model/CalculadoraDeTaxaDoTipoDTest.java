package br.com.leohernandes.agendador.model;


import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxa;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoC;

public class CalculadoraDeTaxaDoTipoDTest {
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorAteVinteECincoMil() {
	}
	
	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorIgualAVinteECincoMil() {
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorAteCentoEVinteMil() {
	}

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorIgualACentoEVinteMil() {
	}
	

	@Test
	public void deveCalcularATaxaDeTransferenciasDoTipoDDeValorMaiorQueCentoEVinteMil() {
	}
	
}