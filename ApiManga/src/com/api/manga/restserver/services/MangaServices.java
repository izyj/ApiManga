package com.api.manga.restserver.services;



import java.util.LinkedList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.api.manga.restserver.Factory.ApiConnectorFactory;
import com.api.manga.restserver.call.api.ApiCallerReceiver;
import com.api.manga.restserver.keys.DataKeys;
import com.api.manga.restserver.keys.MangaEdenKeys;
import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;

@Path("/mangas")
public class MangaServices {
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Manga getManga(@PathParam("id") String idManga) {
		Manga manga ;
		ApiCallerReceiver caller = new ApiCallerReceiver();
		 manga = caller.getManga(idManga);
		return manga;
		
	}
	
	@Path("/list/")
	@Produces(MediaType.APPLICATION_JSON)
	public LinkedList<Manga> getMangaList() {

		return ApiConnectorFactory.getApiCallerReceiver().
				getMangaList(MangaEdenKeys.mangaEden_Language_English.toString());
		
	}
	
	@GET
	@Path("/chapter={id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Chapter getChapter(@PathParam("id") String idChapter) {
		
		return ApiConnectorFactory.getApiCallerReceiver().
				getChapter(idChapter);
		
	}
	

}

