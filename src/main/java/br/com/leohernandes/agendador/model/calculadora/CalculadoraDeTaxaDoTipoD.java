package br.com.leohernandes.agendador.model.calculadora;

import java.math.BigDecimal;

import br.com.leohernandes.agendador.model.Transferencia;

public class CalculadoraDeTaxaDoTipoD implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		return new BigDecimal(0);
	}

}