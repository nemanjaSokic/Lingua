package com.lingua.service;

import java.util.List;

import com.lingua.model.Jezik;
import com.lingua.model.Nastavnik;

public interface NastavnikService {

	List<Nastavnik> finadAll();

	Nastavnik findOne(int id);

	Nastavnik save(Nastavnik newNastavnik);

	List<Nastavnik> delete(List<Nastavnik> nastavnici);

	List<Nastavnik> findByJezik(String id);
	
	Nastavnik delete(int id);

}
