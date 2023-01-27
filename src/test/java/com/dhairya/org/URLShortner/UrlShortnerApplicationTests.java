package com.dhairya.org.URLShortner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhairya.org.URLShortner.repository.URLRepository;

@SpringBootTest
class UrlShortnerApplicationTests {
	
	@Autowired
	private URLRepository repo;
	@Test
	void test() {
		
	}

}
