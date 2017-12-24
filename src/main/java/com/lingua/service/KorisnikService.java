package com.lingua.service;

import java.util.List;

import com.lingua.model.Korisnik;

public interface KorisnikService {

	Korisnik auth(String username, String password);
	Korisnik save(Korisnik k);
	List<Korisnik> getUsers();
	String getUsername(String un);
	Korisnik getOne(String username);
	void delete(Korisnik korisnik);
	List<Korisnik> getUnregistratedUsers();
}
