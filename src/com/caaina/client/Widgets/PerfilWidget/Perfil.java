package com.caaina.client.Widgets.PerfilWidget;

import java.util.ArrayList;
import java.util.List;

import com.caaina.client.Widgets.BuscarCarona.BuscarCarona;
import com.caaina.client.Widgets.CadastraNovaCarona.CadastraNovaCarona;
import com.caaina.client.Widgets.LogonWidget.Logon;
import com.caaina.client.Widgets.MinhasCaronasWidget.MinhasCaronas;
import com.caaina.client.Widgets.Principal.Principal;
import com.caaina.client.Widgets.TelaPerfilInicial.TelaPerfilInicial;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Sistema;
import com.caaina.client.logica.Usuario;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;

public class Perfil extends Composite {

	private static PerfilUiBinder uiBinder = GWT.create(PerfilUiBinder.class);
	@UiField
	MenuItem logoutItem;
	@UiField
	MenuItem minhasCaronasItem;
	@UiField
	MenuItem cadastrarNovaCaronaItem;
	@UiField
	MenuItem usuario;
	@UiField
	MenuBar menuUsuario;
	@UiField
	MenuBar menuBar;
	@UiField
	VerticalPanel gridPerfil;
	@UiField MenuItem buscarCaronasItem;
	@UiField Label campoNome;
	@UiField Label campoEndereco;
	@UiField Label campoEmail;
	final int INDEX_GRID = 1;
	final int INDEX_CADASTRA_NOVA_CARONA = 2;
	private CadastraNovaCarona cadastraNovaCarona;
	private TelaPerfilInicial telaPerfilInicial;
	private MinhasCaronas minhasCaronas;
	private BuscarCarona buscarCarona;
	private Widget tela;
	private String login;
	private List<MenuItem> menuItens;
	private static Sessao sessao;
	private Sistema sistema;

	interface PerfilUiBinder extends UiBinder<Widget, Perfil> {
	}

	public Perfil(Sessao sessao, Sistema sistema) {
		// Seta as variaveis para inicializacao do perfil
		setSistema(sistema);
		setSessao(sessao);
		setLogin(sessao.getLogin());
		telaPerfilInicial = new TelaPerfilInicial();
		setTela(telaPerfilInicial);
		initWidget(uiBinder.createAndBindUi(this));
		menuItens = new ArrayList<MenuItem>();
		menuItens.add(minhasCaronasItem);
		menuItens.add(cadastrarNovaCaronaItem);

		// Personaliza o menubar com o login do usuario
		usuario.setText("Bem Vindo " + getLogin());
		menuBar.setAutoOpen(true);
		menuBar.setAnimationEnabled(true);
		
		mostraDadosDoPerfil(true);
		
		usuario.setCommand(new Command(){

			@Override
			public void execute() {
				limpaTela();
			}
			
		});

		// Adiciona o comando no item Logout para voltar a tela de Logon
		logoutItem.setCommand(new Command() {
			@Override
			public void execute() {
				RootPanel.get("perfil").clear();
				RootPanel.get("principal").clear();
				
				Principal principal = new Principal(Perfil.this.getSistema());
				RootPanel.get("principal").add(principal);
				
			}
		});

		// Adiciona o comando no item Cadastrar Nova Carona para chamar a tela
		// de cadastro da carona
		cadastrarNovaCaronaItem.setCommand(new Command() {
			@Override
			public void execute() {

				limpaTela();
				cadastraNovaCarona = new CadastraNovaCarona(Perfil.this);
				cadastrarNovaCaronaItem.setEnabled(false);
				mostraTela(cadastraNovaCarona);

			}
		});

		// Adiciona o comando no item Mostrar Caronas para chamar a tela com a
		// lista das caronas
		minhasCaronasItem.setCommand(new Command() {

			@Override
			public void execute() {
				limpaTela();
				minhasCaronas = new MinhasCaronas(Perfil.this);
				minhasCaronasItem.setEnabled(false);
				mostraTela(minhasCaronas);
			}

		});
		
		//Adiciona o comando no item Buscar Caronas para chamar a tela com a busca
		
		buscarCaronasItem.setCommand(new Command(){

			@Override
			public void execute() {
				limpaTela();
				buscarCarona = new BuscarCarona(Perfil.this);
				buscarCaronasItem.setEnabled(true);
				mostraTela(buscarCarona);	
			}
			
		});

	}

	public void mostraDadosDoPerfil(boolean bool) {
		if(bool == true){
			Usuario u = sistema.getUsuario(sessao.getLogin());
			this.campoNome.setText(u.getNome());
			this.campoEndereco.setText(u.getEndereco());
			this.campoEmail.setText(u.getEmail());
		}else{
			this.campoNome.setText("");
			this.campoEndereco.setText("");
			this.campoEmail.setText("");
		}
		
	}

	/**
	 * Remove widget selecionado no menu para o widget padrao
	 */
	public void limpaTela() {
		gridPerfil.remove(tela);
		for (MenuItem i : menuItens) {
			i.setEnabled(true);
		}
		setTela(telaPerfilInicial);
	}

	/**
	 * Mostra na tela o widget selecionado
	 * 
	 * @param w
	 *            widget a ser mostrado na tela
	 */
	private void mostraTela(Widget w) {
		gridPerfil.add(w);
		gridPerfil.setCellHorizontalAlignment(w, VerticalPanel.ALIGN_CENTER);
		gridPerfil.setCellVerticalAlignment(w, VerticalPanel.ALIGN_TOP);
		setTela(w);
	}

	/**
	 * 
	 * @param w
	 */
	private void setTela(Widget w) {
		tela = w;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		Perfil.sessao = sessao;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
}
