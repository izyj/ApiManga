package com.api.manga.restserver.entities;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Chapitre {
	
	private int id, idManga;
	private Timestamp lastUpdate;
	private ArrayList<Chapitre> chapters;
	
	public Chapitre() {
		
	}
	
	public Chapitre(int id,int idManga,Timestamp lastupdate, ArrayList chapters) {
		this.id = id;
		this.idManga =idManga;
		this.lastUpdate = lastupdate;
		this.chapters = chapters;

			
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdManga() {
		return idManga;
	}

	public void setIdManga(int idManga) {
		this.idManga = idManga;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public ArrayList<Chapitre> getChapters() {
		return chapters;
	}
	public void setChapters(ArrayList<Chapitre> chapters) {
		this.chapters = chapters;
	}


		
	

}
