package br.com.leohernandes.agendador.model.calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraUtils {
	
	public static BigDecimal arredondar(BigDecimal valor) {
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
