package com.caaina.client.Popups.PopupCadastro;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class PopupCadastro extends Composite {

	private static PopupCadastroUiBinder uiBinder = GWT
			.create(PopupCadastroUiBinder.class);
	@UiField SimplePanel popupCadastro;
	@UiField Button botaoConfirma;
	@UiField Label labelMensagem;

	interface PopupCadastroUiBinder extends UiBinder<Widget, PopupCadastro> {
	}

	public PopupCadastro() {
		initWidget(uiBinder.createAndBindUi(this));
		mensagemSucesso();
		
	}
	
	
	public void mensagemSucesso(){
		labelMensagem.setText("Cadastro efetuado com sucesso!");
	}
	

	@UiHandler("botaoConfirma")
	void onBotaoConfirmaClick(ClickEvent event) {
		this.setVisible(false);
	}
}
