package com.lingua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, String> {

	Korisnik findByKorisnickoImeAndSifraKorisnika(String username, String password);

}
