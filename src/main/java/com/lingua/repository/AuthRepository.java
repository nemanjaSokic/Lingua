package com.lingua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lingua.model.Korisnik;

public interface AuthRepository extends JpaRepository<Korisnik, String>  {

}
