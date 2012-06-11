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
import com.google.gwt.user.client.ui.Image;

public class Principal extends Composite {

	private static PrincipalUiBinder uiBinder = GWT
			.create(PrincipalUiBinder.class);
	@UiField VerticalPanel principal;
	@UiField Image logo;

	interface PrincipalUiBinder extends UiBinder<Widget, Principal> {
	}

	
	private Sistema sistema;
	private Logon logon;
	private CadastraUsuario cadastra;
	
	public Principal(Sistema sistema) {
		initWidget(uiBinder.createAndBindUi(this));
		logo.setUrl("http://i49.tinypic.com/6zsvh2.jpg");
		
		logon = new Logon(sistema);
		cadastra = new CadastraUsuario(sistema);
		
		this.principal.add(logon);
		this.principal.add(cadastra);
		
		
		
		
	}

}
