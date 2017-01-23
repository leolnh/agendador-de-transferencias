package br.com.leohernandes.agendador.model.calculadora;

import java.math.BigDecimal;

import br.com.leohernandes.agendador.model.Transferencia;

public interface CalculadoraDeTaxa {
	
	public BigDecimal calcularTaxa(Transferencia transferencia);

}
