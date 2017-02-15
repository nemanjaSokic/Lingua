package com.lingua.service;

import java.util.List;

import com.lingua.model.Nastavnik;

public interface NastavnikService {

	List<Nastavnik> finadAll();

	Nastavnik findOne(int id);

	Nastavnik save(Nastavnik newNastavnik);

	Nastavnik delete(int id);

}
