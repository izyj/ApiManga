package com.api.manga.restserver.entities;

public class Genre {
	
	private int id;
	private String name;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}
	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	
	

}
