package com.api.manga.restserver.interfaceSample;

import java.util.ArrayList;
import java.util.HashMap;

import com.api.manga.restserver.model.Chapter;
import com.api.manga.restserver.model.Manga;
import com.api.manga.restserver.model.Site;

public interface IConnectorApiMangaScrapper {
	
	/**
	    * Retourne un manga
	    * Retourne les infos d'un manga ainsi que la liste de ces chapitres.
	    * @return
	    */
		public Manga getManga(HashMap<String, String> mangaInfos);

		/**
		 * Retourne la liste des mangas
		 * @return
		 */
		public ArrayList<Manga> getMangaList(HashMap<String, String> requeteInfos);
		
		/**
		 * Retourne la liste des sites disponible
		 * @return
		 */
		public ArrayList<Site>  getSiteList();
		
		/**
		 * Retourne la liste des mangas en fonction du genre demandé
		 * @return
		 */
		public ArrayList<Manga> getMangaByGenre();
		
		/**
		 * Retourne les pages d'un chapitre
		 */
		public Chapter getChapter();
		
		/**
		 * Retourne la liste des genres
		 */
		public Chapter getGenreList();
		
		/**
		 * Permet de se log a l'API
		 * retourne 1 si tout va bien sinon 0
		 */
		public int LogIn();
		
		/**
		 * Permet de se log a l'API
		 * retourne 1 si tout va bien sinon 0
		 */
		public int logOut();
		

}
