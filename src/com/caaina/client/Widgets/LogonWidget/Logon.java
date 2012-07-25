package com.caaina.client.Widgets.LogonWidget;




import com.caaina.client.FacebookLogin.FacebookLogin;
import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.excecoes.AtributoInvalidoException;
import com.caaina.client.excecoes.ItemInexistenteException;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Sistema;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Timer;
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
	@UiField Button loginFacebook;
	private Sessao sessao;
	private FacebookLogin facebook;


	interface LogonUiBinder extends UiBinder<Widget, Logon> {
	}

	public Logon(Sistema sistema, FacebookLogin facebook) {
		initWidget(uiBinder.createAndBindUi(this));
		setStyleName("logon");
		setSistema(sistema);
		setFacebook(facebook);
		getFacebook().setVisible(false);
		
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
			Perfil p = new Perfil(sessao, sistema, getFacebook());
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

	public FacebookLogin getFacebook() {
		return facebook;
	}

	public void setFacebook(FacebookLogin facebook) {
		this.facebook = facebook;
	}
	

	@UiHandler("loginFacebook")
	void onLoginFacebookClick(ClickEvent event) {
		getFacebook().logar();
		
		final Timer t = new Timer(){

			@Override
			public void run() {
				if(!getFacebook().getIdFacebook().equals("nao conectado")){
					String[] login = getSistema().pegaUsuarioFacebook(getFacebook().getIdFacebook());
					if(!login[0].equals("")){
						logar(login[0], login[1]);
						if(sessao!=null){
							RootPanel.get("principal").clear();
							Perfil p = new Perfil(sessao, sistema, getFacebook());
							RootPanel.get("perfil").add(p);
						}
					}else{
						loginFacebook.setText("Usuario do Facebook nao associado");
					}
				}else{
					this.schedule(2000);
				}
				
			}
			
		};
		t.schedule(2000);
	}
}
