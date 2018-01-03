package com.lingua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lingua.model.Ocena;
import com.lingua.repository.OcenaRepository;
import com.lingua.service.OcenaService;

@Service
@Transactional
public class JpaOcenaService implements OcenaService{

	@Autowired
	OcenaRepository or;
	
	@Override
	public Ocena save(Ocena o) {
		return or.save(o);
	}

	@Override
	public List<Ocena> findAll() {
		return or.findAll();
	}

	@Override
	public Ocena findOne(Long id) {
		return or.findOne(id);
	}

}
