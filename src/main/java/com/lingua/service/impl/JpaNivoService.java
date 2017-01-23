package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.NivoRepository;
import com.lingua.service.NivoService;

@Service
@Transactional
public class JpaNivoService implements NivoService{
	
	 NivoRepository nivoRepo;
	
}
