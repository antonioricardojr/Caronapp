package com.caaina.client.Widgets.MinhasCaronasWidget;

import java.util.List;

import com.caaina.client.Widgets.CaronaWidget.CaronaWidget;
import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;


public class MinhasCaronas extends Composite {

	private static MinhasCaronasUiBinder uiBinder = GWT
			.create(MinhasCaronasUiBinder.class);
	@UiField VerticalPanel painelCaronas;
	@UiField Button botaoMinhasCaronas;
	@UiField Button botaoCaronasComoCaroneiro;
	@UiField Button botaoCaronasOferecidas;
	@UiField HorizontalPanel painelBotoesCaronas;
	private Perfil perfil;

	interface MinhasCaronasUiBinder extends UiBinder<Widget, MinhasCaronas> {
	}

	public MinhasCaronas(Perfil perfil) {
		initWidget(uiBinder.createAndBindUi(this));
		setPerfil(perfil);
		mostraCaronas();
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	private void mostraCaronas(){
		List<String> caronas = getPerfil().getSistema().getUsuario(getPerfil().getLogin()).getCaronas();
		for(String c : caronas){
			com.caaina.client.logica.Carona carona = null;
			try {
				carona = getPerfil().getSistema().getCarona(c);
				CaronaWidget caronaLinha = new CaronaWidget(carona.getOrigem(), carona.getDestino(), carona.getData(), carona.getHora(), ""+carona.getVagas(), carona.getId(), "minhas caronas");
				painelCaronas.add(caronaLinha);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
