package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.NastavnikRepository;
import com.lingua.service.NastavnikService;

@Service
@Transactional
public class JpaNastavnikService implements NastavnikService{

	NastavnikRepository nastavnikRepo;
	
}
