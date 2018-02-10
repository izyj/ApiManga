package com.api.manga.restserver.call.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import org.codehaus.jackson.map.ObjectMapper;

import com.api.manga.data.dispatcher.Dispatcher;
import com.api.manga.restserver.interfaceSample.IConnectorAPIMangaEden;
import com.api.manga.restserver.interfaceSample.JsonDataDispatcher;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;



/**
 * Classe permettant de requeter les différentes API distante, de recupérer les informations et de 
 * les traités
 * @author isiramen
 *
 */
public class ApiCallerReceiver implements IConnectorAPIMangaEden  {
	

	private JsonDataDispatcher dispatcher;

	public ApiCallerReceiver() {
		
		
	
	}

	@Override
	public Manga getManga(String idManga) {
		Manga manga = new Manga();
		String uri = MangaEdenKeys.mangaEdenApiMangaURI.toString()+idManga+"/";
		CookieHandler.setDefault(new CookieManager());
		ObjectMapper objectMapper = new ObjectMapper();
		LinkedList<Manga> listMangas;
		String json = new String() ;
		try {
			json  = MethodGetHTTP(uri);		
		} catch (IOException e) {
			
			System.out.println("Erreur : "+ e);
		}
		
		dispatcher = new Dispatcher();
		listMangas = dispatcher.dispatch(json);
		
		
		return listMangas.getFirst();
	}

	@Override
	public LinkedList<Manga> getMangaList(String language) {
					
		String uri = MangaEdenKeys.mangaEdenApiMangaListURI.toString()+language
		+MangaEdenKeys.mangaEdenApiMangaListURISplitPage.toString()+"1";
		CookieHandler.setDefault(new CookieManager());
		LinkedList<Manga> listMangas;
		String json = new String() ;
		try {
			json  = MethodGetHTTP(uri);		
		} catch (IOException e) {
			
			System.out.println("Erreur : "+ e);
		}
		 dispatcher = new Dispatcher();
		 listMangas = dispatcher.dispatch(json);

		return listMangas;
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
