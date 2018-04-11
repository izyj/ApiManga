package com.api.manga.restserver.model;

public class Image { 
	
	private String id;
	private String URI;
	private String height,length;
	
	public Image() {
		
	}
	
	public Image(String id, String uRI) {
		super();
		this.id = id;
		URI = uRI;
	}
	public Image(String id) {
		
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}
	
	
	

}
