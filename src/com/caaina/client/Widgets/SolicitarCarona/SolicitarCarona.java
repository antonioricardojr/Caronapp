package com.caaina.client.Widgets.SolicitarCarona;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class SolicitarCarona extends Composite {

	private static SolicitarCaronaUiBinder uiBinder = GWT
			.create(SolicitarCaronaUiBinder.class);
	@UiField Button botaoSim;
	@UiField Button botaoNao;
	private String idCarona;

	interface SolicitarCaronaUiBinder extends UiBinder<Widget, SolicitarCarona> {
	}

	public SolicitarCarona(String idCarona) {
		initWidget(uiBinder.createAndBindUi(this));
		setIdCarona(idCarona);
	}

	@UiHandler("botaoSim")
	void onBotaoSimClick(ClickEvent event) {
		
	}

	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}
}
