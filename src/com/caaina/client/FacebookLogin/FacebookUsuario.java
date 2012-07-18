package com.caaina.client.FacebookLogin;

import com.google.gwt.core.client.JavaScriptObject;

class FacebookUsuario extends JavaScriptObject  {
	
	protected FacebookUsuario() { }
	
	 public final native String getNome() /*-{
	 	return this.name;
	 }-*/;
	 
	 public final native String getUserID() /*-{
	 	return this.id;
	 }-*/;

}
