package com.caaina.client.Widgets.Principal;

import com.caaina.client.Widgets.CadastraUsuario.CadastraUsuario;
import com.caaina.client.Widgets.LogonWidget.Logon;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HTML;
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
		HTML link1 = new HTML();
		link1.setHTML("<a href=\"http://www.facebook.com/antonioricardojr\"/>Desenvolvido por Antonio Ricardo,</a>");
		HTML link2 = new HTML();
		link2.setHTML("<a href=\"http://www.facebook.com/caaina.jeronimo\"/>Caaina Jeronimo, ");
		HTML link3 = new HTML();
		link3.setHTML("<a href=\"http://www.facebook.com/bellezeta\"/>Isabelle Cardoso</a>");
		this.principal.setCellHorizontalAlignment(cadastra, DockPanel.ALIGN_CENTER);
		this.principal.add(logon);
		this.principal.add(cadastra);
		this.principal.add(link1);
		this.principal.add(link2);
		this.principal.add(link3);
		this.principal.setCellHorizontalAlignment(cadastra, DockPanel.ALIGN_CENTER);
		this.principal.setCellHorizontalAlignment(link1, DockPanel.ALIGN_CENTER);
		this.principal.setCellHorizontalAlignment(link2, DockPanel.ALIGN_CENTER);
		this.principal.setCellHorizontalAlignment(link3, DockPanel.ALIGN_CENTER);
		
		
		
		
		
	}

}
