package com.lingua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lingua.service.JezikService;

@Component
public class TestData {

	@Autowired
	private JezikService jezikService;
	
	

}
