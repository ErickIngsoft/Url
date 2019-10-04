package com.co.springboot.backend.entityservices;

import com.co.springboot.backend.entity.Url;

public interface IURL {

	public Url setUrlToTheMap(String key, Url url);
	public String getUrlFromTheMap(String shortUrl);
	public Url generateShortUrl(Url url);
	
}
