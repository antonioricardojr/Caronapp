package com.caaina.client;

import com.caaina.client.Widgets.CadastraUsuario.CadastraUsuario;
import com.caaina.client.Widgets.LogonWidget.Logon;
import com.caaina.client.Widgets.Principal.Principal;
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
		
		principal = new Principal(sistema);
		
		RootPanel.get("principal").add(principal);
		
		
	}
	
	
}
