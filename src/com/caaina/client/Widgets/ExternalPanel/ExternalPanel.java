package com.caaina.client.Widgets.ExternalPanel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ExternalPanel extends Composite {

	private static ExternalPanelUiBinder uiBinder = GWT
			.create(ExternalPanelUiBinder.class);

	interface ExternalPanelUiBinder extends UiBinder<Widget, ExternalPanel> {
	}

	public ExternalPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	

}
