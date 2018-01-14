package com.api.manga.restserver.call.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.api.manga.restserver.connector.IConnectorAPIMangaEden;
import com.api.manga.restserver.keys.DKeys;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;




public class MedenCaller implements IConnectorAPIMangaEden  {
	


	public MedenCaller() {
		
		
	
	}

	@Override
	public Manga getManga(String idManga) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Manga> getMangaList(String language) {
					
		String uri = DKeys.mangaEdenApiMangaListURI+language+"/"
		+DataKeys.mangaEdenApiMangaListURISplitPage+"1";
		CookieHandler.setDefault(new CookieManager());
		ObjectMapper objectMapper = new ObjectMapper();
		List<Manga> listMangas = new ArrayList<Manga>();
		String json = new String() ;
		try {
			json  = MethodGetHTTP(uri);		
		} catch (IOException e) {
			
			System.out.println("Erreur : "+ e);
		}
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(json);
		if(jsonTree.isJsonObject()) {
		    JsonObject jsonObject = jsonTree.getAsJsonObject();
		    JsonElement listMangaJson  = jsonObject.get(DataKeys.mangaEdenJson_manga);
		    
		    
		    if(listMangaJson.isJsonObject()) {
			    JsonObject listMangaJsonObject = listMangaJson.getAsJsonObject();
			    
		    }else if(listMangaJson.isJsonArray()) {
		    	
		    	Consumer<? super JsonElement> consumerNames = new Consumer<JsonArray>() {
					@Override
					public void accept(JsonArray t) {
						
						t.
						
					}
		    	};
		    	
		    	JsonArray listMangaJsonArray = listMangaJson.getAsJsonArray();
		    	
		    	listMangaJsonArray.forEach(consumerNames);
		    	
		    }
		    
		}

		
		
		
		return (ArrayList<Manga>) listMangas;
	}

	@Override
	public Chapter getChapter(String idChapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int LogIn(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int logOut() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	private static String MethodGetHTTP(String uri) throws IOException {
		
		String line;
		int responseCode;
	 	StringBuilder builder = new StringBuilder();
		URL obj = new URL(uri);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setReadTimeout(5000);
		con.setRequestProperty("Accept", "application/json");
		con.setInstanceFollowRedirects(true);
		
		con.connect();
		
		InputStream  stream = con.getInputStream();
		responseCode = con.getResponseCode();
		System.out.println("Get response code : "+responseCode);
		switch(responseCode) {
		
			case HttpURLConnection.HTTP_OK : 
				BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				try { 
					while((line = reader.readLine()) != null) {
			        	builder.append(line);
			        }
			    }finally {
			        reader.close();
			    }
				break;
			case HttpURLConnection.HTTP_MOVED_PERM :
				String uriMovedTo = con.getHeaderField("Location");
				builder.append(MethodGetHTTP(uriMovedTo));
				
				break;
				
			default: 
				break;
				
				
				
		}
		System.out.println(builder.toString());
	    return builder.toString();

	
	
}


	
}
