package com.caaina.server;

import com.caaina.client.AcessoDataStore;
import com.caaina.client.logica.CaronaAbstrata;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Usuario;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AcessoDataStoreImpl extends RemoteServiceServlet implements AcessoDataStore{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean gravaSessao(Sessao s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gravaUsuario(Usuario u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gravaCaronaAbstrata(CaronaAbstrata c) {
		// TODO Auto-generated method stub
		return false;
	}

}
