package com.caaina.client.Widgets.TelaPerfilInicial;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;

public class TelaPerfilInicial extends Composite {

	private static TelaPerfilInicialUiBinder uiBinder = GWT
			.create(TelaPerfilInicialUiBinder.class);
	@UiField HTMLPanel telaPerfilInicial;

	interface TelaPerfilInicialUiBinder extends
			UiBinder<Widget, TelaPerfilInicial> {
	}

	public TelaPerfilInicial() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
