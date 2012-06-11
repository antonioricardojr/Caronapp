package com.caaina.client.Widgets.LogonWidget;


import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.excecoes.AtributoInvalidoException;
import com.caaina.client.excecoes.ItemInexistenteException;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.PasswordTextBox;



public class Logon extends Composite {

	private Sistema sistema;
	private static LogonUiBinder uiBinder = GWT.create(LogonUiBinder.class);
	@UiField Button confirma;
	@UiField Grid gridCentral;
	@UiField TextBox caixaLogin;
	@UiField PasswordTextBox caixaSenha;
	private Sessao sessao;


	interface LogonUiBinder extends UiBinder<Widget, Logon> {
	}

	public Logon(Sistema sistema) {
		initWidget(uiBinder.createAndBindUi(this));
		setStyleName("logon");
		setSistema(sistema);
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}

	@UiHandler("confirma")
	void onConfirmaClick(ClickEvent event){
		String login = caixaLogin.getText();
		String senha = caixaSenha.getText();
		logar(login, senha);
		if(sessao!=null){
			RootPanel.get("principal").clear();
			Perfil p = new Perfil(sessao, sistema);
			RootPanel.get("perfil").add(p);
			
		}
	}
	
	@UiHandler("caixaSenha")
	void onCaixaSenhaClick(ClickEvent event) {
		caixaSenha.setText("");
	}
	@UiHandler("caixaLogin")
	void onCaixaLoginClick(ClickEvent event) {
		caixaLogin.setText("");
	}
	
	private Sessao logar(String login, String senha){
		try{
			sessao = sistema.abrirSessao(login, senha);		
		}catch(AtributoInvalidoException e){
			sessao = null;
			return sessao;
			
		}catch(ItemInexistenteException e){
			sessao = null;
			return sessao;
		}catch(Exception e){
			sessao = null;
			return sessao;
		}
		return sessao;
	}
}
