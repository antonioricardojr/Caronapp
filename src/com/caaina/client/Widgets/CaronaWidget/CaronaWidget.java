package com.caaina.client.Widgets.CaronaWidget;

import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.Widgets.SolicitarCarona.SolicitarCarona;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CaronaWidget extends Composite {

	private static CaronaWidgetUiBinder uiBinder = GWT.create(CaronaWidgetUiBinder.class);
	@UiField Label origem;
	@UiField Label destino;
	@UiField Label data;
	@UiField Label hora;
	@UiField Label vagas;
	@UiField Button botaoEditar;
	@UiField HorizontalPanel carona;
	@UiField VerticalPanel painelCarona;
	private String contexto;
	private String idCarona;

	interface CaronaWidgetUiBinder extends UiBinder<Widget, CaronaWidget> {
	}

	public CaronaWidget(String origem, String destino, String data, String hora, String vagas,String contexto, String idCarona) {
		initWidget(uiBinder.createAndBindUi(this));
		this.origem.setText(origem);
		this.destino.setText(destino);
		this.data.setText(data);
		this.hora.setText(hora);
		this.vagas.setText(vagas);
		setContexto(contexto);
		setIdCarona(idCarona);
		}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
	}

	@UiHandler("botaoEditar")
	void onBotaoEditarClick(ClickEvent event) {
		if(getContexto().equals("buscar caronas")){
			contextoBuscarCarona();
		}
	}

	private void contextoBuscarCarona() {
		botaoEditar.setText("Solicitar vaga");
		SolicitarCarona solicitar = new SolicitarCarona(getIdCarona());
		painelCarona.add(solicitar);
	}
	
	public String respostaContextoBuscarCarona(String resposta, String idCarona){
		if(resposta.equals("sim")){
			Perfil perfil = (Perfil) this.getParent();
			try {
				perfil.getSistema().solicitarVaga(perfil.getSessao().getId(), getIdCarona());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resposta;
		
	}

	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}
}
