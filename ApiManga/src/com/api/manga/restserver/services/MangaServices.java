package com.api.manga.restserver.services;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.api.manga.restserver.call.api.MedenCaller;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.model.Manga;

@Path("/mangas")
public class MangaServices {
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manga getManga() {
		Manga manga = new Manga();
		MedenCaller m = new MedenCaller();
		m.getMangaList(DataKeys.mangaEden_Language_English);
		return manga;
		
	}
	

}
