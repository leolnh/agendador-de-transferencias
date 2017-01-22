package br.com.leohernandes.agendador.model;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AgendaDeTransferencias {
	
	private List<Transferencia> transferencias = new ArrayList<Transferencia>();
	
	public void agendar(Transferencia transferencia) {
		transferencias.add(transferencia);
	}
	
	public List<Transferencia> listarTransferencias() {
		return transferencias;
	}

}
