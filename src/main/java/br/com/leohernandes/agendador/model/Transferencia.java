package br.com.leohernandes.agendador.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transferencia {
	
	private String contaOrigem;
	
	private String contaDestino;

	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	private LocalDate dataDaTransferencia;
	
	private LocalDate dataDoAgendamento;

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
	
}