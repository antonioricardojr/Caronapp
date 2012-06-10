package com.caaina.client.Widgets.CadastraUsuario;

import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;

public class CadastraUsuario extends Composite {

	private static CadastraUsuarioUiBinder uiBinder = GWT
			.create(CadastraUsuarioUiBinder.class);
	@UiField TextBox campoNome;
	@UiField TextBox campoEmail;
	@UiField PasswordTextBox campoSenha;
	@UiField TextBox campoLogin;
	@UiField TextBox campoEndereco;
	@UiField Button botaoCadastrar;
	
	private Sistema sistema;

	interface CadastraUsuarioUiBinder extends UiBinder<Widget, CadastraUsuario> {
	}

	public CadastraUsuario(Sistema sistema) {
		initWidget(uiBinder.createAndBindUi(this));
		setSistema(sistema);
		
		
		//setStyleName("cadastraUsuario");
	}
	

	
	public Sistema getSistema() {
		return sistema;
	}



	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}



	@UiHandler("campoLogin")
	void onCampoLogin(ClickEvent event) {
		campoLogin.setText("");
	}
	
	@UiHandler("campoNome")
	void onCampoNome(ClickEvent event) {
		campoNome.setText("");
	}
	
	@UiHandler("campoEndereco")
	void onCampoEndereco(ClickEvent event) {
		campoEndereco.setText("");
	}
	
	@UiHandler("campoEmail")
	void onCampoEmail(ClickEvent event) {
		campoEmail.setText("");
	}
	
	@UiHandler("campoSenha")
	void onCampoSenhaClick(ClickEvent event) {
		campoSenha.setText("");
	}

	@UiHandler("botaoCadastrar")
	void onBotaoCadastrarClick(ClickEvent event) {
		String login = campoLogin.getText();
		String nome = campoNome.getText();
		String endereco = campoEndereco.getText();
		String email = campoEmail.getText();
		String senha = campoSenha.getText();
		
		try {
			sistema.criarUsuario(login, senha, nome, endereco, email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
