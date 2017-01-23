package com.lingua.service.impl;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jezik delete(Jezik j) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
