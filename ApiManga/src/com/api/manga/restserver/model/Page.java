package com.api.manga.restserver.model;

import java.util.List;

/**
 * @author isiramen
 *
 */
public class Page {
	
	private String id,chapId;
	private String numPage;
	private Image image;
	
	public Page() {
		
	}
	
	/**
	 * @param id
	 * @param chapId
	 * @param numPage
	 */
	public Page(String id,String chapId, String numPage,Image image) {
		
		this.id = id;
		this.chapId = chapId;
		this.numPage = numPage;
		this.image = image;
		
	}
	public Page(String id) {
		
		this.id =  id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChapId() {
		return chapId;
	}

	public void setChapId(String chapId) {
		this.chapId = chapId;
	}


	public String getNumPage() {
		return numPage;
	}

	public void setNumPage(String numPage) {
		this.numPage = numPage;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	

}
