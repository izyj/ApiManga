package com.api.manga.call.function;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.api.manga.restserver.interfaceSample.IApiFunctionObject;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.model.Chapter;
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
public class MangaEdenGetManga implements IApiFunctionObject<Manga> {

	@Override
	public Manga execute(String json) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsE = parser.parse(json);
		JsonObject jsonObjectTemp;
		
		if(!jsE.isJsonNull()) {
			JsonArray array = jsE.getAsJsonArray();
			Manga manga = new Manga();
			
			for(JsonElement item : array) {
				
				jsonObjectTemp = item.getAsJsonObject();
	    		Set<String> keys = jsonObjectTemp.keySet();
	    		
	    		
	    		for( String k : keys) {
				
				JsonPrimitive jsP = jsonObjectTemp.getAsJsonPrimitive(k);
    			String f = jsP.toString();
    			String f2 = jsP.getAsString();
    			
	    			switch(k) 
	    			{
	    			
	    				case DataKeys.mangaEdenJson_long_mangaTitle  :
	    					manga.setName(jsP.toString());
	    					break;
	    					
	    				case DataKeys.mangaEdenJson_long_status :
	    					Status s = new Status();
	    					s.setName(jsP.toString());
	    					manga.setStatus(s);
	    					break;
	    					
	    				case DataKeys.mangaEdenJson_long_description : 
	    					manga.setDescription(jsP.toString());
	    					break;
	    					
	    				
	    					
	    				case DataKeys.mangaEdenJson_long_last_chapter_date :
	    					String datetime = jsP.getAsString();
	    					manga.setLastUpdate(parse_string_timestamp_java(datetime));
	    					break;
	    					
	    				case DataKeys.mangaEdenJson_long_image : 
	    					Image image = new Image();
	    					image.setURI(jsP.toString());
	    					manga.setImage(image);
	    					break;
	    					
	    				case DataKeys.mangaEdenJson_long_chapters  :
	    					ArrayList<Chapter> chapterlist = new ArrayList();
	    					JsonArray jsO = jsonObjectTemp.get(k).getAsJsonArray();
	    					for (JsonElement jse : jsO) {
	    						JsonArray jsonArray =  jse.getAsJsonArray();
	    						int  size = jsonArray.size();
		    					for(int i=0; i< size; i++) {
		    						
		    						Chapter chapter = new Chapter();
		    						
		    						chapter.setId( jsonArray.get(i).toString());
		    						genres.add(g);
	    						
		    					}
	    					}

	    					break;
	    					
	    				
	    					
	    			}	
	    		}		
			}
			
		}
		
		
		return null;
	}
	
	
	private Timestamp parse_string_timestamp_java(String datetime) throws ParseException {

	    SimpleDateFormat dateFormat = new SimpleDateFormat(
	            "yyyy-MM-dd hh:mm:ss:SSS");

	    Date parsedTimeStamp = dateFormat.parse(datetime);

	    Timestamp timestamp = new Timestamp(parsedTimeStamp.getTime());
	    
	    
		return timestamp;

	}

}
