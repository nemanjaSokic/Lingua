package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.repository.KursRepository;
import com.lingua.repository.NastavnikRepository;
import com.lingua.service.NastavnikService;

@Service
@Transactional
public class JpaNastavnikService implements NastavnikService{
	
	@Autowired
	NastavnikRepository nastavnikRepo;
	@Autowired
	KursRepository kursRepo;

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
	public Nastavnik delete(int nastavnikId) {
		Nastavnik n = findOne(nastavnikId);
		List<Kurs>kursevi=kursRepo.findAll();
		for(Kurs k : kursevi){
			Nastavnik proof = k.getNastavnik();
			if(proof.getId()==nastavnikId){
				k.setNastavnik(null);
				kursRepo.save(k);
			}
		}
		if(n==null){
			return null;
		}
		nastavnikRepo.delete(nastavnikId);
		return n;
	}
	
	
}
