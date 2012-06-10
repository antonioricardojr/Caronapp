package com.caaina.client;

import com.caaina.client.Widgets.LogonWidget.Logon;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class CaronaSI1UI implements EntryPoint {

	@Override
	public void onModuleLoad() {
		Logon l = new Logon();
		RootPanel.get("logon").add(l);
	}
	
}
