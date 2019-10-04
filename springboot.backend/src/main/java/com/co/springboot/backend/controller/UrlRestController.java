package com.co.springboot.backend.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.springboot.backend.entity.Url;
import com.co.springboot.backend.entityservices.IURL;

@RestController
@RequestMapping("/")
public class UrlRestController {
	
	@Autowired
	private IURL iurl;

	@RequestMapping(method = RequestMethod.POST, path = "/generateUrl", consumes = "application/json", produces = "application/json")
	public @ResponseBody Url generateUrl(@RequestBody Url url) {
		
		return iurl.generateShortUrl(url);

	}

	
	@RequestMapping("/{id}")
	public void redirectToUrl(@PathVariable  String id, HttpServletResponse httpServletResponse) throws IOException {
		try {
		String url = iurl.getUrlFromTheMap(id);
		httpServletResponse.sendRedirect(url);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
