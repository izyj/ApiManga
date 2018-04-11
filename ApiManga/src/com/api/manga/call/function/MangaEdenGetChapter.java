package com.api.manga.call.function;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

import com.api.manga.restserver.interfaceSample.IApiFunctionList;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Image;
import com.api.manga.restserver.model.Page;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MangaEdenGetChapter implements IApiFunctionList<Page> {

	@Override
	public LinkedList<Page> execute(String json) {
		
		JsonParser parser = new JsonParser();
		JsonElement jsonE = parser.parse(json);
		LinkedList<Page> pageList = new LinkedList();
		
		if(jsonE.isJsonNull()) {
			JsonObject jsonO = jsonE.getAsJsonObject();
			JsonArray jsonA  = jsonO.get(DataKeys.mangaEdenJson_long_images).getAsJsonArray();
			int i = 1;
			

			for(JsonElement jsE : jsonA) {
				
				Page page = new Page( UUID.randomUUID().toString());
				if(i == 1)
					page.setNumPage(jsE.getAsString());
				
				if(i == 2)
					page.setImage(new Image(UUID.randomUUID().toString(),jsE.getAsString()));
				
				if(i == 3) 
					page.getImage().setHeight(jsE.getAsString());
					
				if(i == 4) {
					page.getImage().setLength(jsE.getAsString());
					i=1;
				}
				
				pageList.add(page);
				i++;
			}
			
			
			
		}
		
		
		
		
		
		return pageList;
	}
	
	

}
