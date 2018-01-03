package com.lingua.service;

import java.util.List;

import com.lingua.model.Ocena;

public interface OcenaService {
	
	Ocena save(Ocena o);

	List<Ocena> findAll();

	Ocena findOne(Long id);

}
