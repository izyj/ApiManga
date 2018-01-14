package com.api.manga.restserver.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import com.api.manga.restserver.model.Manga;

public class DataReceiver {
	
	
	public DataReceiver() {
		
	}
	
	public ArrayList<Manga> getMangaList() throws IOException{
		
		String uri = "https://www.mangaeden.com/api/list/0/";

		URL obj = new URL(uri);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
		
		
		return null;
	}

}
