package com.caaina.client.logica;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.caaina.client.excecoes.ReviewInvalidaException;
import com.google.gwt.user.client.rpc.IsSerializable;


@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Review implements IsSerializable{
	
	@PrimaryKey
	@Persistent
	private String id;
	
	@Persistent
	private String loginUsuario;
	
	@Persistent
	private String idCarona;
	
	@Persistent
	private String review;
	
	public Review(String id, String loginUsuario, String idCarona, String review)throws Exception {
		
		if(id == null || loginUsuario == null || idCarona == null || review == null){
			throw new ReviewInvalidaException();
		}else{
			this.setId(id);
			this.setUsuario(loginUsuario);
			this.setCarona(idCarona);
			this.setReview(review);
		}	
		
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getCarona() {
		return this.idCarona;
	}

	public void setCarona(String idCarona) {
		this.idCarona = idCarona;
	}

	public String getUsuario() {
		return this.loginUsuario;
	}

	public void setUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
