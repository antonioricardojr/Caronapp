package com.caaina.client.Widgets.AjustesPerfil;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class AjustesPerfil extends Composite {

	private static AjustesPerfilUiBinder uiBinder = GWT
			.create(AjustesPerfilUiBinder.class);
	@UiField HorizontalPanel linhaNome;
	@UiField HorizontalPanel linhaEmail;
	@UiField TextBox campoEmail;
	@UiField Label campoNome;
	@UiField TextBox campoEndereço;
	@UiField HorizontalPanel linhaEndereço;

	interface AjustesPerfilUiBinder extends UiBinder<Widget, AjustesPerfil> {
	}

	public AjustesPerfil() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
