package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.model.Nivo;
import com.lingua.repository.NivoRepository;
import com.lingua.service.NivoService;

@Service
@Transactional
public class JpaNivoService implements NivoService{
	
	 NivoRepository nivoRepo;

	@Override
	public Nivo findOne(int id) {
		return nivoRepo.findOne(id);
	}

	@Override
	public List<Nivo> findAll() {
		List<Nivo> n = nivoRepo.findAll();
		return n;
	}

	@Override
	public Nivo save(Nivo n) {
		Nivo presis = nivoRepo.save(n);
		return presis;
	}

	@Override
	public Nivo delete(int id) {
		Nivo nivo = nivoRepo.findOne(id);
		if(nivo == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		nivoRepo.delete(nivo);
		return nivo;
	}
	
}
