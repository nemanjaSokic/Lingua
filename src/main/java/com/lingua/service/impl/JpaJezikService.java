package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Jezik;
import com.lingua.model.Kurs;
import com.lingua.model.Nastavnik;
import com.lingua.repository.JezikRepository;
import com.lingua.repository.KursRepository;
import com.lingua.repository.NastavnikRepository;
import com.lingua.service.JezikService;

@Service
@Transactional
public class JpaJezikService implements JezikService{
	
	@Autowired
	JezikRepository jr;
	@Autowired
	NastavnikRepository nr;
	@Autowired
	KursRepository kr;
	
	

	@Override
	public List<Jezik> findAll() {
		List<Jezik> lista = jr.findAll();
		return lista;
	}

	@Override
	public Jezik save(Jezik j) {
		jr.save(j);
		return j;
	}

	@Override
	public List<Jezik> save(List<Jezik> j) {
		
		return null;
	}

	@Override
	public Jezik delete(String id) {
		Jezik j = jr.findOne(id);
		if(j == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant language");
		}
		List<Nastavnik> nastavnici = nr.findAll();
		List<Kurs> kursevi = kr.findAll();
		for(Nastavnik n : nastavnici){
			if(n.getPredaje().getIdJezika().equals(id)){
			n.setPredaje(null);
			}
		}
		for(Kurs k : kursevi){
			if(k.getJezik().getIdJezika().equals(id)){
				k.setJezik(null);
			}
		}
		jr.delete(j);
		return j;
	}

	@Override
	public Jezik findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
