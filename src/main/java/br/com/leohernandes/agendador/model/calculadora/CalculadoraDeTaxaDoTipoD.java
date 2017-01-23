package br.com.leohernandes.agendador.model.calculadora;

import java.math.BigDecimal;

import br.com.leohernandes.agendador.model.Transferencia;

public class CalculadoraDeTaxaDoTipoD implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		if (transferencia.getValor().compareTo(new BigDecimal(25000)) <= 0) {
			return new CalculadoraDeTaxaDoTipoA().calcularTaxa(transferencia);
		} else if (transferencia.getValor().compareTo(new BigDecimal(120000)) <= 0) {
			return new CalculadoraDeTaxaDoTipoB().calcularTaxa(transferencia);
		} else {
			return new CalculadoraDeTaxaDoTipoC().calcularTaxa(transferencia);
		}
    }
}