package br.com.leohernandes.agendador.model.calculadora;

import static br.com.leohernandes.agendador.model.calculadora.CalculadoraUtils.arredondar;

import java.math.BigDecimal;

import br.com.leohernandes.agendador.model.Transferencia;

public class CalculadoraDeTaxaDoTipoA implements CalculadoraDeTaxa {

	@Override
	public BigDecimal calcularTaxa(Transferencia transferencia) {
		BigDecimal taxa = transferencia.getValor()
				.multiply(new BigDecimal(0.03))
				.add(new BigDecimal(2));
		return arredondar(taxa);
	}

}
