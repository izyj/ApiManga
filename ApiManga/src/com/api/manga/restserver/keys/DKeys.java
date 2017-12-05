package com.api.manga.restserver.keys;

public enum DKeys {
	
	mangaEdenApiMangaListURI("https://www.mangaeden.com/api/list/"),
	mangaEdenApiMangaListURISplitPage("/?p="),
	mangaEden_Language_English("0/"),
	mangaEden_Language_Italian("1/"),
	mangaEdenApiMangaURI("https://www.mangaeden.com/api/manga/"),
	mangaEdenApiChapterURI("https://www.mangaeden.com/api/chapter/"),
	mangaEdenJson_mangaName("a"),
	mangaEdenJson_mangaCategory("c"),
	mangaEdenJson_mangaImage("im"),
	mangaEdenJson_mangaTitle("t"),
	mangaEdenJson_mangaID("i"),
	mangaEdenJson_mangaLastChapterDate("ld"),
	mangaEdenJson_mangaStatus("s"),
	mangaEdenJson_mangaAlias("a"),
	mangaEdenJson_mangaHits("h"),
	mangaEdenJson_manga("manga");

		
	private String info ="";
	
	DKeys(String infos){
		
		this.info = infos;
	}
	



}
