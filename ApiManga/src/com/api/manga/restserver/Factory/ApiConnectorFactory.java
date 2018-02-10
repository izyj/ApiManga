package com.api.manga.restserver.Factory;


import com.api.manga.restserver.call.api.MedenCaller;
import com.api.manga.restserver.interfaceSample.IConnectorAPIMangaEden;

public class ApiConnectorFactory {
	
	private static ApiConnectorFactory INSTANCE = new ApiConnectorFactory();
	
	private ApiConnectorFactory() {
		
	}
	
	public ApiConnectorFactory getInstance() {
		
		return INSTANCE;
	}
	
	public static IConnectorAPIMangaEden getEdenDataConnector() {
		
		return new MedenCaller();
	}
	
	public static IConnectorAPIMangaEden getScrapperDataConnector() {
		
		return null; 
	}

}
