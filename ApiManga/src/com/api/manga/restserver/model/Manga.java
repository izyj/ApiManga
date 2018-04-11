package com.api.manga.restserver.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.api.manga.restserver.keys.DataKeys;
import com.google.gson.annotations.SerializedName;

public class Manga {
	private int id;
	private String idApi;
	private String name;
	private Timestamp yearRelease;
	private String infos;
	private Timestamp lastUpdate;
	private Image image;
	private Image imageURL;
	private Artist artist;
	private Author author;
	private Status status;
	private String description;
	private String chapterLength;
	private String language;
	private ArrayList<Genre> genres;
	
	public Manga() {
		
	}
	
	public Manga(int id,String name, Timestamp yearRelease,String infos,Timestamp lastUpdate,Image image
			,Artist artist,Author author,Status status,ArrayList<Genre>  genres) {
		
		this.id = id;
		this.name = name;
		this.yearRelease = yearRelease;
		this.infos =infos;
		this.lastUpdate = lastUpdate;
		this.image = image;
		this.artist =artist;
		this.author = author;
		this.status = status;
		
	}
	
	
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Image getImageURL() {
		return imageURL;
	}

	public void setImageURL(Image imageURL) {
		this.imageURL = imageURL;
	}

	public String getChapterLength() {
		return chapterLength;
	}

	public void setChapterLength(String chapterLength) {
		this.chapterLength = chapterLength;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getYearRelease() {
		return yearRelease;
	}

	public void setYearRelease(Timestamp yearRelease) {
		this.yearRelease = yearRelease;
	}

	public String getInfos() {
		return infos;
	}

	public void setInfos(String infos) {
		this.infos = infos;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	public String getIdApi() {
		return idApi;
	}

	public void setIdApi(String idApi) {
		this.idApi = idApi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


	
	
	
	
}
