package com.api.manga.restserver.interfaceSample;

public interface JsonDataDispatcher {
	
	
	public Object dispatch(String json, String sourceName,String method);

}
