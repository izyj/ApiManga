package com.api.manga.restserver.interfaceSample;

import java.util.LinkedList;

/**
 * @author isiramen
 *
 * @param <E>
 */
public interface IApiFunctionList<E> {
	
	
	/*
	 * Execute la methode de la Fonction appelé et renvoi une liste. 
	 * @param json
	 * @return
	 */
	public  LinkedList<E> execute(String json);

}
