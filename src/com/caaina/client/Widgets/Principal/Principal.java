package com.caaina.client.Widgets.Principal;

import com.caaina.client.Widgets.CadastraUsuario.CadastraUsuario;
import com.caaina.client.Widgets.LogonWidget.Logon;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Principal extends Composite {

	private static PrincipalUiBinder uiBinder = GWT
			.create(PrincipalUiBinder.class);
	@UiField VerticalPanel principal;

	interface PrincipalUiBinder extends UiBinder<Widget, Principal> {
	}

	
	private Sistema sistema;
	private Logon logon;
	private CadastraUsuario cadastra;
	
	public Principal(Sistema sistema) {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		logon = new Logon(sistema);
		cadastra = new CadastraUsuario(sistema);
		
		this.principal.add(logon);
		this.principal.add(cadastra);
		
		
		
		
	}

}
