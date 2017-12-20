package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.TipKursa;
import com.lingua.repository.TipKursaRepository;
import com.lingua.service.TipKursaService;

@Service
@Transactional
public class JpaTipKursaService implements TipKursaService {

	@Autowired
	TipKursaRepository tipKursaRepo;
	@Override
	public List<TipKursa> getAll() {
		return tipKursaRepo.findAll();
	}
	@Override
	public TipKursa save(TipKursa tip1) {
		return tipKursaRepo.saveAndFlush(tip1);
	}

}
