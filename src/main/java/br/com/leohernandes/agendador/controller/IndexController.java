package br.com.leohernandes.agendador.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.leohernandes.agendador.model.AgendaDeTransferencias;
import br.com.leohernandes.agendador.model.TipoDeTransferencia;
import br.com.leohernandes.agendador.model.Transferencia;

@Controller
public class IndexController {

	@Inject
	private AgendaDeTransferencias agendaDeTransferencias;
	
	@Inject
	private Result result;
	
	@Get("/")
	public void listarTransferencias() {
		result.include("tipos", TipoDeTransferencia.values());
		result.include("transferencias", agendaDeTransferencias.listarTransferencias());
	}
	
	@Post("/agendar")
	public void agendar(Transferencia transferencia) {
		agendaDeTransferencias.agendar(transferencia);
		result.redirectTo(this).listarTransferencias();
	}
}