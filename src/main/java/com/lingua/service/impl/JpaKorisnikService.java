package com.lingua.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lingua.model.Korisnik;
import com.lingua.repository.KorisnikRepository;
import com.lingua.service.KorisnikService;

@Service
@Transactional
public class JpaKorisnikService implements KorisnikService{

	@Autowired
	KorisnikRepository korisnikRepo;

	@Override
	public Korisnik auth(String username, String password) {
		Korisnik k = korisnikRepo.findByKorisnickoImeAndSifraKorisnika(username, password);
		return k;
	}
	
	public Korisnik save(Korisnik newKor){
		Korisnik presistentKor = korisnikRepo.save(newKor);
		if(presistentKor == null){
			return null;
		}
		return presistentKor;
	}

	@Override
	public List<Korisnik> getUsers() {
		List<Korisnik> korisnici = korisnikRepo.findAll();
		return korisnici;
	}
}