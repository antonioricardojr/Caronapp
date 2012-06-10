package com.caaina.client.Widgets.CaronaWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class Carona extends Composite {

	private static CaronaUiBinder uiBinder = GWT.create(CaronaUiBinder.class);
	@UiField Label origem;
	@UiField Label destino;
	@UiField Label data;
	@UiField Label hora;
	@UiField Label vagas;
	@UiField HorizontalPanel carona;

	interface CaronaUiBinder extends UiBinder<Widget, Carona> {
	}

	public Carona(String origem, String destino, String data, String hora, String vagas) {
		initWidget(uiBinder.createAndBindUi(this));
		this.origem.setText(origem);
		this.destino.setText(destino);
		this.data.setText(data);
		this.hora.setText(hora);
		this.vagas.setText(vagas);
		}

}
