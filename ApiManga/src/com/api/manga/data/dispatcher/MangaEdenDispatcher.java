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

public class MangaEdenDispatcher implements JsonDataDispatcher{

	
	ArrayList<Manga> mangaList;
	
	public MangaEdenDispatcher() {
		
		
	}
	
	
	@Override
	public LinkedList<Manga> dispatch(String json) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(json);
		JsonObject jsonObjectTemp;
		LinkedList<Manga> listManga = new LinkedList<>();
		
		
		if(jsonTree.isJsonObject()) {
		    JsonObject jsonObject = jsonTree.getAsJsonObject();
		    JsonElement listMangaJson  = jsonObject.get(DataKeys.mangaEdenJson_manga);
		    
		    	if(listMangaJson.isJsonArray()) {

			    	JsonArray listMangaJsonArray = listMangaJson.getAsJsonArray();
			    	
			    	for(JsonElement  item :  listMangaJsonArray){
			    		
			    		jsonObjectTemp = item.getAsJsonObject();
			    		Set<String> keys = jsonObjectTemp.keySet();
			    		Manga manga = new Manga();
			    		for( String k : keys) {
			    			
			    			if (jsonObjectTemp.get(k).isJsonPrimitive()) {
			    				
			    				
				    			JsonPrimitive jsP = jsonObjectTemp.getAsJsonPrimitive(k);
				    			String f = jsP.toString();
				    			String f2 = jsP.getAsString();
				    			switch(k) 
				    			{
				    			
				    				case DataKeys.mangaEdenJson_mangaName  :
				    					manga.setName(jsP.toString());
				    					break;
				    					
				    				case DataKeys.mangaEdenJson_mangaStatus :
				    					Status s = new Status();
				    					s.setName(jsP.toString());
				    					manga.setStatus(s);
				    					break;
				    					
				    				case DataKeys.mangaEdenJson_mangaID : 
				    					manga.setId(Integer.parseInt(jsP.toString()));
				    					break;
				    					
				    				
				    					
				    				case DataKeys.mangaEdenJson_mangaLastChapterDate :
				    					//manga.setLastUpdate(lastUpdate);
				    					break;
				    					
				    				case DataKeys.mangaEdenJson_mangaImage : 
				    					Image image = new Image();
				    					image.setURI(jsP.toString());
				    					manga.setImage(image);
				    					break;
				    					
				    					
				    			}
			    			}
			    			else if (jsonObjectTemp.get(k).isJsonArray()) {
			    				
			    			
			    				 
		    					ArrayList<Genre> genres = new ArrayList<>();
		    					JsonArray jsO = jsonObjectTemp.get(k).getAsJsonArray();
		    					int  size = jsO.size();
		    					for(int i=0; i< size; i++) {
		    						Genre g = new Genre();
		    						g.setName(jsO.get(i).toString());
		    						genres.add(g);
		    					}
		    					manga.setGenres(genres);
		    					break;
			    			}
			    			
			    		}
			    		
			    		listManga.add(manga);
			    	}

		    	}
		    
		}
		return null;
		
	}
	
	
	 /**
	 *  Designe l'attribut auquel correspond la donn�e r�cup�rer
	 * @param item
	 */
	private void attribute(MangaEdenKeys key) {
		
		
		
		
		
		
	}
	

	
	
	
	

}
