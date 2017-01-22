package br.com.leohernandes.agendador.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.leohernandes.agendador.model.AgendaDeTransferencias;
import br.com.leohernandes.agendador.model.Transferencia;

@Controller
public class IndexController {

	@Inject
	private AgendaDeTransferencias agendaDeTransferencias;
	
	@Inject
	private Result result;
	
	@Get("/")
	public void index() {
		result.include("transferencias", agendaDeTransferencias.listarTransferencias());
	}
	
	@Get("/agendar")
	public void agendar(Transferencia transferencia) {
		agendaDeTransferencias.agendar(transferencia);
	}
}