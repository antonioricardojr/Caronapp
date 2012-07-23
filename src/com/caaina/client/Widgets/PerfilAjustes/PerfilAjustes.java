package com.caaina.client.Widgets.PerfilAjustes;

import com.caaina.client.FacebookLogin.FacebookLogin;
import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

public class PerfilAjustes extends Composite {

	private static PerfilAjustesUiBinder uiBinder = GWT
			.create(PerfilAjustesUiBinder.class);
	@UiField Label campoNome;
	@UiField HorizontalPanel linhaNome;
	@UiField Label nomeLabel;
	@UiField HorizontalPanel linhaEndereco;
	@UiField TextBox campoEndereco;
	@UiField HorizontalPanel linhaEmail;
	@UiField Button botaoSalvar;
	@UiField HorizontalPanel linhaFacebook;
	@UiField TextBox campoEmail;
	private FacebookLogin facebook;
	
	private Perfil perfil;

	interface PerfilAjustesUiBinder extends UiBinder<Widget, PerfilAjustes> {
	}

	public PerfilAjustes(Perfil perfil) {
		facebook = new FacebookLogin();
		initWidget(uiBinder.createAndBindUi(this));
		setPerfil(perfil);
		campoNome.setText(getPerfil().getSistema().getUsuario(getPerfil().getLogin()).getNome());
		campoEndereco.setText(getPerfil().getSistema().getUsuario(getPerfil().getLogin()).getEndereco());
		campoEmail.setText(getPerfil().getSistema().getUsuario(getPerfil().getLogin()).getEmail());
		linhaFacebook.add(facebook);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public FacebookLogin getFacebook() {
		return facebook;
	}

	public void setFacebook(FacebookLogin facebook) {
		this.facebook = facebook;
	}

}
