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
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;

import com.api.manga.data.dispatcher.Dispatcher;
import com.api.manga.restserver.interfaceSample.IConnectorAPIMangaEden;
import com.api.manga.restserver.interfaceSample.JsonDataDispatcher;
import com.api.manga.restserver.keys.FunctionList;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;
import com.api.manga.restserver.model.Page;



/**
 * Classe permettant de requeter les différentes API distante, de recupérer les informations et de 
 * les traités
 * @author isiramen
 *
 */
public class ApiCallerReceiver implements IConnectorAPIMangaEden  {
	

	private JsonDataDispatcher dispatcher;

	public ApiCallerReceiver() {}

	@Override
	public Manga getManga(String idManga) {
		Manga manga = new Manga();
		String uri = MangaEdenKeys.mangaEdenApiMangaURI.toString()+idManga+"/";
		CookieHandler.setDefault(new CookieManager());
		ObjectMapper objectMapper = new ObjectMapper();
		Manga mangas;
		String mangaJson = new String() ;
		try {
			mangaJson  = methodGetHTTP(uri);		
		} catch (IOException e) {
			
			System.out.println("Erreur : Erreur durant la récupération du manga depuis l'API MangaEden "+ e);
		}
		
		dispatcher = new Dispatcher();
		mangas = (Manga) dispatcher.dispatch(mangaJson,MangaEdenKeys.mangaEdenSourceName.toString()
				 ,FunctionList.mangaEdenSourceGetManga.toString());
		
		
		return manga;
	}

	@Override
	public LinkedList<Manga> getMangaList(String language) {
					
		String uri = MangaEdenKeys.mangaEdenApiMangaListURI.toString()+language
		+MangaEdenKeys.mangaEdenApiMangaListURISplitPage.toString()+"1";
		CookieHandler.setDefault(new CookieManager());
		LinkedList<Manga> listMangas;
		String listMangaJson = new String() ;
		try {
			listMangaJson  = methodGetHTTP(uri);		
		} catch (IOException e) {
			
			System.out.println("Erreur : Erreur durant la récupération de la liste des mangas depuis l'API MangaEden "+ e);
		}
		 dispatcher = new Dispatcher();
		 listMangas = (LinkedList<Manga>) dispatcher.dispatch(listMangaJson,MangaEdenKeys.mangaEdenSourceName.toString()
				 ,FunctionList.mangaEdenSourceGetListManga.toString());

		return listMangas;
	}

	@Override
	public Chapter getChapter(String idChapter) {
		
		String uri = MangaEdenKeys.mangaEdenApiChapterURI.toString()+idChapter+"/";
		Chapter chapter = new Chapter();
		dispatcher = new Dispatcher();
		String chapterJson = new String();
		try {
			
			chapterJson  = methodGetHTTP(uri);	
			
		} catch (IOException e) {
			
			System.out.println("Erreur : Erreur durant la récupération du chapitre depuis l'API MangaEden "+ e);
		}
		
		@SuppressWarnings("unchecked")
		LinkedList<Page> pagelist = (LinkedList<Page>) dispatcher.dispatch(chapterJson,MangaEdenKeys.mangaEdenSourceName.toString()
				 ,FunctionList.mangaEdenSourceGetListManga.toString());
		
		chapter.setId(UUID.randomUUID().toString());
		chapter.setPage(pagelist);
		
		return chapter;
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
	
	
	private static String methodGetHTTP(String uri) throws IOException {
		
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
				builder.append(methodGetHTTP(uriMovedTo));
				
				break;
				
			default: 
				break;
				
				
				
		}
		System.out.println(builder.toString());
	    return builder.toString();

	
	
}


	
}
