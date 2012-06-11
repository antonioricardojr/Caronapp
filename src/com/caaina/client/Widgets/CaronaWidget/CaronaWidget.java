package com.caaina.client.Widgets.CaronaWidget;

import com.caaina.client.Widgets.AceitarSolicitacao.AceitarSolicitacao;
import com.caaina.client.Widgets.BuscarCarona.BuscarCarona;
import com.caaina.client.Widgets.MinhasCaronasWidget.MinhasCaronas;
import com.caaina.client.Widgets.PerfilWidget.Perfil;
import com.caaina.client.Widgets.SolicitarCarona.SolicitarCarona;
import com.caaina.client.logica.CaronaAbstrata;
import com.caaina.client.logica.Solicitacao;
import com.caaina.client.logica.Usuario;
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
	@UiField Button botaoDonoDaCarona;
	private String contexto;
	private String idCarona;
	private CaronaAbstrata caronaAbs;
	private Perfil perfil;

	interface CaronaWidgetUiBinder extends UiBinder<Widget, CaronaWidget> {
	}

	public CaronaWidget(Perfil perfil, CaronaAbstrata carona,String contexto) {
		initWidget(uiBinder.createAndBindUi(this));
		setCaronaAbs(carona);
		this.origem.setText("Origem: " + carona.getOrigem());
		this.destino.setText("Destino: " + carona.getDestino());
		this.data.setText("Data: " + carona.getData());
		this.hora.setText("Hora: "+ carona.getHora());
		this.vagas.setText("Vagas restantes: " + carona.getVagas());
		this.botaoDonoDaCarona.setText("Carona de: " + carona.getCriador());
		setContexto(contexto);
		setIdCarona(carona.getId());
		setPerfil(perfil);
		}

	public String getContexto() {
		return contexto;
	}

	public void setContexto(String contexto) {
		this.contexto = contexto;
		if(contexto.equals("buscar caronas")){
			botaoEditar.setText("Solicitar vaga");
		}else if(contexto.equals("minhas caronas")){
			contextoMinhasCaronasShow();
		}
				
	}

	@UiHandler("botaoEditar")
	void onBotaoEditarClick(ClickEvent event) {
		if(getContexto().equals("buscar caronas")){
			contextoBuscarCarona();
		}else if(getContexto().equals("minhas caronas")){
			contextoMinhasCaronas();
		}
	}

	private void contextoMinhasCaronas() {
		for(Solicitacao s : getCaronaAbs().getSolicitacoes()){
			if(s.getEstado().equals("pendente")){
				AceitarSolicitacao aceitar = new AceitarSolicitacao(this, s);
				painelCarona.add(aceitar);
			}
		}
		
	}

	private void contextoMinhasCaronasShow() {
		int contadorPendente = 0;
		for(Solicitacao s : getCaronaAbs().getSolicitacoes()){
			if(s.getEstado().equals("pendente")){
				contadorPendente++;
			}
		}
		botaoEditar.setText("Voce tem " + contadorPendente + " solicitacoes pendentes");
		
	}

	private void contextoBuscarCarona() {
		SolicitarCarona solicitar = new SolicitarCarona(getIdCarona(), this);
		painelCarona.add(solicitar);
	}
	
	public void respostaContextoBuscarCarona(String resposta, String idCarona){
		if(resposta.equals("sim")){
			try {
				getPerfil().getSistema().solicitarVaga(getPerfil().getSessao().getId(), getIdCarona());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void respostaContextoMinhasCaronas(String resposta, String idSolicitacao){
		
		if(resposta.equals("sim")){
			try {
				getPerfil().getSistema().aceitarSolicitacao(getPerfil().getSessao().getId(), idSolicitacao);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getPerfil().limpaTela();
			getPerfil().mostraTela(new MinhasCaronas(getPerfil()));
			
		}else{
			try {
				getPerfil().getSistema().rejeitarSolicitacao(getPerfil().getSessao().getId(), idSolicitacao);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			getPerfil().limpaTela();
			getPerfil().mostraTela(new MinhasCaronas(getPerfil()));
		}
		
	}

	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}

	
	public void habilitaSolicitacao(boolean b){
		botaoEditar.setVisible(b);
	}

	public CaronaAbstrata getCaronaAbs() {
		return caronaAbs;
	}

	public void setCaronaAbs(CaronaAbstrata caronaAbs) {
		this.caronaAbs = caronaAbs;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public void desativaBotaoEditar() {
		botaoEditar.setVisible(false);
		
	}
}
