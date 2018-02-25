package com.api.manga.restserver.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Chapter {
	
	private String id, idManga;
	private Timestamp lastUpdate;
	
	public Chapter() {
		
	}
	
	public Chapter(String id,String idManga,Timestamp lastupdate) {
		this.id = id;
		this.idManga =idManga;
		this.lastUpdate = lastupdate;
			
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdManga() {
		return idManga;
	}

	public void setIdManga(String idManga) {
		this.idManga = idManga;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}



		
	

}
