package com.api.manga.restserver.interfaceSample;

import java.util.LinkedList;

import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;

/**
 * @author isiramen
 *  
 */
public interface IConnectorAPIMangaEden {
	
   /**
    * Retourne un manga
    * Retourne les infos d'un manga ainsi que la liste de ces chapitres.
    * @return
    */
	public Manga getManga(String idManga);

	/**
	 * Retourne la liste des mangas
	 * @return
	 */
	public LinkedList<Manga> getMangaList(String language);
	
	
	/**
	 * Retourne les pages d'un chapitre
	 */
	public Chapter getChapter(String idChapter);
	
	/**
	 * Permet de se log a l'API
	 * retourne 1 si tout va bien sinon 0
	 */
	public int LogIn(String username, String password);
	
	/**
	 * Permet de se log a l'API
	 * retourne 1 si tout va bien sinon 0
	 */
	public int logOut();
	
	
}
