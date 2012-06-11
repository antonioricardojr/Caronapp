package com.caaina.client.Widgets.SolicitarCarona;

import com.caaina.client.Widgets.CaronaWidget.CaronaWidget;
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
	private CaronaWidget carona;

	interface SolicitarCaronaUiBinder extends UiBinder<Widget, SolicitarCarona> {
	}

	public SolicitarCarona(String idCarona, CaronaWidget carona) {
		initWidget(uiBinder.createAndBindUi(this));
		setIdCarona(idCarona);
		setCarona(carona);
	}

	@UiHandler("botaoSim")
	void onBotaoSimClick(ClickEvent event) {
		getCarona().respostaContextoBuscarCarona("sim", getIdCarona());
		this.removeFromParent();
		
	}

	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}
	@UiHandler("botaoNao")
	void onBotaoNaoClick(ClickEvent event) {
		this.removeFromParent();
	}

	public CaronaWidget getCarona() {
		return carona;
	}

	public void setCarona(CaronaWidget carona) {
		this.carona = carona;
	}
}
