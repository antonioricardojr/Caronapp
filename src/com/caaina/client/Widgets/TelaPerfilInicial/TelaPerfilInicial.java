package com.caaina.client.Widgets.TelaPerfilInicial;

import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.logica.Usuario;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

public class TelaPerfilInicial extends Composite {

	private static TelaPerfilInicialUiBinder uiBinder = GWT
			.create(TelaPerfilInicialUiBinder.class);
	@UiField HTMLPanel telaPerfilInicial;
	@UiField VerticalPanel painelPerfil;
	@UiField Label nome;
	@UiField Label login;
	@UiField Label email;
	@UiField Label endereco;
	@UiField Label nomeFacebook;
	private Perfil perfil;
	private Usuario usuario;
	

	interface TelaPerfilInicialUiBinder extends
			UiBinder<Widget, TelaPerfilInicial> {
	}

	@SuppressWarnings("static-access")
	public TelaPerfilInicial(Perfil perfil) {
		initWidget(uiBinder.createAndBindUi(this));
		setPerfil(perfil);
		usuario = perfil.getSistema().getUsuario(perfil.getSessao().getLogin());
		login.setText("login: " + usuario.getLogin());
		nome.setText("Usuario: " + usuario.getNome());
		endereco.setText("Endereco: " + usuario.getEndereco());
		email.setText("E-mail: " + usuario.getEmail());
		nomeFacebook.setText(getPerfil().getFacebook().mostraNome());
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
