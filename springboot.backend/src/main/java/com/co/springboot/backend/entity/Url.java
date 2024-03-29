package com.co.springboot.backend.entity;


public class Url {

	private String shortUrl;
	private String longUrl;
	
	public Url() {
		
	}
	
	public Url(String shortUrl, String longUrl) {
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
	}


	public String getShortUrl() {
		return shortUrl;
	}


	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}


	public String getLongUrl() {
		return longUrl;
	}


	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((shortUrl == null) ? 0 : shortUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Url other = (Url) obj;
		if (shortUrl == null) {
			if (other.shortUrl != null)
				return false;
		} else if (!shortUrl.equals(other.shortUrl))
			return false;
		return true;
	}
	
	
	
	
	
}
