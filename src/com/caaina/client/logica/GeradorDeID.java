package com.caaina.client.logica;
/**
 * Gera um id aleat�rio de tamanho descrito
 * 
 * @author ANTONIOR
 *
 */

public class GeradorDeID {

	static int SIZE = 15;

	public String geraId(){
		String id = "";
		for (int i = 0; i < SIZE; i++) {
			id += (int) (Math.random()*10);
		}

		return id;
	}

}