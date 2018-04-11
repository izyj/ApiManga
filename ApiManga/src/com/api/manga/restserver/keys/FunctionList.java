package com.api.manga.restserver.keys;

public enum FunctionList {

	mangaEdenSourceGetManga("GetManga"),
	mangaEdenSourceGetListManga("GetListManga");
	
	
	
	
	private String info ="";
	
	FunctionList(String infos){
		
		this.info = infos;
	}
	 
	 @Override
	public String toString() {

		return  info;
	}
}
