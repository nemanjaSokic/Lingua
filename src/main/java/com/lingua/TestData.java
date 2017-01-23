package com.lingua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingua.service.JezikService;

@Component
public class TestData {

	@Autowired
	private JezikService jezikService;
	
	
//	@PostConstruct
//	public void init(){
//		Jezik j = new Jezik();
//		j.setIdJezika("eng");
//		j.setNaziv("engleski");
//		jezikService.save(j);
//	}
}
