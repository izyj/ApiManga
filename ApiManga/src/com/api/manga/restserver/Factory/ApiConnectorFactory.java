package com.api.manga.restserver.Factory;


import com.api.manga.restserver.call.api.ApiCallerReceiver;
import com.api.manga.restserver.interfaceSample.IConnectorAPIMangaEden;

public class ApiConnectorFactory {
	
	private static ApiConnectorFactory INSTANCE = new ApiConnectorFactory();
	private static ApiCallerReceiver serviceCaller = new ApiCallerReceiver();
	private ApiConnectorFactory() {
		
	}
	
	public ApiConnectorFactory getInstance() {
		
		return INSTANCE;
	}
	
	public static IConnectorAPIMangaEden getApiCallerReceiver() {
		
		return serviceCaller;
	}
	
	public static IConnectorAPIMangaEden getScrapperDataConnector() {
		
		return null; 
	}

}
