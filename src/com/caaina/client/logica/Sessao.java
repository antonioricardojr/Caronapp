package com.caaina.client.logica;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Classe que representa um sessao do sistema.
 * 
 * @author ANTONIOR
 * 
 */

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Sessao implements IsSerializable{

	
	@PrimaryKey
	@Persistent
	private String id;
	
	@Persistent
	private String login;
	

	public Sessao(String login) throws Exception {

		setLogin(login);
		
		GeradorDeID gerador = new GeradorDeID();
		
		setId(gerador.geraId());
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login)throws Exception {
		if(login == null || login.equals("")){
			throw new Exception("Login inválido");
		}
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		if (id == null || id.equals("")) {
			throw new Exception("ID nulo ou invalido");
		}
		this.id = id;
	}


	
	
	

}
