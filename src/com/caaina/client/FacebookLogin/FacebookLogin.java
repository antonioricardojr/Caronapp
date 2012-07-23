package com.caaina.client.FacebookLogin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class FacebookLogin extends Composite {

	private static FacebookLoginUiBinder uiBinder = GWT
			.create(FacebookLoginUiBinder.class);
	@UiField
	Button button;

	interface FacebookLoginUiBinder extends UiBinder<Widget, FacebookLogin> {
	}

	public FacebookLogin() {
		initWidget(uiBinder.createAndBindUi(this));

	}

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		logar();
		esperarConectar();
	}

	private void esperarConectar() {

		FacebookAcesso f = getFacebookAcesso();
		FacebookUsuario u = getFacebookUsuario();
		while (!f.loginStatus().equals("connected")) {
			f = getFacebookAcesso();
		}
		if(u.getNome().equals("nao conectado")){
			button.setText("Clique para Sincronizar com o Facebook ");
		}else{
			button.setText("Logado no Facebook como " + u.getNome());
		}

	}

	public static native void logar() /*-{
			$wnd.loga();	
	}-*/;

	private static native void pegaNome() /*-{
		$wnd.mostraUsuario();
	}-*/;

	private static native FacebookAcesso getFacebookAcesso() /*-{
		return $wnd.getEstadoAtual();

	}-*/;

	private static native FacebookUsuario getFacebookUsuario() /*-{
		return $wnd.getUsuarioAtual();

	}-*/;

	public void mudaTextoBotao(String texto) {
		button.setText(texto);
	}

}
