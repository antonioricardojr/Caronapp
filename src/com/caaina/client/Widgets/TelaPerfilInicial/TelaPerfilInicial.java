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
	private Perfil perfil;
	private Usuario usuario;
	

	interface TelaPerfilInicialUiBinder extends
			UiBinder<Widget, TelaPerfilInicial> {
	}

	public TelaPerfilInicial(Perfil perfil) {
		initWidget(uiBinder.createAndBindUi(this));
		setPerfil(perfil);
		usuario = perfil.getSistema().getUsuario(perfil.getSessao().getLogin());
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
