package com.lingua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lingua.model.Korisnik;


public interface KorisnikRepository extends JpaRepository<Korisnik, String> {

	Korisnik findByKorisnickoImeAndSifraKorisnika(String username, String password);

	Korisnik findByKorisnickoIme(String un);
	
	List<Korisnik> findByRegistrovanFalse();

}
