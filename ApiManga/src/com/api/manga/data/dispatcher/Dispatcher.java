package com.api.manga.data.dispatcher;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Set;

import com.api.manga.call.function.MangaEdenGetListManga;
import com.api.manga.call.function.MangaEdenGetManga;
import com.api.manga.restserver.interfaceSample.IApiFunctionList;
import com.api.manga.restserver.interfaceSample.IApiFunctionObject;
import com.api.manga.restserver.interfaceSample.JsonDataDispatcher;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.keys.FunctionList;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Genre;
import com.api.manga.restserver.model.Image;
import com.api.manga.restserver.model.Manga;
import com.api.manga.restserver.model.Status;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * @author isiramen
 *
 */
public class Dispatcher implements JsonDataDispatcher{

	
	ArrayList<Manga> mangaList;
	
	
	public Dispatcher() {
		
		
	}

	
	@Override
	public Object dispatch(String json, String sourceName, String method) {
		
		Object  obj ;
		
		if(sourceName.equals(MangaEdenKeys.mangaEdenSourceName.toString())) {
			
			if(method.equals(FunctionList.mangaEdenSourceGetListManga.toString())) {
				LinkedList<Manga> listManga;
				IApiFunctionList<Manga> getlistMangaFunction = new MangaEdenGetListManga();
				obj = listManga = getlistMangaFunction.execute(json);		
			}
			else 
			if(method.equals(FunctionList.mangaEdenSourceGetManga.toString())) {
				
				IApiFunctionObject<Manga> getMangaFunction  = new MangaEdenGetManga();
				
				
			}
			
			
			
		}
	
		return null;
	}

	
	

	

	
	
	
	

}
