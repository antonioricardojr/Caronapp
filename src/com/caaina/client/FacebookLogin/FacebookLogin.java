package com.caaina.client.FacebookLogin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;

public class FacebookLogin extends Composite {

	private static FacebookLoginUiBinder uiBinder = GWT
			.create(FacebookLoginUiBinder.class);
	@UiField
	HTML botaoFacebook;

	interface FacebookLoginUiBinder extends UiBinder<Widget, FacebookLogin> {
	}

	public FacebookLogin() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public static native String mostraNome() /*-{
		return $wnd.leUsuario();
	}-*/;

}
