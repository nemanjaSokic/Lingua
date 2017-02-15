package com.lingua.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Nastavnik;
import com.lingua.repository.NastavnikRepository;
import com.lingua.service.NastavnikService;

@Service
@Transactional
public class JpaNastavnikService implements NastavnikService{
	
	@Autowired
	NastavnikRepository nastavnikRepo;

	@Override
	public List<Nastavnik> finadAll() {
		return nastavnikRepo.findAll();
	}

	@Override
	public Nastavnik findOne(int id) {
		return nastavnikRepo.findOne(id);
	}

	@Override
	public Nastavnik save(Nastavnik newNastavnik) {
		return nastavnikRepo.save(newNastavnik);
	}

	@Override
	public Nastavnik delete(int id) {
		Nastavnik n = findOne(id);
		if(n==null){
			return null;
		}
		nastavnikRepo.delete(id);
		return n;
	}
	
	
}
