package br.com.leohernandes.agendador.model.calculadora;

import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;


import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

import br.com.leohernandes.agendador.model.Transferencia;

public class CalculadoraDeTaxaDoTipoB implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		long dias = ChronoUnit.DAYS.between(transferencia.getDataDoAgendamento(), 
				transferencia.getDataDaTransferencia());
		if (dias <= 30) {
			return arredondar(new BigDecimal(10));
		} else {
			return arredondar(new BigDecimal(8));
		}
	}

}