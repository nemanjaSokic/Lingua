package com.lingua.service;

import java.util.List;

import com.lingua.model.Skola;

public interface SkolaService {

	Skola findOne(int pib);

	Skola save(Skola s);

	List<Skola> findAll();

}
