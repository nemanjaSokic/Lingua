package com.lingua.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Jezik;
import com.lingua.repository.JezikRepository;
import com.lingua.service.JezikService;

@Service
@Transactional
public class JpaJezikService implements JezikService{
	
	@Autowired
	JezikRepository jr;
	
	@Override
	public Jezik findOne(String id) {
		Jezik j = jr.findOne(id);
		return j;
	}

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
		jr.delete(j);
		return j;
	}

	
}
