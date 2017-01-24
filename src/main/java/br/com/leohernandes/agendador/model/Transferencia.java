package br.com.leohernandes.agendador.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Transferencia implements Serializable{
	
	private static final long serialVersionUID = 5636605851904462563L;

	@NotNull @Pattern(regexp="\\d{1,5}-\\d{1,1}", message="deve ter o formato 00000-0")
	private String contaOrigem;
	
	@NotNull @Pattern(regexp="\\d{1,5}-\\d{1,1}", message="deve ter o formato 00000-0")
	private String contaDestino;

	@NotNull 
	private BigDecimal valor;
	
	private BigDecimal taxa;
	
	@NotNull
	private LocalDate dataDaTransferencia;
		
	private LocalDate dataDoAgendamento;
	
	@NotNull
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

	public void preparar() {
		this.dataDoAgendamento = LocalDate.now();
		this.taxa = tipo.calcularTaxa(this);
	}
	
}
