package com.co.springboot.backend.entityservices;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.co.springboot.backend.entity.Url;

@Service
public class EntityServices implements IURL {

	private Map<String, Url> mapOfUrls = new HashMap<String, Url>();
	private String host = "http://localhost:8080/";

	private EntityServices() {

	}

	public Url generateShortUrl(Url url) {
		long l = url.getLongUrl().hashCode();
		String shortUrl = Long.toString(l, 36).toUpperCase();

		url.setShortUrl(host.concat(shortUrl));
		Url tempUrl = setUrlToTheMap(shortUrl, url);
		if (tempUrl != null) {
			return tempUrl;
		}

		return url;

	}

	public Url setUrlToTheMap(String key, Url url) {
		return mapOfUrls.putIfAbsent(key, url);
	}

	public String getUrlFromTheMap(String shortUrl) {
		return mapOfUrls.get(shortUrl).getLongUrl();

	}
}
