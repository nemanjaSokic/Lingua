package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Skola;
import com.lingua.repository.SkolaRepository;
import com.lingua.service.SkolaService;

@Service
@Transactional
public class JpaSkolaService implements SkolaService{
	
	@Autowired
	SkolaRepository skolaRepo;

	@Override
	public Skola findOne(int pib) {
		return skolaRepo.findOne(pib);
	}
	
	@Override
	public Skola save(Skola s){
		return skolaRepo.save(s);
	}

	@Override
	public List<Skola> findAll() {
		List<Skola> skole = skolaRepo.findAll();
		return skole;
	}
}
