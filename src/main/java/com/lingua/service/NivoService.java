package com.lingua.service;

import java.util.List;

import com.lingua.model.Nivo;

public interface NivoService {

	Nivo findOne(int id);

	List<Nivo> findAll();

	Nivo save(Nivo n);

	Nivo delete(int id);

}
