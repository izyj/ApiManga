package com.api.manga.data.dispatcher;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Set;

import com.api.manga.call.function.MangaEdenGetChapter;
import com.api.manga.call.function.MangaEdenGetListManga;
import com.api.manga.call.function.MangaEdenGetManga;
import com.api.manga.restserver.interfaceSample.IApiFunctionList;
import com.api.manga.restserver.interfaceSample.IApiFunctionObject;
import com.api.manga.restserver.interfaceSample.JsonDataDispatcher;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.keys.FunctionList;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Genre;
import com.api.manga.restserver.model.Image;
import com.api.manga.restserver.model.Manga;
import com.api.manga.restserver.model.Page;
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
		
		Object  obj = null ;
		
		if(sourceName.equals(MangaEdenKeys.mangaEdenSourceName.toString())) {
			
			if(method.equals(FunctionList.mangaEdenSourceGetListManga.toString())) {
				
				IApiFunctionList<Manga> getlistMangaFunction = new MangaEdenGetListManga();
				obj = getlistMangaFunction.execute(json);		
			}
			
			else 
			if(method.equals(FunctionList.mangaEdenSourceGetManga.toString())) {

				IApiFunctionObject<Manga> getMangaFunction  = new MangaEdenGetManga();
				obj = getMangaFunction.execute(json);
			}
			else 
			if(method.equals(FunctionList.mangaEdenSourceGetChapter.toString())) {
					
				IApiFunctionList<Page> getChapterPageFunction  = new MangaEdenGetChapter();
				obj = getChapterPageFunction.execute(json);
	
			}
			
			
			
		}
	
		return obj;
	}

	
	

	

	
	
	
	

}
