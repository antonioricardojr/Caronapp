package com.caaina.client.Widgets.BuscarCarona;

import java.util.List;

import com.caaina.client.Widgets.CaronaWidget.CaronaWidget;
import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.logica.Carona;
import com.caaina.client.logica.CaronaAbstrata;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class BuscarCarona extends Composite {

	private static BuscarCaronaUiBinder uiBinder = GWT
			.create(BuscarCaronaUiBinder.class);
	@UiField
	TextBox campoOrigem;
	@UiField
	TextBox campoDestino;
	@UiField
	VerticalPanel painelCentral;
	@UiField
	FlowPanel painelBuscar;
	@UiField
	Button botaoBuscar;
	@UiField
	TextBox campoData;
	@UiField
	VerticalPanel painelCaronas;
	private Perfil perfil;

	interface BuscarCaronaUiBinder extends UiBinder<Widget, BuscarCarona> {
	}

	public BuscarCarona(Perfil perfil) {
		initWidget(uiBinder.createAndBindUi(this));
		setPerfil(perfil);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@UiHandler("botaoBuscar")
	void onBotaoBuscarClick(ClickEvent event) {
		painelCaronas.clear();
		String origem = campoOrigem.getText();
		String destino = campoDestino.getText();
		String data = campoData.getText();
		try {
			List<String> caronas = getPerfil().getSistema()
					.localizarCaronasLista(getPerfil().getSessao().getId(),
							origem, destino);
			for (String c : caronas) {
				CaronaAbstrata carona = getPerfil().getSistema().getCarona(c);
				if (data.equals("")) {
					CaronaWidget linahCarona = new CaronaWidget(getPerfil(),
							carona, "buscar caronas");
					if(carona.getCriador().equals(perfil.getLogin())){
						linahCarona.habilitaSolicitacao(false);
					}
					painelCaronas.add(linahCarona);
					painelCaronas
							.setHorizontalAlignment(DockPanel.ALIGN_CENTER);

				} else if (carona.getData().equals(data)) {
					CaronaWidget linahCarona = new CaronaWidget(getPerfil(),
							carona, "buscar caronas");
					painelCaronas.add(linahCarona);
					painelCaronas
							.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@UiHandler("campoOrigem")
	void onCampoOrigemClick(ClickEvent event) {
		campoOrigem.setText("");
	}

	@UiHandler("campoDestino")
	void onCampoDestinoClick(ClickEvent event) {
		campoDestino.setText("");
	}

	@UiHandler("campoData")
	void onCampoDataClick(ClickEvent event) {
		campoData.setText("");
	}
}
