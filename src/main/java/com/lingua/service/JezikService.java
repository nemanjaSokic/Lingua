package com.lingua.service;

import java.util.List;

import com.lingua.model.Jezik;

public interface JezikService {

	Jezik findOne(String id);
	
	List<Jezik> findAll();
	
	Jezik save(Jezik j);
	
	List<Jezik> save(List<Jezik> j);
	
	Jezik delete (Jezik j);
	
}
