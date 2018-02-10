package com.api.manga.data.dispatcher;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

import com.api.manga.restserver.interfaceSample.JsonDataDispatcher;
import com.api.manga.restserver.keys.DataKeys;
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

public class Dispatcher implements JsonDataDispatcher{

	
	ArrayList<Manga> mangaList;
	
	public Dispatcher() {
		
		
	}

	@Override
	public Object dispatch(String json, String sourceName, String method) {
		
		if(sourceName.equals(MangaEdenKeys.mangaEdenSourceName.toString())) {
			
			
		}
	
		return null;
	}

	
	

	

	
	
	
	

}
