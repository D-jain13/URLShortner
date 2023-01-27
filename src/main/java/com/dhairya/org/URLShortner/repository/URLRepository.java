package com.dhairya.org.URLShortner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhairya.org.URLShortner.entity.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, String>{

	public URL findBySmall(String key);
	
	
	
	//public List<String> findAllSmall();
	
}
