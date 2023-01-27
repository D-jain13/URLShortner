package com.dhairya.org.URLShortner.controller;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.dhairya.org.URLShortner.entity.URL;
import com.dhairya.org.URLShortner.repository.URLRepository;

@RestController
public class URLController {
	
	@Autowired
	private URLRepository repo;

	
	@GetMapping("/test")
	public String test() {
		return "Test API works!!";
	}
	
	
	
	@PostMapping("/create")
	public String createURL(@RequestBody URL url) {
		String short_url = RandomStringUtils.randomAlphanumeric(4, 8);
		URL orgURL = new URL(url.getID(), url.getStr(),short_url, url.getUrlDate(),repo.count());
		repo.save(orgURL);
		return "localhost:8080/"+short_url;
		
	}
	@GetMapping("/getURL")
	public String getURL(@RequestParam String str) {
		String key = str.substring(15);
		URL url = repo.findBySmall(key);
		return url.getStr();
	}
	
	@GetMapping("/getAll")
	public List<URL> getAllShortenedURL(){
		return repo.findAll();
	}
	
	
	
	@GetMapping("/{str}")
	public RedirectView shortened_url(@PathVariable String str) {
		//String key = str.substring(15);
		URL url = repo.findBySmall(str);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url.getStr());
		return redirectView;
	}
	
	
}
