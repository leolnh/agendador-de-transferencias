package br.com.leohernandes.agendador.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;

public class Transferencia {
	
	private String contaOrigem;
	
	private String contaDestino;

	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	private LocalDate dataDaTransferencia;
	
	@Future
	private LocalDate dataDoAgendamento;
	
	private TipoDeTransferencia tipo;

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public LocalDate getDataDaTransferencia() {
		return dataDaTransferencia;
	}

	public void setDataDaTransferencia(LocalDate dataDaTransferencia) {
		this.dataDaTransferencia = dataDaTransferencia;
	}

	public LocalDate getDataDoAgendamento() {
		return dataDoAgendamento;
	}

	public void setDataDoAgendamento(LocalDate dataDoAgendamento) {
		this.dataDoAgendamento = dataDoAgendamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoDeTransferencia getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTransferencia tipo) {
		this.tipo = tipo;
	}

	public void calcularTaxa() {
		this.taxa = tipo.calcularTaxa(this);
	}
	
}
