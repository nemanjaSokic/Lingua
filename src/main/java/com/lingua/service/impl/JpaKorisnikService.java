package com.lingua.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lingua.repository.KorisnikRepository;
import com.lingua.service.KorisnikService;

@Service
@Transactional
public class JpaKorisnikService implements KorisnikService{

	KorisnikRepository korisnikRepo;
	
}
