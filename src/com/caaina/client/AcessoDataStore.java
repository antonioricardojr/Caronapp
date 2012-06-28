package com.caaina.client;

import com.caaina.client.logica.CaronaAbstrata;
import com.caaina.client.logica.Sessao;
import com.caaina.client.logica.Usuario;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accessControl")
public interface AcessoDataStore extends RemoteService {

	public boolean gravaSessao(Sessao s);
	public boolean gravaUsuario(Usuario u);
	public boolean gravaCaronaAbstrata(CaronaAbstrata c);
	
}
