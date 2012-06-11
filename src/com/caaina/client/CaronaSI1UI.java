package com.caaina.client;

import com.caaina.client.Widgets.CadastraUsuario.CadastraUsuario;
import com.caaina.client.Widgets.LogonWidget.Logon;
import com.caaina.client.Widgets.Principal.Principal;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CaronaSI1UI implements EntryPoint {

	private Sistema sistema;
	
	private Principal principal;

	@Override
	public void onModuleLoad() {
		sistema = new Sistema();
		try {
			sistema.criarUsuario("admin", "admin", "admin", "admin", "admin@admin.com");
			Sessao id = sistema.abrirSessao("admin", "admin");
			sistema.criarUsuario("si1", "si1si1", "admino", "admino", "admino@admin.com");
			sistema.criarUsuario("caieu", "caieu", "Caaina Jeronimo", "Av. Floriano Peixoto", "caainaje@gmail.com");
			sistema.criarUsuario("ze", "zeze", "Jose de Ze", "Rua do Jose", "ze@ze.com");
			sistema.criarUsuario("maoe", "bucataOE", "Silvio", "Av. Anhanguera", "silvio@sbt.com");
			sistema.cadastrarCarona(id.getId(), "Campina Grande", "Recife", "11/06/2013", "12:12", "3");
			sistema.cadastrarCarona(id.getId(), "Joao Pessoa", "Recife", "11/08/2013", "08:03", "5");
			sistema.cadastrarCarona(id.getId(), "Campina Grande", "Joao Pessoa", "11/09/2013", "10:50", "3");
			sistema.cadastrarCarona(id.getId(), "Campina Grande", "Recife", "14/06/2013", "22:42", "3");
			sistema.cadastrarCarona(id.getId(), "Joao Pessoa", "Recife", "03/11/2013", "12:12", "8");
			sistema.cadastrarCarona(id.getId(), "Campina Grande", "Joao Pessoa", "12/09/2013", "12:12", "9");
			sistema.cadastrarCarona(id.getId(), "Sao Paulo", "Jundiai", "30/10/2013", "12:12", "5");
			sistema.cadastrarCarona(id.getId(), "Manaus", "Belem", "04/04/2013", "02:00", "7");
			sistema.cadastrarCarona(id.getId(), "Campina Grande", "Joao Pessoa", "11/06/2013", "12:12", "3");
			sistema.cadastrarCarona(id.getId(), "Joao Pessoa", "Recife", "11/09/2013", "10:03", "5");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		principal = new Principal(sistema);
		
		RootPanel.get("principal").add(principal);
		
		
	}
	
	
}
