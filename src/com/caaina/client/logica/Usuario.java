package com.caaina.client.logica;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.caaina.client.excecoes.AtributoInvalidoException;
import com.google.gwt.user.client.rpc.IsSerializable;

//import org.jdom2.Element;



//import xml.FactoryXml;
//import xml.Xml;


/**
 * Classe que representa um usuario do sistema.
 * 
 * @author ANTONIOR
 * 
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario implements IsSerializable{

	@PrimaryKey
	@Persistent
	private String login;
	
	@Persistent
	private String senha;
	
	@Persistent
	private String nome;
	
	@Persistent
	private String endereco;
	
	@Persistent
	private String email;

	@Persistent
	private List<String> caronasOferecidas;
	
	@Persistent
	private List<String> caronasComoCaroneiro;
	
	@Persistent
	private int faltas;
	
	@Persistent
	private int presencas;
	
	@Persistent
	private List<String> caronas;

	@Persistent
	private List<String> amigos;
	
	@Persistent
	private List<String> mensagens;
	
	@Persistent
	private String idFacebook;
	
//	private Xml xmlCreator;
	

	public Usuario(String login, String senha, String nome, String endereco,
			String email) throws Exception {

		setLogin(login);
		setSenha(senha);
		setNome(nome);
		setEndereco(endereco);
		setEmail(email);
		faltas = 0;
		caronasOferecidas = new ArrayList<String>();
		caronasComoCaroneiro = new ArrayList<String>();
		mensagens = new ArrayList<String>();
		setCaronas(new ArrayList<String>());

		setAmigos(new ArrayList<String>());
//		this.xmlCreator = new FactoryXml("Xml usuario");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) throws Exception {

		if (login == null || login.equals("")
				|| contemCharInvalidosLogin(login)) {
			throw new AtributoInvalidoException("Login inválido");
		}
		this.login = login;
	}

	private boolean contemCharInvalidosLogin(String string) {

		String[] palavra = string.trim().split("");

		for (int i = 1; i < palavra.length; i++) {
			if ("'!@#$%¨¨¨&*()+¹²³£¢¬§=[{ª~^]}º;:>,</|´/`áéíóúàèìòùÁÉÍÓÚÀÈÌÒÙãõÃÕâêîôûÂÊÎÔÛ "
					.contains(palavra[i])) {
				return true;
			}
		}

		return false;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws Exception {
		if (senha == null || senha == "") {
			throw new Exception("Senha inválida");
		}
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if (nome == null || nome.equals("") || contemCharInvalidosNome(nome)) {
			throw new Exception("Nome inválido");
		}
		this.nome = nome;
	}

	private boolean contemCharInvalidosNome(String nome) {
		String[] palavra = nome.trim().split("");

		for (int i = 1; i < palavra.length; i++) {
			if ("'!@#$%¨¨¨&*()+¹²³£¢¬§=[{ª~^]}º;:>,</|´/`".contains(palavra[i])) {
				return true;
			}
		}

		return false;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws Exception {
		if (endereco == null || endereco.equals("")) {
			throw new Exception("Endereço inválido");
		}

		this.endereco = endereco;
	}

	public int getFaltas() {
		return faltas;
	}

	public void addFalta() {
		this.faltas +=1;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) throws Exception {
		if (email == null || email.equals("")) {
			throw new Exception("Email inválido");
		}
		ValidadorDeEmail validadorDeEmail = new ValidadorDeEmail();
		
		if(validadorDeEmail.validaEmail(email)){
			this.email = email;
		}else{
			throw new Exception("Email inválido");
		}

	}

	public List<String> getCaronasOferecidas() {
		return caronasOferecidas;
	}

	public void adicionaCaronaOferecida(String novaCarona) {
		caronasOferecidas.add(novaCarona);

	}

	public void removeCaronaOferecida(String caronaARemover) {
		caronasOferecidas.remove(caronaARemover);
	}

	public List<String> getCaronasComoCaroneiro() {
		return caronasComoCaroneiro;
	}

	public void adicionaCaronaComoCaroneiro(String novaCarona) {
		caronasComoCaroneiro.add(novaCarona);
	}

	public void removeCaronaComoCaroneiro(String idCarona) {
		caronasComoCaroneiro.remove(idCarona);
	}

	public List<String> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<String> amigos) {
		this.amigos = amigos;
	}

	public void adicionaAmigo(String u) throws Exception {
		if (u != null) {
			amigos.add(u);
		} else {
			throw new Exception("Amigo inválido");
		}
	}

	public List<String> getCaronas() {
		return caronas;
	}

	public void setCaronas(List<String> caronas) {
		this.caronas = caronas;
	}

	public void adicionaCarona(String c) {
		if (c != null) {
			caronas.add(c);
		}
	}

	public void removeCarona(CaronaAbstrata c) {
		if (c != null) {
			caronas.remove(c);
		}
	}
	
//	public void geraXml(){
//		this.xmlCreator.geraXML(this);
//	}
	
//	public Element getXml() throws XMLNaoGeradaException{
//		return this.xmlCreator.getRaiz();
//	}
	
	public void setCaronasComoCaroneiro(List<String> lista){
		caronasComoCaroneiro = lista;
	}
	
	public void setCaronasOferecidas(List<String> lista){
		caronasOferecidas = lista;
	}
	
	public void adicionaMensagem(String mensagem){
		this.mensagens.add(mensagem);
	}
	
	public String getMensagens(){

		String saida = "[";
		
		for(String message: mensagens){
			saida+=message;
		}
		
		return saida+"]";
				
	}

	public int getPresencas() {

		return presencas;
	}
	
	public void addPresenca(){
		this.presencas +=1;
	}

	public String getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(String idFacebook) {
		this.idFacebook = idFacebook;
	}
}
