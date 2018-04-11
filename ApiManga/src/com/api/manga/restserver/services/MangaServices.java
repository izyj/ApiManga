package com.api.manga.restserver.services;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Manga;

@Path("/mangas")
public class MangaServices {
	
	@GET
	@Path("/manga={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manga getManga() {
		Manga manga = new Manga();
		//MedenCaller m = new MedenCaller();
		//m.getMangaList(MangaEdenKeys.mangaEden_Language_English.toString());
		return manga;
		
	}
	
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manga getMangaList() {
		Manga manga = new Manga();
		//MedenCaller m = new MedenCaller();
		//m.getMangaList(MangaEdenKeys.mangaEden_Language_English.toString());
		return manga;
		
	}
	

}

