package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.repository.KursRepository;
import com.lingua.repository.NastavnikRepository;
import com.lingua.repository.UcenikRepository;
import com.lingua.service.KursService;

@Service
@Transactional
public class JpaKursService implements KursService{
	
	@Autowired
	KursRepository kursRepo;
	@Autowired
	UcenikRepository ucenikRepo;
	@Autowired
	NastavnikRepository nastavnikRepo;

	@Override
	public Kurs findOne(int id) {
		Kurs k = kursRepo.findOne(id);
		return k;
	}

	@Override
	public List<Kurs> findAll() {
		List<Kurs> kursevi = kursRepo.findAll();
		return kursevi;
	}

	@Override
	public Kurs save(Kurs newKurs) {		
		Kurs kurs = kursRepo.saveAndFlush(newKurs);
		return kurs;
	}

	@Override
	public Kurs delete(int id) {
		Kurs deleted = kursRepo.findOne(id);
		if(deleted == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant language");
		}
		kursRepo.delete(id);
		return deleted;
	}

	@Override
	public List<Kurs> getAllByProfessor(int id) {
		return kursRepo.findByNastavnikId(id);
	}
	
	
}
