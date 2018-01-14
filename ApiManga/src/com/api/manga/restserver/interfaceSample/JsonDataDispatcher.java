package com.api.manga.restserver.interfaceSample;

import java.util.LinkedList;

import com.api.manga.restserver.model.Manga;
import com.google.gson.JsonParser;

public interface JsonDataDispatcher {
	
	
	public LinkedList<Manga> dispatch(String json);

}
