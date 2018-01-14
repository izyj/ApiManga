package com.api.manga.restserver.model;

public class Image { 
	
	private int id;
	private String URI;
	
	public Image() {
		
	}
	
	public Image(int id, String uRI) {
		super();
		this.id = id;
		URI = uRI;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
	}
	
	

}
