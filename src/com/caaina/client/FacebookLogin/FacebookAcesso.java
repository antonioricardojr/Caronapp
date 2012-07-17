package com.caaina.client.FacebookLogin;

import com.google.gwt.core.client.JavaScriptObject;

class FacebookAcesso extends JavaScriptObject {

	protected FacebookAcesso() {
	}

	 public final native String loginStatus() /*-{
		return this.status;
	}-*/;

	 public final native String getNomeDoFacebook() /*-{
		return this.userID;
	}-*/;
}
