package com.caaina.client.facede;

import com.caaina.client.excecoes.DataInvalidaException;
import com.caaina.client.excecoes.DestinoInvalidoException;
import com.caaina.client.excecoes.OrigemInvalidaException;
import com.caaina.client.logica.Sistema;





/**
 * Classe Facade para usar os testes do easyAccept.
 * 
 * @author ANTONIOR
 * 
 */
public class Si1ProjectFacade {

	Sistema S1 = new Sistema();

	public void zerarSistema() {
		//S1.zerarSistema();
		S1 = new Sistema();
	}

	public void criarUsuario(String login, String senha, String nome,
			String endereco, String email) throws Exception {

		S1.criarUsuario(login, senha, nome, endereco, email);

	}

	public String abrirSessao(String login, String senha) throws Exception {
		return S1.abrirSessao(login, senha).getId();

	}
	
	public String encerrarSessao(String login) throws Exception{
		return S1.encerrarSessao(login).getLogin();
	}

	public String sugerirPontoEncontro(String idSessao, String idCarona, String pontos) throws Exception{
		return S1.sugerirPontoEncontro(idSessao, idCarona, pontos);
	}
	
	public String responderSugestaoPontoEncontro(String idSessao, String idCarona, String idSugestao,String pontos) throws Exception{
		
		return S1.responderSugestaoPontoEncontro(idSessao, idCarona, idSugestao, pontos);
	}
	
	public String solicitarVagaPontoEncontro(String idSessao, String idCarona, String ponto) throws Exception{
	
		return S1.solicitarVagaPontoEncontro(idSessao, idCarona, ponto).getId();
	}
	
	public String getAtributoSolicitacao(String idSolicitacao, String atributo) throws Exception{
		return S1.getAtributoSolicitacao(idSolicitacao, atributo);
	}
	
	public String getAtributoUsuario(String login, String atributo)
			throws Exception {
		return S1.getAtributoUsuario(login, atributo);
	}

	public String aceitarSolicitacao(String idSessao, String idSolicitacao) throws Exception{
		return S1.aceitarSolicitacao(idSessao, idSolicitacao).getId();
	}
	
	public String desistirRequisicao(String idSessao, String idCarona, String idSugestao) throws Exception{
		return S1.desistirRequisicao(idSessao, idCarona, idSugestao);
	}
	
	public String localizarCarona(String idSessao, String origem,
			String destino) throws Exception {

		return S1.localizarCarona(idSessao, origem, destino);
	}

	public String localizarCaronaMunicipal(String idSessao, String cidade, String origem,
			String destino) throws Exception {

		return S1.localizarCaronaMunicipal(idSessao,cidade, origem, destino);
	}
	
	public String localizarCaronaMunicipal(String idSessao, String cidade) throws Exception {

		return S1.localizarCaronaMunicipal(idSessao,cidade,"","");
	}
	
	public String cadastrarCarona(String idSessao, String origem,
			String destino, String data, String hora, String vagas)
			throws Exception {
		return S1.cadastrarCarona(idSessao, origem, destino, data, hora, vagas).getId();
	}

	public String cadastrarCaronaMunicipal(String idSessao, String origem,
			String destino, String cidade, String data, String hora, String vagas)
			throws Exception {
		return S1.cadastrarCaronaMunicipal(idSessao, origem, destino, cidade, data, hora, vagas).getId();
	}
	
	public String getAtributoCarona(String idCarona, String atributo)
			throws Exception {

		return S1.getAtributoCarona(idCarona, atributo);
	}

	public String getTrajeto(String idCarona) throws Exception {

		return S1.getTrajeto(idCarona);

	}
	
	public String aceitarSolicitacaoPontoEncontro(String idSessao, String idSolicitacao) throws Exception{
		return S1.aceitarSolicitacaoPontoEncontro(idSessao, idSolicitacao).getId();
	}

	public String solicitarVaga(String idSessao, String idCarona) throws Exception{
		return S1.solicitarVaga(idSessao, idCarona).getId();
	}
	
	public String getCarona(String idCarona) throws Exception {
		return S1.getCarona(idCarona).toString();
	}
	
	public void rejeitarSolicitacao(String idSessao, String idSolicitacao) throws Exception{
		S1.rejeitarSolicitacao(idSessao, idSolicitacao);
	}
	
	public String visualizarPerfil(String idSessao, String login) throws Exception{
		return S1.visualizarPerfil(idSessao, login).getNome();
	}
	
	
	public String getAtributoPerfil(String login, String atributo) throws Exception{
		return S1.getAtributoPerfil(login, atributo);
	}

	public String getCaronaUsuario(String idSessao, int indexCarona) throws Exception{
		return S1.getCaronaUsuario(idSessao, indexCarona).getId();
	}
	
	public String getTodasCaronasUsuario(String idSessao) throws Exception{
		return S1.getTodasCaronasUsuario(idSessao);
		
	}
	
	public String getSolicitacoesConfirmadas(String idSessao, String idCarona) throws Exception{
		return S1.getSolicitacoesConfirmadas(idSessao,idCarona);
	}
	
	public String getSolicitacoesPendentes(String idSessao,String idCarona) throws Exception{
		return S1.getSolicitacoesPendentes(idSessao,idCarona);
	}
	
	public String getPontosSugeridos(String idSessao, String idCarona) throws Exception{
		return S1.getPontosSugeridos(idSessao,idCarona);
	}
	
	public String getPontosEncontro(String idSessao, String idCarona) throws Exception{
		return S1.getPontosEncontro(idSessao,idCarona);
	}
	
	public String reviewVagaEmCarona(String idSessao, String idCarona, String loginCaroneiro, String review) throws Exception{
		return S1.reviewVagaEmCarona(idSessao,idCarona, loginCaroneiro,review);
	}
	
	public void reviewCarona(String idSessao, String idCarona, String review) throws Exception{
		S1.reviewCarona(idSessao, idCarona, review);
	}
	
	public String cadastrarInteresse(String idSessao, String origem, String destino, String data, String horaInicio, String horaFim) throws OrigemInvalidaException, DestinoInvalidoException, DataInvalidaException{
		return S1.cadastrarInteresse(idSessao, origem, destino, data, horaInicio, horaFim).toString();
	}
	
	public String verificarMensagensPerfil(String idSessao) throws Exception{
		return S1.verificarMensagensPerfil(idSessao);		
	}
	
	public void reiniciarSistema() throws Exception{
		//S1.zerarSistema();		
	}
	
	public void encerrarSistema() throws Exception {
		//S1.encerrarSistema();

	}
	public boolean enviarEmail(String idSessao, String destino, String message){
		return S1.enviarEmail(idSessao, destino, message);
	}

}
