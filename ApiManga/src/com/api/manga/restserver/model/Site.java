package com.api.manga.restserver.model;

import java.util.ArrayList;

public class Site {
	
	private String siteId;
	private ArrayList<String> mangaProperties;
	private ArrayList<Genre>  genres;
	
	
	public Site() {
		
	}


	public Site(String siteId, ArrayList<String> mangaProperties, ArrayList<Genre> genres) {
		super();
		this.siteId = siteId;
		this.mangaProperties = mangaProperties;
		this.genres = genres;
	}


	public String getSiteId() {
		return siteId;
	}


	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}


	public ArrayList<String> getMangaProperties() {
		return mangaProperties;
	}


	public void setMangaProperties(ArrayList<String> mangaProperties) {
		this.mangaProperties = mangaProperties;
	}


	public ArrayList<Genre> getGenres() {
		return genres;
	}


	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}
	
	

}
