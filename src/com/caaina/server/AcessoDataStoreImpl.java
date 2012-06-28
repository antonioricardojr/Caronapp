package com.caaina.server;

import javax.jdo.PersistenceManager;

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
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(s);
		}catch (Exception e){
			return false;
		}finally{
			pm.close();
		}
		return true;
	}

	@Override
	public boolean gravaUsuario(Usuario u) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(u);
		}catch (Exception e){
			return false;
		}finally{
			pm.close();
		}
		return true;
	}

	@Override
	public boolean gravaCaronaAbstrata(CaronaAbstrata c) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(c);
		}catch (Exception e){
			return false;
		}finally{
			pm.close();
		}
		return true;
	}

}
