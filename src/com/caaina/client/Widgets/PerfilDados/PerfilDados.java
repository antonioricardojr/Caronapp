package com.caaina.client.Widgets.PerfilDados;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Label;

public class PerfilDados extends Composite {

	private static PerfilDadosUiBinder uiBinder = GWT
			.create(PerfilDadosUiBinder.class);
	@UiField LayoutPanel dadosPerfil;
	@UiField Label campoNome;
	@UiField Label campoEndereco;
	@UiField Label campoEmail;

	interface PerfilDadosUiBinder extends UiBinder<Widget, PerfilDados> {
	}

	public PerfilDados(String nome, String endereco, String email) {
		initWidget(uiBinder.createAndBindUi(this));
		
		campoNome.setText(nome);
		campoEndereco.setText(endereco);
		campoEmail.setText(email);
		
	}

}
