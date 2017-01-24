package br.com.leohernandes.agendador.model.calculadora;

import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import br.com.leohernandes.agendador.model.Transferencia;

public class CalculadoraDeTaxaDoTipoC implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		long dias = ChronoUnit.DAYS.between(transferencia.getDataDoAgendamento(), 
				transferencia.getDataDaTransferencia());
		BigDecimal valor = transferencia.getValor();
		if (dias > 30) {
			return arredondar(new BigDecimal(1.2/100).multiply(valor));
		} else if (dias > 25) {
			return arredondar(new BigDecimal(2.1/100).multiply(valor));
		} else if (dias > 20) {
			return arredondar(new BigDecimal(4.3/100).multiply(valor));
		} else if (dias > 15) {
			return arredondar(new BigDecimal(5.4/100).multiply(valor));
		} else if (dias > 10) {
			return arredondar(new BigDecimal(6.7/100).multiply(valor));
		} else if (dias > 05) {
			return arredondar(new BigDecimal(7.4/100).multiply(valor));
		} else {
			return arredondar(new BigDecimal(8.3/100).multiply(valor));
		}
	}

}