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

	

	public static native void logar() /*-{
		$wnd.loga();
	}-*/;

	@UiHandler("button")
	void onButtonClick(ClickEvent event) {

		FacebookAcesso f = getFacebookAcesso() ;
		FacebookUsuario u = getFacebookUsuario();
		if (f.loginStatus().equals("connected")) {
			button.setText("Logado no Facebook como " + u.getNome());
		}
		pegaNome();
	}


	private static native void pegaNome() /*-{
		$wnd.mostraUsuario();
	}-*/;

	private static native FacebookAcesso getFacebookAcesso() /*-{
		return $wnd.getEstadoAtual();

	}-*/;
	
	private static native FacebookUsuario getFacebookUsuario() /*-{
	return $wnd.getUsuarioAtual();

}-*/;

	
}
