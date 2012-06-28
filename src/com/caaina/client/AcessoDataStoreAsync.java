package com.caaina.client;

import com.caaina.client.logica.CaronaAbstrata;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Usuario;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AcessoDataStoreAsync {

	void gravaSessao(Sessao s, AsyncCallback<Boolean> callback);
	void gravaUsuario(Usuario u,  AsyncCallback<Boolean> callback);
	void gravaCaronaAbstrata(CaronaAbstrata c,  AsyncCallback<Boolean> callback);
}
