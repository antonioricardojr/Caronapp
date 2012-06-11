package com.caaina.client.Widgets.AceitarSolicitacao;

import com.caaina.client.Widgets.CaronaWidget.CaronaWidget;
import com.caaina.client.logica.Solicitacao;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class AceitarSolicitacao extends Composite {

	private static AceitarSolicitacaoUiBinder uiBinder = GWT
			.create(AceitarSolicitacaoUiBinder.class);
	@UiField Button botaoSolicitador;
	@UiField Button botaoSim;
	@UiField Button botaoNao;
	private CaronaWidget carona;
	private Solicitacao solicitacao;

	interface AceitarSolicitacaoUiBinder extends
			UiBinder<Widget, AceitarSolicitacao> {
	}

	public AceitarSolicitacao(CaronaWidget carona,Solicitacao s ) {
		this.carona=carona;
		this.solicitacao = s;
		botaoSolicitador.setText(s.getSolicitador());
		
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("botaoSim")
	void onBotaoSimClick(ClickEvent event) {
		carona.respostaContextoMinhasCaronas("sim", solicitacao.getId());
		this.removeFromParent();
	}
	@UiHandler("botaoNao")
	void onBotaoNaoClick(ClickEvent event) {
		carona.respostaContextoMinhasCaronas("nao", solicitacao.getId());
		this.removeFromParent();
	}
}
