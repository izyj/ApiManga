package com.api.manga.restserver.interfaceSample;

public interface JsonDataDispatcher {
	
	
/**
 * Methode qui redirige les appels vers les methodes correpondantes.
 * @param json
 * @param sourceName
 * @param method
 * @return Object
 */
public Object dispatch(String json, String sourceName,String method);

}
