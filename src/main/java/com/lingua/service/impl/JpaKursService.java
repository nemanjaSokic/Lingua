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
		Kurs oldKurs = kursRepo.findOne(newKurs.getIdKursa());
		if(oldKurs!=null){
			Nastavnik n = nastavnikRepo.findOne(oldKurs.getNastavnik().getId());
			if(!newKurs.getNastavnik().getPredaje().getNaziv().equals(n.getPredaje().getNaziv())){
				return null;
			}
		}
		Kurs kurs = kursRepo.save(newKurs);
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
	
	
}
