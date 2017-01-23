package br.com.leohernandes.agendador.model;

import java.math.BigDecimal;

import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxa;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoA;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoB;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoC;
import br.com.leohernandes.agendador.model.calculadora.CalculadoraDeTaxaDoTipoD;

public enum TipoDeTransferencia {
	
	A(new CalculadoraDeTaxaDoTipoA()), 
	B(new CalculadoraDeTaxaDoTipoB()), 
	C(new CalculadoraDeTaxaDoTipoC()), 
	D(new CalculadoraDeTaxaDoTipoD());
	
	private final CalculadoraDeTaxa calculadoraDeTaxa;

	private TipoDeTransferencia(CalculadoraDeTaxa calculadoraDeTaxa) {
		this.calculadoraDeTaxa = calculadoraDeTaxa;
	}

	public BigDecimal calcularTaxa(Transferencia transferencia) {
		return calculadoraDeTaxa.calcularTaxa(transferencia);
	}

}
